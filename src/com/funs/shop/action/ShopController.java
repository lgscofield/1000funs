package com.funs.shop.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.funs.config.action.ConfigAction;
import com.funs.food.action.FoodAction;
import com.funs.food.model.FoodGroupVO;
import com.funs.food.model.FoodQueryCondition;
import com.funs.food.model.FoodVO;
import com.funs.order.action.OrderAction;
import com.funs.order.model.OrderQueryCondition;
import com.funs.order.model.OrderVO;
import com.funs.order.model.OrderVOWithFood;
import com.funs.shop.model.GroupForm;
import com.funs.shop.model.OrderFoodView;
import com.funs.shop.model.OrderView;
import com.funs.shop.model.PlateVO;
import com.funs.shop.model.QueryForm;
import com.funs.shop.util.ShopConstants;
import com.funs.shop.util.ShopUtil;


/**
 * 店铺管理控制器
 * 
 * /shop			-->		主页
 * /shop/todo		-->		订单管理待处理
 * /shop/history	-->		订单管理已处理
 * /shop/catering	-->		配餐模式
 * /shop/package	-->		套餐模式
 * 
 * /shop/save/group	-->		保存分组
 * /shop/order/{id}?status={value}		method=put	-->		更新订单状态
 * /autoprint/{value}		更新是否自动出单
 * 
 * @author jcchen
 *
 */
@Controller
@RequestMapping("/shop")
public class ShopController {
	
	@Autowired
	private OrderAction orderAction;
	
	@Autowired
	private FoodAction foodAction;
	
	@Autowired
	private ConfigAction configAction;

	/**
	 * 
	 * @return
	 */
	@RequestMapping("")
	public String toIndex() {
		return "shop/index"; 
	}
	
	@RequestMapping("/todo")
	public String toToodo(Model model, @ModelAttribute QueryForm queryForm) {
		
		OrderQueryCondition condition = new OrderQueryCondition();
		BeanUtils.copyProperties(queryForm, condition);
		
		List<OrderVOWithFood> list0 = orderAction.queryNewOrdersWithFood(condition);
		List<OrderView> list = transferOrderVOToView(list0);
		
		model.addAttribute("orderList", list);
		return "shop/todo";
	}
	
	@RequestMapping("/history")
	public String toHistory(Model model, @ModelAttribute QueryForm queryForm) {
		
		if(queryForm == null) {
			print("go into history. queryForm = null");
			queryForm = new QueryForm();
		}
		if(queryForm.getPageNo() == 0) queryForm.setPageNo(1);
		if(queryForm.getPageSize() == 0) queryForm.setPageSize(4);
		if(queryForm.getOrderStatus() == null) queryForm.setOrderStatus(
				OrderVO.ORDER_STATUS_DEALED+","+
					OrderVO.ORDER_STATUS_EXCEPTION+","+
						OrderVO.ORDER_STATUS_EVALUATED);
		
		OrderQueryCondition condition = new OrderQueryCondition();
		BeanUtils.copyProperties(queryForm, condition);
		
		int count = orderAction.queryHistoryOrdersCount(condition);
		queryForm.setRecordCount(count);
		
		List<OrderVOWithFood> list0 = orderAction.queryHistoryOrdersWithFoodByPage(condition, queryForm.getPageNo(), queryForm.getPageSize());
		List<OrderView> list = transferOrderVOToView(list0);
		model.addAttribute("orderList", list);
		
		return "shop/history";
	}
	
	@RequestMapping("/catering")
	public String toCatering(Model model) {
		int shopId = 1;
		FoodQueryCondition foodQueryCondition = new FoodQueryCondition(shopId, FoodVO.TYPE_FOOD);
		Map<String, List<FoodVO>> foodMaps = foodAction.queryAllGroupAndFoods(foodQueryCondition);
		model.addAttribute("foodMaps", foodMaps);
		return "shop/catering";
	}
	
	@RequestMapping("/package")
	public String toPackage(Model model) {
		int shopId = 1;
		FoodQueryCondition foodQueryCondition = new FoodQueryCondition(shopId, FoodVO.TYPE_PACKAGE);
		Map<String, List<FoodVO>> packageMaps = foodAction.queryAllGroupAndFoods(foodQueryCondition);
		model.addAttribute("packageMaps", packageMaps);
		return "shop/package";
	}
	
	@RequestMapping("/group")
	public String toGroup(Model model) {
		List<FoodGroupVO> lstGroups = foodAction.queryAllGroups();
		model.addAttribute("groupList", lstGroups);
		return "shop/group";
	}
	
	/**
	 * 保存分组
	 * @param file
	 * @param groupForm
	 * @param model
	 * @return
	 */
	@RequestMapping(value="/save/group", method=RequestMethod.POST)
	public String saveGroup(@RequestParam MultipartFile file, @ModelAttribute GroupForm groupForm, Model model) {
		
		// save the image file to upload directory
		String imageName = "";
		try {
			imageName = ShopUtil.saveImage(file);
		} catch (Exception e) {
			e.printStackTrace();
		}
		if(imageName.equals("")) {
			throw new IllegalStateException("add group fail!");
		}
		
		// save vo to db
		FoodGroupVO vo = new FoodGroupVO();
		transferGroupFormToFoodGroupVO(groupForm, vo);
		vo.setImage(imageName);
		foodAction.insertFoodGroup(vo);
		
		//redirect
		String redirect = "redirect:/shop/" + 
				(groupForm.getType() == FoodVO.TYPE_FOOD ? "catering.ac" : "package.ac");
		return redirect;
	}
	
	/**
	 * 更新订单状态
	 * @return
	 */
	@RequestMapping(value="/order/{id}", method=RequestMethod.PUT, params="status")
	public @ResponseBody boolean updateOrderStatus(@PathVariable int id, @RequestParam int status) {
		OrderVO vo = new OrderVO();
		vo.setId(id);
		vo.setOrderStatus(status);
		int ret = orderAction.updateOrderStatus(vo);
		return ret > 0;
	}
	
	/**
	 * 是否自动出单(更新配置项信息)
	 * @param value
	 * @return
	 */
	@RequestMapping(value="/autoprint/{value}")
	public @ResponseBody boolean updateAutoPrint(@PathVariable String value) {
		int ret = configAction.updateConfig(ShopConstants.CONFIG_KEY_AUTO_PRINT, value);
		return ret > 0;
	}
	
	
	@RequestMapping(value="/query/group/{type}", method=RequestMethod.GET)
	public @ResponseBody List<FoodGroupVO> queryGroup(@PathVariable int type) {
		List<FoodGroupVO> list = foodAction.queryGroups(type);
		System.out.println(list);
		return list;
	}
	
	@RequestMapping("/query/test")
	public @ResponseBody FoodGroupVO queryTest() {
		
		print(" queryTest ");
		ObjectMapper mapper = new ObjectMapper();
		print( mapper );
		
		return new FoodGroupVO(1, "groupName", "image", "detail", 1);
	}
	
	
	
	
	@ExceptionHandler
	public @ResponseBody String handle(Exception e) {
		return e.getMessage();
	}
	
	/**
	 * 将List<OrderVOWithFood>转换为List<OrderViewVO>
	 * @param list
	 * @return
	 */
	private List<OrderView> transferOrderVOToView(List<OrderVOWithFood> list) {
		List<OrderView> ret = new ArrayList<OrderView>();
		int oldOrderId = 0, oldPlate = 0;
		OrderView view = null;
		List<PlateVO> plateList = null;
		PlateVO plate = null;
		for(OrderVOWithFood vo : list) {
			if(oldOrderId != vo.getId()) { // new
				//reset
				oldOrderId = vo.getId();
				oldPlate = 0;
				
				if(view != null) ret.add(view); //add the prior one
				view = new OrderView();
				view.setId(vo.getId());
				view.setAddress(vo.getAddress());
				view.setContact(vo.getContact());
				view.setCreateTime(vo.getCreateTime());
				view.setExceptTime(vo.getExceptTime());
				view.setOrderStatus(vo.getOrderStatus());
				view.setPhone(vo.getPhone());
				view.setTotalPrice(vo.getTotalPrice());
				
				plateList = new ArrayList<PlateVO>();
				view.setPlateList(plateList);
			}
			
			if(oldPlate != vo.getPlate()) {
				oldPlate = vo.getPlate();
				plate = new PlateVO(vo.getPlate());
				plateList.add(plate);
			}
			
			OrderFoodView foodView = new OrderFoodView();
			foodView.setFood(vo.getFoodName());
			foodView.setAmount(vo.getAmount());
			foodView.setPrice(vo.getPrice());
			plate.addFood(foodView);
		}
		if(view != null) { //add the last one
			ret.add(view); 
		}
		return ret;
	}
	
	/**
	 * 将GroupForm 转化为 FoodGroupVO
	 * @param form
	 * @param vo
	 */
	private void transferGroupFormToFoodGroupVO(GroupForm form, FoodGroupVO vo) {
		vo.setGroupName(form.getGroupName());
		vo.setDetail(form.getDetail());
		vo.setType(form.getType());
	}
	
	private <T> void print(T msg) {
		System.out.println(">>>>>>>>>>>>>>>>>>>>\n"+msg.toString()+"\n<<<<<<<<<<<<<<<<<<");
	}
}

package com.funs.order.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.funs.core.util.tools.PosPrinter;
import com.funs.order.action.OrderAction;
import com.funs.order.model.OrderVO;
import com.funs.order.model.OrderView;

@Component
public class OrderAutoPrintListener implements OrderStateListener {
	
	final static Logger LOGGER = LoggerFactory.getLogger(OrderAutoPrintListener.class);
	
	@Autowired
	private OrderAction orderAction;

	@Override
	public void orderSubmited(OrderVO orderVO) {
		LOGGER.debug("提交了订单"+orderVO+";");
		if(orderAction.getAutoPrint()) {
			LOGGER.debug("开始自动出单");
			OrderView orderView = orderAction.getOrderView(orderVO.getId());
			PosPrinter.print(orderView);
		}
		// TODO:: 自动刷新订单管理列表页面
	}

}

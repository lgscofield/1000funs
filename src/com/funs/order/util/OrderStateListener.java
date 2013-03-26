package com.funs.order.util;

import com.funs.order.model.OrderVO;

/**
 * 订单状态监听者
 * @author jcchen
 *
 */
public interface OrderStateListener {

	public void orderSubmited(OrderVO orderVO);
}

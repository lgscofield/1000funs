package com.funs.order.util;

import org.springframework.stereotype.Component;

import com.funs.order.model.OrderVO;

@Component
public class OrderAutoPrintListener implements OrderStateListener {

	@Override
	public void orderSubmited(OrderVO orderVO) {
		System.out.println("订单提交了，赶紧自动出单啊...");
	}

}

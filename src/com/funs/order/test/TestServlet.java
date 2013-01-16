package com.funs.order.test;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funs.core.base.model.ResultVO;
import com.funs.order.action.OrderAction;
import com.funs.order.model.OrderVO;

public class TestServlet extends HttpServlet {

	static OrderAction action = new OrderAction();

	public static void submitOrder(OrderVO orderVO) {
		orderVO.setContact("1237382832");
		ResultVO result = action.submitOrder(orderVO);
		System.out.println(result.isSuccess());
	}

	private static final long serialVersionUID = 2399166345711874635L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		this.doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		if (req.getRequestURI().contains("submitOrder")) {
			submitOrder(new OrderVO());
		} else if (req.getRequestURI().contains("queryAddress")) {
			//
		} else if (req.getRequestURI().contains("addTempAddress")) {
			//
		}
	}
}

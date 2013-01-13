package com.funs.address.test;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.funs.address.action.AddressAction;
import com.funs.address.model.RegionVO;

public class TestServlet extends HttpServlet {

	static AddressAction action = new AddressAction();

	public static void queryChildRegion() {
		int currentRegionId = 1;
		List<RegionVO> result = action.queryChildRegion(currentRegionId);
		System.out.println(result.get(0).getFullPath());
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
		if(req.getRequestURI().contains("queryChildRegion")){
			queryChildRegion();
		}else if(req.getRequestURI().contains("insertFood")){
		}
	}
}

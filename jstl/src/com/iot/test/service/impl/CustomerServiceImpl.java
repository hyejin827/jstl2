package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.CustomerDAO;
import com.iot.test.dao.impl.CustomerDAOImpl;
import com.iot.test.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cdao = new CustomerDAOImpl();
	@Override
	public void setCustomerList(HttpServletRequest req) {
		String str = req.getParameter("orderStr");
		String order = req.getParameter("order");
		
		if(str!=null) {
			int idx = str.indexOf(","); //13
			String str2 =  str.substring(0,idx+1);
			if(str2.indexOf("asc")!=-1) {
				str2 = str2.replace("asc", "desc");
			}else {
				str2 = str2.replace("desc", "asc");
			}
			str = str.replace(str2, "");
			str = str2 + str;
			req.setAttribute("customerList", cdao.selectCustomerList(str));
		}
		System.out.println(cdao.selectCustomerList(str));
		//System.out.println(req.getParameter("order"));
		req.setAttribute("customerList", cdao.selectCustomerList(req.getParameter("order")));
	}
}

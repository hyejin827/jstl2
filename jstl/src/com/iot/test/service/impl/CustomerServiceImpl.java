package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.CustomerDAO;
import com.iot.test.dao.impl.CustomerDAOImpl;
import com.iot.test.service.CustomerService;
import com.iot.test.vo.Customer;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO cdao = new CustomerDAOImpl();
	@Override
	public void setCustomerList(HttpServletRequest req) {
		Customer c = null;
		String searchType = req.getParameter("searchType");
		String searchStr = req.getParameter("searchStr");
		if(searchType!=null) {
			c = new Customer();
			c.setSearchType(searchType);
			if(searchType.equals("customerName")) {
				c.setCustomerName(searchStr);
			}else if(searchType.equals("city")) {
				c.setCity(searchStr);
			}else {
				c.setCountry(searchStr);
			}
			req.setAttribute("customerList", cdao.selectCustomerList(c));
		}else {
			req.setAttribute("customerList", cdao.selectCustomerList(req.getParameter("order")));
		}
	}
	@Override
	public void setCustomer(HttpServletRequest req) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void insertCustomer(HttpServletRequest req) {
		Customer c = new Customer();
		String insertName = req.getParameter("insertName");
		String insertCity = req.getParameter("insertCity");
		String insertCountry = req.getParameter("insertCountry");
		c.setCustomerName(insertName);
		c.setCity(insertCity);
		c.setCountry(insertCountry);
		req.setAttribute("customerList", cdao.insertCustomer(c));
		
	}
	@Override
	public void updateCustomer(HttpServletRequest req) {
		Customer c = new Customer();
		int updateNum = Integer.parseInt(req.getParameter("updateNum"));
		String updateName = req.getParameter("updateName");
		String updateCity = req.getParameter("updateCity");
		String updateCountry = req.getParameter("updateCountry");
		c.setCustomerID(updateNum);
		c.setCustomerName(updateName);
		c.setCity(updateCity);
		c.setCountry(updateCountry);
		req.setAttribute("customerList", cdao.updateCustomer(c));
	}
	@Override
	public void deleteCustomer(HttpServletRequest req) {
		Customer c = new Customer();
		String deleteStr = req.getParameter("deleteStr");
		c.setCustomerName(deleteStr);
		req.setAttribute("customerList", cdao.deleteCustomer(c));
	}
}

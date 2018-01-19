package com.iot.test.dao;

import java.util.List;

import com.iot.test.vo.Customer;
import com.iot.test.vo.Customer;

public interface CustomerDAO {
	public List<Customer> selectCustomerList(String orderStr);
	public List<Customer> selectCustomerList(Customer c);
	public Customer selectCustomer(Customer c);
	public int insertCustomer(Customer c);
	public int updateCustomer(Customer c);
	public int deleteCustomer(Customer c);
}

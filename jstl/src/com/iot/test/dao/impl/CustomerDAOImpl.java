package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.dao.CustomerDAO;
import com.iot.test.vo.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	@Override
	public List<Customer> selectCustomerList(String orderStr) {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from customer";
		if(orderStr!=null) {
			sql += " order by " + orderStr;
		}
		con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer c = new Customer();
				c.setCustomerName(rs.getString("customerName"));
				c.setCustomerID(rs.getInt("customerID"));
				c.setCity(rs.getString("city"));
				c.setCountry(rs.getString("country"));
				customerList.add(c);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return customerList;
	}

	@Override
	public List<Customer> selectCustomerList(Customer c) {
		List<Customer> customerList = new ArrayList<Customer>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from customer where 1=1";
		if(c!=null) {
			sql += " and ";
			sql += c.getSearchType();
			sql += " like ?";
		}
		con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			if(c!=null) {
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public Customer selectCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteCustomer(Customer c) {
		// TODO Auto-generated method stub
		return 0;
	}

}

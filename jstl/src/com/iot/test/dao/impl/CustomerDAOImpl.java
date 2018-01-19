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
				String searchStr = c.getCustomerName();
				if(c.getSearchType().equals("city")) {
					searchStr = c.getCity();
				}else if(c.getSearchType().equals("country")) {
					searchStr = c.getCountry();
				}
				ps.setString(1, "%" + searchStr + "%");
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				Customer c2 = new Customer();
				c2.setCustomerID(rs.getInt("customerID"));
				c2.setCustomerName(rs.getString("customername"));
				c2.setCity(rs.getString("city"));
				c2.setCountry(rs.getString("country"));
				customerList.add(c2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
		}
		return customerList;
	}

	@Override
	public Customer selectCustomer(Customer c) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertCustomer(Customer c) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBCon.getCon();
		String sql = "insert into customer(customername, city, country) values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCity());
			ps.setString(3, c.getCountry());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}

	@Override
	public int updateCustomer(Customer c) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBCon.getCon();
		String sql = "update customer set customername=?, city=?, country=? where customerid=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getCity());
			ps.setString(3, c.getCountry());
			ps.setInt(4, c.getCustomerID());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}

	@Override
		public int deleteCustomer(Customer c) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBCon.getCon();
		String sql = "delete from customer where customername=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, c.getCustomerName());
			
			return ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}

}

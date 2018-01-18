package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.dao.MenuDAO;
import com.iot.test.test.DBConTest;
import com.iot.test.vo.Menu;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<Menu> selectMenuList() {
		List<Menu> menuList = new ArrayList<Menu>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from menu order by mnum";
		//con = DBCon.getCon();
		con = DBConTest.getCon();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()) {
				Menu m = new Menu();
				m.setmNum(rs.getInt("mnum"));
				m.setmName(rs.getString("mname"));
				m.setmUrl(rs.getString("murl"));
				m.setmDesc(rs.getString("mdesc"));
				menuList.add(m);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return menuList;
	}

	@Override
	public Menu selectMenu(Menu m) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertMenu(Menu m) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBCon.getCon();
		String sql = "insert into menu(mName, mUrl, mDesc) values(?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getmName());
			ps.setString(2, m.getmUrl());
			ps.setString(3, m.getmDesc());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateMenu(Menu m) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBCon.getCon();
		String sql = "update menu set mname=?, murl=?, mdesc=? where mnum=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getmName());
			ps.setString(2, m.getmUrl());
			ps.setString(3, m.getmDesc());
			ps.setInt(4, m.getmNum());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteMenu(Menu m) {
		Connection con = null;
		PreparedStatement ps = null;
		con = DBCon.getCon();
		String sql = "delete from menu where mname=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, m.getmName());
			
			return ps.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}

package com.iot.test.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.iot.test.common.DBCon;
import com.iot.test.common.DBUtil;
import com.iot.test.dao.MenuDAO;
import com.iot.test.test.DBConTest;
import com.iot.test.vo.Menu;

public class MenuDAOImpl implements MenuDAO {

	@Override
	public List<Menu> selectMenuList(Menu m) {
		List<Menu> menuList = new ArrayList<Menu>();
		Connection con = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from menu where 1=1";
		if(m!=null) {
			sql += " and ";
			sql += m.getmSearchType();
			sql += " like ?";
		}
		//con = DBCon.getCon();
		con = DBCon.getCon();
		try {
			ps = con.prepareStatement(sql);
			if(m!=null) {
				String searchStr = m.getmName();
				if(m.getmSearchType().equals("mUrl")) {
					searchStr = m.getmUrl();
				}else if(m.getmSearchType().equals("mDesc")) {
					searchStr = m.getmDesc();
				}
				ps.setString(1, "%" + searchStr + "%");
			}
			rs = ps.executeQuery();
			while(rs.next()) {
				Menu m2 = new Menu();
				m2.setmNum(rs.getInt("mnum"));
				m2.setmName(rs.getString("mname"));
				m2.setmUrl(rs.getString("murl"));
				m2.setmDesc(rs.getString("mdesc"));
				menuList.add(m2);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeAll(rs, con, ps);
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
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
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
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
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
		}finally {
			DBUtil.close(con);
			DBUtil.close(ps);
		}
		return 0;
	}

}

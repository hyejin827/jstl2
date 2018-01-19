package com.iot.test.dao;

import java.util.List;

import com.iot.test.vo.Menu;

public interface MenuDAO {
	public List<Menu> selectMenuList(Menu m);
	public Menu selectMenu(Menu m);
	public int insertMenu(Menu m);
	public int updateMenu(Menu m);
	public int deleteMenu(Menu m);
}

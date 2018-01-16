package com.iot.test.test;

import java.util.List;

import com.iot.test.dao.MenuDAO;
import com.iot.test.dao.impl.MenuDAOImpl;
import com.iot.test.vo.Menu;

public class MenuTest {

	public static void main(String[] args) {
		MenuDAO mdao = new MenuDAOImpl();
		
		List<Menu> menuList = mdao.selectMenuList();
		for(Menu m : menuList) {
			System.out.println(m);
		}
	}
}

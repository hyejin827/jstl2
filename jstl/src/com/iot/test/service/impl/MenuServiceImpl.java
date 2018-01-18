package com.iot.test.service.impl;

import javax.servlet.http.HttpServletRequest;

import com.iot.test.dao.MenuDAO;
import com.iot.test.dao.impl.MenuDAOImpl;
import com.iot.test.service.MenuService;
import com.iot.test.vo.Menu;

public class MenuServiceImpl implements MenuService {
	private MenuDAO mdao = new MenuDAOImpl();

	@Override
	public void setMenuList(HttpServletRequest req) {
		req.setAttribute("menuList", mdao.selectMenuList());
	}

	@Override
	public void getMenu(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void insertMenu(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateMenu(HttpServletRequest req) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteMenu(HttpServletRequest req) {
		Menu m = new Menu();
		String deleteStr = req.getParameter("deleteStr");
		System.out.println(deleteStr);
		m.setmName(deleteStr);
		req.setAttribute("menuList", mdao.deleteMenu(m));
	}
}

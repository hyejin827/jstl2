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
		Menu m = new Menu();
		String insertN = req.getParameter("insertN");
		String insertU = req.getParameter("insertU");
		String insertD = req.getParameter("insertD");
		m.setmName(insertN);
		m.setmUrl(insertU);
		m.setmDesc(insertD);
		req.setAttribute("menuList", mdao.insertMenu(m));

	}

	@Override
	public void updateMenu(HttpServletRequest req) {
		Menu m = new Menu();
		int updateNum = Integer.parseInt(req.getParameter("updateNum"));
		String updateN = req.getParameter("updateN");
		String updateU = req.getParameter("updateU");
		String updateD = req.getParameter("updateD");
		
		m.setmNum(updateNum);
		m.setmName(updateN);
		m.setmUrl(updateU);
		m.setmDesc(updateD);
		req.setAttribute("menuList", mdao.updateMenu(m));
	}

	@Override
	public void deleteMenu(HttpServletRequest req) {
		Menu m = new Menu();
		String deleteStr = req.getParameter("deleteStr");
		m.setmName(deleteStr);
		req.setAttribute("menuList", mdao.deleteMenu(m));
	}
}

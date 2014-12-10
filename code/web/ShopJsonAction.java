package org.eg.sc.web;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.eg.sc.entity.OrderCar;
import org.eg.sc.entity.User;
import org.eg.sc.service.ShoppingCartService;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionSupport;

/*
 * Copyright (C) 2014 tqlbigdata（tangqianlong） <tqlbigdata@163.com>
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

/**
 * 描述功能
 * 
 * @author: tqlbigdata
 * @mailto:tqlbigdata@163.com
 * @date: 2014年11月24日
 * @blog : http://tqlbigdata.github.io/
 * @review
 */
@Controller
public class ShopJsonAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private Map<String, Object> datas = new HashMap<>();
	private User user;
	private List<Integer> ids;
	private List<String> infos;

	@Resource
	private ShoppingCartService shopCartServiceImpl;

	public String reg() {
		try {
			shopCartServiceImpl.reg(user);
			datas.put("flag", 1);
		} catch (Exception e) {
			e.printStackTrace();
			datas.put("flag", 0);
		}

		return SUCCESS;
	}

	public String clear() {
		try {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			OrderCar car = new OrderCar();
			session.setAttribute("Car", car);
			datas.put("flag", 1);
		} catch (Exception e) {
			e.printStackTrace();
			datas.put("flag", 0);
		}

		return SUCCESS;
	}

	public String delItem() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		OrderCar car = (OrderCar) session.getAttribute("Car");
		for (Integer id : ids) {
			car.removeProduct(id);
		}
		datas.put("flag", 1);
		return SUCCESS;
	}

	public String modifyItem() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		OrderCar car = (OrderCar) session.getAttribute("Car");
		for (String info : infos) {
			String[] strs = info.split(":");
			car.modifyProduct(Integer.parseInt(strs[0]),
					Integer.parseInt(strs[1]));
		}
		datas.put("flag", 1);
		return SUCCESS;
	}

	public ShoppingCartService getShopCartServiceImpl() {
		return shopCartServiceImpl;
	}

	public void setShopCartServiceImpl(ShoppingCartService shopCartServiceImpl) {
		this.shopCartServiceImpl = shopCartServiceImpl;
	}

	public Map<String, Object> getDatas() {
		return datas;
	}

	public void setDatas(Map<String, Object> datas) {
		this.datas = datas;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<Integer> getIds() {
		return ids;
	}

	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}

	public List<String> getInfos() {
		return infos;
	}

	public void setInfos(List<String> infos) {
		this.infos = infos;
	}

}

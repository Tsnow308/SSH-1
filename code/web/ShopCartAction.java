package org.eg.sc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.eg.sc.entity.Order;
import org.eg.sc.entity.OrderCar;
import org.eg.sc.entity.Product;
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
public class ShopCartAction extends ActionSupport {
	private static final long serialVersionUID = 1L;

	@Resource
	private ShoppingCartService shoppingCartServiceImpl;

	private User user;
	private Product product;
	private OrderCar car;

	public String queryAllProduct() {
		List<Product> products = shoppingCartServiceImpl.queryAllProduct();
		HttpServletRequest request = ServletActionContext.getRequest();
		request.setAttribute("products", products);
		HttpSession session = ServletActionContext.getRequest().getSession();
		OrderCar car = (OrderCar) session.getAttribute("Car");
		if (car == null) {
			car = new OrderCar();
			session.setAttribute("Car", car);
		}

		return SUCCESS;
	}

	public String login() {
		User u = shoppingCartServiceImpl.login(user);
		if (u == null) {
			return ERROR;
		} else {
			HttpSession session = ServletActionContext.getRequest()
					.getSession();
			// OrderCar car = (OrderCar) session.getAttribute("Car");
			// OrderCar car = new OrderCar();
			session.setAttribute("User", u);
			// session.setAttribute("Car", car);
			return "list";
		}
	}

	public String addToCart() {
		HttpSession session = ServletActionContext.getRequest().getSession();
		OrderCar car = (OrderCar) session.getAttribute("Car");
		if (car == null) {
			car = new OrderCar();
			car.addProduct(product);
			session.setAttribute("Car", car);
		} else {
			car.addProduct(product);
		}

		return "list";
	}

	public String saveOrder() {
		Order order = new Order();
		HttpSession session = ServletActionContext.getRequest().getSession();
		car = (OrderCar) session.getAttribute("Car");

		User user = (User) session.getAttribute("User");
		order.setStatus(1);
		order.setUser(user);
		order.setCost(car.getTotalPrice());
		order.setItems(car.getItems());
		car.clear();
		shoppingCartServiceImpl.saveOrder(order);
		return "cart";
	}

	public ShoppingCartService getShoppingCartServiceImpl() {
		return shoppingCartServiceImpl;
	}

	public void setShoppingCartServiceImpl(
			ShoppingCartService shoppingCartServiceImpl) {
		this.shoppingCartServiceImpl = shoppingCartServiceImpl;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public OrderCar getCar() {
		return car;
	}

	public void setCar(OrderCar car) {
		this.car = car;
	}

}
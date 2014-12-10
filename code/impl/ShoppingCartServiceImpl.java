/*
 * Copyright (C) 2014 0xC000005（xiehui） <flexie@foxmail.com>
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
package org.eg.sc.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.eg.sc.dao.OrderDaoImpl;
import org.eg.sc.dao.ProductDaoImpl;
import org.eg.sc.dao.UserDaoImpl;
import org.eg.sc.entity.Order;
import org.eg.sc.entity.Product;
import org.eg.sc.entity.User;
import org.eg.sc.service.ShoppingCartService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author: 0xC000005
 * @mailto: flexie@foxmail.com
 * @date: 2014年11月20日
 * @blog : http://0xC000005.github.io/
 * @review
 */
@Transactional
@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
	@Resource
	private ProductDaoImpl productDaoImpl;
	@Resource
	private UserDaoImpl userDaoImpl;
	@Resource
	private OrderDaoImpl orderDaoImpl;

	@Transactional(readOnly = true)
	@Override
	public List<Product> queryAllProduct() {
		return productDaoImpl.queryAll();
	}

	@Override
	public void reg(User user) {
		userDaoImpl.add(user);

	}

	@Override
	public void saveOrder(Order order) {
		orderDaoImpl.add(order);
	}

	@Override
	public User login(User user) {
		List<User> users = userDaoImpl.findByProperty("name", user.getName());
		if (users != null) {
			for (User u : users) {
				if (user.getPassword().equals(u.getPassword())) {
					return u;
				}
			}
		}
		return null;
	}

	public UserDaoImpl getUserDaoImpl() {
		return userDaoImpl;
	}

	public void setUserDaoImpl(UserDaoImpl userDaoImpl) {
		this.userDaoImpl = userDaoImpl;
	}

	public ProductDaoImpl getProductDaoImpl() {
		return productDaoImpl;
	}

	public void setProductDaoImpl(ProductDaoImpl productDaoImpl) {
		this.productDaoImpl = productDaoImpl;
	}

	public OrderDaoImpl getOrderDaoImpl() {
		return orderDaoImpl;
	}

	public void setOrderDaoImpl(OrderDaoImpl orderDaoImpl) {
		this.orderDaoImpl = orderDaoImpl;
	}

}

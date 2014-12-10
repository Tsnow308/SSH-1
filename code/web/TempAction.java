package org.eg.sc.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.eg.sc.entity.Product;
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
 * @date: 2014年11月26日
 * @blog : http://tqlbigdata.github.io/
 * @review
 */
@Controller
public class TempAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	@Resource
	private ShoppingCartService shoppingCartServiceImpl;

	@Override
	public String execute() {
		HttpServletRequest request = ServletActionContext.getRequest();
		List<Product> products = shoppingCartServiceImpl.queryAllProduct();
		request.getSession().setAttribute("User", null);
		request.setAttribute("products", products);
		request.getSession().setAttribute("Car", null);
		return SUCCESS;
	}
}

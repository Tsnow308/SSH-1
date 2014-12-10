package org.eg.sc.entity;

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
public class OrderItem {
	private Integer id;
	private Integer amount;
	private Product product;
	private Order order;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof OrderItem) {
			OrderItem item = (OrderItem) obj;
			return this.id.equals(item.getId());
		}
		return false;
	}
}

package org.eg.sc.entity;

import java.util.HashSet;
import java.util.Set;

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
public class OrderCar {

    private Set<OrderItem> items      = new HashSet<OrderItem>();
    private Double         totalPrice = new Double(0.0);

    public void addProduct(Product product) {
        totalPrice = totalPrice + product.getPrice();
        for (OrderItem item : items) {
            if (product.getId().equals(item.getProduct().getId())) {
                item.setAmount(item.getAmount() + 1);
                return;
            }
        }
        OrderItem item = new OrderItem();
        item.setProduct(product);
        item.setAmount(1);
        items.add(item);
    }

    public void clear() {
        items = new HashSet<OrderItem>();
        totalPrice = new Double(0.0);
    }

    public void modifyProduct(Integer productId, Integer amount) {

        for (OrderItem item : items) {
            if (productId.equals(item.getProduct().getId())) {
                totalPrice = totalPrice + ((amount - item.getAmount()) * item.getProduct().getPrice());
                item.setAmount(amount);
            }
        }
    }

    public void removeProduct(Integer productId) {
        OrderItem temp = null;
        for (OrderItem item : items) {
            if (productId.equals(item.getProduct().getId())) {
                temp = item;
            }
        }
        if (temp != null) {
            items.remove(temp);
            totalPrice = totalPrice - temp.getAmount() * temp.getProduct().getPrice();
        }
    }

    public Set<OrderItem> getItems() {
        return items;
    }

    public void setItems(Set<OrderItem> items) {
        this.items = items;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }
}

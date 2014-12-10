package org.eg.sc.service;

import org.eg.sc.entity.User;

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
public interface UserService {
	void reg(User user);

	User login(String name, String pwd);
}

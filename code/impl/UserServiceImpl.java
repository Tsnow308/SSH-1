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

import org.eg.sc.dao.UserDaoImpl;
import org.eg.sc.entity.User;
import org.eg.sc.service.UserService;
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
@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Resource
	private UserDaoImpl userDaoImpl;

	@Override
	public void reg(User user) {
		userDaoImpl.add(user);
	}

	@Transactional(readOnly = true)
	@Override
	public User login(String name, String pwd) {
		List<User> users = userDaoImpl.findByProperty("name", name);
		if (users != null) {
			for (User user : users) {
				if (user.getPassword().equals(pwd)) {
					return user;
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

}

package org.eg.sc.util;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

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
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Resource
	private SessionFactory sessionFactory;

	private final Class<T> persistentClass;

	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		this.persistentClass = (Class<T>) ((ParameterizedType) getClass()
				.getGenericSuperclass()).getActualTypeArguments()[0];
	}

	public Class<T> getPersistentClass() {
		return persistentClass;
	}

	@Override
	public void add(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}

	@Override
	public void delete(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.delete(t);
	}

	@Override
	public void update(T t) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(t);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<T> queryAll() {
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from " + getPersistentClass().getName();
		Query query = session.createQuery(queryString);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public T queryById(Integer id) {
		Session session = sessionFactory.getCurrentSession();
		return (T) session.get(this.getPersistentClass(), id);
	}

	@Override
	@SuppressWarnings("unchecked")
	public List<T> findByProperty(String propertyName, Object value) {
		Session session = sessionFactory.getCurrentSession();
		String queryString = "from " + getPersistentClass().getName()
				+ " as model where model." + propertyName + "= ?";
		Query query = session.createQuery(queryString);
		query.setParameter(0, value);
		return query.list();
	}

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

}
package com.yzxd.framework.ssh.core.persistence.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.yzxd.framework.ssh.core.exception.DAOException;
import com.yzxd.framework.ssh.core.persistence.BaseHibernateDao;

@SuppressWarnings(value = { "unchecked", "rawtypes" })
public class BaseHibernateDaoImpl implements BaseHibernateDao {

	@Resource
	private HibernateTemplate hibernateTemplate;

	private Session getSession() {
		return hibernateTemplate.getSessionFactory().getCurrentSession();
	}

	@Override
	public <T> void add(T entity) throws DAOException {
		if (entity != null) {
			hibernateTemplate.save(entity);
		}
	}

	@Override
	public <T> void addBatch(List<T> entitys) throws DAOException {
		if (entitys != null && entitys.size() > 0) {
			for (int i = 0; i < entitys.size(); i++) {
				hibernateTemplate.save(entitys.get(i));
			}
		}
	}

	@Override
	public <T> void save(T entity) throws DAOException {
		if (entity != null) {
			hibernateTemplate.save(entity);
		}
	}

	@Override
	public <T> void saveBatch(List<T> entitys) throws DAOException {
		if (entitys != null && entitys.size() > 0) {
			for (int i = 0; i < entitys.size(); i++) {
				hibernateTemplate.save(entitys.get(i));
			}
		}
	}

	@Override
	public <T> void update(T entity) throws DAOException {
		if (entity != null) {
			hibernateTemplate.update(entity);
		}
	}

	@Override
	public <T> void updateBatch(List<T> entitys) throws DAOException {
		if (entitys != null && entitys.size() > 0) {
			for (int i = 0; i < entitys.size(); i++) {
				hibernateTemplate.update(entitys.get(i));
			}
		}
	}

	public void update(String hql) throws DAOException {
		getSession().createQuery(hql).executeUpdate();
	}

	@Override
	public void update(String hql, Object... params) throws DAOException {
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		query.executeUpdate();
	}

	@Override
	public void update(String hql, Map<String, Object> params) throws DAOException {
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		query.executeUpdate();
	}

	@Override
	public void update(String hql, List<Object> params) throws DAOException {
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		query.executeUpdate();
	}

	@Override
	public <T> void delete(T entity) throws DAOException {
		if (entity != null) {
			hibernateTemplate.delete(entity);
		}
	}

	@Override
	public void delete(String hql) throws DAOException {
		if (hql != null) {
			Query query = getSession().createQuery(hql);
			query.executeUpdate();
		}
	}

	@Override
	public void delete(String hql, Object... params) throws DAOException {
		if (hql != null) {
			Query query = getSession().createQuery(hql);
			setParameter(query, params);
			query.executeUpdate();
		}
	}

	@Override
	public <T> void deleteBatch(List<T> entitys) throws DAOException {
		for (int i = 0; entitys != null && i < entitys.size(); i++) {
			hibernateTemplate.delete(entitys.get(i));
		}
	}

	@Override
	public <T> void deleteBatch(Class<T> clazz, Serializable[] ids) throws DAOException {
		for (int i = 0; ids != null && i < ids.length; i++) {
			T entity = hibernateTemplate.get(clazz, ids[i]);
			if (entity != null)
				hibernateTemplate.delete(entity);
		}
	}

	@Override
	public <T> T load(Class<T> clazz, Serializable id) throws DAOException {
		return hibernateTemplate.load(clazz, id);
	}

	@Override
	public <T> T get(Class<T> clazz, Serializable id) throws DAOException {
		return (T) hibernateTemplate.get(clazz, id);
	}

	@Override
	public <T> T get(String hql) throws DAOException {
		if (hql != null) {
			List<T> list = (List<T>) hibernateTemplate.find(hql);
			if (list != null && list.size() > 0) {
				return (T) list.get(0);
			}
		}
		return null;
	}

	@Override
	public <T> T get(String hql, Object... params) throws DAOException {
		if (hql != null) {
			List<?> list = hibernateTemplate.find(hql, params);
			if (list != null && list.size() > 0) {
				return (T) list.get(0);
			}
		}
		return null;
	}

	@Override
	public <T> T get(String hql, List<Object> params) throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return (T) list.get(0);

		return null;
	}

	@Override
	public <T> T get(String hql, Map<String, Object> params) throws DAOException {

		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return (T) list.get(0);

		return null;

	}

	@Override
	public <T> Long getTotalCount(Class<T> clazz) throws DAOException {

		String hql = (new StringBuilder("select count(*) from ")).append(clazz.getName()).toString();
		Object ur = getSession().createQuery(hql).uniqueResult();
		return Long.valueOf(ur.toString());

		// Criteria c = getSession().createCriteria(clazz.getName());
		// c.setProjection(Projections.rowCount());
		// return Long.valueOf(c.uniqueResult().toString());

	}

	@Override
	public Long getTotalCount(String hql) throws DAOException {
		Object count = getSession().createQuery(hql).uniqueResult();
		return Long.valueOf(count.toString());
	}

	@Override
	public Long getTotalCount(String hql, Object... params) throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		Object count = query.uniqueResult();
		return Long.valueOf(count.toString());
	}

	@Override
	public Long getTotalCount(String hql, List<Object> params) throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		Object count = query.uniqueResult();
		return Long.valueOf(count.toString());
	}

	@Override
	public Long getTotalCount(String hql, Map<String, Object> params) throws DAOException {

		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		Object count = query.uniqueResult();
		return Long.valueOf(count.toString());
	}

	@Override
	public Long getTotalCountBySql(String sql, Object... params) throws DAOException {
		Query query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		Object count = query.uniqueResult();
		return Long.valueOf(count.toString());
	}

	@Override
	public Long getTotalCountBySql(String sql, List<Object> params) throws DAOException {
		Query query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		Object count = query.uniqueResult();
		return Long.valueOf(count.toString());
	}

	@Override
	public Long getTotalCountBySql(String sql, Map<String, Object> params) throws DAOException {
		Query query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		Object count = query.uniqueResult();
		return Long.valueOf(count.toString());
	}

	@Override
	public <T> List<T> findList(Class<T> clazz) throws DAOException {
		return (List<T>) hibernateTemplate.find("from " + clazz.getName());
	}

	@Override
	public <T> List<T> findList(String hql) throws DAOException {
		return (List<T>) hibernateTemplate.find(hql);
	}

	@Override
	public <T> List<T> findList(String hql, Object... params) throws DAOException {
		return (List<T>) hibernateTemplate.find(hql, params);
	}

	@Override
	public <T> List<T> findList(String hql, List<Object> params) throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return list;

		return null;
	}

	@Override
	public <T> List<T> findList(String hql, Map<String, Object> params) throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return list;

		return null;
	}

	@Override
	public List<Map<String, Object>> findList(String hql, Map<String, Class<?>> clazzs, Object... params)
			throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		List list = query.list();
		
		return setData(list, clazzs);
	}

	@Override
	public List<Map<String, Object>> findList(String hql, Map<String, Class<?>> clazzs, List<Object> params)
			throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		List list = query.list();
		
		return setData(list, clazzs);
	}

	@Override
	public List<Map<String, Object>> findList(String hql, Map<String, Class<?>> clazzs, Map<String, Object> params)
			throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		List list = query.list();
		
		return setData(list, clazzs);
		
	}

	@Override
	public <T> List<T> findListBySql(Class<T> clazz, String sql) throws DAOException {
		SQLQuery query = getSession().createSQLQuery(sql);

		query.setResultTransformer(Transformers.aliasToBean(clazz));

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return list;

		return null;
	}

	@Override
	public <T> List<T> findListBySql(Class<T> clazz, String sql, Object... params) throws DAOException {
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.setResultTransformer(Transformers.aliasToBean(clazz));

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return list;

		return null;
	}

	@Override
	public <T> List<T> findListBySql(Class<T> clazz, String sql, List<Object> params) throws DAOException {
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.setResultTransformer(Transformers.aliasToBean(clazz));

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return list;

		return null;
	}

	@Override
	public <T> List<T> findListBySql(Class<T> clazz, String sql, Map<String, Object> params) throws DAOException {
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.setResultTransformer(Transformers.aliasToBean(clazz));

		List<T> list = query.list();
		if (list != null && list.size() > 0)
			return list;

		return null;
	}

	@Override
	public <T> List<T> findListBySql(String sql, String tableAlias, Class<T> clazz, Object... params)
			throws DAOException {
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.addEntity(tableAlias, clazz);

		List list = query.list();

		return list;
	}

	@Override
	public <T> List<T> findListBySql(String sql, String tableAlias, Class<T> clazz, List<Object> params)
			throws DAOException {
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.addEntity(tableAlias, clazz);

		List list = query.list();

		return list;
	}

	@Override
	public <T> List<T> findListBySql(String sql, String tableAlias, Class<T> clazz, Map<String, Object> params)
			throws DAOException {
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.addEntity(tableAlias, clazz);

		List list = query.list();

		return list;
	}

	@Override
	public List<Map<String, Object>> findListBySql(String sql, Map<String, Class<?>> clazzs, Object... params)
			throws DAOException {
		
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		addEntity(query, clazzs);

		List list = query.list();
		
		return setData(list, clazzs);
		
	}

	@Override
	public List<Map<String, Object>> findListBySql(String sql, Map<String, Class<?>> clazzs, List<Object> params)
			throws DAOException {

		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		addEntity(query, clazzs);

		List list = query.list();
		
		return setData(list, clazzs);

	}

	@Override
	public List<Map<String, Object>> findListBySql(String sql, Map<String, Class<?>> clazzs, Map<String, Object> params)
			throws DAOException {
		
		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		addEntity(query, clazzs);

		List list = query.list();
		
		return setData(list, clazzs);

	}

	@Override
	public <T> Map<String, Object> findPage(Class<T> clazz, Integer pageNum, Integer pageSize) throws DAOException {

		String hql = "from " + clazz.getName();
		Query query = getSession().createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List<T> list = query.list();

		Long totalCount = getTotalCount(clazz);

		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;
	}

	@Override
	public Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize) throws DAOException {

		Query query = getSession().createQuery(hql);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();

		Long totalCount = getTotalCount(formatHqlOrSql(hql));

		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;

	}

	@Override
	public Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Object... params)
			throws DAOException {
		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);

		List list = query.list();

		Long totalCount = getTotalCount(formatHqlOrSql(hql), params);

		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;
	}

	@Override
	public Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, List<Object> params)
			throws DAOException {

		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);

		List list = query.list();

		Long totalCount = getTotalCount(formatHqlOrSql(hql), params);

		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;
	}

	@Override
	public Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Object> params)
			throws DAOException {

		Query query = getSession().createQuery(hql);

		setParameter(query, params);

		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);

		List list = query.list();

		Long totalCount = getTotalCount(formatHqlOrSql(hql), params);

		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;
	}

	@Override
	public Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Class<?>> clazzs,
			Object... params) throws DAOException {

		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();

		Long totalCount = getTotalCount(formatHqlOrSql(hql), params);
		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", setData(list, clazzs));

		return map;

	}

	@Override
	public Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Class<?>> clazzs,
			List<Object> params) throws DAOException {
		
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();

		Long totalCount = getTotalCount(formatHqlOrSql(hql), params);
		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", setData(list, clazzs));

		return map;
	}

	@Override
	public Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Class<?>> clazzs,
			Map<String, Object> params) throws DAOException {
		
		Query query = getSession().createQuery(hql);
		setParameter(query, params);
		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);
		List list = query.list();

		Long totalCount = getTotalCount(formatHqlOrSql(hql), params);
		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", setData(list, clazzs));

		return map;
		
	}

	@Override
	public Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize, String tableAlias,
			Class<?> clazz, Object... params) throws DAOException {

		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);

		query.addEntity(tableAlias, clazz);

		List<?> list = query.list();

		Long totalCount = getTotalCountBySql(formatHqlOrSql(sql), params);
		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;
	}

	@Override
	public Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize, String tableAlias,
			Class<?> clazz, List<Object> params) throws DAOException {

		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);

		query.addEntity(tableAlias, clazz);

		List<?> list = query.list();

		Long totalCount = getTotalCountBySql(formatHqlOrSql(sql), params);
		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;
	}

	@Override
	public Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize, String tableAlias,
			Class<?> clazz, Map<String, Object> params) throws DAOException {

		SQLQuery query = getSession().createSQLQuery(sql);

		setParameter(query, params);

		query.setFirstResult((pageNum - 1) * pageSize);
		query.setMaxResults(pageSize);

		query.addEntity(tableAlias, clazz);

		List<?> list = query.list();

		Long totalCount = getTotalCountBySql(formatHqlOrSql(sql), params);
		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", list);

		return map;

	}

	@Override
	public Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize,
			Map<String, Class<?>> clazzs, Object... params) throws DAOException {
		
		SQLQuery query = getSession().createSQLQuery(sql);
		setParameter(query, params);
		addEntity(query, clazzs);
		List list = query.list();

		Long totalCount = getTotalCountBySql(formatHqlOrSql(sql), params);
		Map<String, Object> map = new HashMap<>();
		map.put("TotalCount", totalCount);
		map.put("TotalPage", (totalCount - 1) / pageSize + 1);
		map.put("PageNum", pageNum);
		map.put("PageSize", pageSize);
		map.put("PageData", setData(list, clazzs));

		return map;
	}

	private String formatHqlOrSql(String hsql) {
		String hsqlBak = hsql;
		String strHSql = "";
		if (hsqlBak.toUpperCase().indexOf("SELECT") == -1) {
			strHSql += "SELECT COUNT(*) " + hsql;
		} else if (hsqlBak.toUpperCase().indexOf("SELECT") < 6) {
			strHSql += "SELECT COUNT(*) " + hsqlBak.substring(hsqlBak.toUpperCase().indexOf("FROM"));
		}
		return strHSql;
	}

	private void setParameter(Query query, Object... params) {
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

	private void setParameter(Query query, List<Object> params) {
		for (int i = 0; params != null && i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
	}

	private void setParameter(Query query, Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			Set<String> sets = params.keySet();
			Iterator<String> iterator = sets.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				query.setParameter(key, params.get(key));
			}
		}
	}

	private void setParameter(SQLQuery query, Object... params) {
		for (int i = 0; params != null && i < params.length; i++) {
			query.setParameter(i, params[i]);
		}
	}

	private void setParameter(SQLQuery query, List<Object> params) {
		for (int i = 0; params != null && i < params.size(); i++) {
			query.setParameter(i, params.get(i));
		}
	}

	private void setParameter(SQLQuery query, Map<String, Object> params) {
		if (params != null && params.size() > 0) {
			Set<String> sets = params.keySet();
			Iterator<String> iterator = sets.iterator();
			while (iterator.hasNext()) {
				String key = iterator.next();
				query.setParameter(key, params.get(key));
			}
		}
	}

	private void addEntity(SQLQuery query, Map<String, Class<?>> clazzs) {
		if (clazzs != null && clazzs.size() > 0) {
			Set<String> keySet = clazzs.keySet();
			Iterator<String> iterator = keySet.iterator();

			while (iterator.hasNext()) {
				String key = iterator.next();
				Class<?> clazz = clazzs.get(key);
				query.addEntity(key, clazz);
			}
		}
	}
	
	private List<Map<String, Object>> setData(List list, Map<String, Class<?>> clazzs) {
		if (list != null && list.size() > 0) {
			List<Map<String, Object>> retList = new ArrayList<>();
			for (int i = 0; i < list.size(); i++) {

				Object[] obj = (Object[]) list.get(i);
				Map<String, Object> retMap = new HashMap<>();

				for (int j = 0; j < obj.length; j++) {

					if (obj[j] == null)
						continue;

					Class<? extends Object> class1 = obj[j].getClass();

					if (clazzs != null && clazzs.size() > 0) {
						Set<String> keySet = clazzs.keySet();
						Iterator<String> iterator = keySet.iterator();
						while (iterator.hasNext()) {
							String key = iterator.next();
							Class<?> clazz = clazzs.get(key);

							if (class1.getName().equals(clazz.getName())) {
								retMap.put(key, obj[j]);
								break;
							}
						}
					}
				}

				retList.add(retMap);

			}
			return retList;
		}
		return null;
	}
	
}

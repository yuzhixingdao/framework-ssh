package com.yzxd.framework.ssh.core.persistence;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.yzxd.framework.ssh.core.exception.DAOException;

public interface BaseHibernateDao {

	/**
	 * add entity
	 * 
	 * @param entity
	 * @throws DAOException
	 */
	<T> void add(T entity) throws DAOException;

	<T> void addBatch(List<T> entitys) throws DAOException;

	/**
	 * save entity
	 * 
	 * @param entity
	 * @throws DAOException
	 */
	<T> void save(T entity) throws DAOException;

	<T> void saveBatch(List<T> entitys) throws DAOException;

	/**
	 * update entity
	 * 
	 * @param entity
	 * @throws DAOException
	 */
	<T> void update(T entity) throws DAOException;

	<T> void updateBatch(List<T> entitys) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            update Entity set property_a = 'value_a', property_b =
	 *            'value_b' ...
	 *            </p>
	 * @throws DAOException
	 */
	void update(String hql) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            update Entity set property_a = ?, property_b = ? ...
	 *            </p>
	 * @param params
	 * @throws DAOException
	 */
	void update(String hql, Object... params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            update Entity set property_a = ?, property_b = ? ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add("value a");<br/>
	 *            params.add("value b");
	 *            </p>
	 * @throws DAOException
	 */
	void update(String hql, List<Object> params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            update Entity set property_a = :a, property_b = :b ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("a", "value a");<br/>
	 *            params.put("b", "value b");
	 *            </p>
	 * @throws DAOException
	 */
	void update(String hql, Map<String, Object> params) throws DAOException;

	/**
	 * delete entity
	 * 
	 * @param entity
	 * @throws DAOException
	 */
	<T> void delete(T entity) throws DAOException;

	/**
	 * delete entity
	 * 
	 * @param hql
	 *            delete Entity where id = 1
	 * @throws DAOException
	 */
	void delete(String hql) throws DAOException;

	/**
	 * delete entity
	 * 
	 * @param hql
	 * @param params
	 * @throws DAOException
	 */
	void delete(String hql, Object... params) throws DAOException;

	/**
	 * delete entity
	 * 
	 * @param entitys
	 * @throws DAOException
	 */
	<T> void deleteBatch(List<T> entitys) throws DAOException;

	/**
	 * delete entity
	 * 
	 * @param cazz
	 * @param ids
	 * @throws DAOException
	 */
	<T> void deleteBatch(Class<T> cazz, Serializable[] ids) throws DAOException;

	/**
	 * load entity
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	<T> T load(Class<T> clazz, Serializable id) throws DAOException;

	/**
	 * get entity
	 * 
	 * @param clazz
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	<T> T get(Class<T> clazz, Serializable id) throws DAOException;

	/**
	 * 
	 * @param hql
	 * @return
	 * @throws DAOException
	 */
	<T> T get(String hql) throws DAOException;

	/**
	 * get entity
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = ? and property_b = ? and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            new Object[]{value_a, value_b, ...}
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> T get(String hql, Object... params) throws DAOException;

	/**
	 * get entity
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = ? and property_b = ? and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> T get(String hql, List<Object> params) throws DAOException;

	/**
	 * get entity
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = :a and property_b = :b and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("a", value_a);<br/>
	 *            params.put("b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> T get(String hql, Map<String, Object> params) throws DAOException;

	/**
	 * get total count
	 * 
	 * @param clazz
	 * @return
	 * @throws DAOException
	 */
	<T> Long getTotalCount(Class<T> clazz) throws DAOException;

	/**
	 * get total count
	 * 
	 * @param hql
	 *            <p>
	 *            select count(id) from Entity
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	Long getTotalCount(String hql) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = ? and property_b = ? and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            new Object[]{value_a, value_b}
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	Long getTotalCount(String hql, Object... params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = ? and property_b = ? and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add("value a");<br/>
	 *            params.add("value b");
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	Long getTotalCount(String hql, List<Object> params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = :a and property_b = :b and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("a", "value a");<br/>
	 *            params.put("b", "value b");
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	Long getTotalCount(String hql, Map<String, Object> params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            select count(*) from table where column_a = ? and column_b = ?
	 *            and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            new Object[]{value_a, value_b}
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	Long getTotalCountBySql(String sql, Object... params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            select count(*) from table where column_a = ? and column_b = ?
	 *            and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	Long getTotalCountBySql(String sql, List<Object> params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            select count(*) from table where column_a = :column_a and
	 *            column_b = :column_b and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("column_a", value_a);<br/>
	 *            params.put("column_b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	Long getTotalCountBySql(String sql, Map<String, Object> params) throws DAOException;

	/**
	 * find entity list
	 * 
	 * @param clazz
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findList(Class<T> clazz) throws DAOException;

	/**
	 * find entity list
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = 'value_a' and property_b =
	 *            'value_b' and ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findList(String hql) throws DAOException;

	/**
	 * find entity list
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = ? and property_b = ? and ...
	 *            </p>
	 * @param params
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findList(String hql, Object... params) throws DAOException;

	/**
	 * find entity list
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = ? and property_b = ? and ...
	 *            </p>
	 * @param params
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findList(String hql, List<Object> params) throws DAOException;

	/**
	 * find entity list
	 * 
	 * @param hql
	 *            <p>
	 *            from Entity where property_a = :a and property_b = :b and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("a", "value a");<br/>
	 *            params.put("b", "value b");<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findList(String hql, Map<String, Object> params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            select a, b, ... from EntityA a, EntityB b, ... where a.id =
	 *            b.aId and a.property_a = ? and b.property_b = ? and ...
	 *            </p>
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            new Object[]{value_a, value_b, ...}
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	List<Map<String, Object>> findList(String hql, Map<String, Class<?>> clazzs, Object... params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            select a, b, ... from EntityA a, EntityB b, ... where a.id =
	 *            b.aId and a.property_a = ? and b.property_b = ? and ...
	 *            </p>
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	List<Map<String, Object>> findList(String hql, Map<String, Class<?>> clazzs, List<Object> params)
			throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            select a, b, ... from EntityA a, EntityB b, ... where a.id =
	 *            b.aId and a.property_a = :property_a and b.property_b =
	 *            :property_b and ...
	 *            </p>
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("property_a", value_a);<br/>
	 *            params.put("property_b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	List<Map<String, Object>> findList(String hql, Map<String, Class<?>> clazzs, Map<String, Object> params)
			throws DAOException;

	/**
	 * 
	 * @param clazz
	 *            pojo class
	 * @param sql
	 *            <p>
	 *            select column_a columnA, column_b columnB, ... from table_name
	 *            where column_a = 'value_a' and column_b = 'value_b' and ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findListBySql(Class<T> clazz, String sql) throws DAOException;

	/**
	 * 
	 * @param clazz
	 *            pojo class
	 * @param sql
	 *            <p>
	 *            select column_a columnA, column_b columnB, ... from table_name
	 *            where column_a = ? and column_b = ? and ...
	 *            </p>
	 * @param params
	 *            new Object[]{value_a, value_b, ...}
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findListBySql(Class<T> clazz, String sql, Object... params) throws DAOException;

	/**
	 * 
	 * @param clazz
	 *            pojo class
	 * @param sql
	 *            <p>
	 *            select column_a columnA, column_b columnB, ... from table_name
	 *            where column_a = ? and column_b = ? and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findListBySql(Class<T> clazz, String sql, List<Object> params) throws DAOException;

	/**
	 * 
	 * @param clazz
	 *            pojo class
	 * @param sql
	 *            <p>
	 *            select column_a columnA, column_b columnB, ... from table_name
	 *            where column_a = :column_a and column_b = :column_b and ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("column_a", value_a);<br/>
	 *            params.put("column_b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findListBySql(Class<T> clazz, String sql, Map<String, Object> params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*} from table_a a, table_b b where a.id = b.id
	 *            and a.column_a = ? and b.column_b = ? and ...
	 *            <p>
	 *            2. select {a.*} from table_a a inner join [left join] [right
	 *            join] table_b b on a.id = b.id where a.column_a = ? and
	 *            b.column_b = ? and ...
	 *            </p>
	 * @param tableAlias
	 *            table alias
	 * @param clazz
	 *            Entity.class
	 * @param params
	 *            new Object[]{value_a, value_b, ...}
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findListBySql(String sql, String tableAlias, Class<T> clazz, Object... params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*} from table_a a, table_b b where a.id = b.id
	 *            and a.column_a = ? and b.column_b = ? and ...
	 *            <p>
	 *            2. select {a.*} from table_a a inner join [left join] [right
	 *            join] table_b b on a.id = b.id where a.column_a = ? and
	 *            b.column_b = ? and ...
	 *            </p>
	 * @param tableAlias
	 *            table alias
	 * @param clazz
	 *            Entity.class
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findListBySql(String sql, String tableAlias, Class<T> clazz, List<Object> params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*} from table_a a, table_b b where a.id = b.id
	 *            and a.column_a = :column_a and b.column_b = :column_b and ...
	 *            <p>
	 *            2. select {a.*} from table_a a inner join [left join] [right
	 *            join] table_b b on a.id = b.id where a.column_a = :column_a
	 *            and b.column_b = :column_b and ...
	 *            </p>
	 * @param tableAlias
	 *            table alias
	 * @param clazz
	 *            Entity.class
	 * @param params
	 *            <p>
	 *            params.put("column_a", value_a);<br/>
	 *            params.put("column_b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	<T> List<T> findListBySql(String sql, String tableAlias, Class<T> clazz, Map<String, Object> params)
			throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*}, {b.*} from table_a a, table_b b where a.id =
	 *            b.id a.column_a = ? and b.column_b = ? and ...
	 *            </p>
	 *            <p>
	 *            2. select {a.*}, {b.*} from table_a a inner join [left join]
	 *            [right join] table_b b on a.id = b.id where a.column_a = ? and
	 *            b.column_b = ? and ...
	 *            </p>
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            new Object[]{value_a, value_b, ...}
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	List<Map<String, Object>> findListBySql(String sql, Map<String, Class<?>> clazzs, Object... params)
			throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*}, {b.*} from table_a a, table_b b where a.id =
	 *            b.id a.column_a = ? and b.column_b = ? and ...
	 *            </p>
	 *            <p>
	 *            2. select {a.*}, {b.*} from table_a a inner join [left join]
	 *            [right join] table_b b on a.id = b.id where a.column_a = ? and
	 *            b.column_b = ? and ...
	 *            </p>
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	List<Map<String, Object>> findListBySql(String sql, Map<String, Class<?>> clazzs, List<Object> params)
			throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*}, {b.*} from table_a a, table_b b where a.id =
	 *            b.id and a.column_a = :column_a and b.column_b = :column_b and
	 *            ...
	 *            </p>
	 *            <p>
	 *            2. select {a.*}, {b.*} from table_a a inner join [left join]
	 *            [right join] table_b b on a.id = b.id where a.column_a =
	 *            :column_a and b.column_b = :column_b and ...
	 *            </p>
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("column_a", value_a);<br/>
	 *            params.put("column_b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 * @throws DAOException
	 */
	List<Map<String, Object>> findListBySql(String sql, Map<String, Class<?>> clazzs, Map<String, Object> params)
			throws DAOException;

	/**
	 * 
	 * @param clazz
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	<T> Map<String, Object> findPage(Class<T> clazz, Integer pageNum, Integer pageSize) throws DAOException;

	/**
	 * 
	 * @param hql
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize) throws DAOException;

	/**
	 * 
	 * @param hql
	 * @param pageNum
	 * @param pageSize
	 * @param params
	 * @return
	 * @throws DAOException
	 */
	Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Object... params) throws DAOException;

	/**
	 * 
	 * @param hql
	 * @param params
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, List<Object> params)
			throws DAOException;

	/**
	 * 
	 * @param hql
	 * @param params
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @throws DAOException
	 */
	Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Object> params)
			throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            select a, b, ... from EntityA a, EntityB b, ... where a.id =
	 *            b.aId and a.property_a = ? and b.property_b = ? and ...
	 *            </p>
	 * @param pageNum
	 *            page num
	 * @param pageSize
	 *            page size
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            new Object[]{value_a, value_b, ...}
	 *            </p>
	 * @return
	 *         <p>
	 *         key = TotalCount, value = 102 <br/>
	 *         key = TotalPage, value = 11 <br/>
	 *         key = PageNum, value = 1 <br/>
	 *         key = PageSize, value = 10 <br/>
	 *         key = PageData, value = list[{clazz_a=EntityA, clazz_b=EntityB}]
	 *         </p>
	 * @throws DAOException
	 */
	Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Class<?>> clazzs,
			Object... params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            select a, b, ... from EntityA a, EntityB b, ... where a.id =
	 *            b.aId and a.property_a = ? and b.property_b = ? and ...
	 *            </p>
	 * @param pageNum
	 *            page num
	 * @param pageSize
	 *            page size
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 *         <p>
	 *         key = TotalCount, value = 102 <br/>
	 *         key = TotalPage, value = 11 <br/>
	 *         key = PageNum, value = 1 <br/>
	 *         key = PageSize, value = 10 <br/>
	 *         key = PageData, value = list[{clazz_a=EntityA, clazz_b=EntityB}]
	 *         </p>
	 * @throws DAOException
	 */
	Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Class<?>> clazzs,
			List<Object> params) throws DAOException;

	/**
	 * 
	 * @param hql
	 *            <p>
	 *            select a, b, ... from EntityA a, EntityB b, ... where a.id =
	 *            b.aId and a.property_a = :property_a and b.property_b =
	 *            :property_b and ...
	 *            </p>
	 * @param pageNum
	 *            page num
	 * @param pageSize
	 *            page size
	 * @param clazzs
	 *            <p>
	 *            clazzs.put("a", EntityA.class);<br/>
	 *            clazzs.put("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            <p>
	 *            params.put("property_a", value_a);<br/>
	 *            params.put("property_b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 *         <p>
	 *         key = TotalCount, value = 102 <br/>
	 *         key = TotalPage, value = 11 <br/>
	 *         key = PageNum, value = 1 <br/>
	 *         key = PageSize, value = 10 <br/>
	 *         key = PageData, value = list[{clazz_a=EntityA, clazz_b=EntityB}]
	 *         </p>
	 * @throws DAOException
	 */
	Map<String, Object> findPage(String hql, Integer pageNum, Integer pageSize, Map<String, Class<?>> clazzs,
			Map<String, Object> params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*} from table_a a, table_b b where a.id = b.id
	 *            and a.column_a = ? and b.column_b = ? and ...
	 *            <p>
	 *            2. select {a.*} from table_a a inner join [left join] [right
	 *            join] table_b b on a.id = b.id where a.column_a = ? and
	 *            b.column_b = ? and ...
	 *            </p>
	 * @param pageNum
	 *            page num
	 * @param pageSize
	 *            page size
	 * @param tableAlias
	 *            table alias
	 * @param clazz
	 *            Entity.class
	 * @param params
	 *            new Object[]{value_a, value_b, ...}
	 * @return
	 *         <p>
	 *         key = TotalCount, value = 102 <br/>
	 *         key = TotalPage, value = 11 <br/>
	 *         key = PageNum, value = 1 <br/>
	 *         key = PageSize, value = 10 <br/>
	 *         key = PageData, value = list[{Entity}]
	 *         </p>
	 * @throws DAOException
	 */
	Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize, String tableAlias, Class<?> clazz,
			Object... params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*} from table_a a, table_b b where a.id = b.id
	 *            and a.column_a = ? and b.column_b = ? and ...
	 *            <p>
	 *            2. select {a.*} from table_a a inner join [left join] [right
	 *            join] table_b b on a.id = b.id where a.column_a = ? and
	 *            b.column_b = ? and ...
	 *            </p>
	 * @param pageNum
	 *            page num
	 * @param pageSize
	 *            page size
	 * @param tableAlias
	 *            table alias
	 * @param clazz
	 *            Entity.class
	 * @param params
	 *            <p>
	 *            params.add(value_a);<br/>
	 *            params.add(value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 *         <p>
	 *         key = TotalCount, value = 102 <br/>
	 *         key = TotalPage, value = 11 <br/>
	 *         key = PageNum, value = 1 <br/>
	 *         key = PageSize, value = 10 <br/>
	 *         key = PageData, value = list[{Entity}]
	 *         </p>
	 * @throws DAOException
	 */
	Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize, String tableAlias, Class<?> clazz,
			List<Object> params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*} from table_a a, table_b b where a.id = b.id
	 *            and a.column_a = :column_a and b.column_b = :column_b and ...
	 *            <p>
	 *            2. select {a.*} from table_a a inner join [left join] [right
	 *            join] table_b b on a.id = b.id where a.column_a = :column_a
	 *            and b.column_b = :column_b and ...
	 *            </p>
	 * @param pageNum
	 *            page num
	 * @param pageSize
	 *            page size
	 * @param tableAlias
	 *            table alias
	 * @param clazz
	 *            Entity.class
	 * @param params
	 *            <p>
	 *            params.put("column_a", value_a);<br/>
	 *            params.put("column_b", value_b);<br/>
	 *            ...
	 *            </p>
	 * @return
	 *         <p>
	 *         key = TotalCount, value = 102 <br/>
	 *         key = TotalPage, value = 11 <br/>
	 *         key = PageNum, value = 1 <br/>
	 *         key = PageSize, value = 10 <br/>
	 *         key = PageData, value = list[{Entity}]
	 *         </p>
	 * @throws DAOException
	 */
	Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize, String tableAlias, Class<?> clazz,
			Map<String, Object> params) throws DAOException;

	/**
	 * 
	 * @param sql
	 *            <p>
	 *            1. select {a.*}, {b.*} from table_a a, table_b b where a.id =
	 *            b.id and a.column_a = ? and b.column_b = ? and ...
	 *            <p>
	 *            2. select {a.*}, {b.*} from table_a a inner join [left join]
	 *            [right join] table_b b on a.id = b.id where a.column_a = ? and
	 *            b.column_b = ? and ...
	 *            </p>
	 * @param pageNum
	 *            page num
	 * @param pageSize
	 *            page size
	 * @param clazzs
	 *            <p>
	 *            clazzs.add("a", EntityA.class);<br/>
	 *            clazzs.add("b", EntityB.class);<br/>
	 *            ...
	 *            </p>
	 * @param params
	 *            new Object[]{value_a, value_b, ...}
	 * @return
	 *         <p>
	 *         key = TotalCount, value = 102 <br/>
	 *         key = TotalPage, value = 11 <br/>
	 *         key = PageNum, value = 1 <br/>
	 *         key = PageSize, value = 10 <br/>
	 *         key = PageData, value = list[{a=EntityA, b=EntityB}]
	 *         </p>
	 * @throws DAOException
	 */
	Map<String, Object> findPageBySql(String sql, Integer pageNum, Integer pageSize, Map<String, Class<?>> clazzs,
			Object... params) throws DAOException;

}

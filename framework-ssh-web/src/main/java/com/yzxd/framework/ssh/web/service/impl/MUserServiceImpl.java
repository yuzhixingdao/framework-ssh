package com.yzxd.framework.ssh.web.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yzxd.framework.ssh.core.exception.ServiceException;
import com.yzxd.framework.ssh.web.dao.MUserDao;
import com.yzxd.framework.ssh.web.entity.MUser;
import com.yzxd.framework.ssh.web.entity.MUserVip;
import com.yzxd.framework.ssh.web.service.MUserService;

@Service(value = "muserService")
public class MUserServiceImpl implements MUserService {

	@Autowired
	private MUserDao muserDao;

	@Override
	public MUser loadUser(String id) throws ServiceException {
		return muserDao.load(MUser.class, id);
	}

	@Override
	public MUser getUser(String id) throws ServiceException {
		// return muserDao.get(MUser.class, id);

		Map<String, Object> params = new HashMap<>();
		params.put("id", id);
		return muserDao.get("from MUser where id = :id ", params);
	}

	@Override
	public void addUser(MUser user) throws ServiceException {
		if (user != null) {
			muserDao.add(user);
		}
	}

	@Override
	public void updateUser(MUser user) throws ServiceException {
		// muserDao.update(user);

		// muserDao.update("update MUser set loginName='wangwu',
		// description='description' where id =
		// '4028f82d571da37001571da373550001' ");

		// muserDao.update("update MUser set loginName=?, description=? where id
		// =? ", "qiqi", "备注", "4028f82d571da37001571da373550001");

		Map<String, Object> params = new HashMap<>();
		params.put("loginName", "liuliu");
		params.put("description", "溜溜球");
		params.put("id", "4028f82d571da37001571da373550002");
		muserDao.update("update MUser set loginName=:loginName, description=:description where id = :id ", params);
	}

	@Override
	public Long getTotalCount() throws ServiceException {
		return muserDao.getTotalCount(MUser.class);
		// return muserDao.getTotalCount("select count(id) from MUser");
	}

	@Override
	public void addUserList(List<MUser> list) throws ServiceException {
		muserDao.addBatch(list);
		// for (int i = 0; list != null && i < list.size(); i++) {
		// if (i > 4) {
		// int a = 12 / 0;
		// }
		// muserDao.add(list.get(i));
		// }
	}

	@Override
	public void addUserVipList(List<MUserVip> list) throws ServiceException {
		muserDao.addBatch(list);
	}

	@Override
	public void deleteUser(MUser user) throws ServiceException {
		if (user != null) {
			muserDao.delete(user);
		}
	}

	@Override
	public void deleteUser(String id) throws ServiceException {
		muserDao.delete("delete MUser where id =  '" + id + "'");
	}

	@Override
	public void deleteUser(String[] ids) throws ServiceException {
		muserDao.deleteBatch(MUser.class, ids);
	}

	@Override
	public List findUserList() throws ServiceException {
		// return muserDao.findList(MUser.class);
		// return muserDao.findList("from MUser");
		// return muserDao.findList("from MUser where personName like ?",
		// "%11%");

		// ArrayList<Object> params = new ArrayList<>();
		// params.add("%12%");
		// return muserDao.findList("from MUser where personName like ?",
		// params);

		// Map<Integer, Object> params = new HashMap<>();
		// params.put(0, "%15%");
		// return muserDao.findList("from MUser where personName like ?",
		// params);

		String hql = "select a, b from MUser a, MUserVip b where a.id = b.userId and a.personName like ?";
		ArrayList<Object> params = new ArrayList<>();
		params.add("%1%");
		Map<String, Class<?>> clazzs = new HashMap<>();
		clazzs.put("a", MUser.class);
		clazzs.put("b", MUserVip.class);
		return muserDao.findList(hql, clazzs, params);

		// String hql = "select a, b from MUser a, MUserVip b where a.id =
		// b.userId and a.personName like :personName ";
		// Map<String, Object> params = new HashMap<>();
		// params.put("personName", "%1%");
		// Map<String, Class<?>> clazzs = new HashMap<>();
		// clazzs.put("a", MUser.class);
		// clazzs.put("b", MUserVip.class);
		// return muserDao.findList(hql, clazzs, params);

	}

	@Override
	public Map<String, Object> findUserPage() throws ServiceException {
		// return muserDao.findPage(MUser.class, 1, 5);

		// String hql = "from MUser";
		// return muserDao.findPage(hql, 1, 5);

		// String hql = "from MUser where personName like ?";
		// Map<Integer, Object> params = new HashMap<>();
		// params.put(0, "%15%");
		// return muserDao.findPage(hql, params, 1, 5);

		// ArrayList<Object> params = new ArrayList<>();
		// params.add("%12%");
		// return muserDao.findPage("from MUser where personName like ?", 1, 5,
		// params);

		String hql = "select a, b from MUser a, MUserVip b where a.id = b.userId and a.personName like ?";
		Map<String, Class<?>> clazzs = new HashMap<>();
		clazzs.put("a", MUser.class);
		clazzs.put("b", MUserVip.class);
		return muserDao.findPage(hql, 2, 3, clazzs, "%1%");
	}

	@Override
	public Map<String, Object> findUserPageBySql() throws ServiceException {
		
		// String sql = "select {a.*} from m_user_back a where a.person_name
		// like ?";
		// return muserDao.findPageBySql(sql, 2, 5, "a", MUser.class, "%1%");

		// String sql = "select {a.*} from m_user_back a where a.person_name
		// like ?";
		// ArrayList<Object> params = new ArrayList<>();
		// params.add("%1%");
		// return muserDao.findPageBySql(sql, 2, 5, "a", MUser.class, params);

//		String sql = "select {a.*} from m_user_back a where a.person_name like :person_name ";
//		Map<String, Object> params = new HashMap<>();
//		params.put("person_name", "%1%");
//		return muserDao.findPageBySql(sql, 2, 5, "a", MUser.class, params);
		
		String sql = "select {a.*} from m_user_back a inner join m_user_back_vip b on a.id = b.user_id where a.person_name like :person_name ";
		Map<String, Object> params = new HashMap<>();
		params.put("person_name", "%1%");
		return muserDao.findPageBySql(sql, 1, 5, "a", MUser.class, params);
		
	}

	@Override
	public List<MUser> findUserListBySql() throws ServiceException {
		// String sql = "select u.id, u.login_name loginName, u.password,
		// u.person_name personName from m_user_back u";
		// return muserDao.findListBySql(MUser.class, sql);

		// String sql = "select u.id, u.login_name loginName, u.password,
		// u.person_name personName from m_user_back u where u.person_name like
		// ? and u.create_date < ?";
		// return muserDao.findListBySql(MUser.class, sql, "%1%", new Date());

		// String sql = "select u.id, u.login_name loginName, u.password,
		// u.person_name personName from m_user_back u where u.person_name like
		// ?";
		// Map<Integer, Object> params = new HashMap<>();
		// params.put(0, "%15%");
		// return muserDao.findListBySql(MUser.class, sql, params);

		// String sql = "select u.id, u.login_name loginName, u.password,
		// u.person_name personName from m_user_back u where u.person_name like
		// ?";
		// List<Object> params = new ArrayList<>();
		// params.add("%18%");
		// return muserDao.findListBySql(MUser.class, sql, params);

		// String sql = "select {u.*} from m_user_back u where u.person_name
		// like ?";
		// List<Object> params = new ArrayList<>();
		// params.add("%1%");
		// return muserDao.findListBySql(sql, "u", MUser.class, params);

		String sql = "select {u.*} from m_user_back u where u.person_name like :person_name";
		Map<String, Object> params = new HashMap<>();
		params.put("person_name", "%1%");
		return muserDao.findListBySql(sql, "u", MUser.class, params);

	}

	@Override
	public List<Map<String, Object>> findObjectListBySql() throws ServiceException {

		String sql = "select {a.*}, {b.*} from m_user_back a left join m_user_back_vip b on a.id = b.user_id where a.person_name like ?";
		List<Object> params = new ArrayList<>();
		params.add("%1%");

		Map<String, Class<?>> clazzs = new HashMap<>();
		clazzs.put("a", MUser.class);
		clazzs.put("b", MUserVip.class);

		return muserDao.findListBySql(sql, clazzs, params);

	}

}

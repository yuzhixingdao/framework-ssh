package com.yzxd.framework.ssh.web.service;

import java.util.List;
import java.util.Map;

import com.yzxd.framework.ssh.core.exception.ServiceException;
import com.yzxd.framework.ssh.web.entity.MUser;
import com.yzxd.framework.ssh.web.entity.MUserVip;

public interface MUserService {

	void addUser(MUser user) throws ServiceException;
	
	MUser loadUser(String id) throws ServiceException;
	
	MUser getUser(String id) throws ServiceException;

	void updateUser(MUser user) throws ServiceException;
	
	Long getTotalCount() throws ServiceException;

	void addUserList(List<MUser> list) throws ServiceException;

	void deleteUser(MUser user) throws ServiceException;
	
	void deleteUser(String id) throws ServiceException;
	
	void deleteUser(String[] id) throws ServiceException;

	List findUserList() throws ServiceException;
	
	List<MUser> findUserListBySql() throws ServiceException;
	
	List<Map<String, Object>> findObjectListBySql() throws ServiceException;
	
	Map<String, Object> findUserPage() throws ServiceException;
	
	Map<String, Object> findUserPageBySql() throws ServiceException;
	
	void addUserVipList(List<MUserVip> list) throws ServiceException;
	
}

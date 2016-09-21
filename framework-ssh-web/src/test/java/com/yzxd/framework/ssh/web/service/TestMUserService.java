package com.yzxd.framework.ssh.web.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.yzxd.framework.ssh.core.util.bean.BeanUtil;
import com.yzxd.framework.ssh.web.entity.MUser;
import com.yzxd.framework.ssh.web.entity.MUserVip;

@RunWith(value = SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:/config/springs/applicationContext-resource.xml" })
public class TestMUserService {

	@Autowired
	private MUserService muserService;

	@Test
	public void testLoad() {
		MUser user = muserService.loadUser("4028f82d571c87dd01571c87dfb60000");
		System.out.println(user);
	}
	
	@Test
	public void testGet() {
		MUser user = muserService.getUser("4028f82d571da37001571da373550001");
		System.out.println(user);
	}

	@Test
	public void testAddUser() {
		MUser user = new MUser();
		user.setLoginName("zhangsan");
		user.setPersonName("张三");
		user.setPassword("123456");
		muserService.addUser(user);
	}

	@Test
	public void testAddUserList() {
		List<MUser> list = new ArrayList<>();
		for (int i = 10; i < 20; i++) {
			MUser user = new MUser();
			user.setLoginName("zhangsan" + i);
			user.setPersonName("张三" + i);
			user.setPassword("123456" + i);
			list.add(user);
		}

		muserService.addUserList(list);
	}
	
	@Test
	public void testAddUserVipList() {
		List<MUserVip> list = new ArrayList<>();
		for (int i = 10; i < 20; i++) {
			MUserVip user = new MUserVip();
			user.setLoginName("lisi" + i);
			user.setPersonName("lisi" + i);
			user.setPassword("654321" + i);
			list.add(user);
		}
		
		muserService.addUserVipList(list);
	}

	@Test
	public void testDelete() {

		// MUser user = new MUser();
		// user.setLoginName("lisi");
		// user.setPersonName("李四");
		// user.setPassword("123456");
		// muserService.addUser(user);
		//
		// System.out.println(user);
		//
		// MUser u = new MUser();
		// BeanUtil.copy(u, user);
		//
		// muserService.deleteUser(u);

		// muserService.deleteUser("4028f82d571da37001571da373470000");

		muserService.deleteUser(new String[] { "4028f82d571da37001571da373470000" });

	}

	@Test
	public void testUpdateUser() {
		MUser user = muserService.getUser("4028f82d571c87dd01571c87dfb60000");

		MUser u = new MUser();
		BeanUtil.copy(u, user);

		u.setCreateDate(new Date());
		u.setIsValid("0");
		muserService.updateUser(u);
	}
	
	@Test
	public void testUpdateUser2() {
		muserService.updateUser(null);
	}

	@Test
	public void testGetTotalCount() {
		Long totalCount = muserService.getTotalCount();
		System.out.println("totalCount:" + totalCount);
	}

	@Test
	public void testFindUserList() {
//		List<MUser> list = muserService.findUserList();
//		for (int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
		List list = muserService.findUserList();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map = (Map<String, Object>) list.get(i);
			System.out.println(map.get("a"));
			System.out.println(map.get("b"));
			System.out.println();
		}
	}

	@Test
	public void testFindUserPage() {
		Map<String, Object> map = muserService.findUserPage();
		System.out.println(map);
	}

	@Test
	public void testFindUserListBySql() {
		List<MUser> list = muserService.findUserListBySql();
		System.out.println(list);
	}

	@Test
	public void testFindObjectListBySql() {
		List<Map<String, Object>> list = muserService.findObjectListBySql();
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> obj = list.get(i);
			System.out.println(obj.get("a"));
			System.out.println(obj.get("b"));
			System.out.println("\n");
		}
	}
	
	@Test
	public void testFindUserPageBySql(){
		Map<String, Object> page = muserService.findUserPageBySql();
		System.out.println(page);
		System.out.println(page.get("PageData"));
	}

}

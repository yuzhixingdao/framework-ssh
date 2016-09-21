package com.yzxd.framework.ssh.web.dao.impl;

import org.springframework.stereotype.Repository;

import com.yzxd.framework.ssh.core.persistence.impl.BaseHibernateDaoImpl;
import com.yzxd.framework.ssh.web.dao.MUserDao;

@Repository(value = "muserDao")
public class MUserDaoImpl extends BaseHibernateDaoImpl implements MUserDao {

}

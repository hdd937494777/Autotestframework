package com.mizlicai.eudemon.mng.service.impl;

import com.mizlicai.eudemon.mng.mapper.MemberRoleMapper;
import com.mizlicai.eudemon.mng.service.UserMemberRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserMemberRoleServiceImpl implements UserMemberRoleService {
	
	@Autowired
	private MemberRoleMapper memberRoleMapper;

	@Override
	public String obtianTheRole(Integer memberId) {
		
		// TODO Auto-generated method stub
		return null;
	}

}

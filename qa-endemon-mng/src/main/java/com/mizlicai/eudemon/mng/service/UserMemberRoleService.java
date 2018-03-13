package com.mizlicai.eudemon.mng.service;


/**
 * 用户，角色service
 * @author carro
 *
 */
public interface UserMemberRoleService {
	
	
	/**
	 * 获得登录用户的角色
	 * @param memberId
	 * @return
	 */
	String obtianTheRole(Integer memberId);

}

package com.mizlicai.eudemon.mng.service;

import com.mizlicai.eudemon.mng.entity.Member;
import org.springframework.ui.Model;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * 内部系统登录服务
 *
 *
 *
 * Created by clt on 15/5/5.上午11:45
 *
 * Copyright © mizhuanglicai
 */
public interface InternalLogService {

    /**
     * SUCCESS 成功
     * PASSWORD_ERROR 密码错误
     * INSUFFICIENT_PERMISSIONS 权限不足
     * NO_SUCH_USER 没有此用户
     * INITIALIZATION_CODE 联系管理员初始化密码
     */
    public static enum LogStatus {
        SUCCESS, PASSWORD_ERROR, NO_SUCH_USER, INSUFFICIENT_PERMISSIONS, INITIALIZATION_CODE;
    }


    /**
     * 内部系统登录
     *
     * @param request 请求
     * @param session HttpSession
     * @param model 数据模型
     * @param username 用户名
     * @param password 密码
     * @param resourceUrl 资源地址
     * @return 返回登录状态 LogStatus
     */
    LogStatus login(final HttpServletRequest request, HttpSession session,
                    Model model, String username, String password, String resourceUrl);
  
	Member login(HttpSession session, Model model, String username,
                 String password, String resourceUrl, String userAgent, HttpServletRequest request);

    /**
     * 授权进入
     *
     * @throws Exception
     */
    boolean authorizedAccess(HttpServletRequest request, HttpServletResponse response, String sessionUser)throws Exception;

    /**
     * 授权进入V2版
     * 多了一个 uri 的参数
     *
     * @param request 请求
     * @param response 响应
     * @param sessionUser
     * @return true false
     * @throws Exception
     */
    boolean authorizedAccessV2(HttpServletRequest request, HttpServletResponse response, String sessionUser, String uri)throws Exception;


}

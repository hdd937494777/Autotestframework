package com.mizlicai.eudemon.mng.service;

/**
 * Created by chars on 2015 下午2:49:36.
 * <p/>
 * Copyright © mizhuanglicai
 */
public interface IpConfigService {

    boolean findByIp(String ip);

    /**
     * 根据name删除ip记录
     *
     * @param name name
     * @return boolean
     */
    boolean deleteByName(String name);

    /**
     * 添加ip记录
     *
     * @param remoteAddr ip
     * @param name       name
     * @return boolean
     */
    boolean addIpConfig(String remoteAddr, String name);
}

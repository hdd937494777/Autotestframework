package com.mizlicai.eudemon.biz;
import com.mizlicai.eudemon.entity.ServicesExample;
import com.mizlicai.eudemon.exceptions.TestException;


/**
 * Created by huangyt on 2017/6/3.
 */

public interface CommonRequestBiz {
    /**
     * 根据服务列表发送请求
     * @
     * @throws TestException
     */
    public void commonQuest( ServicesExample example) throws TestException;

}

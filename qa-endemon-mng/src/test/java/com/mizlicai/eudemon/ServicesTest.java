package com.mizlicai.eudemon;

import com.github.pagehelper.PageHelper;
import com.mizlicai.eudemon.mng.context.ManagerContext;
import com.mizlicai.eudemon.mng.entity.IpConfigExample;
import com.mizlicai.eudemon.mng.entity.Member;
import com.mizlicai.eudemon.mng.entity.MemberExample;
import com.mizlicai.eudemon.mng.mapper.IpConfigMapper;
import com.mizlicai.eudemon.mng.mapper.MemberMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by huangyt on 2017/6/5.
 */
public class ServicesTest extends BaseSpringContextTest {

    @Autowired
    private MemberMapper memberMapper;

    @Autowired
    private IpConfigMapper ipConfigMapper;

    @Test
    public void servicesInsert(){
        MemberExample example = new MemberExample();
        example.createCriteria().andStatusEqualTo(ManagerContext.MemberStatus.OPEN.name());
        PageHelper.startPage(0, 20);
        List<Member> list = memberMapper.selectByExample(example);
    }

    @Test
    public void servicesInsert1(){
        IpConfigExample example = new IpConfigExample();
        PageHelper.startPage(0, 20);
        ipConfigMapper.countByExample(example);
    }

}

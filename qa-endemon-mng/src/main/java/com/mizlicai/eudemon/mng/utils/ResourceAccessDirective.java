package com.mizlicai.eudemon.mng.utils;

import com.mizlicai.eudemon.mng.entity.Member;
import com.mizlicai.eudemon.mng.service.ResourceAccessService;
import freemarker.core.Environment;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.beans.factory.annotation.Value;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by chenlt on 15/5/7.上午1:08
 *
 * Copyright © mizhuanglicai
 */
public class ResourceAccessDirective implements TemplateDirectiveModel {

    @Resource
    private ResourceAccessService accessService;

    @Value("#{settings['session.user.name']}")
    protected String sessionUser;

    @Resource
    private HttpServletRequest request;

    @SuppressWarnings("rawtypes")
	@Override
    public void execute(Environment env, Map params, TemplateModel[] loopVars,
                        TemplateDirectiveBody body) throws TemplateException, IOException {
        String url = params.get("url").toString();

        if (body == null){
            throw new RuntimeException("标签内部至少要加一个空格");
        }
        if (!checkURL(url)){
            body = null;
        }else{
            body.render(env.getOut());
        }

    }

    public boolean checkURL(String url){
        accessService.addNewResourceUrl(url);

        HttpSession session = request.getSession();
        Member member = (Member)session.getAttribute(sessionUser);
        return accessService.isEnoughPermissions(member, url);
    }

}

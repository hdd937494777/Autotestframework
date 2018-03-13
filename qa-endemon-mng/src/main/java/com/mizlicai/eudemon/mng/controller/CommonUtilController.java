package com.mizlicai.eudemon.mng.controller;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.PageInfo;
import com.miz.cashier.api.co.base.NormalResponse;
import com.miz.cashier.api.co.request.TokenRequest;
import com.miz.cashier.api.co.response.TokenResponse;
import com.miz.cashier.api.service.TokenService;
import com.miz.cashier.api.util.DesUtil;
import com.miz.cashier.api.util.SignUtil;
import com.mizlicai.cashier.enums.MerchantAccountType;
import com.mizlicai.eudemon.entity.Services;
import com.mizlicai.eudemon.mng.dto.CipherRo;
import com.mizlicai.eudemon.mng.utils.PagerHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangyt on 2017/6/21.
 */
@Controller
@RequestMapping(value = "common")
public class CommonUtilController extends  BaseController {

    private Logger logger = LoggerFactory.getLogger(getClass());


    @Autowired
    private TokenService tokenService;

    /**
     * 查询服务列表
     * @param
     * @param
     * @param model
     * @return
     */
    @RequestMapping(value = "gosign", method = RequestMethod.GET)
    public String servicesList(Model model){

        return "common/signutil";

    }

    @RequestMapping(value = "token", method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,Object> token(String requestId,String data , Model model){
        final TokenRequest tokenRequest = new TokenRequest();
        tokenRequest.setRequestId(requestId);
        tokenRequest.setMerchantAccount(MerchantAccountType.URANUS.getMerchantAccount());
        tokenRequest.setSign(SignUtil.addSignMD5(JSONObject.parseObject(JSONObject.toJSONString(tokenRequest))));
        final NormalResponse<TokenResponse> response = tokenService.token(tokenRequest);
        final String token = response.getData().getToken();
        Map<String ,Object> map = new HashMap<String ,Object>();
        setSuccess(map);
        map.put("token",token);
        return map;

    }
    @RequestMapping(value = "sign", method = RequestMethod.POST)
    @ResponseBody
    public Map<String ,Object> sign(String signData , Model model) throws Exception {
        Map<String ,Object> map = new HashMap<String ,Object>();
        setSuccess(map);
        map.put("cipher",DesUtil.encrypt(signData));
        return map;

    }

}

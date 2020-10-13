package com.miz.testframework.entity;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class ClassEntity implements Serializable {

    /**
     * 测试类包名 eg : com.miz.neutralgate.api.service
     */
    private String packageName;
    /**
     *  测试类类名 eg:com.miz.neutralgate.api.service.BidService
     */
    private String className;
    /**
     * 测试方法名 eg:companyBidSynchronization
     */
    private String methodName;
    /**
     * 测试方法返回类型,eg:com.miz.neutralgate.api.response.CompanyBidSynchronizationResponse
     */
    private String returnType;
    /**
     * 测试方法返回值的简写：eg:CompanyBidSynchronizationResponse
     */
    private String shortReturnType;
    /**
     * 请求参数类型简写
     */
    private String shortRequestName;
    /**
     * 入参列表 eg: "com.miz.neutralgate.api.request.CompanyBidSynchronizationRequest"
     */
    private List<String> requestParameters;
    /**
     * 生成脚本类名 eg :companyBidSynchronizationNormalTest
     */
    private String scriptClassName;
    /**
     * 返回参数的简写，eg:返回类型：com.mizlicai.eudemon.entity.ErrorRequest 则简写为 ErrorRequest
     */
    private String shortClassName;
    /**
     * 生成脚本所在包 eg: com.miz.autotest.servicetest.bidservice
     */
    private String scriptPackage;
    /**
     * xls读入属性值 eg:        "projectNo","projectName",
     */
    private  List<String>  xlsParameter;
    /**
     * 方法请求参数的键值对
     */
    private List<Map<String ,String>> methodParameter;


    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getReturnType() {
        return returnType;
    }

    public void setReturnType(String returnType) {
        this.returnType = returnType;
    }

    public List<String> getRequestParameters() {
        return requestParameters;
    }

    public void setRequestParameters(List<String> requestParameters) {
        this.requestParameters = requestParameters;
    }

    public String getShortClassName() {
        return shortClassName;
    }

    public void setShortClassName(String shortClassName) {
        this.shortClassName = shortClassName;
    }

    public List<String> getXlsParameter() {
        return xlsParameter;
    }

    public void setXlsParameter(List<String> xlsParameter) {
        this.xlsParameter = xlsParameter;
    }


    public String getScriptClassName() {
        return scriptClassName;
    }

    public void setScriptClassName(String scriptClassName) {
        this.scriptClassName = scriptClassName;
    }

    public String getScriptPackage() {
        return scriptPackage;
    }

    public void setScriptPackage(String scriptPackage) {
        this.scriptPackage = scriptPackage;
    }

    public String getShortReturnType() {
        return shortReturnType;
    }

    public void setShortReturnType(String shortReturnType) {
        this.shortReturnType = shortReturnType;
    }

    public List<Map<String, String>> getMethodParameter() {
        return methodParameter;
    }

    public void setMethodParameter(List<Map<String, String>> methodParameter) {
        this.methodParameter = methodParameter;
    }

    public String getShortRequestName() {
        return shortRequestName;
    }

    public void setShortRequestName(String shortRequestName) {
        this.shortRequestName = shortRequestName;
    }
}

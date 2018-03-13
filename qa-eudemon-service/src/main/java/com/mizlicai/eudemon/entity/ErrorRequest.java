package com.mizlicai.eudemon.entity;

import java.io.Serializable;
import java.util.Date;

public class ErrorRequest implements Serializable {
    private Integer id;

    private Date createTime;

    private String serviceId;

    private String serviceName;

    private Date requestTime;

    private String requestUrl;

    private String requestData;

    private Date responseTime;

    private String responseStatus;

    private String responseData;

    private String responseCode;

    private String expectResponseStatus;

    private String expectResponseData;

    private String expectResponseCode;

    private String result;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId == null ? null : serviceId.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData == null ? null : requestData.trim();
    }

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(String responseStatus) {
        this.responseStatus = responseStatus == null ? null : responseStatus.trim();
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData == null ? null : responseData.trim();
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode == null ? null : responseCode.trim();
    }

    public String getExpectResponseStatus() {
        return expectResponseStatus;
    }

    public void setExpectResponseStatus(String expectResponseStatus) {
        this.expectResponseStatus = expectResponseStatus == null ? null : expectResponseStatus.trim();
    }

    public String getExpectResponseData() {
        return expectResponseData;
    }

    public void setExpectResponseData(String expectResponseData) {
        this.expectResponseData = expectResponseData == null ? null : expectResponseData.trim();
    }

    public String getExpectResponseCode() {
        return expectResponseCode;
    }

    public void setExpectResponseCode(String expectResponseCode) {
        this.expectResponseCode = expectResponseCode == null ? null : expectResponseCode.trim();
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result == null ? null : result.trim();
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        ErrorRequest other = (ErrorRequest) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getRequestTime() == null ? other.getRequestTime() == null : this.getRequestTime().equals(other.getRequestTime()))
            && (this.getRequestUrl() == null ? other.getRequestUrl() == null : this.getRequestUrl().equals(other.getRequestUrl()))
            && (this.getRequestData() == null ? other.getRequestData() == null : this.getRequestData().equals(other.getRequestData()))
            && (this.getResponseTime() == null ? other.getResponseTime() == null : this.getResponseTime().equals(other.getResponseTime()))
            && (this.getResponseStatus() == null ? other.getResponseStatus() == null : this.getResponseStatus().equals(other.getResponseStatus()))
            && (this.getResponseData() == null ? other.getResponseData() == null : this.getResponseData().equals(other.getResponseData()))
            && (this.getResponseCode() == null ? other.getResponseCode() == null : this.getResponseCode().equals(other.getResponseCode()))
            && (this.getExpectResponseStatus() == null ? other.getExpectResponseStatus() == null : this.getExpectResponseStatus().equals(other.getExpectResponseStatus()))
            && (this.getExpectResponseData() == null ? other.getExpectResponseData() == null : this.getExpectResponseData().equals(other.getExpectResponseData()))
            && (this.getExpectResponseCode() == null ? other.getExpectResponseCode() == null : this.getExpectResponseCode().equals(other.getExpectResponseCode()))
            && (this.getResult() == null ? other.getResult() == null : this.getResult().equals(other.getResult()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getRequestTime() == null) ? 0 : getRequestTime().hashCode());
        result = prime * result + ((getRequestUrl() == null) ? 0 : getRequestUrl().hashCode());
        result = prime * result + ((getRequestData() == null) ? 0 : getRequestData().hashCode());
        result = prime * result + ((getResponseTime() == null) ? 0 : getResponseTime().hashCode());
        result = prime * result + ((getResponseStatus() == null) ? 0 : getResponseStatus().hashCode());
        result = prime * result + ((getResponseData() == null) ? 0 : getResponseData().hashCode());
        result = prime * result + ((getResponseCode() == null) ? 0 : getResponseCode().hashCode());
        result = prime * result + ((getExpectResponseStatus() == null) ? 0 : getExpectResponseStatus().hashCode());
        result = prime * result + ((getExpectResponseData() == null) ? 0 : getExpectResponseData().hashCode());
        result = prime * result + ((getExpectResponseCode() == null) ? 0 : getExpectResponseCode().hashCode());
        result = prime * result + ((getResult() == null) ? 0 : getResult().hashCode());
        return result;
    }
}
package com.mizlicai.eudemon.entity;

import java.io.Serializable;
import java.util.Date;

public class ResponseData implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String serviceId;

    private String serviceName;

    private Date responseTime;

    private Date requestTime;

    private String responseStatus;

    private String responseData;

    private Integer requestId;

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

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
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

    public Date getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(Date responseTime) {
        this.responseTime = responseTime;
    }

    public Date getRequestTime() {
        return requestTime;
    }

    public void setRequestTime(Date requestTime) {
        this.requestTime = requestTime;
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

    public Integer getRequestId() {
        return requestId;
    }

    public void setRequestId(Integer requestId) {
        this.requestId = requestId;
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
        ResponseData other = (ResponseData) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getResponseTime() == null ? other.getResponseTime() == null : this.getResponseTime().equals(other.getResponseTime()))
            && (this.getRequestTime() == null ? other.getRequestTime() == null : this.getRequestTime().equals(other.getRequestTime()))
            && (this.getResponseStatus() == null ? other.getResponseStatus() == null : this.getResponseStatus().equals(other.getResponseStatus()))
            && (this.getResponseData() == null ? other.getResponseData() == null : this.getResponseData().equals(other.getResponseData()))
            && (this.getRequestId() == null ? other.getRequestId() == null : this.getRequestId().equals(other.getRequestId()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getResponseTime() == null) ? 0 : getResponseTime().hashCode());
        result = prime * result + ((getRequestTime() == null) ? 0 : getRequestTime().hashCode());
        result = prime * result + ((getResponseStatus() == null) ? 0 : getResponseStatus().hashCode());
        result = prime * result + ((getResponseData() == null) ? 0 : getResponseData().hashCode());
        result = prime * result + ((getRequestId() == null) ? 0 : getRequestId().hashCode());
        return result;
    }
}
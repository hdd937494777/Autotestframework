package com.mizlicai.eudemon.entity;

import java.io.Serializable;
import java.util.Date;

public class Services implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String requestUrl;

    private String requestType;

    private String requestDataUrl;

    private String responseDataUrl;

    private String serviceName;

    private String description;

    private String needParameter;

    private String project;

    private String operatorName;

    private String operatorId;

    private Integer timeOut;

    private Integer concurrentCount;

    private String isNormal;

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

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl == null ? null : requestUrl.trim();
    }

    public String getRequestType() {
        return requestType;
    }

    public void setRequestType(String requestType) {
        this.requestType = requestType == null ? null : requestType.trim();
    }

    public String getRequestDataUrl() {
        return requestDataUrl;
    }

    public void setRequestDataUrl(String requestDataUrl) {
        this.requestDataUrl = requestDataUrl == null ? null : requestDataUrl.trim();
    }

    public String getResponseDataUrl() {
        return responseDataUrl;
    }

    public void setResponseDataUrl(String responseDataUrl) {
        this.responseDataUrl = responseDataUrl == null ? null : responseDataUrl.trim();
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName == null ? null : serviceName.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getNeedParameter() {
        return needParameter;
    }

    public void setNeedParameter(String needParameter) {
        this.needParameter = needParameter == null ? null : needParameter.trim();
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project == null ? null : project.trim();
    }

    public String getOperatorName() {
        return operatorName;
    }

    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName == null ? null : operatorName.trim();
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId == null ? null : operatorId.trim();
    }

    public Integer getTimeOut() {
        return timeOut;
    }

    public void setTimeOut(Integer timeOut) {
        this.timeOut = timeOut;
    }

    public Integer getConcurrentCount() {
        return concurrentCount;
    }

    public void setConcurrentCount(Integer concurrentCount) {
        this.concurrentCount = concurrentCount;
    }

    public String getIsNormal() {
        return isNormal;
    }

    public void setIsNormal(String isNormal) {
        this.isNormal = isNormal == null ? null : isNormal.trim();
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
        Services other = (Services) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRequestUrl() == null ? other.getRequestUrl() == null : this.getRequestUrl().equals(other.getRequestUrl()))
            && (this.getRequestType() == null ? other.getRequestType() == null : this.getRequestType().equals(other.getRequestType()))
            && (this.getRequestDataUrl() == null ? other.getRequestDataUrl() == null : this.getRequestDataUrl().equals(other.getRequestDataUrl()))
            && (this.getResponseDataUrl() == null ? other.getResponseDataUrl() == null : this.getResponseDataUrl().equals(other.getResponseDataUrl()))
            && (this.getServiceName() == null ? other.getServiceName() == null : this.getServiceName().equals(other.getServiceName()))
            && (this.getDescription() == null ? other.getDescription() == null : this.getDescription().equals(other.getDescription()))
            && (this.getNeedParameter() == null ? other.getNeedParameter() == null : this.getNeedParameter().equals(other.getNeedParameter()))
            && (this.getProject() == null ? other.getProject() == null : this.getProject().equals(other.getProject()))
            && (this.getOperatorName() == null ? other.getOperatorName() == null : this.getOperatorName().equals(other.getOperatorName()))
            && (this.getOperatorId() == null ? other.getOperatorId() == null : this.getOperatorId().equals(other.getOperatorId()))
            && (this.getTimeOut() == null ? other.getTimeOut() == null : this.getTimeOut().equals(other.getTimeOut()))
            && (this.getConcurrentCount() == null ? other.getConcurrentCount() == null : this.getConcurrentCount().equals(other.getConcurrentCount()))
            && (this.getIsNormal() == null ? other.getIsNormal() == null : this.getIsNormal().equals(other.getIsNormal()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRequestUrl() == null) ? 0 : getRequestUrl().hashCode());
        result = prime * result + ((getRequestType() == null) ? 0 : getRequestType().hashCode());
        result = prime * result + ((getRequestDataUrl() == null) ? 0 : getRequestDataUrl().hashCode());
        result = prime * result + ((getResponseDataUrl() == null) ? 0 : getResponseDataUrl().hashCode());
        result = prime * result + ((getServiceName() == null) ? 0 : getServiceName().hashCode());
        result = prime * result + ((getDescription() == null) ? 0 : getDescription().hashCode());
        result = prime * result + ((getNeedParameter() == null) ? 0 : getNeedParameter().hashCode());
        result = prime * result + ((getProject() == null) ? 0 : getProject().hashCode());
        result = prime * result + ((getOperatorName() == null) ? 0 : getOperatorName().hashCode());
        result = prime * result + ((getOperatorId() == null) ? 0 : getOperatorId().hashCode());
        result = prime * result + ((getTimeOut() == null) ? 0 : getTimeOut().hashCode());
        result = prime * result + ((getConcurrentCount() == null) ? 0 : getConcurrentCount().hashCode());
        result = prime * result + ((getIsNormal() == null) ? 0 : getIsNormal().hashCode());
        return result;
    }
}
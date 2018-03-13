package com.mizlicai.eudemon.entity;

import java.io.Serializable;
import java.util.Date;

public class ServiceConfig implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private Integer serviceId;

    private Integer timeOut;

    private Integer concurrentCount;

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

    public Integer getServiceId() {
        return serviceId;
    }

    public void setServiceId(Integer serviceId) {
        this.serviceId = serviceId;
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
        ServiceConfig other = (ServiceConfig) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getServiceId() == null ? other.getServiceId() == null : this.getServiceId().equals(other.getServiceId()))
            && (this.getTimeOut() == null ? other.getTimeOut() == null : this.getTimeOut().equals(other.getTimeOut()))
            && (this.getConcurrentCount() == null ? other.getConcurrentCount() == null : this.getConcurrentCount().equals(other.getConcurrentCount()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getServiceId() == null) ? 0 : getServiceId().hashCode());
        result = prime * result + ((getTimeOut() == null) ? 0 : getTimeOut().hashCode());
        result = prime * result + ((getConcurrentCount() == null) ? 0 : getConcurrentCount().hashCode());
        return result;
    }
}
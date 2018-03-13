package com.mizlicai.eudemon.mng.entity;

import java.io.Serializable;
import java.util.Date;

public class SysSetting implements Serializable {
    private Integer id;

    private Date createTime;

    private Date updateTime;

    private String feeRate;

    private String period;

    private String copyright;

    private String closeReason;

    private String status;

    private String emailStatus;

    private String emailHost;

    private String emailPort;

    private String emailUser;

    private String emailUsername;

    private String emailPwd;

    private String emailTest;

    private String hotDestination;

    private String keywords;

    private String smsStatus;

    private String smsUsername;

    private String smsPwd;

    private String smsSendGateway;

    private String smsReceiveGateway;

    private String script;

    private String orderRetain;

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

    public String getFeeRate() {
        return feeRate;
    }

    public void setFeeRate(String feeRate) {
        this.feeRate = feeRate == null ? null : feeRate.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public String getCopyright() {
        return copyright;
    }

    public void setCopyright(String copyright) {
        this.copyright = copyright == null ? null : copyright.trim();
    }

    public String getCloseReason() {
        return closeReason;
    }

    public void setCloseReason(String closeReason) {
        this.closeReason = closeReason == null ? null : closeReason.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getEmailStatus() {
        return emailStatus;
    }

    public void setEmailStatus(String emailStatus) {
        this.emailStatus = emailStatus == null ? null : emailStatus.trim();
    }

    public String getEmailHost() {
        return emailHost;
    }

    public void setEmailHost(String emailHost) {
        this.emailHost = emailHost == null ? null : emailHost.trim();
    }

    public String getEmailPort() {
        return emailPort;
    }

    public void setEmailPort(String emailPort) {
        this.emailPort = emailPort == null ? null : emailPort.trim();
    }

    public String getEmailUser() {
        return emailUser;
    }

    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser == null ? null : emailUser.trim();
    }

    public String getEmailUsername() {
        return emailUsername;
    }

    public void setEmailUsername(String emailUsername) {
        this.emailUsername = emailUsername == null ? null : emailUsername.trim();
    }

    public String getEmailPwd() {
        return emailPwd;
    }

    public void setEmailPwd(String emailPwd) {
        this.emailPwd = emailPwd == null ? null : emailPwd.trim();
    }

    public String getEmailTest() {
        return emailTest;
    }

    public void setEmailTest(String emailTest) {
        this.emailTest = emailTest == null ? null : emailTest.trim();
    }

    public String getHotDestination() {
        return hotDestination;
    }

    public void setHotDestination(String hotDestination) {
        this.hotDestination = hotDestination == null ? null : hotDestination.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getSmsStatus() {
        return smsStatus;
    }

    public void setSmsStatus(String smsStatus) {
        this.smsStatus = smsStatus == null ? null : smsStatus.trim();
    }

    public String getSmsUsername() {
        return smsUsername;
    }

    public void setSmsUsername(String smsUsername) {
        this.smsUsername = smsUsername == null ? null : smsUsername.trim();
    }

    public String getSmsPwd() {
        return smsPwd;
    }

    public void setSmsPwd(String smsPwd) {
        this.smsPwd = smsPwd == null ? null : smsPwd.trim();
    }

    public String getSmsSendGateway() {
        return smsSendGateway;
    }

    public void setSmsSendGateway(String smsSendGateway) {
        this.smsSendGateway = smsSendGateway == null ? null : smsSendGateway.trim();
    }

    public String getSmsReceiveGateway() {
        return smsReceiveGateway;
    }

    public void setSmsReceiveGateway(String smsReceiveGateway) {
        this.smsReceiveGateway = smsReceiveGateway == null ? null : smsReceiveGateway.trim();
    }

    public String getScript() {
        return script;
    }

    public void setScript(String script) {
        this.script = script == null ? null : script.trim();
    }

    public String getOrderRetain() {
        return orderRetain;
    }

    public void setOrderRetain(String orderRetain) {
        this.orderRetain = orderRetain == null ? null : orderRetain.trim();
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
        SysSetting other = (SysSetting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getFeeRate() == null ? other.getFeeRate() == null : this.getFeeRate().equals(other.getFeeRate()))
            && (this.getPeriod() == null ? other.getPeriod() == null : this.getPeriod().equals(other.getPeriod()))
            && (this.getCopyright() == null ? other.getCopyright() == null : this.getCopyright().equals(other.getCopyright()))
            && (this.getCloseReason() == null ? other.getCloseReason() == null : this.getCloseReason().equals(other.getCloseReason()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getEmailStatus() == null ? other.getEmailStatus() == null : this.getEmailStatus().equals(other.getEmailStatus()))
            && (this.getEmailHost() == null ? other.getEmailHost() == null : this.getEmailHost().equals(other.getEmailHost()))
            && (this.getEmailPort() == null ? other.getEmailPort() == null : this.getEmailPort().equals(other.getEmailPort()))
            && (this.getEmailUser() == null ? other.getEmailUser() == null : this.getEmailUser().equals(other.getEmailUser()))
            && (this.getEmailUsername() == null ? other.getEmailUsername() == null : this.getEmailUsername().equals(other.getEmailUsername()))
            && (this.getEmailPwd() == null ? other.getEmailPwd() == null : this.getEmailPwd().equals(other.getEmailPwd()))
            && (this.getEmailTest() == null ? other.getEmailTest() == null : this.getEmailTest().equals(other.getEmailTest()))
            && (this.getHotDestination() == null ? other.getHotDestination() == null : this.getHotDestination().equals(other.getHotDestination()))
            && (this.getKeywords() == null ? other.getKeywords() == null : this.getKeywords().equals(other.getKeywords()))
            && (this.getSmsStatus() == null ? other.getSmsStatus() == null : this.getSmsStatus().equals(other.getSmsStatus()))
            && (this.getSmsUsername() == null ? other.getSmsUsername() == null : this.getSmsUsername().equals(other.getSmsUsername()))
            && (this.getSmsPwd() == null ? other.getSmsPwd() == null : this.getSmsPwd().equals(other.getSmsPwd()))
            && (this.getSmsSendGateway() == null ? other.getSmsSendGateway() == null : this.getSmsSendGateway().equals(other.getSmsSendGateway()))
            && (this.getSmsReceiveGateway() == null ? other.getSmsReceiveGateway() == null : this.getSmsReceiveGateway().equals(other.getSmsReceiveGateway()))
            && (this.getScript() == null ? other.getScript() == null : this.getScript().equals(other.getScript()))
            && (this.getOrderRetain() == null ? other.getOrderRetain() == null : this.getOrderRetain().equals(other.getOrderRetain()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getFeeRate() == null) ? 0 : getFeeRate().hashCode());
        result = prime * result + ((getPeriod() == null) ? 0 : getPeriod().hashCode());
        result = prime * result + ((getCopyright() == null) ? 0 : getCopyright().hashCode());
        result = prime * result + ((getCloseReason() == null) ? 0 : getCloseReason().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getEmailStatus() == null) ? 0 : getEmailStatus().hashCode());
        result = prime * result + ((getEmailHost() == null) ? 0 : getEmailHost().hashCode());
        result = prime * result + ((getEmailPort() == null) ? 0 : getEmailPort().hashCode());
        result = prime * result + ((getEmailUser() == null) ? 0 : getEmailUser().hashCode());
        result = prime * result + ((getEmailUsername() == null) ? 0 : getEmailUsername().hashCode());
        result = prime * result + ((getEmailPwd() == null) ? 0 : getEmailPwd().hashCode());
        result = prime * result + ((getEmailTest() == null) ? 0 : getEmailTest().hashCode());
        result = prime * result + ((getHotDestination() == null) ? 0 : getHotDestination().hashCode());
        result = prime * result + ((getKeywords() == null) ? 0 : getKeywords().hashCode());
        result = prime * result + ((getSmsStatus() == null) ? 0 : getSmsStatus().hashCode());
        result = prime * result + ((getSmsUsername() == null) ? 0 : getSmsUsername().hashCode());
        result = prime * result + ((getSmsPwd() == null) ? 0 : getSmsPwd().hashCode());
        result = prime * result + ((getSmsSendGateway() == null) ? 0 : getSmsSendGateway().hashCode());
        result = prime * result + ((getSmsReceiveGateway() == null) ? 0 : getSmsReceiveGateway().hashCode());
        result = prime * result + ((getScript() == null) ? 0 : getScript().hashCode());
        result = prime * result + ((getOrderRetain() == null) ? 0 : getOrderRetain().hashCode());
        return result;
    }
}
package com.mizlicai.eudemon.mng.entity;

import java.io.Serializable;
import java.util.Date;

public class MessageRoleSetting implements Serializable {
    private Integer id;

    private Date createTime;

    private String roleId;

    private String settingPrivilge;

    private String roleName;

    private String isEffect;

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

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId == null ? null : roleId.trim();
    }

    public String getSettingPrivilge() {
        return settingPrivilge;
    }

    public void setSettingPrivilge(String settingPrivilge) {
        this.settingPrivilge = settingPrivilge == null ? null : settingPrivilge.trim();
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getIsEffect() {
        return isEffect;
    }

    public void setIsEffect(String isEffect) {
        this.isEffect = isEffect == null ? null : isEffect.trim();
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
        MessageRoleSetting other = (MessageRoleSetting) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getRoleId() == null ? other.getRoleId() == null : this.getRoleId().equals(other.getRoleId()))
            && (this.getSettingPrivilge() == null ? other.getSettingPrivilge() == null : this.getSettingPrivilge().equals(other.getSettingPrivilge()))
            && (this.getRoleName() == null ? other.getRoleName() == null : this.getRoleName().equals(other.getRoleName()))
            && (this.getIsEffect() == null ? other.getIsEffect() == null : this.getIsEffect().equals(other.getIsEffect()));
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getRoleId() == null) ? 0 : getRoleId().hashCode());
        result = prime * result + ((getSettingPrivilge() == null) ? 0 : getSettingPrivilge().hashCode());
        result = prime * result + ((getRoleName() == null) ? 0 : getRoleName().hashCode());
        result = prime * result + ((getIsEffect() == null) ? 0 : getIsEffect().hashCode());
        return result;
    }
}
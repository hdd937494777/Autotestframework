package com.mizlicai.eudemon.mng.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SysSettingExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public SysSettingExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNull() {
            addCriterion("create_time is null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIsNotNull() {
            addCriterion("create_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreateTimeEqualTo(Date value) {
            addCriterion("create_time =", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotEqualTo(Date value) {
            addCriterion("create_time <>", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThan(Date value) {
            addCriterion("create_time >", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("create_time >=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThan(Date value) {
            addCriterion("create_time <", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeLessThanOrEqualTo(Date value) {
            addCriterion("create_time <=", value, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeIn(List<Date> values) {
            addCriterion("create_time in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotIn(List<Date> values) {
            addCriterion("create_time not in", values, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeBetween(Date value1, Date value2) {
            addCriterion("create_time between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andCreateTimeNotBetween(Date value1, Date value2) {
            addCriterion("create_time not between", value1, value2, "createTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNull() {
            addCriterion("update_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIsNotNull() {
            addCriterion("update_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeEqualTo(Date value) {
            addCriterion("update_time =", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotEqualTo(Date value) {
            addCriterion("update_time <>", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThan(Date value) {
            addCriterion("update_time >", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("update_time >=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThan(Date value) {
            addCriterion("update_time <", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeLessThanOrEqualTo(Date value) {
            addCriterion("update_time <=", value, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeIn(List<Date> values) {
            addCriterion("update_time in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotIn(List<Date> values) {
            addCriterion("update_time not in", values, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeBetween(Date value1, Date value2) {
            addCriterion("update_time between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andUpdateTimeNotBetween(Date value1, Date value2) {
            addCriterion("update_time not between", value1, value2, "updateTime");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNull() {
            addCriterion("fee_rate is null");
            return (Criteria) this;
        }

        public Criteria andFeeRateIsNotNull() {
            addCriterion("fee_rate is not null");
            return (Criteria) this;
        }

        public Criteria andFeeRateEqualTo(String value) {
            addCriterion("fee_rate =", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotEqualTo(String value) {
            addCriterion("fee_rate <>", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThan(String value) {
            addCriterion("fee_rate >", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateGreaterThanOrEqualTo(String value) {
            addCriterion("fee_rate >=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThan(String value) {
            addCriterion("fee_rate <", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLessThanOrEqualTo(String value) {
            addCriterion("fee_rate <=", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateLike(String value) {
            addCriterion("fee_rate like", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotLike(String value) {
            addCriterion("fee_rate not like", value, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateIn(List<String> values) {
            addCriterion("fee_rate in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotIn(List<String> values) {
            addCriterion("fee_rate not in", values, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateBetween(String value1, String value2) {
            addCriterion("fee_rate between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andFeeRateNotBetween(String value1, String value2) {
            addCriterion("fee_rate not between", value1, value2, "feeRate");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNull() {
            addCriterion("period is null");
            return (Criteria) this;
        }

        public Criteria andPeriodIsNotNull() {
            addCriterion("period is not null");
            return (Criteria) this;
        }

        public Criteria andPeriodEqualTo(String value) {
            addCriterion("period =", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotEqualTo(String value) {
            addCriterion("period <>", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThan(String value) {
            addCriterion("period >", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodGreaterThanOrEqualTo(String value) {
            addCriterion("period >=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThan(String value) {
            addCriterion("period <", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLessThanOrEqualTo(String value) {
            addCriterion("period <=", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodLike(String value) {
            addCriterion("period like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotLike(String value) {
            addCriterion("period not like", value, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodIn(List<String> values) {
            addCriterion("period in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotIn(List<String> values) {
            addCriterion("period not in", values, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodBetween(String value1, String value2) {
            addCriterion("period between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andPeriodNotBetween(String value1, String value2) {
            addCriterion("period not between", value1, value2, "period");
            return (Criteria) this;
        }

        public Criteria andCopyrightIsNull() {
            addCriterion("copyright is null");
            return (Criteria) this;
        }

        public Criteria andCopyrightIsNotNull() {
            addCriterion("copyright is not null");
            return (Criteria) this;
        }

        public Criteria andCopyrightEqualTo(String value) {
            addCriterion("copyright =", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotEqualTo(String value) {
            addCriterion("copyright <>", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightGreaterThan(String value) {
            addCriterion("copyright >", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightGreaterThanOrEqualTo(String value) {
            addCriterion("copyright >=", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLessThan(String value) {
            addCriterion("copyright <", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLessThanOrEqualTo(String value) {
            addCriterion("copyright <=", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightLike(String value) {
            addCriterion("copyright like", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotLike(String value) {
            addCriterion("copyright not like", value, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightIn(List<String> values) {
            addCriterion("copyright in", values, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotIn(List<String> values) {
            addCriterion("copyright not in", values, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightBetween(String value1, String value2) {
            addCriterion("copyright between", value1, value2, "copyright");
            return (Criteria) this;
        }

        public Criteria andCopyrightNotBetween(String value1, String value2) {
            addCriterion("copyright not between", value1, value2, "copyright");
            return (Criteria) this;
        }

        public Criteria andCloseReasonIsNull() {
            addCriterion("close_reason is null");
            return (Criteria) this;
        }

        public Criteria andCloseReasonIsNotNull() {
            addCriterion("close_reason is not null");
            return (Criteria) this;
        }

        public Criteria andCloseReasonEqualTo(String value) {
            addCriterion("close_reason =", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonNotEqualTo(String value) {
            addCriterion("close_reason <>", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonGreaterThan(String value) {
            addCriterion("close_reason >", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonGreaterThanOrEqualTo(String value) {
            addCriterion("close_reason >=", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonLessThan(String value) {
            addCriterion("close_reason <", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonLessThanOrEqualTo(String value) {
            addCriterion("close_reason <=", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonLike(String value) {
            addCriterion("close_reason like", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonNotLike(String value) {
            addCriterion("close_reason not like", value, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonIn(List<String> values) {
            addCriterion("close_reason in", values, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonNotIn(List<String> values) {
            addCriterion("close_reason not in", values, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonBetween(String value1, String value2) {
            addCriterion("close_reason between", value1, value2, "closeReason");
            return (Criteria) this;
        }

        public Criteria andCloseReasonNotBetween(String value1, String value2) {
            addCriterion("close_reason not between", value1, value2, "closeReason");
            return (Criteria) this;
        }

        public Criteria andStatusIsNull() {
            addCriterion("status is null");
            return (Criteria) this;
        }

        public Criteria andStatusIsNotNull() {
            addCriterion("status is not null");
            return (Criteria) this;
        }

        public Criteria andStatusEqualTo(String value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(String value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(String value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(String value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(String value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(String value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLike(String value) {
            addCriterion("status like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotLike(String value) {
            addCriterion("status not like", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<String> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<String> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(String value1, String value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(String value1, String value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNull() {
            addCriterion("email_status is null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIsNotNull() {
            addCriterion("email_status is not null");
            return (Criteria) this;
        }

        public Criteria andEmailStatusEqualTo(String value) {
            addCriterion("email_status =", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotEqualTo(String value) {
            addCriterion("email_status <>", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThan(String value) {
            addCriterion("email_status >", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusGreaterThanOrEqualTo(String value) {
            addCriterion("email_status >=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThan(String value) {
            addCriterion("email_status <", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLessThanOrEqualTo(String value) {
            addCriterion("email_status <=", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLike(String value) {
            addCriterion("email_status like", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotLike(String value) {
            addCriterion("email_status not like", value, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusIn(List<String> values) {
            addCriterion("email_status in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotIn(List<String> values) {
            addCriterion("email_status not in", values, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusBetween(String value1, String value2) {
            addCriterion("email_status between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailStatusNotBetween(String value1, String value2) {
            addCriterion("email_status not between", value1, value2, "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailHostIsNull() {
            addCriterion("email_host is null");
            return (Criteria) this;
        }

        public Criteria andEmailHostIsNotNull() {
            addCriterion("email_host is not null");
            return (Criteria) this;
        }

        public Criteria andEmailHostEqualTo(String value) {
            addCriterion("email_host =", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotEqualTo(String value) {
            addCriterion("email_host <>", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostGreaterThan(String value) {
            addCriterion("email_host >", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostGreaterThanOrEqualTo(String value) {
            addCriterion("email_host >=", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostLessThan(String value) {
            addCriterion("email_host <", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostLessThanOrEqualTo(String value) {
            addCriterion("email_host <=", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostLike(String value) {
            addCriterion("email_host like", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotLike(String value) {
            addCriterion("email_host not like", value, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostIn(List<String> values) {
            addCriterion("email_host in", values, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotIn(List<String> values) {
            addCriterion("email_host not in", values, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostBetween(String value1, String value2) {
            addCriterion("email_host between", value1, value2, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailHostNotBetween(String value1, String value2) {
            addCriterion("email_host not between", value1, value2, "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailPortIsNull() {
            addCriterion("email_port is null");
            return (Criteria) this;
        }

        public Criteria andEmailPortIsNotNull() {
            addCriterion("email_port is not null");
            return (Criteria) this;
        }

        public Criteria andEmailPortEqualTo(String value) {
            addCriterion("email_port =", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortNotEqualTo(String value) {
            addCriterion("email_port <>", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortGreaterThan(String value) {
            addCriterion("email_port >", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortGreaterThanOrEqualTo(String value) {
            addCriterion("email_port >=", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortLessThan(String value) {
            addCriterion("email_port <", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortLessThanOrEqualTo(String value) {
            addCriterion("email_port <=", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortLike(String value) {
            addCriterion("email_port like", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortNotLike(String value) {
            addCriterion("email_port not like", value, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortIn(List<String> values) {
            addCriterion("email_port in", values, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortNotIn(List<String> values) {
            addCriterion("email_port not in", values, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortBetween(String value1, String value2) {
            addCriterion("email_port between", value1, value2, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailPortNotBetween(String value1, String value2) {
            addCriterion("email_port not between", value1, value2, "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailUserIsNull() {
            addCriterion("email_user is null");
            return (Criteria) this;
        }

        public Criteria andEmailUserIsNotNull() {
            addCriterion("email_user is not null");
            return (Criteria) this;
        }

        public Criteria andEmailUserEqualTo(String value) {
            addCriterion("email_user =", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserNotEqualTo(String value) {
            addCriterion("email_user <>", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserGreaterThan(String value) {
            addCriterion("email_user >", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserGreaterThanOrEqualTo(String value) {
            addCriterion("email_user >=", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserLessThan(String value) {
            addCriterion("email_user <", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserLessThanOrEqualTo(String value) {
            addCriterion("email_user <=", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserLike(String value) {
            addCriterion("email_user like", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserNotLike(String value) {
            addCriterion("email_user not like", value, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserIn(List<String> values) {
            addCriterion("email_user in", values, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserNotIn(List<String> values) {
            addCriterion("email_user not in", values, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserBetween(String value1, String value2) {
            addCriterion("email_user between", value1, value2, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUserNotBetween(String value1, String value2) {
            addCriterion("email_user not between", value1, value2, "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameIsNull() {
            addCriterion("email_username is null");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameIsNotNull() {
            addCriterion("email_username is not null");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameEqualTo(String value) {
            addCriterion("email_username =", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameNotEqualTo(String value) {
            addCriterion("email_username <>", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameGreaterThan(String value) {
            addCriterion("email_username >", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("email_username >=", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameLessThan(String value) {
            addCriterion("email_username <", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameLessThanOrEqualTo(String value) {
            addCriterion("email_username <=", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameLike(String value) {
            addCriterion("email_username like", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameNotLike(String value) {
            addCriterion("email_username not like", value, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameIn(List<String> values) {
            addCriterion("email_username in", values, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameNotIn(List<String> values) {
            addCriterion("email_username not in", values, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameBetween(String value1, String value2) {
            addCriterion("email_username between", value1, value2, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameNotBetween(String value1, String value2) {
            addCriterion("email_username not between", value1, value2, "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailPwdIsNull() {
            addCriterion("email_pwd is null");
            return (Criteria) this;
        }

        public Criteria andEmailPwdIsNotNull() {
            addCriterion("email_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andEmailPwdEqualTo(String value) {
            addCriterion("email_pwd =", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdNotEqualTo(String value) {
            addCriterion("email_pwd <>", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdGreaterThan(String value) {
            addCriterion("email_pwd >", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdGreaterThanOrEqualTo(String value) {
            addCriterion("email_pwd >=", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdLessThan(String value) {
            addCriterion("email_pwd <", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdLessThanOrEqualTo(String value) {
            addCriterion("email_pwd <=", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdLike(String value) {
            addCriterion("email_pwd like", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdNotLike(String value) {
            addCriterion("email_pwd not like", value, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdIn(List<String> values) {
            addCriterion("email_pwd in", values, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdNotIn(List<String> values) {
            addCriterion("email_pwd not in", values, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdBetween(String value1, String value2) {
            addCriterion("email_pwd between", value1, value2, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailPwdNotBetween(String value1, String value2) {
            addCriterion("email_pwd not between", value1, value2, "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailTestIsNull() {
            addCriterion("email_test is null");
            return (Criteria) this;
        }

        public Criteria andEmailTestIsNotNull() {
            addCriterion("email_test is not null");
            return (Criteria) this;
        }

        public Criteria andEmailTestEqualTo(String value) {
            addCriterion("email_test =", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestNotEqualTo(String value) {
            addCriterion("email_test <>", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestGreaterThan(String value) {
            addCriterion("email_test >", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestGreaterThanOrEqualTo(String value) {
            addCriterion("email_test >=", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestLessThan(String value) {
            addCriterion("email_test <", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestLessThanOrEqualTo(String value) {
            addCriterion("email_test <=", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestLike(String value) {
            addCriterion("email_test like", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestNotLike(String value) {
            addCriterion("email_test not like", value, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestIn(List<String> values) {
            addCriterion("email_test in", values, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestNotIn(List<String> values) {
            addCriterion("email_test not in", values, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestBetween(String value1, String value2) {
            addCriterion("email_test between", value1, value2, "emailTest");
            return (Criteria) this;
        }

        public Criteria andEmailTestNotBetween(String value1, String value2) {
            addCriterion("email_test not between", value1, value2, "emailTest");
            return (Criteria) this;
        }

        public Criteria andHotDestinationIsNull() {
            addCriterion("hot_destination is null");
            return (Criteria) this;
        }

        public Criteria andHotDestinationIsNotNull() {
            addCriterion("hot_destination is not null");
            return (Criteria) this;
        }

        public Criteria andHotDestinationEqualTo(String value) {
            addCriterion("hot_destination =", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationNotEqualTo(String value) {
            addCriterion("hot_destination <>", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationGreaterThan(String value) {
            addCriterion("hot_destination >", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationGreaterThanOrEqualTo(String value) {
            addCriterion("hot_destination >=", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationLessThan(String value) {
            addCriterion("hot_destination <", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationLessThanOrEqualTo(String value) {
            addCriterion("hot_destination <=", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationLike(String value) {
            addCriterion("hot_destination like", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationNotLike(String value) {
            addCriterion("hot_destination not like", value, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationIn(List<String> values) {
            addCriterion("hot_destination in", values, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationNotIn(List<String> values) {
            addCriterion("hot_destination not in", values, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationBetween(String value1, String value2) {
            addCriterion("hot_destination between", value1, value2, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andHotDestinationNotBetween(String value1, String value2) {
            addCriterion("hot_destination not between", value1, value2, "hotDestination");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNull() {
            addCriterion("keywords is null");
            return (Criteria) this;
        }

        public Criteria andKeywordsIsNotNull() {
            addCriterion("keywords is not null");
            return (Criteria) this;
        }

        public Criteria andKeywordsEqualTo(String value) {
            addCriterion("keywords =", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotEqualTo(String value) {
            addCriterion("keywords <>", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThan(String value) {
            addCriterion("keywords >", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsGreaterThanOrEqualTo(String value) {
            addCriterion("keywords >=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThan(String value) {
            addCriterion("keywords <", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLessThanOrEqualTo(String value) {
            addCriterion("keywords <=", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsLike(String value) {
            addCriterion("keywords like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotLike(String value) {
            addCriterion("keywords not like", value, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsIn(List<String> values) {
            addCriterion("keywords in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotIn(List<String> values) {
            addCriterion("keywords not in", values, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsBetween(String value1, String value2) {
            addCriterion("keywords between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andKeywordsNotBetween(String value1, String value2) {
            addCriterion("keywords not between", value1, value2, "keywords");
            return (Criteria) this;
        }

        public Criteria andSmsStatusIsNull() {
            addCriterion("sms_status is null");
            return (Criteria) this;
        }

        public Criteria andSmsStatusIsNotNull() {
            addCriterion("sms_status is not null");
            return (Criteria) this;
        }

        public Criteria andSmsStatusEqualTo(String value) {
            addCriterion("sms_status =", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusNotEqualTo(String value) {
            addCriterion("sms_status <>", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusGreaterThan(String value) {
            addCriterion("sms_status >", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusGreaterThanOrEqualTo(String value) {
            addCriterion("sms_status >=", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusLessThan(String value) {
            addCriterion("sms_status <", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusLessThanOrEqualTo(String value) {
            addCriterion("sms_status <=", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusLike(String value) {
            addCriterion("sms_status like", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusNotLike(String value) {
            addCriterion("sms_status not like", value, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusIn(List<String> values) {
            addCriterion("sms_status in", values, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusNotIn(List<String> values) {
            addCriterion("sms_status not in", values, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusBetween(String value1, String value2) {
            addCriterion("sms_status between", value1, value2, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsStatusNotBetween(String value1, String value2) {
            addCriterion("sms_status not between", value1, value2, "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameIsNull() {
            addCriterion("sms_username is null");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameIsNotNull() {
            addCriterion("sms_username is not null");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameEqualTo(String value) {
            addCriterion("sms_username =", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameNotEqualTo(String value) {
            addCriterion("sms_username <>", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameGreaterThan(String value) {
            addCriterion("sms_username >", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameGreaterThanOrEqualTo(String value) {
            addCriterion("sms_username >=", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameLessThan(String value) {
            addCriterion("sms_username <", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameLessThanOrEqualTo(String value) {
            addCriterion("sms_username <=", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameLike(String value) {
            addCriterion("sms_username like", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameNotLike(String value) {
            addCriterion("sms_username not like", value, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameIn(List<String> values) {
            addCriterion("sms_username in", values, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameNotIn(List<String> values) {
            addCriterion("sms_username not in", values, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameBetween(String value1, String value2) {
            addCriterion("sms_username between", value1, value2, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameNotBetween(String value1, String value2) {
            addCriterion("sms_username not between", value1, value2, "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsPwdIsNull() {
            addCriterion("sms_pwd is null");
            return (Criteria) this;
        }

        public Criteria andSmsPwdIsNotNull() {
            addCriterion("sms_pwd is not null");
            return (Criteria) this;
        }

        public Criteria andSmsPwdEqualTo(String value) {
            addCriterion("sms_pwd =", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdNotEqualTo(String value) {
            addCriterion("sms_pwd <>", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdGreaterThan(String value) {
            addCriterion("sms_pwd >", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdGreaterThanOrEqualTo(String value) {
            addCriterion("sms_pwd >=", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdLessThan(String value) {
            addCriterion("sms_pwd <", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdLessThanOrEqualTo(String value) {
            addCriterion("sms_pwd <=", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdLike(String value) {
            addCriterion("sms_pwd like", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdNotLike(String value) {
            addCriterion("sms_pwd not like", value, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdIn(List<String> values) {
            addCriterion("sms_pwd in", values, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdNotIn(List<String> values) {
            addCriterion("sms_pwd not in", values, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdBetween(String value1, String value2) {
            addCriterion("sms_pwd between", value1, value2, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsPwdNotBetween(String value1, String value2) {
            addCriterion("sms_pwd not between", value1, value2, "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayIsNull() {
            addCriterion("sms_send_gateway is null");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayIsNotNull() {
            addCriterion("sms_send_gateway is not null");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayEqualTo(String value) {
            addCriterion("sms_send_gateway =", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayNotEqualTo(String value) {
            addCriterion("sms_send_gateway <>", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayGreaterThan(String value) {
            addCriterion("sms_send_gateway >", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayGreaterThanOrEqualTo(String value) {
            addCriterion("sms_send_gateway >=", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayLessThan(String value) {
            addCriterion("sms_send_gateway <", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayLessThanOrEqualTo(String value) {
            addCriterion("sms_send_gateway <=", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayLike(String value) {
            addCriterion("sms_send_gateway like", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayNotLike(String value) {
            addCriterion("sms_send_gateway not like", value, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayIn(List<String> values) {
            addCriterion("sms_send_gateway in", values, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayNotIn(List<String> values) {
            addCriterion("sms_send_gateway not in", values, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayBetween(String value1, String value2) {
            addCriterion("sms_send_gateway between", value1, value2, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayNotBetween(String value1, String value2) {
            addCriterion("sms_send_gateway not between", value1, value2, "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayIsNull() {
            addCriterion("sms_receive_gateway is null");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayIsNotNull() {
            addCriterion("sms_receive_gateway is not null");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayEqualTo(String value) {
            addCriterion("sms_receive_gateway =", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayNotEqualTo(String value) {
            addCriterion("sms_receive_gateway <>", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayGreaterThan(String value) {
            addCriterion("sms_receive_gateway >", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayGreaterThanOrEqualTo(String value) {
            addCriterion("sms_receive_gateway >=", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayLessThan(String value) {
            addCriterion("sms_receive_gateway <", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayLessThanOrEqualTo(String value) {
            addCriterion("sms_receive_gateway <=", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayLike(String value) {
            addCriterion("sms_receive_gateway like", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayNotLike(String value) {
            addCriterion("sms_receive_gateway not like", value, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayIn(List<String> values) {
            addCriterion("sms_receive_gateway in", values, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayNotIn(List<String> values) {
            addCriterion("sms_receive_gateway not in", values, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayBetween(String value1, String value2) {
            addCriterion("sms_receive_gateway between", value1, value2, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayNotBetween(String value1, String value2) {
            addCriterion("sms_receive_gateway not between", value1, value2, "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andScriptIsNull() {
            addCriterion("script is null");
            return (Criteria) this;
        }

        public Criteria andScriptIsNotNull() {
            addCriterion("script is not null");
            return (Criteria) this;
        }

        public Criteria andScriptEqualTo(String value) {
            addCriterion("script =", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptNotEqualTo(String value) {
            addCriterion("script <>", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptGreaterThan(String value) {
            addCriterion("script >", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptGreaterThanOrEqualTo(String value) {
            addCriterion("script >=", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptLessThan(String value) {
            addCriterion("script <", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptLessThanOrEqualTo(String value) {
            addCriterion("script <=", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptLike(String value) {
            addCriterion("script like", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptNotLike(String value) {
            addCriterion("script not like", value, "script");
            return (Criteria) this;
        }

        public Criteria andScriptIn(List<String> values) {
            addCriterion("script in", values, "script");
            return (Criteria) this;
        }

        public Criteria andScriptNotIn(List<String> values) {
            addCriterion("script not in", values, "script");
            return (Criteria) this;
        }

        public Criteria andScriptBetween(String value1, String value2) {
            addCriterion("script between", value1, value2, "script");
            return (Criteria) this;
        }

        public Criteria andScriptNotBetween(String value1, String value2) {
            addCriterion("script not between", value1, value2, "script");
            return (Criteria) this;
        }

        public Criteria andOrderRetainIsNull() {
            addCriterion("order_retain is null");
            return (Criteria) this;
        }

        public Criteria andOrderRetainIsNotNull() {
            addCriterion("order_retain is not null");
            return (Criteria) this;
        }

        public Criteria andOrderRetainEqualTo(String value) {
            addCriterion("order_retain =", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainNotEqualTo(String value) {
            addCriterion("order_retain <>", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainGreaterThan(String value) {
            addCriterion("order_retain >", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainGreaterThanOrEqualTo(String value) {
            addCriterion("order_retain >=", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainLessThan(String value) {
            addCriterion("order_retain <", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainLessThanOrEqualTo(String value) {
            addCriterion("order_retain <=", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainLike(String value) {
            addCriterion("order_retain like", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainNotLike(String value) {
            addCriterion("order_retain not like", value, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainIn(List<String> values) {
            addCriterion("order_retain in", values, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainNotIn(List<String> values) {
            addCriterion("order_retain not in", values, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainBetween(String value1, String value2) {
            addCriterion("order_retain between", value1, value2, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andOrderRetainNotBetween(String value1, String value2) {
            addCriterion("order_retain not between", value1, value2, "orderRetain");
            return (Criteria) this;
        }

        public Criteria andFeeRateLikeInsensitive(String value) {
            addCriterion("upper(fee_rate) like", value.toUpperCase(), "feeRate");
            return (Criteria) this;
        }

        public Criteria andPeriodLikeInsensitive(String value) {
            addCriterion("upper(period) like", value.toUpperCase(), "period");
            return (Criteria) this;
        }

        public Criteria andCopyrightLikeInsensitive(String value) {
            addCriterion("upper(copyright) like", value.toUpperCase(), "copyright");
            return (Criteria) this;
        }

        public Criteria andCloseReasonLikeInsensitive(String value) {
            addCriterion("upper(close_reason) like", value.toUpperCase(), "closeReason");
            return (Criteria) this;
        }

        public Criteria andStatusLikeInsensitive(String value) {
            addCriterion("upper(status) like", value.toUpperCase(), "status");
            return (Criteria) this;
        }

        public Criteria andEmailStatusLikeInsensitive(String value) {
            addCriterion("upper(email_status) like", value.toUpperCase(), "emailStatus");
            return (Criteria) this;
        }

        public Criteria andEmailHostLikeInsensitive(String value) {
            addCriterion("upper(email_host) like", value.toUpperCase(), "emailHost");
            return (Criteria) this;
        }

        public Criteria andEmailPortLikeInsensitive(String value) {
            addCriterion("upper(email_port) like", value.toUpperCase(), "emailPort");
            return (Criteria) this;
        }

        public Criteria andEmailUserLikeInsensitive(String value) {
            addCriterion("upper(email_user) like", value.toUpperCase(), "emailUser");
            return (Criteria) this;
        }

        public Criteria andEmailUsernameLikeInsensitive(String value) {
            addCriterion("upper(email_username) like", value.toUpperCase(), "emailUsername");
            return (Criteria) this;
        }

        public Criteria andEmailPwdLikeInsensitive(String value) {
            addCriterion("upper(email_pwd) like", value.toUpperCase(), "emailPwd");
            return (Criteria) this;
        }

        public Criteria andEmailTestLikeInsensitive(String value) {
            addCriterion("upper(email_test) like", value.toUpperCase(), "emailTest");
            return (Criteria) this;
        }

        public Criteria andHotDestinationLikeInsensitive(String value) {
            addCriterion("upper(hot_destination) like", value.toUpperCase(), "hotDestination");
            return (Criteria) this;
        }

        public Criteria andKeywordsLikeInsensitive(String value) {
            addCriterion("upper(keywords) like", value.toUpperCase(), "keywords");
            return (Criteria) this;
        }

        public Criteria andSmsStatusLikeInsensitive(String value) {
            addCriterion("upper(sms_status) like", value.toUpperCase(), "smsStatus");
            return (Criteria) this;
        }

        public Criteria andSmsUsernameLikeInsensitive(String value) {
            addCriterion("upper(sms_username) like", value.toUpperCase(), "smsUsername");
            return (Criteria) this;
        }

        public Criteria andSmsPwdLikeInsensitive(String value) {
            addCriterion("upper(sms_pwd) like", value.toUpperCase(), "smsPwd");
            return (Criteria) this;
        }

        public Criteria andSmsSendGatewayLikeInsensitive(String value) {
            addCriterion("upper(sms_send_gateway) like", value.toUpperCase(), "smsSendGateway");
            return (Criteria) this;
        }

        public Criteria andSmsReceiveGatewayLikeInsensitive(String value) {
            addCriterion("upper(sms_receive_gateway) like", value.toUpperCase(), "smsReceiveGateway");
            return (Criteria) this;
        }

        public Criteria andScriptLikeInsensitive(String value) {
            addCriterion("upper(script) like", value.toUpperCase(), "script");
            return (Criteria) this;
        }

        public Criteria andOrderRetainLikeInsensitive(String value) {
            addCriterion("upper(order_retain) like", value.toUpperCase(), "orderRetain");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}
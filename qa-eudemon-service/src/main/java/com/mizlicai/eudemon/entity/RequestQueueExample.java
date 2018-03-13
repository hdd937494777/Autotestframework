package com.mizlicai.eudemon.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestQueueExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public RequestQueueExample() {
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

        public Criteria andServiceIdIsNull() {
            addCriterion("service_id is null");
            return (Criteria) this;
        }

        public Criteria andServiceIdIsNotNull() {
            addCriterion("service_id is not null");
            return (Criteria) this;
        }

        public Criteria andServiceIdEqualTo(Integer value) {
            addCriterion("service_id =", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotEqualTo(Integer value) {
            addCriterion("service_id <>", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThan(Integer value) {
            addCriterion("service_id >", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("service_id >=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThan(Integer value) {
            addCriterion("service_id <", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdLessThanOrEqualTo(Integer value) {
            addCriterion("service_id <=", value, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdIn(List<Integer> values) {
            addCriterion("service_id in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotIn(List<Integer> values) {
            addCriterion("service_id not in", values, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdBetween(Integer value1, Integer value2) {
            addCriterion("service_id between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceIdNotBetween(Integer value1, Integer value2) {
            addCriterion("service_id not between", value1, value2, "serviceId");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNull() {
            addCriterion("service_name is null");
            return (Criteria) this;
        }

        public Criteria andServiceNameIsNotNull() {
            addCriterion("service_name is not null");
            return (Criteria) this;
        }

        public Criteria andServiceNameEqualTo(String value) {
            addCriterion("service_name =", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotEqualTo(String value) {
            addCriterion("service_name <>", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThan(String value) {
            addCriterion("service_name >", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameGreaterThanOrEqualTo(String value) {
            addCriterion("service_name >=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThan(String value) {
            addCriterion("service_name <", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLessThanOrEqualTo(String value) {
            addCriterion("service_name <=", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameLike(String value) {
            addCriterion("service_name like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotLike(String value) {
            addCriterion("service_name not like", value, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameIn(List<String> values) {
            addCriterion("service_name in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotIn(List<String> values) {
            addCriterion("service_name not in", values, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameBetween(String value1, String value2) {
            addCriterion("service_name between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andServiceNameNotBetween(String value1, String value2) {
            addCriterion("service_name not between", value1, value2, "serviceName");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNull() {
            addCriterion("request_time is null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIsNotNull() {
            addCriterion("request_time is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTimeEqualTo(Date value) {
            addCriterion("request_time =", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotEqualTo(Date value) {
            addCriterion("request_time <>", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThan(Date value) {
            addCriterion("request_time >", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("request_time >=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThan(Date value) {
            addCriterion("request_time <", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeLessThanOrEqualTo(Date value) {
            addCriterion("request_time <=", value, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeIn(List<Date> values) {
            addCriterion("request_time in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotIn(List<Date> values) {
            addCriterion("request_time not in", values, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeBetween(Date value1, Date value2) {
            addCriterion("request_time between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestTimeNotBetween(Date value1, Date value2) {
            addCriterion("request_time not between", value1, value2, "requestTime");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIsNull() {
            addCriterion("request_url is null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIsNotNull() {
            addCriterion("request_url is not null");
            return (Criteria) this;
        }

        public Criteria andRequestUrlEqualTo(String value) {
            addCriterion("request_url =", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotEqualTo(String value) {
            addCriterion("request_url <>", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThan(String value) {
            addCriterion("request_url >", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlGreaterThanOrEqualTo(String value) {
            addCriterion("request_url >=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThan(String value) {
            addCriterion("request_url <", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLessThanOrEqualTo(String value) {
            addCriterion("request_url <=", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLike(String value) {
            addCriterion("request_url like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotLike(String value) {
            addCriterion("request_url not like", value, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlIn(List<String> values) {
            addCriterion("request_url in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotIn(List<String> values) {
            addCriterion("request_url not in", values, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlBetween(String value1, String value2) {
            addCriterion("request_url between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestUrlNotBetween(String value1, String value2) {
            addCriterion("request_url not between", value1, value2, "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNull() {
            addCriterion("request_type is null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIsNotNull() {
            addCriterion("request_type is not null");
            return (Criteria) this;
        }

        public Criteria andRequestTypeEqualTo(String value) {
            addCriterion("request_type =", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotEqualTo(String value) {
            addCriterion("request_type <>", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThan(String value) {
            addCriterion("request_type >", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("request_type >=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThan(String value) {
            addCriterion("request_type <", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLessThanOrEqualTo(String value) {
            addCriterion("request_type <=", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLike(String value) {
            addCriterion("request_type like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotLike(String value) {
            addCriterion("request_type not like", value, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeIn(List<String> values) {
            addCriterion("request_type in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotIn(List<String> values) {
            addCriterion("request_type not in", values, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeBetween(String value1, String value2) {
            addCriterion("request_type between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestTypeNotBetween(String value1, String value2) {
            addCriterion("request_type not between", value1, value2, "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestDataIsNull() {
            addCriterion("request_data is null");
            return (Criteria) this;
        }

        public Criteria andRequestDataIsNotNull() {
            addCriterion("request_data is not null");
            return (Criteria) this;
        }

        public Criteria andRequestDataEqualTo(String value) {
            addCriterion("request_data =", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotEqualTo(String value) {
            addCriterion("request_data <>", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataGreaterThan(String value) {
            addCriterion("request_data >", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataGreaterThanOrEqualTo(String value) {
            addCriterion("request_data >=", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataLessThan(String value) {
            addCriterion("request_data <", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataLessThanOrEqualTo(String value) {
            addCriterion("request_data <=", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataLike(String value) {
            addCriterion("request_data like", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotLike(String value) {
            addCriterion("request_data not like", value, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataIn(List<String> values) {
            addCriterion("request_data in", values, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotIn(List<String> values) {
            addCriterion("request_data not in", values, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataBetween(String value1, String value2) {
            addCriterion("request_data between", value1, value2, "requestData");
            return (Criteria) this;
        }

        public Criteria andRequestDataNotBetween(String value1, String value2) {
            addCriterion("request_data not between", value1, value2, "requestData");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNull() {
            addCriterion("response_time is null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIsNotNull() {
            addCriterion("response_time is not null");
            return (Criteria) this;
        }

        public Criteria andResponseTimeEqualTo(Date value) {
            addCriterion("response_time =", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotEqualTo(Date value) {
            addCriterion("response_time <>", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThan(Date value) {
            addCriterion("response_time >", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("response_time >=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThan(Date value) {
            addCriterion("response_time <", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeLessThanOrEqualTo(Date value) {
            addCriterion("response_time <=", value, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeIn(List<Date> values) {
            addCriterion("response_time in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotIn(List<Date> values) {
            addCriterion("response_time not in", values, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeBetween(Date value1, Date value2) {
            addCriterion("response_time between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseTimeNotBetween(Date value1, Date value2) {
            addCriterion("response_time not between", value1, value2, "responseTime");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIsNull() {
            addCriterion("response_status is null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIsNotNull() {
            addCriterion("response_status is not null");
            return (Criteria) this;
        }

        public Criteria andResponseStatusEqualTo(String value) {
            addCriterion("response_status =", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotEqualTo(String value) {
            addCriterion("response_status <>", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThan(String value) {
            addCriterion("response_status >", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("response_status >=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThan(String value) {
            addCriterion("response_status <", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLessThanOrEqualTo(String value) {
            addCriterion("response_status <=", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLike(String value) {
            addCriterion("response_status like", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotLike(String value) {
            addCriterion("response_status not like", value, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusIn(List<String> values) {
            addCriterion("response_status in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotIn(List<String> values) {
            addCriterion("response_status not in", values, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusBetween(String value1, String value2) {
            addCriterion("response_status between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseStatusNotBetween(String value1, String value2) {
            addCriterion("response_status not between", value1, value2, "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseDataIsNull() {
            addCriterion("response_data is null");
            return (Criteria) this;
        }

        public Criteria andResponseDataIsNotNull() {
            addCriterion("response_data is not null");
            return (Criteria) this;
        }

        public Criteria andResponseDataEqualTo(String value) {
            addCriterion("response_data =", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotEqualTo(String value) {
            addCriterion("response_data <>", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataGreaterThan(String value) {
            addCriterion("response_data >", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataGreaterThanOrEqualTo(String value) {
            addCriterion("response_data >=", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLessThan(String value) {
            addCriterion("response_data <", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLessThanOrEqualTo(String value) {
            addCriterion("response_data <=", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataLike(String value) {
            addCriterion("response_data like", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotLike(String value) {
            addCriterion("response_data not like", value, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataIn(List<String> values) {
            addCriterion("response_data in", values, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotIn(List<String> values) {
            addCriterion("response_data not in", values, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataBetween(String value1, String value2) {
            addCriterion("response_data between", value1, value2, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseDataNotBetween(String value1, String value2) {
            addCriterion("response_data not between", value1, value2, "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNull() {
            addCriterion("response_code is null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIsNotNull() {
            addCriterion("response_code is not null");
            return (Criteria) this;
        }

        public Criteria andResponseCodeEqualTo(String value) {
            addCriterion("response_code =", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotEqualTo(String value) {
            addCriterion("response_code <>", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThan(String value) {
            addCriterion("response_code >", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("response_code >=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThan(String value) {
            addCriterion("response_code <", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLessThanOrEqualTo(String value) {
            addCriterion("response_code <=", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLike(String value) {
            addCriterion("response_code like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotLike(String value) {
            addCriterion("response_code not like", value, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeIn(List<String> values) {
            addCriterion("response_code in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotIn(List<String> values) {
            addCriterion("response_code not in", values, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeBetween(String value1, String value2) {
            addCriterion("response_code between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andResponseCodeNotBetween(String value1, String value2) {
            addCriterion("response_code not between", value1, value2, "responseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusIsNull() {
            addCriterion("expect_response_status is null");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusIsNotNull() {
            addCriterion("expect_response_status is not null");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusEqualTo(String value) {
            addCriterion("expect_response_status =", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusNotEqualTo(String value) {
            addCriterion("expect_response_status <>", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusGreaterThan(String value) {
            addCriterion("expect_response_status >", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusGreaterThanOrEqualTo(String value) {
            addCriterion("expect_response_status >=", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusLessThan(String value) {
            addCriterion("expect_response_status <", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusLessThanOrEqualTo(String value) {
            addCriterion("expect_response_status <=", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusLike(String value) {
            addCriterion("expect_response_status like", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusNotLike(String value) {
            addCriterion("expect_response_status not like", value, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusIn(List<String> values) {
            addCriterion("expect_response_status in", values, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusNotIn(List<String> values) {
            addCriterion("expect_response_status not in", values, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusBetween(String value1, String value2) {
            addCriterion("expect_response_status between", value1, value2, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusNotBetween(String value1, String value2) {
            addCriterion("expect_response_status not between", value1, value2, "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataIsNull() {
            addCriterion("expect_response_data is null");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataIsNotNull() {
            addCriterion("expect_response_data is not null");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataEqualTo(String value) {
            addCriterion("expect_response_data =", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataNotEqualTo(String value) {
            addCriterion("expect_response_data <>", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataGreaterThan(String value) {
            addCriterion("expect_response_data >", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataGreaterThanOrEqualTo(String value) {
            addCriterion("expect_response_data >=", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataLessThan(String value) {
            addCriterion("expect_response_data <", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataLessThanOrEqualTo(String value) {
            addCriterion("expect_response_data <=", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataLike(String value) {
            addCriterion("expect_response_data like", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataNotLike(String value) {
            addCriterion("expect_response_data not like", value, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataIn(List<String> values) {
            addCriterion("expect_response_data in", values, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataNotIn(List<String> values) {
            addCriterion("expect_response_data not in", values, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataBetween(String value1, String value2) {
            addCriterion("expect_response_data between", value1, value2, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataNotBetween(String value1, String value2) {
            addCriterion("expect_response_data not between", value1, value2, "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeIsNull() {
            addCriterion("expect_response_code is null");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeIsNotNull() {
            addCriterion("expect_response_code is not null");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeEqualTo(String value) {
            addCriterion("expect_response_code =", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeNotEqualTo(String value) {
            addCriterion("expect_response_code <>", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeGreaterThan(String value) {
            addCriterion("expect_response_code >", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeGreaterThanOrEqualTo(String value) {
            addCriterion("expect_response_code >=", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeLessThan(String value) {
            addCriterion("expect_response_code <", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeLessThanOrEqualTo(String value) {
            addCriterion("expect_response_code <=", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeLike(String value) {
            addCriterion("expect_response_code like", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeNotLike(String value) {
            addCriterion("expect_response_code not like", value, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeIn(List<String> values) {
            addCriterion("expect_response_code in", values, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeNotIn(List<String> values) {
            addCriterion("expect_response_code not in", values, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeBetween(String value1, String value2) {
            addCriterion("expect_response_code between", value1, value2, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeNotBetween(String value1, String value2) {
            addCriterion("expect_response_code not between", value1, value2, "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNull() {
            addCriterion("is_check is null");
            return (Criteria) this;
        }

        public Criteria andIsCheckIsNotNull() {
            addCriterion("is_check is not null");
            return (Criteria) this;
        }

        public Criteria andIsCheckEqualTo(String value) {
            addCriterion("is_check =", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotEqualTo(String value) {
            addCriterion("is_check <>", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThan(String value) {
            addCriterion("is_check >", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckGreaterThanOrEqualTo(String value) {
            addCriterion("is_check >=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThan(String value) {
            addCriterion("is_check <", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLessThanOrEqualTo(String value) {
            addCriterion("is_check <=", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckLike(String value) {
            addCriterion("is_check like", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotLike(String value) {
            addCriterion("is_check not like", value, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckIn(List<String> values) {
            addCriterion("is_check in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotIn(List<String> values) {
            addCriterion("is_check not in", values, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckBetween(String value1, String value2) {
            addCriterion("is_check between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andIsCheckNotBetween(String value1, String value2) {
            addCriterion("is_check not between", value1, value2, "isCheck");
            return (Criteria) this;
        }

        public Criteria andTestPointIsNull() {
            addCriterion("test_point is null");
            return (Criteria) this;
        }

        public Criteria andTestPointIsNotNull() {
            addCriterion("test_point is not null");
            return (Criteria) this;
        }

        public Criteria andTestPointEqualTo(String value) {
            addCriterion("test_point =", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotEqualTo(String value) {
            addCriterion("test_point <>", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointGreaterThan(String value) {
            addCriterion("test_point >", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointGreaterThanOrEqualTo(String value) {
            addCriterion("test_point >=", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointLessThan(String value) {
            addCriterion("test_point <", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointLessThanOrEqualTo(String value) {
            addCriterion("test_point <=", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointLike(String value) {
            addCriterion("test_point like", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotLike(String value) {
            addCriterion("test_point not like", value, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointIn(List<String> values) {
            addCriterion("test_point in", values, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotIn(List<String> values) {
            addCriterion("test_point not in", values, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointBetween(String value1, String value2) {
            addCriterion("test_point between", value1, value2, "testPoint");
            return (Criteria) this;
        }

        public Criteria andTestPointNotBetween(String value1, String value2) {
            addCriterion("test_point not between", value1, value2, "testPoint");
            return (Criteria) this;
        }

        public Criteria andServiceNameLikeInsensitive(String value) {
            addCriterion("upper(service_name) like", value.toUpperCase(), "serviceName");
            return (Criteria) this;
        }

        public Criteria andRequestUrlLikeInsensitive(String value) {
            addCriterion("upper(request_url) like", value.toUpperCase(), "requestUrl");
            return (Criteria) this;
        }

        public Criteria andRequestTypeLikeInsensitive(String value) {
            addCriterion("upper(request_type) like", value.toUpperCase(), "requestType");
            return (Criteria) this;
        }

        public Criteria andRequestDataLikeInsensitive(String value) {
            addCriterion("upper(request_data) like", value.toUpperCase(), "requestData");
            return (Criteria) this;
        }

        public Criteria andResponseStatusLikeInsensitive(String value) {
            addCriterion("upper(response_status) like", value.toUpperCase(), "responseStatus");
            return (Criteria) this;
        }

        public Criteria andResponseDataLikeInsensitive(String value) {
            addCriterion("upper(response_data) like", value.toUpperCase(), "responseData");
            return (Criteria) this;
        }

        public Criteria andResponseCodeLikeInsensitive(String value) {
            addCriterion("upper(response_code) like", value.toUpperCase(), "responseCode");
            return (Criteria) this;
        }

        public Criteria andExpectResponseStatusLikeInsensitive(String value) {
            addCriterion("upper(expect_response_status) like", value.toUpperCase(), "expectResponseStatus");
            return (Criteria) this;
        }

        public Criteria andExpectResponseDataLikeInsensitive(String value) {
            addCriterion("upper(expect_response_data) like", value.toUpperCase(), "expectResponseData");
            return (Criteria) this;
        }

        public Criteria andExpectResponseCodeLikeInsensitive(String value) {
            addCriterion("upper(expect_response_code) like", value.toUpperCase(), "expectResponseCode");
            return (Criteria) this;
        }

        public Criteria andIsCheckLikeInsensitive(String value) {
            addCriterion("upper(is_check) like", value.toUpperCase(), "isCheck");
            return (Criteria) this;
        }

        public Criteria andTestPointLikeInsensitive(String value) {
            addCriterion("upper(test_point) like", value.toUpperCase(), "testPoint");
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
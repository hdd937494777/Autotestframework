package com.mizlicai.eudemon.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ServicesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ServicesExample() {
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

        public Criteria andRequestDataUrlIsNull() {
            addCriterion("request_data_url is null");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlIsNotNull() {
            addCriterion("request_data_url is not null");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlEqualTo(String value) {
            addCriterion("request_data_url =", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlNotEqualTo(String value) {
            addCriterion("request_data_url <>", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlGreaterThan(String value) {
            addCriterion("request_data_url >", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("request_data_url >=", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlLessThan(String value) {
            addCriterion("request_data_url <", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlLessThanOrEqualTo(String value) {
            addCriterion("request_data_url <=", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlLike(String value) {
            addCriterion("request_data_url like", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlNotLike(String value) {
            addCriterion("request_data_url not like", value, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlIn(List<String> values) {
            addCriterion("request_data_url in", values, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlNotIn(List<String> values) {
            addCriterion("request_data_url not in", values, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlBetween(String value1, String value2) {
            addCriterion("request_data_url between", value1, value2, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andRequestDataUrlNotBetween(String value1, String value2) {
            addCriterion("request_data_url not between", value1, value2, "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlIsNull() {
            addCriterion("response_data_url is null");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlIsNotNull() {
            addCriterion("response_data_url is not null");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlEqualTo(String value) {
            addCriterion("response_data_url =", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlNotEqualTo(String value) {
            addCriterion("response_data_url <>", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlGreaterThan(String value) {
            addCriterion("response_data_url >", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlGreaterThanOrEqualTo(String value) {
            addCriterion("response_data_url >=", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlLessThan(String value) {
            addCriterion("response_data_url <", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlLessThanOrEqualTo(String value) {
            addCriterion("response_data_url <=", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlLike(String value) {
            addCriterion("response_data_url like", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlNotLike(String value) {
            addCriterion("response_data_url not like", value, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlIn(List<String> values) {
            addCriterion("response_data_url in", values, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlNotIn(List<String> values) {
            addCriterion("response_data_url not in", values, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlBetween(String value1, String value2) {
            addCriterion("response_data_url between", value1, value2, "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlNotBetween(String value1, String value2) {
            addCriterion("response_data_url not between", value1, value2, "responseDataUrl");
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

        public Criteria andDescriptionIsNull() {
            addCriterion("description is null");
            return (Criteria) this;
        }

        public Criteria andDescriptionIsNotNull() {
            addCriterion("description is not null");
            return (Criteria) this;
        }

        public Criteria andDescriptionEqualTo(String value) {
            addCriterion("description =", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotEqualTo(String value) {
            addCriterion("description <>", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThan(String value) {
            addCriterion("description >", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionGreaterThanOrEqualTo(String value) {
            addCriterion("description >=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThan(String value) {
            addCriterion("description <", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLessThanOrEqualTo(String value) {
            addCriterion("description <=", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionLike(String value) {
            addCriterion("description like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotLike(String value) {
            addCriterion("description not like", value, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionIn(List<String> values) {
            addCriterion("description in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotIn(List<String> values) {
            addCriterion("description not in", values, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionBetween(String value1, String value2) {
            addCriterion("description between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andDescriptionNotBetween(String value1, String value2) {
            addCriterion("description not between", value1, value2, "description");
            return (Criteria) this;
        }

        public Criteria andNeedParameterIsNull() {
            addCriterion("need_parameter is null");
            return (Criteria) this;
        }

        public Criteria andNeedParameterIsNotNull() {
            addCriterion("need_parameter is not null");
            return (Criteria) this;
        }

        public Criteria andNeedParameterEqualTo(String value) {
            addCriterion("need_parameter =", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterNotEqualTo(String value) {
            addCriterion("need_parameter <>", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterGreaterThan(String value) {
            addCriterion("need_parameter >", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterGreaterThanOrEqualTo(String value) {
            addCriterion("need_parameter >=", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterLessThan(String value) {
            addCriterion("need_parameter <", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterLessThanOrEqualTo(String value) {
            addCriterion("need_parameter <=", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterLike(String value) {
            addCriterion("need_parameter like", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterNotLike(String value) {
            addCriterion("need_parameter not like", value, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterIn(List<String> values) {
            addCriterion("need_parameter in", values, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterNotIn(List<String> values) {
            addCriterion("need_parameter not in", values, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterBetween(String value1, String value2) {
            addCriterion("need_parameter between", value1, value2, "needParameter");
            return (Criteria) this;
        }

        public Criteria andNeedParameterNotBetween(String value1, String value2) {
            addCriterion("need_parameter not between", value1, value2, "needParameter");
            return (Criteria) this;
        }

        public Criteria andProjectIsNull() {
            addCriterion("project is null");
            return (Criteria) this;
        }

        public Criteria andProjectIsNotNull() {
            addCriterion("project is not null");
            return (Criteria) this;
        }

        public Criteria andProjectEqualTo(String value) {
            addCriterion("project =", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotEqualTo(String value) {
            addCriterion("project <>", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThan(String value) {
            addCriterion("project >", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectGreaterThanOrEqualTo(String value) {
            addCriterion("project >=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThan(String value) {
            addCriterion("project <", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLessThanOrEqualTo(String value) {
            addCriterion("project <=", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectLike(String value) {
            addCriterion("project like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotLike(String value) {
            addCriterion("project not like", value, "project");
            return (Criteria) this;
        }

        public Criteria andProjectIn(List<String> values) {
            addCriterion("project in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotIn(List<String> values) {
            addCriterion("project not in", values, "project");
            return (Criteria) this;
        }

        public Criteria andProjectBetween(String value1, String value2) {
            addCriterion("project between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andProjectNotBetween(String value1, String value2) {
            addCriterion("project not between", value1, value2, "project");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNull() {
            addCriterion("operator_name is null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIsNotNull() {
            addCriterion("operator_name is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorNameEqualTo(String value) {
            addCriterion("operator_name =", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotEqualTo(String value) {
            addCriterion("operator_name <>", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThan(String value) {
            addCriterion("operator_name >", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameGreaterThanOrEqualTo(String value) {
            addCriterion("operator_name >=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThan(String value) {
            addCriterion("operator_name <", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLessThanOrEqualTo(String value) {
            addCriterion("operator_name <=", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLike(String value) {
            addCriterion("operator_name like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotLike(String value) {
            addCriterion("operator_name not like", value, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameIn(List<String> values) {
            addCriterion("operator_name in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotIn(List<String> values) {
            addCriterion("operator_name not in", values, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameBetween(String value1, String value2) {
            addCriterion("operator_name between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorNameNotBetween(String value1, String value2) {
            addCriterion("operator_name not between", value1, value2, "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNull() {
            addCriterion("operator_id is null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIsNotNull() {
            addCriterion("operator_id is not null");
            return (Criteria) this;
        }

        public Criteria andOperatorIdEqualTo(String value) {
            addCriterion("operator_id =", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotEqualTo(String value) {
            addCriterion("operator_id <>", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThan(String value) {
            addCriterion("operator_id >", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdGreaterThanOrEqualTo(String value) {
            addCriterion("operator_id >=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThan(String value) {
            addCriterion("operator_id <", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLessThanOrEqualTo(String value) {
            addCriterion("operator_id <=", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLike(String value) {
            addCriterion("operator_id like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotLike(String value) {
            addCriterion("operator_id not like", value, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdIn(List<String> values) {
            addCriterion("operator_id in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotIn(List<String> values) {
            addCriterion("operator_id not in", values, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdBetween(String value1, String value2) {
            addCriterion("operator_id between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andOperatorIdNotBetween(String value1, String value2) {
            addCriterion("operator_id not between", value1, value2, "operatorId");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNull() {
            addCriterion("time_out is null");
            return (Criteria) this;
        }

        public Criteria andTimeOutIsNotNull() {
            addCriterion("time_out is not null");
            return (Criteria) this;
        }

        public Criteria andTimeOutEqualTo(Integer value) {
            addCriterion("time_out =", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotEqualTo(Integer value) {
            addCriterion("time_out <>", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThan(Integer value) {
            addCriterion("time_out >", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutGreaterThanOrEqualTo(Integer value) {
            addCriterion("time_out >=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThan(Integer value) {
            addCriterion("time_out <", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutLessThanOrEqualTo(Integer value) {
            addCriterion("time_out <=", value, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutIn(List<Integer> values) {
            addCriterion("time_out in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotIn(List<Integer> values) {
            addCriterion("time_out not in", values, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutBetween(Integer value1, Integer value2) {
            addCriterion("time_out between", value1, value2, "timeOut");
            return (Criteria) this;
        }

        public Criteria andTimeOutNotBetween(Integer value1, Integer value2) {
            addCriterion("time_out not between", value1, value2, "timeOut");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountIsNull() {
            addCriterion("concurrent_count is null");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountIsNotNull() {
            addCriterion("concurrent_count is not null");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountEqualTo(Integer value) {
            addCriterion("concurrent_count =", value, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountNotEqualTo(Integer value) {
            addCriterion("concurrent_count <>", value, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountGreaterThan(Integer value) {
            addCriterion("concurrent_count >", value, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountGreaterThanOrEqualTo(Integer value) {
            addCriterion("concurrent_count >=", value, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountLessThan(Integer value) {
            addCriterion("concurrent_count <", value, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountLessThanOrEqualTo(Integer value) {
            addCriterion("concurrent_count <=", value, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountIn(List<Integer> values) {
            addCriterion("concurrent_count in", values, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountNotIn(List<Integer> values) {
            addCriterion("concurrent_count not in", values, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountBetween(Integer value1, Integer value2) {
            addCriterion("concurrent_count between", value1, value2, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andConcurrentCountNotBetween(Integer value1, Integer value2) {
            addCriterion("concurrent_count not between", value1, value2, "concurrentCount");
            return (Criteria) this;
        }

        public Criteria andIsNormalIsNull() {
            addCriterion("is_normal is null");
            return (Criteria) this;
        }

        public Criteria andIsNormalIsNotNull() {
            addCriterion("is_normal is not null");
            return (Criteria) this;
        }

        public Criteria andIsNormalEqualTo(String value) {
            addCriterion("is_normal =", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalNotEqualTo(String value) {
            addCriterion("is_normal <>", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalGreaterThan(String value) {
            addCriterion("is_normal >", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalGreaterThanOrEqualTo(String value) {
            addCriterion("is_normal >=", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalLessThan(String value) {
            addCriterion("is_normal <", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalLessThanOrEqualTo(String value) {
            addCriterion("is_normal <=", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalLike(String value) {
            addCriterion("is_normal like", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalNotLike(String value) {
            addCriterion("is_normal not like", value, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalIn(List<String> values) {
            addCriterion("is_normal in", values, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalNotIn(List<String> values) {
            addCriterion("is_normal not in", values, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalBetween(String value1, String value2) {
            addCriterion("is_normal between", value1, value2, "isNormal");
            return (Criteria) this;
        }

        public Criteria andIsNormalNotBetween(String value1, String value2) {
            addCriterion("is_normal not between", value1, value2, "isNormal");
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

        public Criteria andRequestDataUrlLikeInsensitive(String value) {
            addCriterion("upper(request_data_url) like", value.toUpperCase(), "requestDataUrl");
            return (Criteria) this;
        }

        public Criteria andResponseDataUrlLikeInsensitive(String value) {
            addCriterion("upper(response_data_url) like", value.toUpperCase(), "responseDataUrl");
            return (Criteria) this;
        }

        public Criteria andServiceNameLikeInsensitive(String value) {
            addCriterion("upper(service_name) like", value.toUpperCase(), "serviceName");
            return (Criteria) this;
        }

        public Criteria andDescriptionLikeInsensitive(String value) {
            addCriterion("upper(description) like", value.toUpperCase(), "description");
            return (Criteria) this;
        }

        public Criteria andNeedParameterLikeInsensitive(String value) {
            addCriterion("upper(need_parameter) like", value.toUpperCase(), "needParameter");
            return (Criteria) this;
        }

        public Criteria andProjectLikeInsensitive(String value) {
            addCriterion("upper(project) like", value.toUpperCase(), "project");
            return (Criteria) this;
        }

        public Criteria andOperatorNameLikeInsensitive(String value) {
            addCriterion("upper(operator_name) like", value.toUpperCase(), "operatorName");
            return (Criteria) this;
        }

        public Criteria andOperatorIdLikeInsensitive(String value) {
            addCriterion("upper(operator_id) like", value.toUpperCase(), "operatorId");
            return (Criteria) this;
        }

        public Criteria andIsNormalLikeInsensitive(String value) {
            addCriterion("upper(is_normal) like", value.toUpperCase(), "isNormal");
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
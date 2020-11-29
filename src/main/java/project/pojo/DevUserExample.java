package project.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DevUserExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DevUserExample() {
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

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andDevCodeIsNull() {
            addCriterion("devCode is null");
            return (Criteria) this;
        }

        public Criteria andDevCodeIsNotNull() {
            addCriterion("devCode is not null");
            return (Criteria) this;
        }

        public Criteria andDevCodeEqualTo(String value) {
            addCriterion("devCode =", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeNotEqualTo(String value) {
            addCriterion("devCode <>", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeGreaterThan(String value) {
            addCriterion("devCode >", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeGreaterThanOrEqualTo(String value) {
            addCriterion("devCode >=", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeLessThan(String value) {
            addCriterion("devCode <", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeLessThanOrEqualTo(String value) {
            addCriterion("devCode <=", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeLike(String value) {
            addCriterion("devCode like", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeNotLike(String value) {
            addCriterion("devCode not like", value, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeIn(List<String> values) {
            addCriterion("devCode in", values, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeNotIn(List<String> values) {
            addCriterion("devCode not in", values, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeBetween(String value1, String value2) {
            addCriterion("devCode between", value1, value2, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevCodeNotBetween(String value1, String value2) {
            addCriterion("devCode not between", value1, value2, "devCode");
            return (Criteria) this;
        }

        public Criteria andDevNameIsNull() {
            addCriterion("devName is null");
            return (Criteria) this;
        }

        public Criteria andDevNameIsNotNull() {
            addCriterion("devName is not null");
            return (Criteria) this;
        }

        public Criteria andDevNameEqualTo(String value) {
            addCriterion("devName =", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotEqualTo(String value) {
            addCriterion("devName <>", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameGreaterThan(String value) {
            addCriterion("devName >", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameGreaterThanOrEqualTo(String value) {
            addCriterion("devName >=", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLessThan(String value) {
            addCriterion("devName <", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLessThanOrEqualTo(String value) {
            addCriterion("devName <=", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameLike(String value) {
            addCriterion("devName like", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotLike(String value) {
            addCriterion("devName not like", value, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameIn(List<String> values) {
            addCriterion("devName in", values, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotIn(List<String> values) {
            addCriterion("devName not in", values, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameBetween(String value1, String value2) {
            addCriterion("devName between", value1, value2, "devName");
            return (Criteria) this;
        }

        public Criteria andDevNameNotBetween(String value1, String value2) {
            addCriterion("devName not between", value1, value2, "devName");
            return (Criteria) this;
        }

        public Criteria andDevPasswordIsNull() {
            addCriterion("devPassword is null");
            return (Criteria) this;
        }

        public Criteria andDevPasswordIsNotNull() {
            addCriterion("devPassword is not null");
            return (Criteria) this;
        }

        public Criteria andDevPasswordEqualTo(String value) {
            addCriterion("devPassword =", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotEqualTo(String value) {
            addCriterion("devPassword <>", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordGreaterThan(String value) {
            addCriterion("devPassword >", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordGreaterThanOrEqualTo(String value) {
            addCriterion("devPassword >=", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordLessThan(String value) {
            addCriterion("devPassword <", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordLessThanOrEqualTo(String value) {
            addCriterion("devPassword <=", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordLike(String value) {
            addCriterion("devPassword like", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotLike(String value) {
            addCriterion("devPassword not like", value, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordIn(List<String> values) {
            addCriterion("devPassword in", values, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotIn(List<String> values) {
            addCriterion("devPassword not in", values, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordBetween(String value1, String value2) {
            addCriterion("devPassword between", value1, value2, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevPasswordNotBetween(String value1, String value2) {
            addCriterion("devPassword not between", value1, value2, "devPassword");
            return (Criteria) this;
        }

        public Criteria andDevEmailIsNull() {
            addCriterion("devEmail is null");
            return (Criteria) this;
        }

        public Criteria andDevEmailIsNotNull() {
            addCriterion("devEmail is not null");
            return (Criteria) this;
        }

        public Criteria andDevEmailEqualTo(String value) {
            addCriterion("devEmail =", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotEqualTo(String value) {
            addCriterion("devEmail <>", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailGreaterThan(String value) {
            addCriterion("devEmail >", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailGreaterThanOrEqualTo(String value) {
            addCriterion("devEmail >=", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailLessThan(String value) {
            addCriterion("devEmail <", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailLessThanOrEqualTo(String value) {
            addCriterion("devEmail <=", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailLike(String value) {
            addCriterion("devEmail like", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotLike(String value) {
            addCriterion("devEmail not like", value, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailIn(List<String> values) {
            addCriterion("devEmail in", values, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotIn(List<String> values) {
            addCriterion("devEmail not in", values, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailBetween(String value1, String value2) {
            addCriterion("devEmail between", value1, value2, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevEmailNotBetween(String value1, String value2) {
            addCriterion("devEmail not between", value1, value2, "devEmail");
            return (Criteria) this;
        }

        public Criteria andDevInfoIsNull() {
            addCriterion("devInfo is null");
            return (Criteria) this;
        }

        public Criteria andDevInfoIsNotNull() {
            addCriterion("devInfo is not null");
            return (Criteria) this;
        }

        public Criteria andDevInfoEqualTo(String value) {
            addCriterion("devInfo =", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoNotEqualTo(String value) {
            addCriterion("devInfo <>", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoGreaterThan(String value) {
            addCriterion("devInfo >", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoGreaterThanOrEqualTo(String value) {
            addCriterion("devInfo >=", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoLessThan(String value) {
            addCriterion("devInfo <", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoLessThanOrEqualTo(String value) {
            addCriterion("devInfo <=", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoLike(String value) {
            addCriterion("devInfo like", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoNotLike(String value) {
            addCriterion("devInfo not like", value, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoIn(List<String> values) {
            addCriterion("devInfo in", values, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoNotIn(List<String> values) {
            addCriterion("devInfo not in", values, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoBetween(String value1, String value2) {
            addCriterion("devInfo between", value1, value2, "devInfo");
            return (Criteria) this;
        }

        public Criteria andDevInfoNotBetween(String value1, String value2) {
            addCriterion("devInfo not between", value1, value2, "devInfo");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNull() {
            addCriterion("createBy is null");
            return (Criteria) this;
        }

        public Criteria andCreateByIsNotNull() {
            addCriterion("createBy is not null");
            return (Criteria) this;
        }

        public Criteria andCreateByEqualTo(Long value) {
            addCriterion("createBy =", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotEqualTo(Long value) {
            addCriterion("createBy <>", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThan(Long value) {
            addCriterion("createBy >", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByGreaterThanOrEqualTo(Long value) {
            addCriterion("createBy >=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThan(Long value) {
            addCriterion("createBy <", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByLessThanOrEqualTo(Long value) {
            addCriterion("createBy <=", value, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByIn(List<Long> values) {
            addCriterion("createBy in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotIn(List<Long> values) {
            addCriterion("createBy not in", values, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByBetween(Long value1, Long value2) {
            addCriterion("createBy between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreateByNotBetween(Long value1, Long value2) {
            addCriterion("createBy not between", value1, value2, "createBy");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNull() {
            addCriterion("creationDate is null");
            return (Criteria) this;
        }

        public Criteria andCreationDateIsNotNull() {
            addCriterion("creationDate is not null");
            return (Criteria) this;
        }

        public Criteria andCreationDateEqualTo(Date value) {
            addCriterion("creationDate =", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotEqualTo(Date value) {
            addCriterion("creationDate <>", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThan(Date value) {
            addCriterion("creationDate >", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateGreaterThanOrEqualTo(Date value) {
            addCriterion("creationDate >=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThan(Date value) {
            addCriterion("creationDate <", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateLessThanOrEqualTo(Date value) {
            addCriterion("creationDate <=", value, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateIn(List<Date> values) {
            addCriterion("creationDate in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotIn(List<Date> values) {
            addCriterion("creationDate not in", values, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateBetween(Date value1, Date value2) {
            addCriterion("creationDate between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andCreationDateNotBetween(Date value1, Date value2) {
            addCriterion("creationDate not between", value1, value2, "creationDate");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNull() {
            addCriterion("modifyBy is null");
            return (Criteria) this;
        }

        public Criteria andModifyByIsNotNull() {
            addCriterion("modifyBy is not null");
            return (Criteria) this;
        }

        public Criteria andModifyByEqualTo(Long value) {
            addCriterion("modifyBy =", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotEqualTo(Long value) {
            addCriterion("modifyBy <>", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThan(Long value) {
            addCriterion("modifyBy >", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByGreaterThanOrEqualTo(Long value) {
            addCriterion("modifyBy >=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThan(Long value) {
            addCriterion("modifyBy <", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByLessThanOrEqualTo(Long value) {
            addCriterion("modifyBy <=", value, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByIn(List<Long> values) {
            addCriterion("modifyBy in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotIn(List<Long> values) {
            addCriterion("modifyBy not in", values, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByBetween(Long value1, Long value2) {
            addCriterion("modifyBy between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyByNotBetween(Long value1, Long value2) {
            addCriterion("modifyBy not between", value1, value2, "modifyBy");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNull() {
            addCriterion("modifyDate is null");
            return (Criteria) this;
        }

        public Criteria andModifyDateIsNotNull() {
            addCriterion("modifyDate is not null");
            return (Criteria) this;
        }

        public Criteria andModifyDateEqualTo(Date value) {
            addCriterion("modifyDate =", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotEqualTo(Date value) {
            addCriterion("modifyDate <>", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThan(Date value) {
            addCriterion("modifyDate >", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("modifyDate >=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThan(Date value) {
            addCriterion("modifyDate <", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateLessThanOrEqualTo(Date value) {
            addCriterion("modifyDate <=", value, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateIn(List<Date> values) {
            addCriterion("modifyDate in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotIn(List<Date> values) {
            addCriterion("modifyDate not in", values, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateBetween(Date value1, Date value2) {
            addCriterion("modifyDate between", value1, value2, "modifyDate");
            return (Criteria) this;
        }

        public Criteria andModifyDateNotBetween(Date value1, Date value2) {
            addCriterion("modifyDate not between", value1, value2, "modifyDate");
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
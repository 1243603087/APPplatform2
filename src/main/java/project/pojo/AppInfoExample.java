package project.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class AppInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppInfoExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
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

        public Criteria andSoftwareNameIsNull() {
            addCriterion("softwareName is null");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameIsNotNull() {
            addCriterion("softwareName is not null");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameEqualTo(String value) {
            addCriterion("softwareName =", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotEqualTo(String value) {
            addCriterion("softwareName <>", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameGreaterThan(String value) {
            addCriterion("softwareName >", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameGreaterThanOrEqualTo(String value) {
            addCriterion("softwareName >=", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameLessThan(String value) {
            addCriterion("softwareName <", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameLessThanOrEqualTo(String value) {
            addCriterion("softwareName <=", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameLike(String value) {
            addCriterion("softwareName like", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotLike(String value) {
            addCriterion("softwareName not like", value, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameIn(List<String> values) {
            addCriterion("softwareName in", values, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotIn(List<String> values) {
            addCriterion("softwareName not in", values, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameBetween(String value1, String value2) {
            addCriterion("softwareName between", value1, value2, "softwareName");
            return (Criteria) this;
        }

        public Criteria andSoftwareNameNotBetween(String value1, String value2) {
            addCriterion("softwareName not between", value1, value2, "softwareName");
            return (Criteria) this;
        }

        public Criteria andAPKNameIsNull() {
            addCriterion("APKName is null");
            return (Criteria) this;
        }

        public Criteria andAPKNameIsNotNull() {
            addCriterion("APKName is not null");
            return (Criteria) this;
        }

        public Criteria andAPKNameEqualTo(String value) {
            addCriterion("APKName =", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameNotEqualTo(String value) {
            addCriterion("APKName <>", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameGreaterThan(String value) {
            addCriterion("APKName >", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameGreaterThanOrEqualTo(String value) {
            addCriterion("APKName >=", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameLessThan(String value) {
            addCriterion("APKName <", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameLessThanOrEqualTo(String value) {
            addCriterion("APKName <=", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameLike(String value) {
            addCriterion("APKName like", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameNotLike(String value) {
            addCriterion("APKName not like", value, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameIn(List<String> values) {
            addCriterion("APKName in", values, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameNotIn(List<String> values) {
            addCriterion("APKName not in", values, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameBetween(String value1, String value2) {
            addCriterion("APKName between", value1, value2, "APKName");
            return (Criteria) this;
        }

        public Criteria andAPKNameNotBetween(String value1, String value2) {
            addCriterion("APKName not between", value1, value2, "APKName");
            return (Criteria) this;
        }

        public Criteria andSupportROMIsNull() {
            addCriterion("supportROM is null");
            return (Criteria) this;
        }

        public Criteria andSupportROMIsNotNull() {
            addCriterion("supportROM is not null");
            return (Criteria) this;
        }

        public Criteria andSupportROMEqualTo(String value) {
            addCriterion("supportROM =", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMNotEqualTo(String value) {
            addCriterion("supportROM <>", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMGreaterThan(String value) {
            addCriterion("supportROM >", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMGreaterThanOrEqualTo(String value) {
            addCriterion("supportROM >=", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMLessThan(String value) {
            addCriterion("supportROM <", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMLessThanOrEqualTo(String value) {
            addCriterion("supportROM <=", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMLike(String value) {
            addCriterion("supportROM like", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMNotLike(String value) {
            addCriterion("supportROM not like", value, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMIn(List<String> values) {
            addCriterion("supportROM in", values, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMNotIn(List<String> values) {
            addCriterion("supportROM not in", values, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMBetween(String value1, String value2) {
            addCriterion("supportROM between", value1, value2, "supportROM");
            return (Criteria) this;
        }

        public Criteria andSupportROMNotBetween(String value1, String value2) {
            addCriterion("supportROM not between", value1, value2, "supportROM");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageIsNull() {
            addCriterion("interfaceLanguage is null");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageIsNotNull() {
            addCriterion("interfaceLanguage is not null");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageEqualTo(String value) {
            addCriterion("interfaceLanguage =", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageNotEqualTo(String value) {
            addCriterion("interfaceLanguage <>", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageGreaterThan(String value) {
            addCriterion("interfaceLanguage >", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageGreaterThanOrEqualTo(String value) {
            addCriterion("interfaceLanguage >=", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageLessThan(String value) {
            addCriterion("interfaceLanguage <", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageLessThanOrEqualTo(String value) {
            addCriterion("interfaceLanguage <=", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageLike(String value) {
            addCriterion("interfaceLanguage like", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageNotLike(String value) {
            addCriterion("interfaceLanguage not like", value, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageIn(List<String> values) {
            addCriterion("interfaceLanguage in", values, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageNotIn(List<String> values) {
            addCriterion("interfaceLanguage not in", values, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageBetween(String value1, String value2) {
            addCriterion("interfaceLanguage between", value1, value2, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andInterfaceLanguageNotBetween(String value1, String value2) {
            addCriterion("interfaceLanguage not between", value1, value2, "interfaceLanguage");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeIsNull() {
            addCriterion("softWareSize is null");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeIsNotNull() {
            addCriterion("softWareSize is not null");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeEqualTo(BigDecimal value) {
            addCriterion("softWareSize =", value, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeNotEqualTo(BigDecimal value) {
            addCriterion("softWareSize <>", value, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeGreaterThan(BigDecimal value) {
            addCriterion("softWareSize >", value, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("softWareSize >=", value, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeLessThan(BigDecimal value) {
            addCriterion("softWareSize <", value, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("softWareSize <=", value, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeIn(List<BigDecimal> values) {
            addCriterion("softWareSize in", values, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeNotIn(List<BigDecimal> values) {
            addCriterion("softWareSize not in", values, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("softWareSize between", value1, value2, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andSoftWareSizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("softWareSize not between", value1, value2, "softWareSize");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNull() {
            addCriterion("updateDate is null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIsNotNull() {
            addCriterion("updateDate is not null");
            return (Criteria) this;
        }

        public Criteria andUpdateDateEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate =", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate <>", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThan(Date value) {
            addCriterionForJDBCDate("updateDate >", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate >=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThan(Date value) {
            addCriterionForJDBCDate("updateDate <", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("updateDate <=", value, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateIn(List<Date> values) {
            addCriterionForJDBCDate("updateDate in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotIn(List<Date> values) {
            addCriterionForJDBCDate("updateDate not in", values, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateDate between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andUpdateDateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("updateDate not between", value1, value2, "updateDate");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNull() {
            addCriterion("devId is null");
            return (Criteria) this;
        }

        public Criteria andDevIdIsNotNull() {
            addCriterion("devId is not null");
            return (Criteria) this;
        }

        public Criteria andDevIdEqualTo(Long value) {
            addCriterion("devId =", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotEqualTo(Long value) {
            addCriterion("devId <>", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThan(Long value) {
            addCriterion("devId >", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdGreaterThanOrEqualTo(Long value) {
            addCriterion("devId >=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThan(Long value) {
            addCriterion("devId <", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdLessThanOrEqualTo(Long value) {
            addCriterion("devId <=", value, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdIn(List<Long> values) {
            addCriterion("devId in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotIn(List<Long> values) {
            addCriterion("devId not in", values, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdBetween(Long value1, Long value2) {
            addCriterion("devId between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andDevIdNotBetween(Long value1, Long value2) {
            addCriterion("devId not between", value1, value2, "devId");
            return (Criteria) this;
        }

        public Criteria andAppInfoIsNull() {
            addCriterion("appInfo is null");
            return (Criteria) this;
        }

        public Criteria andAppInfoIsNotNull() {
            addCriterion("appInfo is not null");
            return (Criteria) this;
        }

        public Criteria andAppInfoEqualTo(String value) {
            addCriterion("appInfo =", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoNotEqualTo(String value) {
            addCriterion("appInfo <>", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoGreaterThan(String value) {
            addCriterion("appInfo >", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoGreaterThanOrEqualTo(String value) {
            addCriterion("appInfo >=", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoLessThan(String value) {
            addCriterion("appInfo <", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoLessThanOrEqualTo(String value) {
            addCriterion("appInfo <=", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoLike(String value) {
            addCriterion("appInfo like", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoNotLike(String value) {
            addCriterion("appInfo not like", value, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoIn(List<String> values) {
            addCriterion("appInfo in", values, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoNotIn(List<String> values) {
            addCriterion("appInfo not in", values, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoBetween(String value1, String value2) {
            addCriterion("appInfo between", value1, value2, "appInfo");
            return (Criteria) this;
        }

        public Criteria andAppInfoNotBetween(String value1, String value2) {
            addCriterion("appInfo not between", value1, value2, "appInfo");
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

        public Criteria andStatusEqualTo(Long value) {
            addCriterion("status =", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotEqualTo(Long value) {
            addCriterion("status <>", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThan(Long value) {
            addCriterion("status >", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("status >=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThan(Long value) {
            addCriterion("status <", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusLessThanOrEqualTo(Long value) {
            addCriterion("status <=", value, "status");
            return (Criteria) this;
        }

        public Criteria andStatusIn(List<Long> values) {
            addCriterion("status in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotIn(List<Long> values) {
            addCriterion("status not in", values, "status");
            return (Criteria) this;
        }

        public Criteria andStatusBetween(Long value1, Long value2) {
            addCriterion("status between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andStatusNotBetween(Long value1, Long value2) {
            addCriterion("status not between", value1, value2, "status");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateIsNull() {
            addCriterion("onSaleDate is null");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateIsNotNull() {
            addCriterion("onSaleDate is not null");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateEqualTo(Date value) {
            addCriterion("onSaleDate =", value, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateNotEqualTo(Date value) {
            addCriterion("onSaleDate <>", value, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateGreaterThan(Date value) {
            addCriterion("onSaleDate >", value, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("onSaleDate >=", value, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateLessThan(Date value) {
            addCriterion("onSaleDate <", value, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateLessThanOrEqualTo(Date value) {
            addCriterion("onSaleDate <=", value, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateIn(List<Date> values) {
            addCriterion("onSaleDate in", values, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateNotIn(List<Date> values) {
            addCriterion("onSaleDate not in", values, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateBetween(Date value1, Date value2) {
            addCriterion("onSaleDate between", value1, value2, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOnSaleDateNotBetween(Date value1, Date value2) {
            addCriterion("onSaleDate not between", value1, value2, "onSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateIsNull() {
            addCriterion("offSaleDate is null");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateIsNotNull() {
            addCriterion("offSaleDate is not null");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateEqualTo(Date value) {
            addCriterion("offSaleDate =", value, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateNotEqualTo(Date value) {
            addCriterion("offSaleDate <>", value, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateGreaterThan(Date value) {
            addCriterion("offSaleDate >", value, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateGreaterThanOrEqualTo(Date value) {
            addCriterion("offSaleDate >=", value, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateLessThan(Date value) {
            addCriterion("offSaleDate <", value, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateLessThanOrEqualTo(Date value) {
            addCriterion("offSaleDate <=", value, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateIn(List<Date> values) {
            addCriterion("offSaleDate in", values, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateNotIn(List<Date> values) {
            addCriterion("offSaleDate not in", values, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateBetween(Date value1, Date value2) {
            addCriterion("offSaleDate between", value1, value2, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andOffSaleDateNotBetween(Date value1, Date value2) {
            addCriterion("offSaleDate not between", value1, value2, "offSaleDate");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdIsNull() {
            addCriterion("floatFormId is null");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdIsNotNull() {
            addCriterion("floatFormId is not null");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdEqualTo(Long value) {
            addCriterion("floatFormId =", value, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdNotEqualTo(Long value) {
            addCriterion("floatFormId <>", value, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdGreaterThan(Long value) {
            addCriterion("floatFormId >", value, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdGreaterThanOrEqualTo(Long value) {
            addCriterion("floatFormId >=", value, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdLessThan(Long value) {
            addCriterion("floatFormId <", value, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdLessThanOrEqualTo(Long value) {
            addCriterion("floatFormId <=", value, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdIn(List<Long> values) {
            addCriterion("floatFormId in", values, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdNotIn(List<Long> values) {
            addCriterion("floatFormId not in", values, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdBetween(Long value1, Long value2) {
            addCriterion("floatFormId between", value1, value2, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andFloatFormIdNotBetween(Long value1, Long value2) {
            addCriterion("floatFormId not between", value1, value2, "floatFormId");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3IsNull() {
            addCriterion("categoryLevel3 is null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3IsNotNull() {
            addCriterion("categoryLevel3 is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3EqualTo(Long value) {
            addCriterion("categoryLevel3 =", value, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3NotEqualTo(Long value) {
            addCriterion("categoryLevel3 <>", value, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3GreaterThan(Long value) {
            addCriterion("categoryLevel3 >", value, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3GreaterThanOrEqualTo(Long value) {
            addCriterion("categoryLevel3 >=", value, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3LessThan(Long value) {
            addCriterion("categoryLevel3 <", value, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3LessThanOrEqualTo(Long value) {
            addCriterion("categoryLevel3 <=", value, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3In(List<Long> values) {
            addCriterion("categoryLevel3 in", values, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3NotIn(List<Long> values) {
            addCriterion("categoryLevel3 not in", values, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3Between(Long value1, Long value2) {
            addCriterion("categoryLevel3 between", value1, value2, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel3NotBetween(Long value1, Long value2) {
            addCriterion("categoryLevel3 not between", value1, value2, "categoryLevel3");
            return (Criteria) this;
        }

        public Criteria andDownloadsIsNull() {
            addCriterion("downloads is null");
            return (Criteria) this;
        }

        public Criteria andDownloadsIsNotNull() {
            addCriterion("downloads is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadsEqualTo(Long value) {
            addCriterion("downloads =", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotEqualTo(Long value) {
            addCriterion("downloads <>", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsGreaterThan(Long value) {
            addCriterion("downloads >", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsGreaterThanOrEqualTo(Long value) {
            addCriterion("downloads >=", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsLessThan(Long value) {
            addCriterion("downloads <", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsLessThanOrEqualTo(Long value) {
            addCriterion("downloads <=", value, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsIn(List<Long> values) {
            addCriterion("downloads in", values, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotIn(List<Long> values) {
            addCriterion("downloads not in", values, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsBetween(Long value1, Long value2) {
            addCriterion("downloads between", value1, value2, "downloads");
            return (Criteria) this;
        }

        public Criteria andDownloadsNotBetween(Long value1, Long value2) {
            addCriterion("downloads not between", value1, value2, "downloads");
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

        public Criteria andCategoryLevel1IsNull() {
            addCriterion("categoryLevel1 is null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1IsNotNull() {
            addCriterion("categoryLevel1 is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1EqualTo(Long value) {
            addCriterion("categoryLevel1 =", value, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1NotEqualTo(Long value) {
            addCriterion("categoryLevel1 <>", value, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1GreaterThan(Long value) {
            addCriterion("categoryLevel1 >", value, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1GreaterThanOrEqualTo(Long value) {
            addCriterion("categoryLevel1 >=", value, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1LessThan(Long value) {
            addCriterion("categoryLevel1 <", value, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1LessThanOrEqualTo(Long value) {
            addCriterion("categoryLevel1 <=", value, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1In(List<Long> values) {
            addCriterion("categoryLevel1 in", values, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1NotIn(List<Long> values) {
            addCriterion("categoryLevel1 not in", values, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1Between(Long value1, Long value2) {
            addCriterion("categoryLevel1 between", value1, value2, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel1NotBetween(Long value1, Long value2) {
            addCriterion("categoryLevel1 not between", value1, value2, "categoryLevel1");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2IsNull() {
            addCriterion("categoryLevel2 is null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2IsNotNull() {
            addCriterion("categoryLevel2 is not null");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2EqualTo(Long value) {
            addCriterion("categoryLevel2 =", value, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2NotEqualTo(Long value) {
            addCriterion("categoryLevel2 <>", value, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2GreaterThan(Long value) {
            addCriterion("categoryLevel2 >", value, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2GreaterThanOrEqualTo(Long value) {
            addCriterion("categoryLevel2 >=", value, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2LessThan(Long value) {
            addCriterion("categoryLevel2 <", value, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2LessThanOrEqualTo(Long value) {
            addCriterion("categoryLevel2 <=", value, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2In(List<Long> values) {
            addCriterion("categoryLevel2 in", values, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2NotIn(List<Long> values) {
            addCriterion("categoryLevel2 not in", values, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2Between(Long value1, Long value2) {
            addCriterion("categoryLevel2 between", value1, value2, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andCategoryLevel2NotBetween(Long value1, Long value2) {
            addCriterion("categoryLevel2 not between", value1, value2, "categoryLevel2");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathIsNull() {
            addCriterion("logoLocPath is null");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathIsNotNull() {
            addCriterion("logoLocPath is not null");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathEqualTo(String value) {
            addCriterion("logoLocPath =", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathNotEqualTo(String value) {
            addCriterion("logoLocPath <>", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathGreaterThan(String value) {
            addCriterion("logoLocPath >", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathGreaterThanOrEqualTo(String value) {
            addCriterion("logoLocPath >=", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathLessThan(String value) {
            addCriterion("logoLocPath <", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathLessThanOrEqualTo(String value) {
            addCriterion("logoLocPath <=", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathLike(String value) {
            addCriterion("logoLocPath like", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathNotLike(String value) {
            addCriterion("logoLocPath not like", value, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathIn(List<String> values) {
            addCriterion("logoLocPath in", values, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathNotIn(List<String> values) {
            addCriterion("logoLocPath not in", values, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathBetween(String value1, String value2) {
            addCriterion("logoLocPath between", value1, value2, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andLogoLocPathNotBetween(String value1, String value2) {
            addCriterion("logoLocPath not between", value1, value2, "logoLocPath");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNull() {
            addCriterion("versionId is null");
            return (Criteria) this;
        }

        public Criteria andVersionIdIsNotNull() {
            addCriterion("versionId is not null");
            return (Criteria) this;
        }

        public Criteria andVersionIdEqualTo(Long value) {
            addCriterion("versionId =", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotEqualTo(Long value) {
            addCriterion("versionId <>", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThan(Long value) {
            addCriterion("versionId >", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdGreaterThanOrEqualTo(Long value) {
            addCriterion("versionId >=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThan(Long value) {
            addCriterion("versionId <", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdLessThanOrEqualTo(Long value) {
            addCriterion("versionId <=", value, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdIn(List<Long> values) {
            addCriterion("versionId in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotIn(List<Long> values) {
            addCriterion("versionId not in", values, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdBetween(Long value1, Long value2) {
            addCriterion("versionId between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andVersionIdNotBetween(Long value1, Long value2) {
            addCriterion("versionId not between", value1, value2, "versionId");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathIsNull() {
            addCriterion("logoWebPath is null");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathIsNotNull() {
            addCriterion("logoWebPath is not null");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathEqualTo(String value) {
            addCriterion("logoWebPath =", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathNotEqualTo(String value) {
            addCriterion("logoWebPath <>", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathGreaterThan(String value) {
            addCriterion("logoWebPath >", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathGreaterThanOrEqualTo(String value) {
            addCriterion("logoWebPath >=", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathLessThan(String value) {
            addCriterion("logoWebPath <", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathLessThanOrEqualTo(String value) {
            addCriterion("logoWebPath <=", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathLike(String value) {
            addCriterion("logoWebPath like", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathNotLike(String value) {
            addCriterion("logoWebPath not like", value, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathIn(List<String> values) {
            addCriterion("logoWebPath in", values, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathNotIn(List<String> values) {
            addCriterion("logoWebPath not in", values, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathBetween(String value1, String value2) {
            addCriterion("logoWebPath between", value1, value2, "logoWebPath");
            return (Criteria) this;
        }

        public Criteria andLogoWebPathNotBetween(String value1, String value2) {
            addCriterion("logoWebPath not between", value1, value2, "logoWebPath");
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
package project.pojo;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class AppVersionExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public AppVersionExample() {
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

        public Criteria andAppIdIsNull() {
            addCriterion("appId is null");
            return (Criteria) this;
        }

        public Criteria andAppIdIsNotNull() {
            addCriterion("appId is not null");
            return (Criteria) this;
        }

        public Criteria andAppIdEqualTo(Long value) {
            addCriterion("appId =", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotEqualTo(Long value) {
            addCriterion("appId <>", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThan(Long value) {
            addCriterion("appId >", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdGreaterThanOrEqualTo(Long value) {
            addCriterion("appId >=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThan(Long value) {
            addCriterion("appId <", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdLessThanOrEqualTo(Long value) {
            addCriterion("appId <=", value, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdIn(List<Long> values) {
            addCriterion("appId in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotIn(List<Long> values) {
            addCriterion("appId not in", values, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdBetween(Long value1, Long value2) {
            addCriterion("appId between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andAppIdNotBetween(Long value1, Long value2) {
            addCriterion("appId not between", value1, value2, "appId");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNull() {
            addCriterion("versionNo is null");
            return (Criteria) this;
        }

        public Criteria andVersionNoIsNotNull() {
            addCriterion("versionNo is not null");
            return (Criteria) this;
        }

        public Criteria andVersionNoEqualTo(String value) {
            addCriterion("versionNo =", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotEqualTo(String value) {
            addCriterion("versionNo <>", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThan(String value) {
            addCriterion("versionNo >", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoGreaterThanOrEqualTo(String value) {
            addCriterion("versionNo >=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThan(String value) {
            addCriterion("versionNo <", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLessThanOrEqualTo(String value) {
            addCriterion("versionNo <=", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoLike(String value) {
            addCriterion("versionNo like", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotLike(String value) {
            addCriterion("versionNo not like", value, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoIn(List<String> values) {
            addCriterion("versionNo in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotIn(List<String> values) {
            addCriterion("versionNo not in", values, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoBetween(String value1, String value2) {
            addCriterion("versionNo between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionNoNotBetween(String value1, String value2) {
            addCriterion("versionNo not between", value1, value2, "versionNo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoIsNull() {
            addCriterion("versionInfo is null");
            return (Criteria) this;
        }

        public Criteria andVersionInfoIsNotNull() {
            addCriterion("versionInfo is not null");
            return (Criteria) this;
        }

        public Criteria andVersionInfoEqualTo(String value) {
            addCriterion("versionInfo =", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoNotEqualTo(String value) {
            addCriterion("versionInfo <>", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoGreaterThan(String value) {
            addCriterion("versionInfo >", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("versionInfo >=", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoLessThan(String value) {
            addCriterion("versionInfo <", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoLessThanOrEqualTo(String value) {
            addCriterion("versionInfo <=", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoLike(String value) {
            addCriterion("versionInfo like", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoNotLike(String value) {
            addCriterion("versionInfo not like", value, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoIn(List<String> values) {
            addCriterion("versionInfo in", values, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoNotIn(List<String> values) {
            addCriterion("versionInfo not in", values, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoBetween(String value1, String value2) {
            addCriterion("versionInfo between", value1, value2, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andVersionInfoNotBetween(String value1, String value2) {
            addCriterion("versionInfo not between", value1, value2, "versionInfo");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNull() {
            addCriterion("publishStatus is null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIsNotNull() {
            addCriterion("publishStatus is not null");
            return (Criteria) this;
        }

        public Criteria andPublishStatusEqualTo(Long value) {
            addCriterion("publishStatus =", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotEqualTo(Long value) {
            addCriterion("publishStatus <>", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThan(Long value) {
            addCriterion("publishStatus >", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusGreaterThanOrEqualTo(Long value) {
            addCriterion("publishStatus >=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThan(Long value) {
            addCriterion("publishStatus <", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusLessThanOrEqualTo(Long value) {
            addCriterion("publishStatus <=", value, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusIn(List<Long> values) {
            addCriterion("publishStatus in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotIn(List<Long> values) {
            addCriterion("publishStatus not in", values, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusBetween(Long value1, Long value2) {
            addCriterion("publishStatus between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andPublishStatusNotBetween(Long value1, Long value2) {
            addCriterion("publishStatus not between", value1, value2, "publishStatus");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkIsNull() {
            addCriterion("downloadLink is null");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkIsNotNull() {
            addCriterion("downloadLink is not null");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkEqualTo(String value) {
            addCriterion("downloadLink =", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkNotEqualTo(String value) {
            addCriterion("downloadLink <>", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkGreaterThan(String value) {
            addCriterion("downloadLink >", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkGreaterThanOrEqualTo(String value) {
            addCriterion("downloadLink >=", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkLessThan(String value) {
            addCriterion("downloadLink <", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkLessThanOrEqualTo(String value) {
            addCriterion("downloadLink <=", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkLike(String value) {
            addCriterion("downloadLink like", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkNotLike(String value) {
            addCriterion("downloadLink not like", value, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkIn(List<String> values) {
            addCriterion("downloadLink in", values, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkNotIn(List<String> values) {
            addCriterion("downloadLink not in", values, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkBetween(String value1, String value2) {
            addCriterion("downloadLink between", value1, value2, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andDownloadLinkNotBetween(String value1, String value2) {
            addCriterion("downloadLink not between", value1, value2, "downloadLink");
            return (Criteria) this;
        }

        public Criteria andVersionSizeIsNull() {
            addCriterion("versionSize is null");
            return (Criteria) this;
        }

        public Criteria andVersionSizeIsNotNull() {
            addCriterion("versionSize is not null");
            return (Criteria) this;
        }

        public Criteria andVersionSizeEqualTo(BigDecimal value) {
            addCriterion("versionSize =", value, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeNotEqualTo(BigDecimal value) {
            addCriterion("versionSize <>", value, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeGreaterThan(BigDecimal value) {
            addCriterion("versionSize >", value, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeGreaterThanOrEqualTo(BigDecimal value) {
            addCriterion("versionSize >=", value, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeLessThan(BigDecimal value) {
            addCriterion("versionSize <", value, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeLessThanOrEqualTo(BigDecimal value) {
            addCriterion("versionSize <=", value, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeIn(List<BigDecimal> values) {
            addCriterion("versionSize in", values, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeNotIn(List<BigDecimal> values) {
            addCriterion("versionSize not in", values, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("versionSize between", value1, value2, "versionSize");
            return (Criteria) this;
        }

        public Criteria andVersionSizeNotBetween(BigDecimal value1, BigDecimal value2) {
            addCriterion("versionSize not between", value1, value2, "versionSize");
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

        public Criteria andApkLocPathIsNull() {
            addCriterion("apkLocPath is null");
            return (Criteria) this;
        }

        public Criteria andApkLocPathIsNotNull() {
            addCriterion("apkLocPath is not null");
            return (Criteria) this;
        }

        public Criteria andApkLocPathEqualTo(String value) {
            addCriterion("apkLocPath =", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathNotEqualTo(String value) {
            addCriterion("apkLocPath <>", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathGreaterThan(String value) {
            addCriterion("apkLocPath >", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathGreaterThanOrEqualTo(String value) {
            addCriterion("apkLocPath >=", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathLessThan(String value) {
            addCriterion("apkLocPath <", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathLessThanOrEqualTo(String value) {
            addCriterion("apkLocPath <=", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathLike(String value) {
            addCriterion("apkLocPath like", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathNotLike(String value) {
            addCriterion("apkLocPath not like", value, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathIn(List<String> values) {
            addCriterion("apkLocPath in", values, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathNotIn(List<String> values) {
            addCriterion("apkLocPath not in", values, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathBetween(String value1, String value2) {
            addCriterion("apkLocPath between", value1, value2, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkLocPathNotBetween(String value1, String value2) {
            addCriterion("apkLocPath not between", value1, value2, "apkLocPath");
            return (Criteria) this;
        }

        public Criteria andApkFileNameIsNull() {
            addCriterion("apkFileName is null");
            return (Criteria) this;
        }

        public Criteria andApkFileNameIsNotNull() {
            addCriterion("apkFileName is not null");
            return (Criteria) this;
        }

        public Criteria andApkFileNameEqualTo(String value) {
            addCriterion("apkFileName =", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotEqualTo(String value) {
            addCriterion("apkFileName <>", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameGreaterThan(String value) {
            addCriterion("apkFileName >", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameGreaterThanOrEqualTo(String value) {
            addCriterion("apkFileName >=", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameLessThan(String value) {
            addCriterion("apkFileName <", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameLessThanOrEqualTo(String value) {
            addCriterion("apkFileName <=", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameLike(String value) {
            addCriterion("apkFileName like", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotLike(String value) {
            addCriterion("apkFileName not like", value, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameIn(List<String> values) {
            addCriterion("apkFileName in", values, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotIn(List<String> values) {
            addCriterion("apkFileName not in", values, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameBetween(String value1, String value2) {
            addCriterion("apkFileName between", value1, value2, "apkFileName");
            return (Criteria) this;
        }

        public Criteria andApkFileNameNotBetween(String value1, String value2) {
            addCriterion("apkFileName not between", value1, value2, "apkFileName");
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
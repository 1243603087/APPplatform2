package project.pojo;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class AppInfo {
    private Long id;

    //软件三级分类信息(关联app_version表的versionNo字段查询)
    private List<AppCategory> appCategorys;

    //归属的平台(关联data_dictionary表的valueName字段查找)
    private String platformName;

    //软件状态（关联data_dictionary表的valueName字段查找）
    private String softwareStatus;

    //软件版本号（关联app_version表的versionNo字段查询）
    private String versionNo;


    //一级分类，通过get方法设置值
    private String categoryLevel1Name;

    //二级分类，通过get方法设置值
    private String categoryLevel2Name;

    //三级分类，通过get方法设置值
    private String categoryLevel3Name;

    private String softwareName;

    private String APKName;

    private String supportROM;

    private String interfaceLanguage;

    private BigDecimal softWareSize;

    private Date updateDate;

    private Long devId;

    private String appInfo;

    private Long status;

    private Date onSaleDate;

    private Date offSaleDate;

    private Long floatFormId;

    private Long categoryLevel3;

    private Long downloads;

    private Long createBy;

    private Date creationDate;

    private Long modifyBy;

    private Date modifyDate;

    private Long categoryLevel1;

    private Long categoryLevel2;

    private String logoLocPath;

    private Long versionId;

    private String logoWebPath;


    public String getCategoryLevel1Name() {
        this.categoryLevel1Name=this.appCategorys.get(0).getCategoryName();
        return categoryLevel1Name;
    }

    public void setCategoryLevel1Name(String categoryLevel1Name) {
        this.categoryLevel1Name = categoryLevel1Name;
    }

    public String getCategoryLevel2Name() {
        this.categoryLevel2Name=this.appCategorys.get(1).getCategoryName();
        return categoryLevel2Name;
    }

    public void setCategoryLevel2Name(String categoryLevel2Name) {
        this.categoryLevel2Name = categoryLevel2Name;
    }

    public String getCategoryLevel3Name() {
        this.categoryLevel3Name=this.appCategorys.get(2).getCategoryName();
        return categoryLevel3Name;
    }

    public void setCategoryLevel3Name(String categoryLevel3Name) {
        this.categoryLevel3Name = categoryLevel3Name;
    }

    public List<AppCategory> getAppCategorys() {
        return appCategorys;
    }

    public void setAppCategorys(List<AppCategory> appCategorys) {
        this.appCategorys = appCategorys;
    }

    public String getPlatformName() {
        return platformName;
    }

    public void setPlatformName(String platformName) {
        this.platformName = platformName;
    }

    public String getSoftwareStatus() {
        return softwareStatus;
    }

    public void setSoftwareStatus(String softwareStatus) {
        this.softwareStatus = softwareStatus;
    }

    public String getVersionNo() {
        return versionNo;
    }

    public void setVersionNo(String versionNo) {
        this.versionNo = versionNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSoftwareName() {
        return softwareName;
    }

    public void setSoftwareName(String softwareName) {
        this.softwareName = softwareName == null ? null : softwareName.trim();
    }

    public String getAPKName() {
        return APKName;
    }

    public void setAPKName(String APKName) {
        this.APKName = APKName == null ? null : APKName.trim();
    }

    public String getSupportROM() {
        return supportROM;
    }

    public void setSupportROM(String supportROM) {
        this.supportROM = supportROM == null ? null : supportROM.trim();
    }

    public String getInterfaceLanguage() {
        return interfaceLanguage;
    }

    public void setInterfaceLanguage(String interfaceLanguage) {
        this.interfaceLanguage = interfaceLanguage == null ? null : interfaceLanguage.trim();
    }

    public BigDecimal getSoftWareSize() {
        return softWareSize;
    }

    public void setSoftWareSize(BigDecimal softWareSize) {
        this.softWareSize = softWareSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getDevId() {
        return devId;
    }

    public void setDevId(Long devId) {
        this.devId = devId;
    }

    public String getAppInfo() {
        return appInfo;
    }

    public void setAppInfo(String appInfo) {
        this.appInfo = appInfo == null ? null : appInfo.trim();
    }

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Date getOnSaleDate() {
        return onSaleDate;
    }

    public void setOnSaleDate(Date onSaleDate) {
        this.onSaleDate = onSaleDate;
    }

    public Date getOffSaleDate() {
        return offSaleDate;
    }

    public void setOffSaleDate(Date offSaleDate) {
        this.offSaleDate = offSaleDate;
    }

    public Long getFloatFormId() {
        return floatFormId;
    }

    public void setFloatFormId(Long floatFormId) {
        this.floatFormId = floatFormId;
    }

    public Long getCategoryLevel3() {
        return categoryLevel3;
    }

    public void setCategoryLevel3(Long categoryLevel3) {
        this.categoryLevel3 = categoryLevel3;
    }

    public Long getDownloads() {
        return downloads;
    }

    public void setDownloads(Long downloads) {
        this.downloads = downloads;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public Long getModifyBy() {
        return modifyBy;
    }

    public void setModifyBy(Long modifyBy) {
        this.modifyBy = modifyBy;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Long getCategoryLevel1() {
        return categoryLevel1;
    }

    public void setCategoryLevel1(Long categoryLevel1) {
        this.categoryLevel1 = categoryLevel1;
    }

    public Long getCategoryLevel2() {
        return categoryLevel2;
    }

    public void setCategoryLevel2(Long categoryLevel2) {
        this.categoryLevel2 = categoryLevel2;
    }

    public String getLogoLocPath() {
        return logoLocPath;
    }

    public void setLogoLocPath(String logoLocPath) {
        this.logoLocPath = logoLocPath == null ? null : logoLocPath.trim();
    }

    public Long getVersionId() {
        return versionId;
    }

    public void setVersionId(Long versionId) {
        this.versionId = versionId;
    }

    public String getLogoWebPath() {
        return logoWebPath;
    }

    public void setLogoWebPath(String logoWebPath) {
        this.logoWebPath = logoWebPath == null ? null : logoWebPath.trim();
    }

    @Override
    public String toString() {
        return "AppInfo{" +
                "id=" + id +
                ", appCategorys=" + appCategorys +
                ", platformName='" + platformName + '\'' +
                ", softwareStatus='" + softwareStatus + '\'' +
                ", versionNo='" + versionNo + '\'' +
                ", softwareName='" + softwareName + '\'' +
                ", APKName='" + APKName + '\'' +
                ", supportROM='" + supportROM + '\'' +
                ", interfaceLanguage='" + interfaceLanguage + '\'' +
                ", softWareSize=" + softWareSize +
                ", updateDate=" + updateDate +
                ", devId=" + devId +
                ", appInfo='" + appInfo + '\'' +
                ", status=" + status +
                ", onSaleDate=" + onSaleDate +
                ", offSaleDate=" + offSaleDate +
                ", floatFormId=" + floatFormId +
                ", categoryLevel3=" + categoryLevel3 +
                ", downloads=" + downloads +
                ", createBy=" + createBy +
                ", creationDate=" + creationDate +
                ", modifyBy=" + modifyBy +
                ", modifyDate=" + modifyDate +
                ", categoryLevel1=" + categoryLevel1 +
                ", categoryLevel2=" + categoryLevel2 +
                ", logoLocPath='" + logoLocPath + '\'' +
                ", versionId=" + versionId +
                ", logoWebPath='" + logoWebPath + '\'' +
                '}';
    }
}
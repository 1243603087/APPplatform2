package project.service;

import project.pojo.AppVersion;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/30 - 13:41
 */
public interface AppVersionService {

    /**
     * 通过AppId查询版本信息列表
     * @param id
     * @return
     */
    List<AppVersion> getAppVersionList(Long id);

    /**
     * 新增版本信息
     */
    boolean saveAppVersion(AppVersion appVersion);

    /**
     * 通过版本Id查询版本信息
     */
    AppVersion getAppVersionById(Long vid);

    /**
     * 通过id修改APP版本信息
     */
    boolean modifyAppVersionById(AppVersion appVersion);
}

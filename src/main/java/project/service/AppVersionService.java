package project.service;

import project.pojo.AppVersion;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/30 - 13:41
 */
public interface AppVersionService {

    List<AppVersion> getAppVersionList(Long id);

    /**
     * 新增版本信息
     */
    boolean saveAppVersion(AppVersion appVersion);
}

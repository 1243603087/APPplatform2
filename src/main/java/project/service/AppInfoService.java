package project.service;

import com.github.pagehelper.PageInfo;
import project.pojo.AppInfo;
import project.pojo.AppInfoExample;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/27 - 13:10
 */
public interface AppInfoService {

    /**
     *按条件分页查询app信息
     */
    PageInfo<AppInfo> getAppInfosByPage(Integer pn,
                                        String querySoftwareName,
                                        Long queryStatus,
                                        Long queryFlatformId,
                                        Long queryCategoryLevel1,
                                        Long queryCategoryLevel2,
                                        Long queryCategoryLevel3);


    /**
     * 检查APKName是否重复
     * @return
     */
    boolean checkAPKName(String APKName);

    /**
     * 新增APP基础信息
     */
    boolean saveAPPInfo(AppInfo appInfo);

    /**
     * 通过id查询APP基础信息
     */
    AppInfo getAppInfoById(Long id);

    /**
     * 更新APP基础信息
     */
    boolean modifyAppInfoById(AppInfo appInfo);

    /**
     * 删除APP信息及版本信息
     */
    boolean delApp(Long id);


}

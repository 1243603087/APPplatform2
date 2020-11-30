package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.AppVersionMapper;
import project.pojo.AppVersion;
import project.pojo.AppVersionExample;
import project.service.AppInfoService;
import project.service.AppVersionService;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/30 - 13:42
 */
@Service
public class AppVersionServiceImpl implements AppVersionService {

    @Autowired
    AppVersionMapper appVersionMapper;

    /**
     * 根据AppId获取版本信息列表
     * @return
     */
    @Override
    public List<AppVersion> getAppVersionList(Long id) {
        AppVersionExample appVersionExample = new AppVersionExample();
        AppVersionExample.Criteria criteria = appVersionExample.createCriteria();
        criteria.andAppIdEqualTo(id);
        List<AppVersion> appVersions = appVersionMapper.selectByExampleWithOther(appVersionExample);
        return appVersions;
    }

    /**
     * 新增版本信息
     * @return  true==添加成功   false==添加失败
     */
    @Override
    public boolean saveAppVersion(AppVersion appVersion) {
        int flag = appVersionMapper.insertSelective(appVersion);
        return flag!=0;
    }

    /**
     * 通过版本Id查询版本信息
     */
    @Override
    public AppVersion getAppVersionById(Long vid) {
        AppVersion appVersion = appVersionMapper.selectByPrimaryKey(vid);
        return appVersion;
    }

    /**
     * 通过id修改APP版本信息
     */
    @Override
    public boolean modifyAppVersionById(AppVersion appVersion) {
        int flag = appVersionMapper.updateByPrimaryKeySelective(appVersion);
        return flag!=0;
    }
}

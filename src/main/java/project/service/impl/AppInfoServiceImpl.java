package project.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.AppInfoMapper;
import project.dao.AppVersionMapper;
import project.pojo.AppInfo;
import project.pojo.AppInfoExample;
import project.pojo.AppVersionExample;
import project.service.AppInfoService;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/27 - 13:10
 */
@Service
public class AppInfoServiceImpl implements AppInfoService {

    @Autowired
    AppInfoMapper appInfoMapper;

    @Autowired
    AppVersionMapper appVersionMapper;

    /**
     * 按条件分页查询app信息，动态组装sql
     * @param pn
     * @return
     */
    @Override
    public PageInfo<AppInfo> getAppInfosByPage(Integer pn,
                                               String querySoftwareName,
                                               Long queryStatus,
                                               Long queryFlatformId,
                                               Long queryCategoryLevel1,
                                               Long queryCategoryLevel2,
                                               Long queryCategoryLevel3) {
        AppInfoExample appInfoExample = new AppInfoExample();
        AppInfoExample.Criteria criteria = appInfoExample.createCriteria();
        if (querySoftwareName!=null&&!"".equals(querySoftwareName)){
            criteria.andSoftwareNameLike("%"+querySoftwareName+"%");
        }
        if (queryStatus!=null&&queryStatus!=0){
            criteria.andStatusEqualTo(queryStatus);
        }
        if (queryFlatformId!=null&&queryFlatformId!=0){
            criteria.andFloatFormIdEqualTo(queryFlatformId);
        }
        if (queryCategoryLevel1!=null&&queryCategoryLevel1!=0){
            criteria.andCategoryLevel1EqualTo(queryCategoryLevel1);
        }
        if (queryCategoryLevel2!=null&&queryCategoryLevel2!=0){
            criteria.andCategoryLevel2EqualTo(queryCategoryLevel2);
        }
        if (queryCategoryLevel3!=null&&queryCategoryLevel3!=0){
            criteria.andCategoryLevel3EqualTo(queryCategoryLevel3);
        }
        PageHelper.startPage(pn,5);
        List<AppInfo> appInfos = appInfoMapper.selectByExampleWithOther(appInfoExample);
        PageInfo<AppInfo> appInfoPageInfo = new PageInfo<>(appInfos,5);
        return appInfoPageInfo;
    }


    /**
     * 检查APKName是否重复
     * @return  true 重复     false 不重复
     */
    @Override
    public boolean checkAPKName(String APKName) {
        AppInfoExample appInfoExample = new AppInfoExample();
        AppInfoExample.Criteria criteria = appInfoExample.createCriteria();
        criteria.andAPKNameEqualTo(APKName);
        List<AppInfo> appInfos = appInfoMapper.selectByExample(appInfoExample);
        //查询后不管查不查得到数据都会返回一个list集合赋给变量appInfos，
        // 但是如果查不到，list的大小是0，所以此处需要判断appInfos.size()>0
        if (appInfos!=null&&appInfos.size()>0){
            return true;
        }
        return false;
    }


    /**
     * 新增APP基础信息
     * @return  true==保存成功   false==保存失败
     */
    @Override
    public boolean saveAPPInfo(AppInfo appInfo) {
        int flag = appInfoMapper.insertSelective(appInfo);
        return flag!=0;
    }

    /**
     * 通过id查询APP基础信息
     */
    @Override
    public AppInfo getAppInfoById(Long id) {
        AppInfo appInfo = appInfoMapper.selectByPrimaryKeyWithOther(id);
        return appInfo;
    }

    /**
     * 更新APP基础信息
     * @return  true==更新成功   false==更新失败
     */
    @Override
    public boolean modifyAppInfoById(AppInfo appInfo) {
        int flag = appInfoMapper.updateByPrimaryKeySelective(appInfo);
        return flag!=0;
    }

    /**
     * 删除APP信息及版本信息
     */
    @Override
    public boolean delApp(Long id) {
        AppVersionExample appVersionExample = new AppVersionExample();
        AppVersionExample.Criteria criteria = appVersionExample.createCriteria();
        criteria.andAppIdEqualTo(id);
        boolean flag=false;
        try {
            appVersionMapper.deleteByExample(appVersionExample);
            appInfoMapper.deleteByPrimaryKey(id);
            flag=true;
        }catch (Exception e){
            e.printStackTrace();
            flag=false;
        }
        return flag;

    }



}

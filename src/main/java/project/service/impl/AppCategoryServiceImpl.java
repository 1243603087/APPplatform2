package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.AppCategoryMapper;
import project.pojo.AppCategory;
import project.pojo.AppCategoryExample;
import project.service.AppCategoryService;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/28 - 12:22
 */
@Service
public class AppCategoryServiceImpl implements AppCategoryService {


    @Autowired
    AppCategoryMapper appCategoryMapper;

    /**
     * 查询一级分类
     */
    @Override
    public List<AppCategory> getAppLevel1() {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        criteria.andCategoryCodeEqualTo("level1");
        List<AppCategory> appCategories = appCategoryMapper.selectByExample(appCategoryExample);
        return appCategories;
    }

    /**
     * 查询二级分类
     */
    @Override
    public List<AppCategory> getAppLevel2() {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        criteria.andCategoryCodeEqualTo("level2");
        List<AppCategory> appCategories = appCategoryMapper.selectByExample(appCategoryExample);
        return appCategories;
    }

    /**
     * 查询三级分类
     */
    @Override
    public List<AppCategory> getAPPLevel3() {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        criteria.andCategoryCodeEqualTo("level3");
        List<AppCategory> appCategories = appCategoryMapper.selectByExample(appCategoryExample);
        return appCategories;
    }

    /**
     * 查询以当前pid为父节点的节点有哪些
     */
    @Override
    public List<AppCategory> getAPPLevelByPid(Long pid) {
        AppCategoryExample appCategoryExample = new AppCategoryExample();
        AppCategoryExample.Criteria criteria = appCategoryExample.createCriteria();
        criteria.andParentIdEqualTo(pid);
        List<AppCategory> appCategories = appCategoryMapper.selectByExample(appCategoryExample);
        return appCategories;
    }


}

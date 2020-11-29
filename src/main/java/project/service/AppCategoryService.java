package project.service;

import project.pojo.AppCategory;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/28 - 12:21
 */
public interface AppCategoryService {

    /**
     * 查询一级分类
     */
    List<AppCategory> getAppLevel1();

    /**
     * 查询二级分类
     */
    List<AppCategory> getAppLevel2();

    /**
     * 查询三级分类
     */
    List<AppCategory> getAPPLevel3();


    /**
     * 查询以当前pid为父节点的节点有哪些
     */
    List<AppCategory> getAPPLevelByPid(Long pid);
}

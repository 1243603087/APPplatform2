package project.dao;

import java.util.List;
import org.apache.ibatis.annotations.Param;
import project.pojo.AppCategory;
import project.pojo.AppCategoryExample;

public interface AppCategoryMapper {
    long countByExample(AppCategoryExample example);

    int deleteByExample(AppCategoryExample example);

    int deleteByPrimaryKey(Long id);

    int insert(AppCategory record);

    int insertSelective(AppCategory record);

    List<AppCategory> selectByExample(AppCategoryExample example);

    AppCategory selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") AppCategory record, @Param("example") AppCategoryExample example);

    int updateByExample(@Param("record") AppCategory record, @Param("example") AppCategoryExample example);

    int updateByPrimaryKeySelective(AppCategory record);

    int updateByPrimaryKey(AppCategory record);

    //给appInfo提供嵌套查询 c1=categoryLevel1,c2=categoryLevel2,c3=categoryLevel3
    List<AppCategory> selectBySomeId(@Param("c1") long categoryLevel1,@Param("c2") long categoryLevel2,@Param("c3") long categoryLevel3);
}
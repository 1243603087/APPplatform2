import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import project.dao.AppCategoryMapper;
import project.dao.AppInfoMapper;
import project.dao.DevUserMapper;
import project.pojo.AppCategory;
import project.pojo.AppInfo;
import project.pojo.AppInfoExample;
import project.pojo.DevUser;
import sun.rmi.log.LogInputStream;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 20:17
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class MybatisTest {

    @Autowired
    DevUserMapper devUserMapper;

    @Autowired
    AppCategoryMapper appCategoryMapper;

    @Autowired
    AppInfoMapper appInfoMapper;

    @Test
    public void select(){
        List<DevUser> devUsers = devUserMapper.selectByExample(null);
        for (DevUser devUser : devUsers) {
            System.out.println(devUser);
        }
    }
    @Test
    public void select2(){
        List<AppCategory> appCategories = appCategoryMapper.selectBySomeId(1, 2, 3);
        for (AppCategory appCategory : appCategories) {
            System.out.println(appCategory);
        }
    }

    @Test
    public void select3(){

        List<AppInfo> appInfos = appInfoMapper.selectByExampleWithOther(null);
        for (AppInfo appInfo : appInfos) {
            System.out.println(appInfo);
        }
    }


    @Test
    public void select5(){

        AppInfoExample appInfoExample = new AppInfoExample();
        AppInfoExample.Criteria criteria = appInfoExample.createCriteria();
            criteria.andStatusEqualTo(Long.parseLong("4"));
        PageHelper.startPage(1,5);
        List<AppInfo> appInfos = appInfoMapper.selectByExampleWithOther(appInfoExample);
        PageInfo<AppInfo> appInfoPageInfo = new PageInfo<>(appInfos,5);
        List<AppInfo> list = appInfoPageInfo.getList();
        for (AppInfo appInfo : list) {
            System.out.println(appInfo);
        }
    }

    @Test
    public void select6(){

        AppInfo appInfo = appInfoMapper.selectByPrimaryKeyWithOther(new Long(402));
        System.out.println(appInfo);
    }


}

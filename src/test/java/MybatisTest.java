import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.util.StringUtil;
import com.mysql.cj.util.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import project.dao.AppCategoryMapper;
import project.dao.AppInfoMapper;
import project.dao.AppVersionMapper;
import project.dao.DevUserMapper;
import project.pojo.*;
import project.service.AppInfoService;
import sun.rmi.log.LogInputStream;

import java.io.File;
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

    @Autowired
    AppInfoService appInfoService;

    @Autowired
    AppVersionMapper appVersionMapper;

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


    @Test
    public void delete1(){
        File file = new File("D:\\APPLOGOIMAGE");
        File[] files = file.listFiles();
        for (File file1 : files) {
            if(file1.getName().equals("jpg55992d25-2c8e-40ef-a893-1af27fb0031d.jpg")){
                file1.delete();
                System.out.println("成功删除："+file1.getName());
            }
        }
    }

    @Test
    public void sub(){
       String a="statics/uploadfiles/jpgb94d68a3-58ab-4d41-a99f-72e67eaa6f63.jpg";
        System.out.println(a.lastIndexOf("/"));

        int index = a.lastIndexOf("/");
        String a01 = a.substring(index+1);
        System.out.println(a01);

    }


    @Test
    public void delete(){

        AppInfo appInfo = appInfoService.getAppInfoById(new  Long(468));
        appInfo.setLogoWebPath(null);
        appInfo.setLogoLocPath(null);
        boolean  k= appInfoService.modifyAppInfoById(appInfo);
        System.out.println(k);
    }

    @Test
    public void select8(){

        AppVersionExample appVersionExample = new AppVersionExample();
        AppVersionExample.Criteria criteria = appVersionExample.createCriteria();
        criteria.andAppIdEqualTo(new Long(400));
        List<AppVersion> appVersions = appVersionMapper.selectByExampleWithOther(appVersionExample);
        for (AppVersion appVersion : appVersions) {
            System.out.println(appVersion);
        }
    }



}

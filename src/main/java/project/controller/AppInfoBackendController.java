package project.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import project.pojo.AppCategory;
import project.pojo.AppInfo;
import project.pojo.AppVersion;
import project.pojo.DataDictionary;
import project.service.AppCategoryService;
import project.service.AppInfoService;
import project.service.AppVersionService;
import project.service.DataDictionaryService;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/12/1 - 08:31
 */
@Controller
@RequestMapping("/manager/backend/app")
public class AppInfoBackendController {

    @Autowired
    AppInfoService appInfoService;

    @Autowired
    AppVersionService appVersionService;

    @Autowired
    DataDictionaryService dataDictionaryService;

    @Autowired
    AppCategoryService appCategoryService;


    /**
     * 分页查询app信息列表
     *
     * @return
     */
    @RequestMapping(value = "/list")
    public String getAppInfoList(
            @RequestParam(required = false, defaultValue = "1") Integer pageIndex,
            @RequestParam(required = false) String querySoftwareName,
            @RequestParam(required = false) Long queryStatus,
            @RequestParam(required = false) Long queryFlatformId,
            @RequestParam(required = false) Long queryCategoryLevel1,
            @RequestParam(required = false) Long queryCategoryLevel2,
            @RequestParam(required = false) Long queryCategoryLevel3,
            Model model) {
        //分页查询
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.getAppInfosByStatus(pageIndex, querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
        //下拉框app状态
        List<DataDictionary> appStatusList = dataDictionaryService.getAppStatusByTypeCode();
        //下拉框app所属平台
        List<DataDictionary> floarList = dataDictionaryService.getFloarByTypeCode();
        //下拉框app类别1
        List<AppCategory> appLevel1 = appCategoryService.getAppLevel1();
        //下拉框app类别2
        List<AppCategory> appLevel2 = appCategoryService.getAppLevel2();
        //下拉框app类别3
        List<AppCategory> appLevel3 = appCategoryService.getAPPLevel3();
        model.addAttribute("appInfoList", appInfoPageInfo);
        model.addAttribute("statusList", appStatusList);
        model.addAttribute("flatFormList", floarList);
        model.addAttribute("categoryLevel1List", appLevel1);
        model.addAttribute("categoryLevel2List", appLevel2);
        model.addAttribute("categoryLevel3List", appLevel3);
        model.addAttribute("querySoftwareName", querySoftwareName);
        model.addAttribute("queryStatus", queryStatus);
        model.addAttribute("queryFlatformId", queryFlatformId);
        model.addAttribute("queryCategoryLevel1", queryCategoryLevel1);
        model.addAttribute("queryCategoryLevel2", queryCategoryLevel2);
        model.addAttribute("queryCategoryLevel3", queryCategoryLevel3);
        return "backend/applist";
    }


    @RequestMapping("/check")
    public String check(Long aid,Long vid,Model model){
        AppInfo appInfo = appInfoService.getAppInfoById(aid);
        AppVersion appVersion = appVersionService.getAppVersionById(vid);
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("appVersion",appVersion);
        return "backend/appcheck";
    }

    /**
     * 审核，修改APP状态
     * @return
     */
    @RequestMapping("/checksave")
    public String checksave(Long id,Long status,Model model){
        AppInfo appInfo = new AppInfo();
        appInfo.setId(id);
        appInfo.setStatus(status);
        boolean flag = appInfoService.modifyAppInfoById(appInfo);
        if (flag){
           return "redirect:/manager/backend/app/list";
        }
       model.addAttribute("checkResult","更新失败，请重新操作");
        return "backend/appcheck";
    }

}

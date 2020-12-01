package project.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import project.pojo.*;
import project.service.AppCategoryService;
import project.service.AppInfoService;
import project.service.AppVersionService;
import project.service.DataDictionaryService;
import project.util.FileDeleteUtil;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.Date;

/**
 * @author 杨乔瀚
 * @create 2020/11/27 - 13:09
 */
@Controller
@RequestMapping(value = "/dev/flatform/app")
public class AppInfoController {

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
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.getAppInfosByPage(pageIndex, querySoftwareName, queryStatus, queryFlatformId, queryCategoryLevel1, queryCategoryLevel2, queryCategoryLevel3);
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
        return "developer/appinfolist";
    }


    /**
     * 检查APKName是否为空
     *
     * @param APKName
     */
    @ResponseBody
    @RequestMapping("/apkexist.json")
    public Map<String, Object> checkAPKName(String APKName) {
        Map<String, Object> result = new HashMap<>();
        //判空
        if (APKName == null || "".equals(APKName)) {
            result.put("APKName", "empty");
            return result;
        }

//        true 重复     false 不重复
        boolean flag = appInfoService.checkAPKName(APKName);
        if (flag == true) {
            //重复
            result.put("APKName", "exist");
            return result;
        } else {
            //不重复
            result.put("APKName", "noexist");
            return result;
        }

    }

    /**
     * 新增APP基础信息
     */
    @RequestMapping("/appinfoaddsave")
    public String saveAPPInfo(@Valid AppInfo appInfo,
                              BindingResult bindingResult,
                              String softWareSize,
                              MultipartFile a_logoPicPath,
                              Model model,
                              HttpServletRequest request) {

        //前端校验+后端JSR303校验,防止会代码的人绕过前端，直接发送保存请求，插入错误数据
        if (bindingResult.hasErrors()) {
            model.addAttribute("fileUploadError", "所有字段均不能为空");
            //校验错误后,数据回显到前端表单
            model.addAttribute("SubmitAppInfo", appInfo);
            return "developer/appinfoadd";
        }

        //前后端一起判断APKName是否重复，前端只是提示APKName重复，
        // 如果用户不理提示不修改，照样能进行保存，所以有必要进行后端校验
        boolean flag1 = appInfoService.checkAPKName(appInfo.getAPKName());
        if (flag1 == true) {
            //重复
            model.addAttribute("APKNameResult", "APKName重复，请重新输入");
            //校验错误后,数据回显到前端表单
            model.addAttribute("SubmitAppInfo", appInfo);
            return "developer/appinfoadd";
        }

        //文件为空或者大小为0跳转到页面，返回错误信息
        if (a_logoPicPath != null && !a_logoPicPath.isEmpty()) {

            //文件有内容，判断文件是否小于等于50K
            if (a_logoPicPath.getSize() > (50 * 1024)) {
                model.addAttribute("fileUploadError", "文件大小必须小于等于50K");
                //校验错误后,数据回显到前端表单
                model.addAttribute("SubmitAppInfo", appInfo);
                return "developer/appinfoadd";
            }

            //判断文件是否为jpg、jpeg、png格式
            String fileType = a_logoPicPath.getContentType();
            if (!fileType.equals("image/png") && !fileType.equals("image/jpeg") && !fileType.equals("image/jpg")) {
                model.addAttribute("fileUploadError", "上传图片格式限定为jpg、jpeg、png");
                //校验错误后,数据回显到前端表单
                model.addAttribute("SubmitAppInfo", appInfo);
                return "developer/appinfoadd";
            }

            //防止文件名重复，使用UUID命名
            String originalFilename = a_logoPicPath.getOriginalFilename();
            String UUIDName = UUID.randomUUID().toString();
            int index = originalFilename.lastIndexOf(".");
            StringBuffer stringBuffer = new StringBuffer(originalFilename);
            StringBuffer insertStringBuffer = stringBuffer.insert(index, UUIDName);
            String newFileName = new String(insertStringBuffer);
            String realPath = "D:\\APPLOGOIMAGE";
            File file01 = new File(realPath, newFileName);
            if (!file01.exists()) {
                file01.mkdirs();
            }
            try {
                a_logoPicPath.transferTo(file01);
                appInfo.setLogoWebPath("statics/uploadfiles/" + newFileName);
                appInfo.setLogoLocPath(realPath);
                //因为springMVC不能自动封装BigDecimal数据类型
                //所以先用String接受，再转为BigDecimal类型，存入实体类种
                if (softWareSize != null && !"".equals(softWareSize)) {
                    BigDecimal softWareSize01 = new BigDecimal(softWareSize);
                    appInfo.setSoftWareSize(softWareSize01);
                } else {
                    model.addAttribute("fileUploadError", "所有字段均不能为空");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("SubmitAppInfo", appInfo);
                    return "developer/appinfoadd";
                }

                //新增APP是由哪个用户创建的，创建时间是什么时候
                DevUser devUser = (DevUser) request.getSession().getAttribute("devUserSession");
                appInfo.setCreateBy(devUser.getId());
                Date currentDate = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formatDate = simpleDateFormat.format(currentDate);
                Date date01 = simpleDateFormat.parse(formatDate);
                appInfo.setCreationDate(date01);

                //判断是否成功保存到数据库
                boolean flag = appInfoService.saveAPPInfo(appInfo);
                if (flag == true) {
                    //保存成功，跳转到最后一页
                    return "redirect:/dev/flatform/app/list?pageIndex=99999";
                } else {
                    //保存失败
                    model.addAttribute("fileUploadError", "保存失败");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("SubmitAppInfo", appInfo);
                    return "developer/appinfoadd";
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        //文件为空
        model.addAttribute("fileUploadError", "必须上传文件且文件不能为空");
        //校验错误后,数据回显到前端表单
        model.addAttribute("SubmitAppInfo", appInfo);
        return "developer/appinfoadd";

    }


    /**
     * 修改APP基础信息
     */
    @RequestMapping(value = "/appinfomodify", method = RequestMethod.GET)
    public String modefyAppInfo(Long id, Integer pageNum, Model model) {
        AppInfo appInfo = appInfoService.getAppInfoById(id);
        model.addAttribute("appInfo", appInfo);
        model.addAttribute("pageNum", pageNum);
        return "developer/appinfomodify";
    }

    /**
     * 页面点击删除照片，找到绝对路径删除照片
     * @param id
     * @param flag
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "delfile.json", method = RequestMethod.GET)
    public Map<String, Object> delImageFile(Long id, String flag) {
        AppInfo appInfo=null;
        Map<String, Object> result = new HashMap<>();
        if(flag.equals("logo")){
             appInfo = appInfoService.getAppInfoById(id);
            //截取路径，得到文件名
            String logoWebPath = appInfo.getLogoWebPath();
            int index = logoWebPath.lastIndexOf("/") + 1;
            String fileName = logoWebPath.substring(index);
            boolean check = FileDeleteUtil.deleteFile(appInfo.getLogoLocPath(), fileName);
            if (check==true){
                //在磁盘成功删除文件后，还需要在数据库更新照片网络和磁盘地址为空，不然文件上传报错后不能显示文件框
                appInfo.setLogoWebPath("");
                appInfo.setLogoLocPath("");
                appInfoService.modifyAppInfoById(appInfo);
                result.put("result", "success");
                return result;
            }
        }

        if (flag.equals("apk")){
            AppVersion appVersion = appVersionService.getAppVersionById(id);
            String apkFileName = appVersion.getApkFileName();
            boolean check = FileDeleteUtil.deleteFile("D:\\APPLOGOIMAGE", apkFileName);
            if (check==true){
                appVersion.setDownloadLink("");
                appVersion.setApkLocPath("");
                appVersion.setApkFileName("");
                appVersionService.modifyAppVersionById(appVersion);
                result.put("result", "success");
                return result;
            }
        }
//                删除照片失败
        result.put("result", "failed");
        return result;


    }


    /**
     * 修改页面点击保存，请求到这里，修改更改的APP基础信息
     */
    @RequestMapping(value = "/appinfomodifysave",method = RequestMethod.POST)
    public String appInfoModifySave(@Valid AppInfo appInfo,
                                    BindingResult bindingResult,
                                    String softWareSize,
                                    MultipartFile a_logoPicPath,
                                    Integer pageNum,
                                    Model model,
                                    HttpServletRequest request) {

        //前端校验+后端JSR303校验,防止会代码的人绕过前端，直接发送保存请求，插入错误数据
        if (bindingResult.hasErrors()) {
            model.addAttribute("fileUploadError", "所有字段均不能为空");
            //校验错误后,数据回显到前端表单
            model.addAttribute("appInfo", appInfo);
            //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
            model.addAttribute("pageNum",pageNum);
            return "developer/appinfomodify";
        }
            //文件为空或者大小为0，跳转到页面，返回错误信息
            if (a_logoPicPath != null && !a_logoPicPath.isEmpty()) {
            //第一种情况：有上传文件，上传的文件有内容
                //文件有内容，判断文件是否小于等于50K
                if (a_logoPicPath.getSize() > (50 * 1024)) {
                    model.addAttribute("fileUploadError", "文件大小必须小于等于50K");
                    //如果一开始到修改页面有照片，前端的LogoLocPath、LogoWebPath就有值，无论你删除照片与否都有值
                    //此时提交更新,带过来的就是LogoLocPath、LogoWebPath有值的appinfo，虽然此时数据库的已经没值
                    //所以为了防止把有LogoLocPath、LogoWebPath值的appinfo带回页面，造成文件框不显示，此处把两个地址置空再带回去
                    appInfo.setLogoLocPath("");
                    appInfo.setLogoWebPath("");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("appInfo", appInfo);
                    //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
                    model.addAttribute("pageNum",pageNum);
                    return "developer/appinfomodify";
                }

                //判断文件是否为jpg、jpeg、png格式
                String fileType = a_logoPicPath.getContentType();
                if (!fileType.equals("image/png") && !fileType.equals("image/jpeg") && !fileType.equals("image/jpg")) {
                    model.addAttribute("fileUploadError", "上传图片格式限定为jpg、jpeg、png");
                    //如果一开始到修改页面有照片，前端的LogoLocPath、LogoWebPath就有值，无论你删除照片与否都有值
                    //此时提交更新,带过来的就是LogoLocPath、LogoWebPath有值的appinfo，虽然此时数据库的已经没值
                    //所以为了防止把有LogoLocPath、LogoWebPath值的appinfo带回页面，造成文件框不显示，此处把两个地址置空再带回去
                    appInfo.setLogoLocPath("");
                    appInfo.setLogoWebPath("");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("appInfo", appInfo);
                    //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
                    model.addAttribute("pageNum",pageNum);
                    return "developer/appinfomodify";
                }

                //防止文件名重复，使用UUID命名
                String originalFilename = a_logoPicPath.getOriginalFilename();
                String UUIDName = UUID.randomUUID().toString();
                int index = originalFilename.lastIndexOf(".");
                StringBuffer stringBuffer = new StringBuffer(originalFilename);
                StringBuffer insertStringBuffer = stringBuffer.insert(index, UUIDName);
                String newFileName = new String(insertStringBuffer);
                String realPath = "D:\\APPLOGOIMAGE";
                File file01 = new File(realPath, newFileName);
                if (!file01.exists()) {
                    file01.mkdirs();
                }
                try {
                    a_logoPicPath.transferTo(file01);
                    appInfo.setLogoWebPath("statics/uploadfiles/" + newFileName);
                    appInfo.setLogoLocPath(realPath);
                    //因为springMVC不能自动封装BigDecimal数据类型
                    //所以先用String接受，再转为BigDecimal类型，存入实体类种
                    if (softWareSize != null && !"".equals(softWareSize)) {
                        BigDecimal softWareSize01 = new BigDecimal(softWareSize);
                        appInfo.setSoftWareSize(softWareSize01);
                    } else {
                        model.addAttribute("fileUploadError", "所有字段均不能为空");
                        //校验错误后,数据回显到前端表单
                        //如果一开始到修改页面有照片，前端的LogoLocPath、LogoWebPath就有值，无论你删除照片与否都有值
                        //此时提交更新,带过来的就是LogoLocPath、LogoWebPath有值的appinfo，虽然此时数据库的已经没值
                        //所以为了防止把有LogoLocPath、LogoWebPath值的appinfo带回页面，造成文件框不显示，此处把两个地址置空再带回去
                        appInfo.setLogoLocPath("");
                        appInfo.setLogoWebPath("");
                        model.addAttribute("appInfo", appInfo);
                        //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
                        model.addAttribute("pageNum",pageNum);
                        return "developer/appinfomodify";
                    }

                    //添加更新者信息和更新时间
                    DevUser devUser = (DevUser) request.getSession().getAttribute("devUserSession");
                    appInfo.setModifyBy(devUser.getId());
                    Date currentDate = new Date();
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formatDate = simpleDateFormat.format(currentDate);
                    Date date01 = simpleDateFormat.parse(formatDate);
                    appInfo.setModifyDate(date01);
                    //判断是否成功保存到数据库
                    boolean flag = appInfoService.modifyAppInfoById(appInfo);
                    if (flag == true) {
                        //更新成功，跳转当前页
                        return "redirect:/dev/flatform/app/list?pageIndex=" + pageNum;
                    } else {
                        //更新失败
                        model.addAttribute("fileUploadError", "更新失败");
                        //校验错误后,数据回显到前端表单
                        //如果一开始到修改页面有照片，前端的LogoLocPath、LogoWebPath就有值，无论你删除照片与否都有值
                        //此时提交更新,带过来的就是LogoLocPath、LogoWebPath有值的appinfo，虽然此时数据库的已经没值
                        //所以为了防止把有LogoLocPath、LogoWebPath值的appinfo带回页面，造成文件框不显示，此处把两个地址置空再带回去
                        appInfo.setLogoLocPath("");
                        appInfo.setLogoWebPath("");
                        model.addAttribute("appInfo", appInfo);
                        //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
                        model.addAttribute("pageNum",pageNum);
                        return "developer/appinfomodify";
                    }
                } catch (IOException | ParseException e) {
                    e.printStackTrace();
                }

            }

//        }
        //第二种情况：说明数据库里还有照片地址，没有删除照片，不需要进行文件上传
        AppInfo appInfo02 = appInfoService.getAppInfoById(appInfo.getId());
        if (appInfo02.getLogoWebPath()!=null&&!appInfo02.getLogoWebPath().equals("")) {
                //因为springMVC不能自动封装BigDecimal数据类型
                //所以先用String接受，再转为BigDecimal类型，存入实体类种
                if (softWareSize != null && !"".equals(softWareSize)) {
                    BigDecimal softWareSize01 = new BigDecimal(softWareSize);
                    appInfo.setSoftWareSize(softWareSize01);
                } else {
                    model.addAttribute("fileUploadError", "所有字段均不能为空");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("appInfo", appInfo);
                    //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
                    model.addAttribute("pageNum",pageNum);
                    return "developer/appinfomodify";
                }
                //添加更新者信息和更新时间
                DevUser devUser = (DevUser) request.getSession().getAttribute("devUserSession");
                appInfo.setModifyBy(devUser.getId());
                Date currentDate = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formatDate = simpleDateFormat.format(currentDate);
                Date date01 = null;
                try {
                    date01 = simpleDateFormat.parse(formatDate);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                appInfo.setModifyDate(date01);
                //判断是否成功保存到数据库
                boolean flag = appInfoService.modifyAppInfoById(appInfo);
                if (flag == true) {
                    //更新成功，跳转当前页
                    return "redirect:/dev/flatform/app/list?pageIndex=" + pageNum;
                } else {
                    //更新失败
                    model.addAttribute("fileUploadError", "更新失败");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("appInfo", appInfo);
                    //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
                    model.addAttribute("pageNum",pageNum);
                    return "developer/appinfomodify";
                }
            }

        //第三种情况:文件为空
        model.addAttribute("fileUploadError", "必须上传文件且文件不能为空");
        //如果一开始到修改页面有照片，前端的LogoLocPath、LogoWebPath就有值，无论你删除照片与否都有值
        //此时提交更新,带过来的就是LogoLocPath、LogoWebPath有值的appinfo，虽然此时数据库的已经没值
        //所以为了防止把有LogoLocPath、LogoWebPath值的appinfo带回页面，造成文件框不显示，此处把两个地址置空再带回去
        appInfo.setLogoLocPath("");
        appInfo.setLogoWebPath("");
        //校验错误后,数据回显到前端表单
        model.addAttribute("appInfo", appInfo);
        //每次从这个页面回去到修改页面，pageNum都会丢失，导致更新成功后页面不能跳转到当前页，所以要把pageNum属性值带回去
        model.addAttribute("pageNum",pageNum);
        return "developer/appinfomodify";

    }

    /**
     * 查询APP信息及对应的版本信息
     * @param appId
     * @param model
     * @return
     */
    @RequestMapping("/appview")
    public String appView(Long appId,Model model){
        AppInfo appInfo = appInfoService.getAppInfoById(appId);
        List<AppVersion> appVersionList = appVersionService.getAppVersionList(appId);
        model.addAttribute("appInfo",appInfo);
        model.addAttribute("appVersionList",appVersionList);
        return "developer/appinfoview";
    }

    /**
     * 删除APP信息及对应的版本信息
     */
    @ResponseBody
    @RequestMapping("/delapp.json")
    public Map<String, Object> delApp(Long id){
        boolean flag = appInfoService.delApp(id);
        Map<String, Object> result = new HashMap<>();
        if (flag==true){
            result.put("delResult","true");
            return result;
        }
        result.put("delResult","false");
        return result;
    }

    /**
     * 修改上下架
     * @param appId
     */
    @ResponseBody
    @RequestMapping(value = "sale.json/{appId}/{saleSwitch}",method = RequestMethod.POST)
    public Map<String, Object> sale(@PathVariable("appId") Long appId,@PathVariable("saleSwitch") String saleSwitch){
        Map<String, Object> result = new HashMap<>();
        //上架操作
        if (saleSwitch.equals("open")){
            AppInfo appInfo = appInfoService.getAppInfoById(appId);
            Long status = appInfo.getStatus();
            if(status==5||status==8){
                result.put("errorCode","0");
                AppInfo appInfo01 = new AppInfo();
                appInfo01.setStatus(new Long(7));
                appInfo01.setId(new Long(appId));
                boolean flag = appInfoService.modifyAppInfoById(appInfo01);
                if (flag){
                    result.put("resultMsg","success");
                    return result;
                }
                result.put("resultMsg","failed");
                return result;
            }
            result.put("errorCode","param000001");
            return result;
        }

        //下架操作
        if (saleSwitch.equals("close")){
            AppInfo appInfo = appInfoService.getAppInfoById(appId);
            Long status = appInfo.getStatus();
            if(status==7){
                result.put("errorCode","0");
                AppInfo appInfo01 = new AppInfo();
                appInfo01.setStatus(new Long(8));
                appInfo01.setId(new Long(appId));
                boolean flag = appInfoService.modifyAppInfoById(appInfo01);
                if (flag){
                    result.put("resultMsg","success");
                    return result;
                }
                result.put("resultMsg","failed");
                return result;
            }
            result.put("errorCode","param000001");
            return result;
        }

        result.put("errorCode","exception000001");
        return result;

    }

}

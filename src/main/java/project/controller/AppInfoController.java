package project.controller;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.LocaleResolver;
import project.pojo.AppCategory;
import project.pojo.AppInfo;
import project.pojo.DataDictionary;
import project.pojo.DevUser;
import project.service.AppCategoryService;
import project.service.AppInfoService;
import project.service.DataDictionaryService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
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
    DataDictionaryService dataDictionaryService;

    @Autowired
    AppCategoryService appCategoryService;





    /**
     * 分页查询app信息列表
     * @return
     */
    @RequestMapping(value = "/list")
    public String getAppInfoList(
            @RequestParam(required = false,defaultValue = "1") Integer pageIndex,
            @RequestParam(required = false) String querySoftwareName,
            @RequestParam(required = false) Long queryStatus,
            @RequestParam(required = false) Long queryFlatformId,
            @RequestParam(required = false) Long queryCategoryLevel1,
            @RequestParam(required = false) Long queryCategoryLevel2,
            @RequestParam(required = false) Long queryCategoryLevel3,
            Model model){
        //分页查询
        PageInfo<AppInfo> appInfoPageInfo = appInfoService.getAppInfosByPage(pageIndex,querySoftwareName,queryStatus,queryFlatformId,queryCategoryLevel1,queryCategoryLevel2,queryCategoryLevel3);
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
        model.addAttribute("appInfoList",appInfoPageInfo);
        model.addAttribute("statusList",appStatusList);
        model.addAttribute("flatFormList",floarList);
        model.addAttribute("categoryLevel1List",appLevel1);
        model.addAttribute("categoryLevel2List",appLevel2);
        model.addAttribute("categoryLevel3List",appLevel3);
        model.addAttribute("querySoftwareName",querySoftwareName);
        model.addAttribute("queryStatus",queryStatus);
        model.addAttribute("queryFlatformId",queryFlatformId);
        model.addAttribute("queryCategoryLevel1",queryCategoryLevel1);
        model.addAttribute("queryCategoryLevel2",queryCategoryLevel2);
        model.addAttribute("queryCategoryLevel3",queryCategoryLevel3);
        return "developer/appinfolist";
    }


    /**
     * 检查APKName是否为空
     * @param APKName
     */
    @ResponseBody
    @RequestMapping("/apkexist.json")
    public Map<String, Object> checkAPKName(String APKName){
        Map<String, Object> result = new HashMap<>();
        //判空
        if (APKName==null||"".equals(APKName)){
            result.put("APKName","empty");
            return result;
        }

//        true 重复     false 不重复
        boolean flag = appInfoService.checkAPKName(APKName);
        if (flag==true){
            //重复
            result.put("APKName","exist");
            return result;
        }else {
            //不重复
            result.put("APKName","noexist");
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
                              HttpServletRequest request){

        //前端校验+后端JSR303校验,防止会代码的人绕过前端，直接发送保存请求，插入错误数据
        if(bindingResult.hasErrors()){
            model.addAttribute("fileUploadError","所有字段均不能为空");
            //校验错误后,数据回显到前端表单
            model.addAttribute("SubmitAppInfo",appInfo);
            return "developer/appinfoadd";
        }

        //前后端一起判断APKName是否重复，前端只是提示APKName重复，
        // 如果用户不理提示不修改，照样能进行保存，所以有必要进行后端校验
            boolean flag1 = appInfoService.checkAPKName(appInfo.getAPKName());
            if (flag1==true){
                //重复
                model.addAttribute("APKNameResult","APKName重复，请重新输入");
                //校验错误后,数据回显到前端表单
                model.addAttribute("SubmitAppInfo",appInfo);
                return "developer/appinfoadd";
            }

        //文件为空或者大小为0跳转到页面，返回错误信息
       if (a_logoPicPath!=null&&!a_logoPicPath.isEmpty()){

           //文件有内容，判断文件是否小于等于50K
           if(a_logoPicPath.getSize()>(50*1024)){
               model.addAttribute("fileUploadError","文件大小必须小于等于50K");
               //校验错误后,数据回显到前端表单
               model.addAttribute("SubmitAppInfo",appInfo);
               return "developer/appinfoadd";
           }

           //判断文件是否为jpg、jpeg、png格式
           String fileType = a_logoPicPath.getContentType();
           if (!fileType.equals("image/png")&&!fileType.equals("image/jpeg")&&!fileType.equals("image/jpg")){
               model.addAttribute("fileUploadError","上传图片格式限定为jpg、jpeg、png");
               //校验错误后,数据回显到前端表单
               model.addAttribute("SubmitAppInfo",appInfo);
               return "developer/appinfoadd";
           }

           //防止文件名重复，使用UUID命名
           String originalFilename = a_logoPicPath.getOriginalFilename();
           String UUIDName = UUID.randomUUID().toString();
           int index = originalFilename.lastIndexOf(".");
           StringBuffer stringBuffer = new StringBuffer(originalFilename);
           StringBuffer insertStringBuffer = stringBuffer.insert(index, UUIDName);
           String newFileName = new String(insertStringBuffer);
           String realPath = request.getServletContext().getRealPath("statics/uploadfiles");
           File file01 = new File(realPath, newFileName);
           if (!file01.exists()) {
               file01.mkdirs();
           }
           try {
               a_logoPicPath.transferTo(file01);
               appInfo.setLogoWebPath("statics/uploadfiles/" + newFileName);
               //因为springMVC不能自动封装BigDecimal数据类型
               //所以先用String接受，再转为BigDecimal类型，存入实体类种
               if (softWareSize!=null&&!"".equals(softWareSize)){
                   BigDecimal softWareSize01 = new BigDecimal(softWareSize);
                   appInfo.setSoftWareSize(softWareSize01);
               }
               else{
                   model.addAttribute("fileUploadError","所有字段均不能为空");
                   //校验错误后,数据回显到前端表单
                   model.addAttribute("SubmitAppInfo",appInfo);
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
                   model.addAttribute("SubmitAppInfo",appInfo);
                   return "developer/appinfoadd";
               }
           } catch (IOException | ParseException e) {
               e.printStackTrace();
           }
       }
           //文件为空
           model.addAttribute("fileUploadError","必须上传文件且文件不能为空");
           //校验错误后,数据回显到前端表单
           model.addAttribute("SubmitAppInfo",appInfo);
           return "developer/appinfoadd";

    }




//    修改APP基础信息
    @RequestMapping(value = "/appinfomodify",method = RequestMethod.GET)
    public String modefyAppInfo(Long id,Model model){
        AppInfo appInfo = appInfoService.getAppInfoById(id);
        model.addAttribute("appInfo",appInfo);
        return "developer/appinfomodify";
    }

}

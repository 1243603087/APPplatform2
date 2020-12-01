package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;
import project.pojo.AppInfo;
import project.pojo.AppVersion;
import project.pojo.DevUser;
import project.service.AppInfoService;
import project.service.AppVersionService;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @author 杨乔瀚
 * @create 2020/11/30 - 13:38
 */
@Controller
@RequestMapping("dev/flatform/app")
public class AppVersionController {


    @Autowired
    AppVersionService appVersionService;

    @Autowired
    AppInfoService appInfoService;

    /**
     * 根据appId获取版本信息
     * @param id
     * @param model
     * @return
     */
    @RequestMapping("/appversionadd")
    public String getAppVersionList(Long id, Integer pageNum,Model model){
        List<AppVersion> appVersionList = appVersionService.getAppVersionList(id);
        model.addAttribute("appId",id);
        model.addAttribute("pageNum",pageNum);
        model.addAttribute("appVersionList",appVersionList);
        return "developer/appversionadd";
    }

    /**
     * 新增APP版本信息
     */
    @RequestMapping(value = "/addversionsave",method = RequestMethod.POST)
    public String saveAPPVersion(@Valid AppVersion appVersion,
                                 BindingResult bindingResult,
                                 MultipartFile a_downloadLink,
                                 String versionSize,
                                 Model model,
                                 Integer pageNum,
                                 HttpServletRequest request){

        if(bindingResult.hasErrors()){
            model.addAttribute("fileUploadError","所有字段均不能为空");
            model.addAttribute("SubmitAppVersion",appVersion);
            return "forward:/dev/flatform/app/appversionadd?id="+appVersion.getAppId()+"&pageNum="+pageNum;
        }

        //文件为空或者大小为0跳转到页面，返回错误信息
        if (a_downloadLink != null && !a_downloadLink.isEmpty()) {

            //文件有内容，判断文件是否小于等于500M
            if (a_downloadLink.getSize() > (500*1024*1024)) {
                model.addAttribute("fileUploadError", "文件大小必须小于等于500M");
                //校验错误后,数据回显到前端表单
                model.addAttribute("SubmitAppVersion", appVersion);
                return "forward:/dev/flatform/app/appversionadd?id="+appVersion.getAppId()+"&pageNum="+pageNum;
            }




            //判断文件是否为apk格式
            String originalFilename = a_downloadLink.getOriginalFilename();
            int index2 = originalFilename.lastIndexOf(".")+1;
            String substring = originalFilename.substring(index2);
            if (!substring.equals("apk")){
                model.addAttribute("fileUploadError", "上传文件格式为apk");
                //校验错误后,数据回显到前端表单
                model.addAttribute("SubmitAppInfo", appVersion);
                return "forward:/dev/flatform/app/appversionadd?id="+appVersion.getAppId()+"&pageNum="+pageNum;
            }
            //防止文件名重复，使用UUID命名
            String UUIDName = UUID.randomUUID().toString();
            int index = originalFilename.lastIndexOf(".");
            StringBuffer stringBuffer = new StringBuffer(originalFilename);
            StringBuffer insertStringBuffer = stringBuffer.insert(index, UUIDName+"-"+appVersion.getVersionNo());
            String newFileName = new String(insertStringBuffer);
            String realPath = "D:\\APPLOGOIMAGE";
            File file01 = new File(realPath, newFileName);
            if (!file01.exists()) {
                file01.mkdirs();
            }
            try {
                a_downloadLink.transferTo(file01);
                appVersion.setApkFileName(newFileName);
                appVersion.setApkLocPath("statics/uploadfiles/"+newFileName);
                appVersion.setDownloadLink(newFileName);
                //因为springMVC不能自动封装BigDecimal数据类型
                //所以先用String接受，再转为BigDecimal类型，存入实体类种
                if (versionSize != null && !"".equals(versionSize)) {
                    BigDecimal versionSize01 = new BigDecimal(versionSize);
                    appVersion.setVersionSize(versionSize01);
                } else {
                    model.addAttribute("fileUploadError", "所有字段均不能为空");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("SubmitAppVersion", appVersion);
                    return "forward:/dev/flatform/app/appversionadd?id="+appVersion.getAppId()+"&pageNum="+pageNum;
                }

                //新增APP版本是由哪个用户创建的，创建时间是什么时候
                DevUser devUser = (DevUser) request.getSession().getAttribute("devUserSession");
                appVersion.setCreateBy(devUser.getId());
                Date currentDate = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formatDate = simpleDateFormat.format(currentDate);
                Date date01 = simpleDateFormat.parse(formatDate);
                appVersion.setCreationDate(date01);

                //判断是否成功保存到数据库,保存后需要把id取回来，后续才可以更新APP基础信息中的版本id
                boolean flag = appVersionService.saveAppVersion(appVersion);
                //更新APP基础信息表的版本Id
                AppInfo appInfo = new AppInfo();
                appInfo.setId(appVersion.getAppId());
                appInfo.setVersionId(appVersion.getId());
                appInfo.setStatus(new Long(4));
                boolean flag02 = appInfoService.modifyAppInfoById(appInfo);
                if (flag == true&&flag02==true) {
                    //保存成功，跳转到最后一页
                    return "redirect:/dev/flatform/app/list?pageIndex="+pageNum;
                } else {
                    //保存失败
                    model.addAttribute("fileUploadError", "保存失败");
                    //校验错误后,数据回显到前端表单
                    model.addAttribute("SubmitAppVersion", appVersion);
                    return "forward:/dev/flatform/app/appversionadd?id="+appVersion.getAppId()+"&pageNum="+pageNum;
                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        //文件为空
        model.addAttribute("fileUploadError", "必须上传文件且文件不能为空");
        //校验错误后,数据回显到前端表单
        model.addAttribute("SubmitAppVersion", appVersion);
        return "forward:/dev/flatform/app/appversionadd?id="+appVersion.getAppId()+"&pageNum="+pageNum;


    }

    /**
     * 用于查询当前版本信息，跳转到修改APP版本页面
     * @param vid  版本id
     * @param aid  appId
     * @return
     */
    @RequestMapping("/appversionmodify")
    public String toAppVersionModify(Long vid,Long aid,Integer pageNum,Model model){
        List<AppVersion> appVersionList = appVersionService.getAppVersionList(aid);
        AppVersion appVersion = appVersionService.getAppVersionById(vid);
        model.addAttribute("appVersionList",appVersionList);
        model.addAttribute("appVersion",appVersion);
        model.addAttribute("pageNum",pageNum);
        return "developer/appversionmodify";
    }


    /**
     * 修改APP版本信息
     */
    @RequestMapping(value = "/appversionmodifysave",method = RequestMethod.POST)
    public String appVersionModify(@Valid AppVersion appVersion,
                                 BindingResult bindingResult,
                                 MultipartFile a_downloadLink,
                                 String versionSize,
                                 Model model,
                                 Integer pageNum,
                                 HttpServletRequest request){

        if(bindingResult.hasErrors()){
            model.addAttribute("fileUploadError","所有字段均不能为空");
            return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;
        }

        //文件为空或者大小为0跳转到页面，返回错误信息
        if (a_downloadLink != null && !a_downloadLink.isEmpty()) {

            //文件有内容，判断文件是否小于等于500M
            if (a_downloadLink.getSize() > (500*1024*1024)) {
                model.addAttribute("fileUploadError", "文件大小必须小于等于500M");
                return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;
            }


            //判断文件是否为apk格式
            String originalFilename = a_downloadLink.getOriginalFilename();
            int index2 = originalFilename.lastIndexOf(".")+1;
            String substring = originalFilename.substring(index2);
            if (!substring.equals("apk")){
                model.addAttribute("fileUploadError", "上传文件格式为apk");
                return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;

            }
            //防止文件名重复，使用UUID命名
            String UUIDName = UUID.randomUUID().toString();
            int index = originalFilename.lastIndexOf(".");
            StringBuffer stringBuffer = new StringBuffer(originalFilename);
            StringBuffer insertStringBuffer = stringBuffer.insert(index, UUIDName+"-"+appVersion.getVersionNo());
            String newFileName = new String(insertStringBuffer);
            String realPath = "D:\\APPLOGOIMAGE";
            File file01 = new File(realPath, newFileName);
            if (!file01.exists()) {
                file01.mkdirs();
            }
            try {
                a_downloadLink.transferTo(file01);
                appVersion.setApkFileName(newFileName);
                appVersion.setApkLocPath("statics/uploadfiles/"+newFileName);
                appVersion.setDownloadLink(newFileName);
                //因为springMVC不能自动封装BigDecimal数据类型
                //所以先用String接受，再转为BigDecimal类型，存入实体类种
                if (versionSize != null && !"".equals(versionSize)) {
                    BigDecimal versionSize01 = new BigDecimal(versionSize);
                    appVersion.setVersionSize(versionSize01);
                } else {
                    model.addAttribute("fileUploadError", "所有字段均不能为空");
                    return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;

                }

                //添加更新者信息和更新时间
                DevUser devUser = (DevUser) request.getSession().getAttribute("devUserSession");
                appVersion.setModifyBy(devUser.getId());
                Date currentDate = new Date();
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String formatDate = simpleDateFormat.format(currentDate);
                Date date01 = simpleDateFormat.parse(formatDate);
                appVersion.setModifyDate(date01);

                //判断是否成功保存到数据库,保存后需要把id取回来，后续才可以更新APP基础信息中的版本id
                boolean flag = appVersionService.modifyAppVersionById(appVersion);
                if (flag == true) {
                    //更新成功，跳转到当前页
                    return "redirect:/dev/flatform/app/list?pageIndex="+pageNum;
                } else {
                    //更新失败
                    model.addAttribute("fileUploadError", "保存失败");
                    return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;

                }
            } catch (IOException | ParseException e) {
                e.printStackTrace();
            }
        }
        //第二种情况：说明数据库里还有照片地址，没有删除照片，不需要进行文件上传
        AppVersion appVersion01 = appVersionService.getAppVersionById(appVersion.getId());
        System.out.println(appVersion01);
        if (appVersion01.getApkLocPath()!=null&&!appVersion01.getApkLocPath().equals("")){
            //因为springMVC不能自动封装BigDecimal数据类型
            //所以先用String接受，再转为BigDecimal类型，存入实体类种
            if (versionSize != null && !"".equals(versionSize)) {
                BigDecimal versionSize01 = new BigDecimal(versionSize);
                appVersion.setVersionSize(versionSize01);
            } else {
                model.addAttribute("fileUploadError", "所有字段均不能为空");
                return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;

            }

            //添加更新者信息和更新时间
            DevUser devUser = (DevUser) request.getSession().getAttribute("devUserSession");
            appVersion.setModifyBy(devUser.getId());
            Date currentDate = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String formatDate = simpleDateFormat.format(currentDate);
            Date date01 = null;
            try {
                date01 = simpleDateFormat.parse(formatDate);
            } catch (ParseException e) {
                e.printStackTrace();
            }
            appVersion.setModifyDate(date01);

            //判断是否成功保存到数据库,保存后需要把id取回来，后续才可以更新APP基础信息中的版本id
            //
            AppInfo appInfo = new AppInfo();
            appInfo.setId(appVersion.getAppId());
            appInfo.setStatus(new Long(4));
            appInfoService.modifyAppInfoById(appInfo);
            boolean flag = appVersionService.modifyAppVersionById(appVersion);
            if (flag == true) {
                //更新成功，跳转到当前页
                return "redirect:/dev/flatform/app/list?pageIndex="+pageNum;
            } else {
                //更新失败
                model.addAttribute("fileUploadError", "保存失败");
                return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;

            }


        }


        //文件为空
        model.addAttribute("fileUploadError", "必须上传文件且文件不能为空");
        return "forward:/dev/flatform/app/appversionmodify?vid="+appVersion.getId()+"&aid="+appVersion.getAppId()+"&pageNum="+pageNum;



    }
}

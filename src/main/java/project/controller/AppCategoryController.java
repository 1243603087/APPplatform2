package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import project.pojo.AppCategory;
import project.service.AppCategoryService;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/28 - 13:39
 */
@Controller
@RequestMapping(value = "/dev/flatform/app")
public class AppCategoryController {

    @Autowired
    AppCategoryService appCategoryService;


    /**
     * 当下拉框选择了对应的level1，发送ajax请求到这个方法，响应当前level1类别对应的level2给前端渲染
     */
    @ResponseBody
    @RequestMapping(value = "/categorylevellist.json",method= RequestMethod.GET)
    public List<AppCategory> getLevel2List(@RequestParam(required = false,defaultValue = "0") Long pid){
        List<AppCategory> childrenLevel = appCategoryService.getAPPLevelByPid(pid);
        return childrenLevel;
    }

}

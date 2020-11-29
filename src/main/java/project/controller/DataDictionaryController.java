package project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import project.pojo.DataDictionary;
import project.service.DataDictionaryService;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/28 - 09:40
 */
@Controller
@RequestMapping("/dev/flatform/app")
public class DataDictionaryController{

    @Autowired
    DataDictionaryService dataDictionaryService;


    /**
     * 查询所属平台列表，发送到前端
     */
    @ResponseBody
    @RequestMapping(value = "/datadictionarylist.json",method = RequestMethod.GET)
    public List<DataDictionary> getAppFloar(){
        List<DataDictionary> floarByTypeCode = dataDictionaryService.getFloarByTypeCode();
        return floarByTypeCode;
    }


}

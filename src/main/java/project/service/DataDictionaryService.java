package project.service;

import project.pojo.DataDictionary;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/28 - 09:40
 */
public interface DataDictionaryService {

    /**
     * 查询有哪些手机状态通过数据字典状态
     */
    List<DataDictionary> getAppStatusByTypeCode();

    /**
     * 查询有哪些所属平台通过数据字典
     */
    List<DataDictionary> getFloarByTypeCode();

}

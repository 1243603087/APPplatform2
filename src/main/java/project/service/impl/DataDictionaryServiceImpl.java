package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.DataDictionaryMapper;
import project.pojo.DataDictionary;
import project.pojo.DataDictionaryExample;
import project.service.DataDictionaryService;

import java.util.List;

/**
 * @author 杨乔瀚
 * @create 2020/11/28 - 09:41
 */
@Service
public class DataDictionaryServiceImpl implements DataDictionaryService {


    @Autowired
    DataDictionaryMapper dataDictionaryMapper;

    /**
     * 查询有哪些手机状态通过数据字典状态
     * @return
     */
    @Override
    public List<DataDictionary> getAppStatusByTypeCode() {
        DataDictionaryExample dataDictionaryExample = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypeCodeEqualTo("status");
        List<DataDictionary> dataDictionaries = dataDictionaryMapper.selectByExample(dataDictionaryExample);
        return dataDictionaries;
    }

    /**
     * 查询有哪些所属平台通过数据字典
     */
    @Override
    public List<DataDictionary> getFloarByTypeCode() {
        DataDictionaryExample dataDictionaryExample = new DataDictionaryExample();
        DataDictionaryExample.Criteria criteria = dataDictionaryExample.createCriteria();
        criteria.andTypeCodeEqualTo("floar");
        List<DataDictionary> dataDictionaries = dataDictionaryMapper.selectByExample(dataDictionaryExample);
        return dataDictionaries;
    }
}

package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.BackendUserMapper;
import project.dao.DevUserMapper;
import project.pojo.BackendUser;
import project.pojo.BackendUserExample;
import project.service.BackendUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 22:17
 */
@Service
public class BackendUserServiceImpl implements BackendUserService {

    @Autowired
    BackendUserMapper backendUserMapper;

    /**
     * 通过用户名查询，判断用户名密码正确性
     * @param backendUser
     * @return
     */
    @Override
    public Map<String, Object> login(BackendUser backendUser) {
        BackendUserExample backendUserExample = new BackendUserExample();
        BackendUserExample.Criteria criteria = backendUserExample.createCriteria();
        criteria.andUserCodeEqualTo(backendUser.getUserCode());
        List<BackendUser> backendUsers = backendUserMapper.selectByExample(backendUserExample);
        Map<String, Object> result = new HashMap<>();
        if(backendUsers!=null&&backendUsers.size()>0){
            //有这个用户名
            BackendUser backendUser1 = backendUsers.get(0);
            if(backendUser1.getUserPassword().equals(backendUser.getUserPassword())){
                //密码正确
//                result.put("devUser",devUser1);
//                result.put("message","true");
//                return result;
                result.put("backendUser",backendUser1);
                result.put("message","true");
                return result;
            }
            else {
                //密码错误
                result.put("message","false");
                return result;
            }
        }
        result.put("message","false");
        return result;
    }
}

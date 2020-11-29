package project.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.dao.DevUserMapper;
import project.pojo.DevUser;
import project.pojo.DevUserExample;
import project.service.DevUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 17:41
 */
@Service
public class DevUserServiceImpl implements DevUserService {

    @Autowired
    private DevUserMapper devUserMapper;


    /**
     * 查询开发者用户
     * @param devUser
     * @return
     */
    public Map<String,Object> login(DevUser devUser) {
        DevUserExample devUserExample = new DevUserExample();
        DevUserExample.Criteria criteria = devUserExample.createCriteria();
        criteria.andDevCodeEqualTo(devUser.getDevCode());
        List<DevUser> devUsers = devUserMapper.selectByExample(devUserExample);
        Map<String, Object> result = new HashMap<>();
        if (devUsers!=null&&devUsers.size()>0){
            //找到用户
            DevUser devUser1 = devUsers.get(0);
            if(devUser1.getDevPassword().equals(devUser.getDevPassword())){
                //密码正确
                result.put("devUser",devUser1);
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

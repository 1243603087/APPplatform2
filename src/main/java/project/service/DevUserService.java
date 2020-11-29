package project.service;

import project.pojo.DevUser;

import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 17:40
 */
public interface DevUserService {

    Map<String,Object> login(DevUser devUser);
}

package project.service;

import org.springframework.stereotype.Service;
import project.pojo.BackendUser;
import project.pojo.DevUser;

import java.util.Map;

/**
 * @author 杨乔瀚
 * @create 2020/11/26 - 22:15
 */

public interface BackendUserService {

    Map<String,Object> login(BackendUser backendUser);
}

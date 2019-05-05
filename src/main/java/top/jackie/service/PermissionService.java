package top.jackie.service;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class PermissionService {

    /**
     * 根据用户名查找其权限
     * @param username
     * @return
     */
    public Set<String> findPermissions(String userName) {
        return null;
        // return userDao.findPermissions(username);
    }

}

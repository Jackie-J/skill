package top.jackie.service;

import java.util.Set;

import org.springframework.stereotype.Service;

@Service
public class RoleService {

    /**
     * 根据用户名查找其角色
     * @param username
     * @return
     */
    public Set<String> findRoles(String userName) {
        return null;
        // return userDao.findRoles(username);
    }

}

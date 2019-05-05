package top.jackie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import top.jackie.entity.User;
import top.jackie.repository.UserRepository;
import top.jackie.util.PasswordHelper;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private PasswordHelper passwordHelper = new PasswordHelper();

    public User createUser(User user) {
        // 加密密码
        passwordHelper.encryptPassword(user);
        return userRepository.save(user);
    }

    public void changePassword(Integer userId, String newPassword) {
        User user = userRepository.findOne(userId);
        user.setPassword(newPassword);
        passwordHelper.encryptPassword(user);
        userRepository.saveAndFlush(user);
    }
    
    /**
     * 根据用户名查找用户
     * @param username
     * @return
     */
    public User findByUsername(String userName) {
        return null;
        //return userDao.findByUsername(username);
    }

}

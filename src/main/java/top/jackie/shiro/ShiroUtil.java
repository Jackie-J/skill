package top.jackie.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;

public class ShiroUtil {

    public static void initSecurityUtils(String initFile) {
        Factory<SecurityManager> factory = new IniSecurityManagerFactory(initFile);
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
    }

    public static void login(String initFile, String username, String password) {
        initSecurityUtils(initFile);
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        subject.login(token);
    }

    public static Subject subject() {
        return SecurityUtils.getSubject();
    }

}

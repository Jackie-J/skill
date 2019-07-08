package top.jackie.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import top.jackie.service.TestService;

@RestController
public class TestController {

    @Autowired
    private TestService testService;
    
    @Autowired
    private Environment env;
    
    /** 人脸后台服务 */
    private static final String FACE_CMS_SERVER_CONFIG = "face.cms.server.config";
    /** 人脸后台服务1:1对比 */
    private static final String COMPARE_ONE_CONFIG = "compare.one.config";
    /** 人脸后台服务侦测人脸数 */
    private static final String DETECT_FACE_NUMBER_CONFIG = "detcet.facenumber.config";

//    @RequestMapping(value = "/as")
//    public int ok() {
//        String a = env.getProperty(FACE_CMS_SERVER_CONFIG);
//        a.length();
//        System.out.println(a);
//        return testService.before(1);
//    }
    
    @RequestMapping(value = "/as")
    @GetMapping
    public int ok() {
        System.out.println("/as");
        return testService.before(1);
    }

}

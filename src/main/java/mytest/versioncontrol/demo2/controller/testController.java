package mytest.versioncontrol.demo2.controller;

import mytest.versioncontrol.demo2.configuration.ApiVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// 在url中增加一个占位符，用于匹配未知的版本 v1 v2...
@RestController
@RequestMapping("/find")
public class testController {

    @GetMapping("/test")
    public String test(){
        return "测试.....................................";
    }

    @ApiVersion
    @GetMapping("/{version}/test")
    public String find1() {
        System.out.println("1");
        return "111111111111111111";
    }

    @ApiVersion(2)
    @GetMapping("/{version}/test")
    public String find2() {
        System.out.println("2");
        return "2222222222222222222";
    }

    @ApiVersion(4)
    @GetMapping("/{version}/test")
    public String find4() {
        System.out.println("4");
        return "44444444444444444444";
    }

}

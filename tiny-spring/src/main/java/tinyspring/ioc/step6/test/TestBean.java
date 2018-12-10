package tinyspring.ioc.step6.test;

import lombok.Data;

@Data
public class TestBean {

    private String name;

    private String sex;

    private Integer id;

    private TestService testService;

    public void hello(){
        testService.say(name);
    }
}


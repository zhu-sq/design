package tinyspring.ioc.step5;

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


package tinyspring.ioc.step6.test;

public class TestService {

    private String serviceId;

    public void say(String name){
        System.out.printf("serviceId: %s talk to %s",serviceId,name);
    }
}

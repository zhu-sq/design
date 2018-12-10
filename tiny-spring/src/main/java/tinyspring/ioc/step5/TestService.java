package tinyspring.ioc.step5;

public class TestService {

    private String serviceId;

    public void say(String name){
        System.out.printf("serviceId: %s talk to %s",serviceId,name);
    }
}

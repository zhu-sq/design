package tinyspring.ioc.step1;

public class TestBean {
    private String name;


    public TestBean(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}

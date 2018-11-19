package tinyspring.ioc.step2;

public class TestBean {
    private String name;

    public TestBean(){}

    public TestBean(String name){
        this.name=name;
    }

    public String getName(){
        return this.name;
    }
}

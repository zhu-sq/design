package study;

public abstract class Shape {
    int a;
    {
        System.out.println("初始化");
    }

    private String color;
    public  abstract double call();

    public abstract String get();

    public Shape(){
        System.out.println("");
    }
    public Shape(String color){}

    public abstract void a();

    public void A(){

    }

    public final void f1() {}
}

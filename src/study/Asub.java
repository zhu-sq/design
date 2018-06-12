package study;

public class Asub extends A {

    public static void main(String[] args){
       System.out.println(args);

    }
    public void test(){
        System.out.printf("%d%d%d%d",proInt,pubInt,defInt);
    }
    public void test1(){
        this.test();
    }
}

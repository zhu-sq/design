package study;

public class SubClass extends  BaseClass{
    {
        x++;
    }

    public String book="strbook";
    public void test(){
        System.out.println("子类覆盖的方法");
    }
    public void sub(){
        System.out.println("子类普通方法");
    }
    public static void main(String[] args){
        BaseClass baseClass = new BaseClass();
        System.out.println(baseClass.book);
        baseClass.base();
        baseClass.test();

        SubClass subClass= new SubClass();
        System.out.println(subClass.book);
        subClass.sub();
        subClass.test();
        subClass.base();


        BaseClass bc = new SubClass();
        System.out.println(bc.book);
        bc.test();
        bc.base();
    }
}

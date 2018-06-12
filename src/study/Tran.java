package study;

public class Tran extends Shape {
    @Override
    public double call() {
        return 0;
    }

    @Override
    public String get() {
        return null;
    }

    @Override
    public void a() {
        
    }

    public class InTran{
        public void test(){
            System.out.println("Tran in test");
        }
    }
}

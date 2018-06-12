package study.design;

/**
 * 1.对象适配器
 * 2.类适配器
 * 3.接口适配器
 */
public class Adapter {

    /**
     * 对象适配器
     *   1.ObjAdaptee(适配者类)：被适配对象
     *   2.ObjTarget（目标抽象接口）：定义需要的接口
     *   3.ObjAdapter（适配类）：需要实现ObjTarget接口
     */

    class ObjAdaptee{
        public void method1(){
            System.out.println("ObjAdaptee method1");
        }
    }

    public interface ObjTarget{
        void  method1();
        void  method2();
    }

    class ObjAdapter implements ObjTarget{

        private ObjAdaptee objAdaptee;
        public ObjAdapter(ObjAdaptee objAdaptee){
            this.objAdaptee=  objAdaptee;
        }
        @Override
        public void method1(){
             objAdaptee.method1();
        }

        @Override
        public void method2(){
           System.out.println("ObjAdapter method2");
        }
    }

    /**
     * 类适配器
     *    需要继承被适配者
     *    1.ClassAdaptee（被适配者）
     *    2.ClassTarget（抽象接口）：定义需要新的接口
     *    3.ClassAdapter（适配者）
     */

    class ClassAdaptee{
        public void method1(){
            System.out.println("ClassAdaptee method1");
        }
    }

    interface ClassTarget{
        void method2();
    }

    class ClassAdapter extends ClassAdaptee implements ClassTarget{
        @Override
        public void method2(){
            System.out.println("ClassAdapter method2");
        }
    }

    /**
     * 接口适配
     *    使用一个抽象类实现所有接口，子类继承抽象类，实现自己需要的接口
     *    1.Interface1  接口1
     *    2.Interface2  接口2
     *    3.AbstractClass 实现接口1、接口2的对象
     *    4.Wrapper1    继承AbstractClass，重写自己需要的类
     */

    interface  Interface1{
        void method1();
        void method2();
    }

    interface Interface2{
        void method3();
        void method4();
    }

    abstract class AbstractClass implements Interface1,Interface2{
        public void method1(){}
        public void method2(){}
        public void method3(){}
        public void method4(){}
        public void method5(){
            System.out.println("接口适配 method5");
        }
    }

    class Wrapper1 extends AbstractClass{
        public void method1(){
             System.out.println("Wrapper1 重写 method1");
        }

    }

    /**
     * 使用
     */
    public static void main(String[] args){

        /**
         * 类适配器使用
         */
        Adapter adapter = new Adapter();
        ClassAdapter classAdapter = adapter.new ClassAdapter();
        classAdapter.method1();
        classAdapter.method2();

        /**
         * 对象适配器使用
         */
        ObjAdaptee objAdaptee = adapter.new ObjAdaptee();
        ObjAdapter objAdapter = adapter.new ObjAdapter(objAdaptee);
        objAdapter.method1();
        objAdapter.method2();

        /**
         * 接口适配器使用
         */

        Wrapper1 wrapper1 = adapter.new Wrapper1();
        wrapper1.method1();

    }
}

package study.design;

/**
 * 1.饿汉式
 * 2.懒汉式
 * 3.双重校验锁
 * 4.枚举
 * 5.静态内部类
 */

/**
 * 问题：怎么保证系统中只有一个对象
 * 1.保证构造方法是私有的：如果构造函数是public，那么谁都可以new一个新对象，不能保证单例
 * 2.构造方法时私有的，怎么new对象：在类中先new一个对象，然后提供给外部使用
 * 3.同步问题怎么解决
 */

/**
 * 1.饿汉式
 *     在java虚拟机初始化类时就创建一个对象
 *
 *   缺点：不管有没有用到都实例化了单例类
 *
 *   client使用：
 *       HurrySingleton singleton = HurrySingleton.getSingleton();
 */
class HurrySingleton{
    private static HurrySingleton singleton = new HurrySingleton();

    private  HurrySingleton(){}

    public static HurrySingleton getSingleton(){
        return singleton;
    }
}

/**
 * 2.懒汉式
 *    饿汉式是不管有没有用到都会实例一个单例类，这样对资源是极大的浪费，系统的性能也很差，
 *    那么对饿汉式改变一下，只有在用的时候才实例化对象
 *
 * 缺点：
 *    虽然在获得前会判断singleton是否为null，但是这是线程不安全的
 *
 * 改进:
 *    在getSingleton加上synchronize，锁住这个类，保证这个函数同一时间只有一个线程可以操作，保证初始化只有一个
 *
 * 改进之后的缺点：
 *    在每次getSingleton时都是线程安全的，这样系统性能会变差很多
 */

class LazySingleton{
    private static LazySingleton singleton;

    private LazySingleton(){}

    public static LazySingleton getSingleton(){
        if(singleton==null){
            singleton = new LazySingleton();
        }
        return singleton;
    }
}

/**
 * 改进的懒汉式，添加synchronize关键字，保证线程安全
 */
class LazySingleton2{
    private static LazySingleton2 singleton;

    private LazySingleton2(){}

    public static synchronized LazySingleton2 getSingleton(){
        if(singleton==null){
            singleton = new LazySingleton2();
        }
        return singleton;
    }
}


/**
 * 3.双重检验锁
 *   上述懒汉式为了保证线程安全而在getSingleton上加了锁，将整个类给锁住了，导致系统性能很差
 *   那么改进方法是getSinleton不加锁，先判断singleton是否为空，如果为空，再加锁，然后进行实例化
 *
 * 缺点：可以通过反射机制产生多个对象
 */

class DoubleCheckLockSingleton{
    private volatile static DoubleCheckLockSingleton singleton;

    private DoubleCheckLockSingleton(){}

    public static DoubleCheckLockSingleton getSingleton(){
        if(singleton==null){
            synchronized (DoubleCheckLockSingleton.class){
                singleton = new DoubleCheckLockSingleton();
            }
        }

        return singleton;
    }
}


/**
 * 4.枚举
 *   枚举类型也是在第一次被使用的时候初始化，并且默认构造函数是private修饰，而且线程安全。
 */


enum EnumSingleton{
    INSTANCE;
    public void doSomeThing(){}
}


/**
 * 5.静态内部类
 *   静态内部类在第一次使用的时候才会初始化，并且只会保证初始化一次
 */
class StaticInnerSingleton{
     private StaticInnerSingleton(){}

     public static StaticInnerSingleton getSingleton(){
         return SingletonHolder.instance;
     }

     public static class SingletonHolder{
         public static final StaticInnerSingleton instance = new StaticInnerSingleton();
     }
}


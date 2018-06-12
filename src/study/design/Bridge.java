package study.design;

/**
 * 桥接模式
 *     抽象和实现分离，适合二维的变化
 * 例子：
 *     有若干种毛笔，每种毛笔可以多种着色
 */
public class Bridge {
    /**
     * 毛笔抽象接口
     */
    interface Brush{
        abstract void write();
    }

    /**
     *  具体毛笔类，假设有两种种
     */
    class SmallBrush implements Brush{
        @Override
        public void write(){
            System.out.print("我是小毛笔：");
        }
    }
    class BigBrush implements Brush{
        @Override
        public void write(){
            System.out.print("我是大毛笔：");
        }
    }

    /**
     * 抽象颜色类（代表颜色是实现者)
     */
    abstract class Color{
        protected Brush brush;

        public void setBrush(Brush brush) {
            this.brush = brush;
        }

        abstract void DoColor();
    }

    /**
     * 具体的颜色
     */
    class Red extends Bridge.Color{
        @Override
        public void DoColor(){
             super.brush.write();
             System.out.print("红色");
        }
    }

    public static void main(String[] args){
        Bridge bridge = new Bridge();
        Brush brush = bridge.new BigBrush();
        Color color = bridge.new Red();
        color.setBrush(brush);
        color.DoColor();
    }

}

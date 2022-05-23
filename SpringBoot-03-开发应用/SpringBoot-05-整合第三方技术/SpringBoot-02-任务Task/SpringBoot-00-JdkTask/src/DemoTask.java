import java.util.Timer;
import java.util.TimerTask;


/**
 * 演示jdk原生任务
 */
public class DemoTask {

    public static void main(String[] args) {

        //定义一个计时器类 Timer
        Timer timer = new Timer();

        //创建一个任务类TimerTask 实现方法run(){}
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                //调用任务
                new MyTask().taskMethod();
            }
        };

        //绑定 计时器和任务 同时设置 是么时候触发 出发执行是否一次 多次出发每次间隔时间
        timer.schedule(task,0,3000);

    }



}

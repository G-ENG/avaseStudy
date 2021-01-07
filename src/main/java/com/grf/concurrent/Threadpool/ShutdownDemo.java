package com.grf.concurrent.Threadpool;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.*;

/**
 *future.cancel()
*/
public class ShutdownDemo {
    private static final Logger LOG = LoggerFactory.getLogger(ShutdownDemo.class);
    private Future<?> future = null;

    private static final ExecutorService executorService = Executors.newSingleThreadExecutor();

    private ShutdownDemo() {
    }

    public static ShutdownDemo getInstant() {
        return LazyHolder.SingleInstant;
    }

    static class LazyHolder {
        private static final ShutdownDemo SingleInstant = new ShutdownDemo();
    }

    public void start() throws InterruptedException {
        if (future != null && !future.isDone()) {
            LOG.warn("there is already a task");
            return;
        }
        //lambda写法，是否有返回决定了是runable还是callable，两者都能被cancel取消，只要中断异常不被胡乱捕获
        this.future = executorService.submit(
                () -> {
                    int count = 0;
                    while (true) {

                        Thread.sleep(1000);
                            count++;
                        LOG.info("task is running..... count({})", count);
                        if (count == 100) {
                            break;
                        }

                    }
                    return true;
                });
        //you can use future.cancel() to stop
    }

    public void stop() {
        if (future == null) {
            LOG.warn("there is no future to cancel");
            return;
        }
        //传入false参数只能取消还没有开始的任务，若任务已经开始了，就任由其运下去
        //future.cancel() 取消失败的情况 ： 代码中使用了sleep wait，调用cancel产生的中断异常又被捕获了，那么那个线程仍会正常运行，取消便失败了
        this.future.cancel(true);
        //shutdown will forbid other task join the pool,but wont stop the running task
        // executorService.shutdown(); wiil interupt the running task
    }


}

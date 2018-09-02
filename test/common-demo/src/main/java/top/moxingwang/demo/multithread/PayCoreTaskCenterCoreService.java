package top.moxingwang.demo.multithread;

import java.util.concurrent.*;

/**
 * Created by MoXingwang on 2017/5/22.
 */
public class PayCoreTaskCenterCoreService {

    //创建20个固定线程池
    private ExecutorService threadPool = new ThreadPoolExecutor(20, 100
            , 30, TimeUnit.MINUTES, new ArrayBlockingQueue<Runnable>(100));

    public void notifyExecute() {
        try {
            SendMessageTask sendMessageTask = new SendMessageTask();
            FutureTask<Object> futureTask = new FutureTask<Object>(sendMessageTask);
            threadPool.submit(futureTask);
        } catch (RejectedExecutionException re) {
            //默认拒绝策略异常
        } catch (Exception e) {
        }
    }

    class SendMessageTask implements Callable<Object> {
        public SendMessageTask() {

        }

        @Override
        public Object call() throws Exception {
            try {
                System.out.println("test");
                return null;
            } catch (Exception e) {
                return null;
            }

        }
    }
}

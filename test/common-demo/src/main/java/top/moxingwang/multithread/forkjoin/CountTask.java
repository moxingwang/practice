package top.moxingwang.multithread.forkjoin;

import java.util.concurrent.*;

/**
 * forkjoin框架测试代码
 * Created by M on 17/7/18.
 */
public class CountTask extends RecursiveTask<Long> {

    private static final int threshold = 10000;
    private long start;
    private long end;

    public CountTask(long start, long end) {
        this.start = start;
        this.end = end;
    }

    @Override
    protected Long compute() {
        long sum = 0;

        if(end - start > threshold){
            for (long i = start;i<end;i++){
                sum += i;
            }
        }else {
            long middle = (start + end)/2;

            CountTask left = new CountTask(start,middle);
            CountTask right = new CountTask(middle + 1,end);

            left.fork();
            right.fork();

            long leftResult = left.join();
            long rightResult = right.join();

            sum = leftResult + rightResult;
        }

        return sum;
    }

    public static void main(String[] args) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        CountTask countTask = new CountTask(1,999999999);
        Future<Long> future = forkJoinPool.submit(countTask);

        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}

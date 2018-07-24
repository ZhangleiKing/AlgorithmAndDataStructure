package util.concurrent;

import java.util.ArrayList;
import java.util.concurrent.*;

/**
 * Created by Vincent on 2018/7/8.
 * 利用多线程执行并行计算
 * 采用FutureTask结合Callable来实现
 */
public class CallableAndFuture {
    ArrayList<Future<Integer>> list = null;
    ExecutorService threadPool = null;
    int target;
    int threads;

    public CallableAndFuture(int target, int threads) {
        list = new ArrayList<>();
        threadPool = Executors.newFixedThreadPool(threads);
        this.target = target;
        this.threads = threads;
    }

    public int concurrentCount(){
        int sum = 0;
        int perTarget = target / threads;
        Task task;
        for(int i=1; i<=threads; i++) {
            if(i!=threads)
                task = new Task((i-1)*perTarget+1, i*perTarget);
            else
                task = new Task((i-1)*perTarget+1, target);
            FutureTask<Integer> ftask = new FutureTask<>(task);
            list.add(ftask);
            threadPool.submit(ftask);
        }

        try {
            for(int i=0, len=list.size();i<len;i++) {
                if(list.get(i).isDone()) {
                    sum += list.get(i).get();
                }else {
                    Thread.sleep(50);
                    i--;
                }
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        return sum;
    }

    public static void main(String[] args) {
        CallableAndFuture callableAndFuture = new CallableAndFuture(5005, 5);
        int sum1 = 0;
        for(int i=1;i<=5005;i++) {
            sum1 += i;
        }
        int sum2 = callableAndFuture.concurrentCount();
        if(sum1 == sum2) {
            System.out.println("concurrentCount in CallableAndFuture is true");
        }else {
            System.out.println("concurrentCount in CallableAndFuture is false");
        }
    }

    class Task implements Callable<Integer> {
        int start;
        int end;
        int sum;

        public Task(int start, int end) {
            this.start = start;
            this.end = end;
            this.sum = 0;
        }

        @Override
        public Integer call() throws Exception {
            for(int i=start; i<=end; i++) {
                sum += i;
            }
            return sum;
        }
    }
}

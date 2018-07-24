package util.threadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Vincent on 2018/7/17.
 */
public class DefaultThreadPool<Job extends Runnable> implements ThreadPool<Job>{
    private static final int MAX_WORKER_NUM = 10;

    private static final int DEFAULT_WORKER_NUM = 5;

    private static final int MIN_WORKER_NUM = 1;

    // 工作列表，向里面插入Job
    private final LinkedList<Job> jobs = new LinkedList<Job>();

    private final List<Worker> workers = Collections.synchronizedList(new ArrayList<Worker>());

    private int workerNum = DEFAULT_WORKER_NUM;

    private AtomicLong threadNum = new AtomicLong();

    public DefaultThreadPool() {
        initializeWorker(DEFAULT_WORKER_NUM);
    }

    public DefaultThreadPool(int num) {
        initializeWorker(num > MAX_WORKER_NUM ? MAX_WORKER_NUM : (num < MIN_WORKER_NUM ? MIN_WORKER_NUM : num));
    }

    private void initializeWorker(int num) {
        for(int i=0; i<num; i++) {
            Worker worker = new Worker();
            workers.add(worker);
            Thread thread = new Thread(worker, "Thread-Worker-" + threadNum.incrementAndGet());
            thread.start();
        }
    }

    @Override
    public void execute(Job job) {
        if(job != null) {
            synchronized (jobs) {
                jobs.add(job);
                jobs.notify();
            }
        }
    }

    @Override
    public void shutdown() {
        for(Worker worker : workers) {
            worker.shutDown();
        }
    }

    @Override
    public void addWorker(int num) {
        synchronized(jobs) {
            if(num + workerNum > MAX_WORKER_NUM) {
                num = MAX_WORKER_NUM - workerNum;
            }
            initializeWorker(num);
            workerNum = workerNum + num;
        }
    }

    @Override
    public void removeWorker(int num) {
        synchronized (jobs) {
            if(num > this.workerNum) {
                throw new IllegalArgumentException("beyond workerNum");
            }
            int cnt = 0;
            while(cnt < num) {
                Worker worker = workers.get(0);
                if(workers.remove(worker)) {
                    worker.shutDown();
                    cnt++;
                }
            }
            this.workerNum -= num;
        }
    }

    /**
     * 正在等待执行任务的数量
     * @return
     */
    @Override
    public int getSize() {
        return jobs.size();
    }

    /**
     * 工作者，负责消费任务
     */
    class Worker implements Runnable{

        private volatile boolean isRunning = true;

        @Override
        public void run() {
            while(isRunning) {
                Job job = null;
                synchronized (jobs) {
                    while (jobs.isEmpty()) {
                        try {
                            jobs.wait();
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                            return;
                        }
                    }
                    job = jobs.removeFirst();
                }
                if(job != null) {
                    job.run();
                }
            }
        }

        public void shutDown() {
            this.isRunning = false;
        }
    }
}

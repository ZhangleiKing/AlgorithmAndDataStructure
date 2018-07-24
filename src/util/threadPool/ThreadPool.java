package util.threadPool;

/**
 * Created by Vincent on 2018/7/17.
 */
public interface ThreadPool<Job extends Runnable> {
    void execute(Job job);

    void shutdown();

    /**
     * 增加工作者线程
     * @param num
     */
    void addWorker(int num);

    void removeWorker(int num);

    int getSize();
}

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolCallableTest{
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);
        TaskCallable c = new TaskCallable();
        //�̳߳��л�ȡ�̶߳��󣬵���run����
        service.submit(c);
        //�ٻ�ȡһ��
        service.submit(c);
        //�ر��̳߳�
        service.shutdown();
    }
}
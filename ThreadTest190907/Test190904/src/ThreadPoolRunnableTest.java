import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolRunnableTest {
    public static void main(String[] args) {
        //�����̳߳ض���  ����5��������5���̵߳��̳߳�
        ExecutorService service = Executors.newFixedThreadPool(5);
        //����Runnable�߳��������
        TaskRunnable task = new TaskRunnable();
        //���̳߳��л�ȡ�̶߳���
        service.submit(task);
        System.out.println("----------------------");
        //�ٻ�ȡһ���̶߳���
        service.submit(task);
        //�ر��̳߳�
        service.shutdown();
    }
}
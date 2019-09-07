
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.Callable;

public class ThreadPoolDemo {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //�����̳߳ض���
        ExecutorService threadPool = Executors.newFixedThreadPool(2);
        
        //����һ��Callable�ӿ��������
        //MyCallable c = new MyCallable();
        MyCallable c = new MyCallable(100, 200);
        MyCallable c2 = new MyCallable(10, 20);
        
        //��ȡ�̳߳��е��̣߳�����Callable�ӿ���������е�call()����, �����Ͳ���
        //<Integer> Future<Integer> submit(Callable<Integer> task)
        // Future �������
        Future<Integer> result = threadPool.submit(c);
        //�� Future �� get ���������صĽ������
        Integer sum = result.get();
        System.out.println("sum=" + sum);
        
        //����ʾ
        result = threadPool.submit(c2);
        sum = result.get();
        System.out.println("sum=" + sum);
        //�ر��̳߳�(���Բ��ر�)
        
    }
}



class MyCallable implements Callable<Integer> {
    //��Ա����
    int x = 5;
    int y = 3;
    //���췽��
    public MyCallable(){
    }
    public MyCallable(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public Integer call() throws Exception {
        return x+y;
    }
}
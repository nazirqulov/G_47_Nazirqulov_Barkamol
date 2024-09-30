package task1;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Counter counter=new Counter();
        Thread[] thread=new Thread[5];
        for (int i = 0; i < thread.length; i++) {
            thread[i]=new Thread(()->{
                for (int j = 0; j < 1000; j++) {
                    counter.increment();
                }
            });
            thread[i].start();
        }
     Thread.sleep(1000);
        System.out.println("counter.getCount() = " + counter.getCount());
    }
}

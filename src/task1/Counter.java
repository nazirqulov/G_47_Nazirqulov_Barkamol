package task1;

public class Counter {
    private int count;

    public Counter() {
    }

    public synchronized void increment(){
        count++;
    }

    public int getCount() {
        return count;
    }
}

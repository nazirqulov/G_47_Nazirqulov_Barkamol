package task2;

public class daycountandisLeapyercount {
    private int daycount=0;
    private int isLeapYear=0;
    public synchronized void addWork(int days){
        daycount+=days;
    }
    public synchronized void isLeapyear(){
        isLeapYear++;
    }

    public int getDaycount() {
        return daycount;
    }

    public int getIsLeapYear() {
        return isLeapYear;
    }
}

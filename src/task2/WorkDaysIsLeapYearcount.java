package task2;

import java.time.LocalDate;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class WorkDaysIsLeapYearcount {
    private int workDays = 0;
    private int leapYears = 0;
    public synchronized void addWorkDays(int days) {
        workDays += days;
    }
    public synchronized void addLeapYear() {
        leapYears++;
    }
    public int getWorkDays() {
        return workDays;
    }
    public int getLeapYears() {
        return leapYears;
    }

    public static void main(String[] args) {

        WorkDaysIsLeapYearcount calculator = new WorkDaysIsLeapYearcount();
        LocalDate startDate = LocalDate.of(1990, 1, 1);
        LocalDate endDate = LocalDate.of(2024, 1, 1);

        ExecutorService executor = Executors.newFixedThreadPool(5);

        for (int year = startDate.getYear(); year < endDate.getYear(); year++) {
            int finalYear = year;
            executor.execute(() -> {
                int workDaysInYear = 0;
                for (LocalDate date = LocalDate.of(finalYear, 1, 1);
                     date.getYear() == finalYear; date = date.plusDays(1)) {

                    if (date.getDayOfWeek().getValue() >= 1 && date.getDayOfWeek().getValue() <= 5) {
                        workDaysInYear++;
                    }
                }
                calculator.addWorkDays(workDaysInYear);
                if (LocalDate.of(finalYear, 1, 1).isLeapYear()) {
                    calculator.addLeapYear();
                }
            });
        }

        executor.shutdown();
        while (!executor.isTerminated()) {
        }
        System.out.println("Ish kunlari: " + calculator.getWorkDays());
        System.out.println("Kabisa yillari: " + calculator.getLeapYears());
    }
}

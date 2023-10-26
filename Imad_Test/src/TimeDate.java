import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class TimeDate {
    LocalDateTime dateTime = LocalDateTime.now();
    LocalDate date = LocalDate.now();
    LocalTime time = LocalTime.now();
    private int year = date.getYear();
    private int month = date.getMonthValue();
    private int oclock = time.getHour();
    private int minutes = time.getMinute();
    private int seconds = time.getSecond();

    public int getYear() {
        return year;
    }

    public int getOclock() {
        return oclock;
    }

    public int getMinutes() {
        return minutes;
    }

    public int getSeconds() {
        return seconds;
    }

    public int getMonth() {
        return month;
    }
}

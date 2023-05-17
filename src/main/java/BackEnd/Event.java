package BackEnd;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Event {

    private String name;
    private LocalTime start;
    private LocalTime finish;
    private LocalDate date;

    public Event() {

    }

    public Event(String name, LocalTime start, LocalTime finish, LocalDate date) {
        this.name = name;
        this.start = start;
        this.finish = finish;
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getFinish() {
        return finish;
    }

    public void setFinish(LocalTime finish) {
        this.finish = finish;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}

package BackEnd;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.Date;

public class Event {

    @JsonProperty("name")
    private String name;
    //@JsonFormat(pattern = "hh:mm:ss")
    @JsonProperty("start")
    private LocalTime start;
    //@JsonFormat(pattern = "hh:mm:ss")
    @JsonProperty("finish")
    private LocalTime finish;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @JsonProperty("date")
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

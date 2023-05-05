package BackEnd;
import java.time.LocalDate;


public class Form {
    private String link;
    private String name;
    private LocalDate endDate;

    public Form() {
    }

    public Form(String link, String name, LocalDate endDate) {
        this.link = link;
        this.name = name;
        this.endDate = endDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}

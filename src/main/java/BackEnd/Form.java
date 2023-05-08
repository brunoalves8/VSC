package BackEnd;
import java.time.LocalDate;
import java.util.Date;


public class Form {
    private String link;
    private String name;
    private Date endDate;

    public Form() {
    }

    public Form(String link, String name, Date endDate) {
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

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}

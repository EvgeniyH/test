package beans;

import org.springframework.stereotype.Component;
import java.sql.Timestamp;

/**
 * Created by Jenya on 05.06.2017.
 */
@Component
public class User {
    private int id;
    private String fio;
    private Timestamp date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}

package domain;

import java.util.Date;
import java.util.List;

public class News {
    private int id_news;
    private String title;
    private String contain;
    private Date date_post;
    private int id_reporter;
    private int id_rating;

    public News() {
    }

    public int getId_news() {
        return id_news;
    }

    public void setId_news(int id_news) {
        this.id_news = id_news;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContain() {
        return contain;
    }

    public void setContain(String contain) {
        this.contain = contain;
    }

    public int getId_reporter() {
        return id_reporter;
    }

    public void setId_reporter(int id_reporter) {
        this.id_reporter = id_reporter;
    }
}

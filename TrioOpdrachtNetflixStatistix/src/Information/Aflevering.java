package Information;

public class Aflevering {
    private int id;
    private int show;
    private String season;
    private String title;
    private String length;

    public Aflevering(int id, int show, String season, String title, String length) {
        this.id = id;
        this.show = show;
        this.season = season;
        this.title = title;
        this.length = length;
    }

    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    public int getShow() {
        return show;
    }

    public void setShow(int show) {
        this.show = show;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}




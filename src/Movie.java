 import java.util.*;
public class Movie{

    private String name;

    private Details detail;

    public Movie(String name, Details detail) {
        this.name = name;
        this.detail = detail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Details getDetail() {
        return detail;
    }

    public void setDetail(Details detail) {
        this.detail = detail;
    }
}
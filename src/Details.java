public class Details {

    private String genre;
    private String year;
    private String director;

    public Details(String genre, String year, String director) {
        this.genre = genre;
        this.year = year;
        this.director = director;
    }

    public String getGenre() {
        return genre;
    }

    public String getYear() {
        return year;
    }

    public String getDirector() {
        return director;
    }

    public String returnAllDetails(){
        return "Genre: " + genre + " Year: " + year + " Director: " + director;
    }
}

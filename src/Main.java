import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Main implements MoviesProject {

    private static Map<String,Details> moviesMap;


    public static void main(String[] args) throws IOException {
        Main ex = new Main();


        Repository repository = new Repository();
        moviesMap = repository.createMusicArrayList();

        for (Map.Entry<String, Details> entry : moviesMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().returnAllDetails());
        }

        System.out.println(ex.find("Bridget Jones's Diary"));
        System.out.println(ex.add("chicken", new String[]{"chicken", "chicken", "chicken"}));
        System.out.println(ex.getLoadFactor());
        System.out.println(ex.find("chicken"));

    }

    @Override
    public String find(String movie) {
        return moviesMap.containsKey(movie) ?  movie + " " + moviesMap.get(movie).returnAllDetails() : "Movie not found";
    }

    @Override
    public boolean add(String movie, String[] entry) {

        return moviesMap.putIfAbsent(movie, new Details(entry[0], entry[1], entry[2])) == null;
    }

    @Override
    public boolean delete(String movie) {
        return moviesMap.remove(movie) != null;
    }

    @Override
    public void printHT() {
        for (Map.Entry<String, Details> entry : moviesMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().returnAllDetails());
        }
    }

    @Override
    public double getLoadFactor() {
        return moviesMap.size() / 1000.0;
    }

    @Override
    public double getMaxLoadFactor() {
        return moviesMap.size() / moviesMap.keySet().size();
    }

    @Override
    public int count() {
        return moviesMap.size();
    }

    @Override
    public void who() {

    }

    @Override
    public void help() {

    }

    @Override
    public void exit() {

    }
}
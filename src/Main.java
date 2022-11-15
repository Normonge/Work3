import java.io.IOException;
import java.util.Map;

public class Main {
    public static void main(String[] args) throws IOException {

        Map<String, Details> moviesMap = new Repository().createMusicArrayList();
        Repository repository = new Repository();
        moviesMap = repository.createMusicArrayList();

        for (Map.Entry<String, Details> entry : moviesMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue().returnAllDetails());
        }

    }
}
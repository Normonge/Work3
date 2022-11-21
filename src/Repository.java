
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
public class Repository {
  //read top10s_1.csv
  HashMap<String, Details> moviesMap = new HashMap<>();
  public HashMap<String, Details> createMusicArrayList() throws IOException {
    File file = new File("movies.csv");

    try (BufferedReader reader = new BufferedReader(new FileReader(file, StandardCharsets.UTF_8))) {
      String line;
      line = reader.readLine();


      while ((line = reader.readLine()) != null) {
        //print title only

        //create music object
        Details details = new Details(
                line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[1],
                line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[2],
                line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[3]
        );
        String title = line.split(",(?=([^\"]*\"[^\"]*\")*[^\"]*$)")[0];

        moviesMap.put(title, details);
      }

    }

    return moviesMap;
  }

  public void quadraticProbing(String key, Details value){
    int index = key.hashCode() % moviesMap.size();
    int i = 1;
    while(moviesMap.containsKey(key)){
      index = (index + (i*i)) % moviesMap.size();
      i++;
    }
    moviesMap.put(key, value);
  }




}
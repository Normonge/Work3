import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main implements MoviesProject {

    private static HashMap<String,Details> moviesMap = new HashMap<>();

    Double max = 16.0;
    final Double THRESHOLD = 0.75;
    Double loadFactor = 0.0;

    public static void main(String[] args) throws IOException {
        Main ex = new Main();

        Repository repository = new Repository();
        moviesMap = repository.createMusicArrayList();

        //loop printOptions until user enters 10
        moviesMap = ex.quadraticProbing(moviesMap);

        int option = 0;

        while(option != 10){
            ex.printOptions();
            Scanner scanner = new Scanner(System.in);
            option = scanner.nextInt();
            ex.optionChosen(option);
        }
    }

    public HashMap<String, Details> quadraticProbing(HashMap<String,Details> moviesMap){
        HashMap<String,Details> newMap = new HashMap<>();
        for(Map.Entry<String, Details> entry : moviesMap.entrySet()){
            String key = entry.getKey();
            Details value = entry.getValue();
            int i = 0;
            while(newMap.containsKey(key)){
                i++;
                key = key + i;
            }
            newMap.put(key, value);
        }
        return newMap;
    }

    public void printOptions() {
        System.out.println("1. Find a movie");
        System.out.println("2. Add a movie");
        System.out.println("3. Remove a movie");
        System.out.println("4. Print all movies");
        System.out.println("5. Get load factor");
        System.out.println("6. Get Max Load Factor");
        System.out.println("7. Count the number of movies");
        System.out.println("8. Who");
        System.out.println("9. Help");
        System.out.println("10. Exit");
    }

    public void optionChosen(int option){
        String movieName;
        switch (option){
            case 1:
                System.out.println("Enter the name of the movie you want to find");
                Scanner scanner = new Scanner(System.in);
                movieName = scanner.nextLine();
                System.out.println(find(movieName));
                break;
            case 2:
                System.out.println("Enter the name of the movie you want to add");
                Scanner scanner1 = new Scanner(System.in);
                movieName = scanner1.nextLine();
                System.out.println("Enter the genre: ");
                Scanner scanner2 = new Scanner(System.in);
                String genre = scanner2.nextLine();
                System.out.println("Enter the year: ");
                Scanner scanner3 = new Scanner(System.in);
                String year = scanner3.nextLine();
                System.out.println("Enter the director: ");
                Scanner scanner4 = new Scanner(System.in);
                String director = scanner4.nextLine();
                System.out.println(add(movieName, new String[]{genre, year, director}));
                break;
            case 3:
                System.out.println("Enter the name of the movie you want to remove");
                Scanner scanner5 = new Scanner(System.in);
                String movieName2 = scanner5.nextLine();
                System.out.println(delete(movieName2));
                break;
            case 4:
               printHT();
                break;
            case 5:
                System.out.println(getLoadFactor());
                break;
            case 6:
                System.out.println(getMaxLoadFactor());
                break;
            case 7:
                System.out.println(count());
                break;
            case 8:
                who();
                break;
            case 9:
                help();
                break;
            case 10:
                exit();
                break;
            default:
                System.out.println("Invalid option");
        }
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
            System.out.println(entry.getKey() + entry.getValue().returnAllDetails());
        }
    }

    @Override
    public Double getLoadFactor() {
        loadFactor = (moviesMap.size() / max);

        if (loadFactor > THRESHOLD) {
            max = max * 2;
            getLoadFactor();
        }
        return loadFactor;
    }

    @Override
    public double getMaxLoadFactor() {
        //get max load factor
        return THRESHOLD;
    }

    @Override
    public int count() {
        return moviesMap.size();
    }

    @Override
    public void who() {
        System.out.println("Name: " + "Adeleke Oluwaseun");
        System.out.println("Student Number: " + "C17335831");
    }

    @Override
    public void help() {
        System.out.println("1. Find a movie - Enter the name of the movie you want to find");
        System.out.println("2. Add a movie - Enter the name of the movie you want to add");
        System.out.println("3. Remove a movie - Enter the name of the movie you want to remove");
        System.out.println("4. Print all movies - Prints all movies in the hash table");
        System.out.println("5. Get load factor - Prints the load factor");
        System.out.println("6. Get Max Load Factor - Prints the max load factor");
        System.out.println("7. Count the number of movies - Prints the number of movies in the hash table");
        System.out.println("8. Who - Prints the name of the person who wrote the program");
        System.out.println("9. Help - Prints the help menu");
        System.out.println("10. Exit - Exits the program");
    }

    @Override
    public void exit() {
        System.exit(0);
    }
}
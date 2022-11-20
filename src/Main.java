import javax.swing.text.html.parser.Entity;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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


        ex.printOptions();
        Scanner scanner = new Scanner(System.in);
        int option = scanner.nextInt();
        ex.optionChosen(option);
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
        switch (option){
            case 1:
                System.out.println("Enter the name of the movie you want to find");
                Scanner scanner = new Scanner(System.in);
                String movieName = scanner.nextLine();
                System.out.println(find(movieName));
                break;
            case 2:
                System.out.println("Enter the name of the movie you want to add");
                Scanner scanner1 = new Scanner(System.in);
                String movieName1 = scanner1.nextLine();
                System.out.println("Enter the details of the movie you want to add");
                Scanner scanner2 = new Scanner(System.in);
                String movieDetails = scanner2.nextLine();
                String[] movieDetailsArray = movieDetails.split(",");
                System.out.println(add(movieName1,movieDetailsArray));
                break;
            case 3:
                System.out.println("Enter the name of the movie you want to remove");
                Scanner scanner3 = new Scanner(System.in);
                String movieName2 = scanner3.nextLine();
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
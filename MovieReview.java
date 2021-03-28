import Models.*;
import java.util.HashMap;

public interface MovieReview {

    
    public int CURR_YEAR = 2021;
    public HashMap<String, User> users = new HashMap<>();
    public HashMap<String, Movie> movies = new HashMap<>();
    // public User userArr[];
    // public Movie movieArr[];

    public void add_user(String user_name);

    public void add_movie(String movie_name, int year, String genre);

    public void add_review(String user_name, String movie_name, int rating);

    // public int get_average_movie(String movie_name);

    // public int get_average_year(int year);
}



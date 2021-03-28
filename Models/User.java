package Models;

import java.util.HashMap;


public abstract class User {
    
    public String name;
    public String user_type;
    public int no_movies = 0;

    public HashMap<String, Integer> movies_rated = new HashMap<>();

    public User(String user_name) {
        this.name = user_name;
        this.user_type = "Viewer";
    }
    
    public abstract String getUserType();

    public abstract String getName();

    public abstract boolean isRated(String movie_name);

    public abstract void checkUser();

    public abstract void removeReview(String movie_name, int rating);

    public abstract void addReview(String movie_name, int rating) throws Exception;


}

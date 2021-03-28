import java.util.ArrayList;
import java.util.HashMap;

import Models.Movie;

// This class inherits abstract class Movie from package Models

class Rating {
    public String user_type;
    public int rating;
    public Rating(String user_type, int rating) {
        this.user_type = user_type;
        this.rating = rating;
    }
}


public class MovieImpl extends Movie {


    public final int CURR_YEAR = 2021;
    // private ArrayList<Integer> ratings = new ArrayList<>(); // To store the ratings for a particular movie object
    // private HashMap<In
    private ArrayList<Rating> ratings = new ArrayList<>();
    private int total_rating = 0;

    public MovieImpl(String movie_name, int year, String genre) {
        super(movie_name, year, genre);
    }

    @Override
    public void addRating(int rating, String user_type) throws Exception{
        if(this.getYear()>this.CURR_YEAR) {
            throw new Exception("Error - Movie not released yet!!");
        }
        else {
            ratings.add(new Rating(user_type, rating));
            total_rating += rating;
        }
    }

    // This method returns average rating for a movie
    public int getAverage() {
        // System.out.println("Average = " + total_rating);
        return total_rating/ratings.size();
    }

    // This method returns Total rating for a movie
    public int getTotal() {
        return total_rating;
    }

    public int getTotalByCritic() {
        int sum = 0;
        for(Rating r: ratings) {
            if(r.user_type.equals("Critic"))
                sum += r.rating;
        }

        return sum;
    }

}

import Models.*;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
// This class implements MovieReview Interface
import java.util.Map;


public class MovieReviewService implements MovieReview {

    
    // Method used to add new user in the users hashmap
    @Override
    public void add_user(String user_name) {
        try {
            if(users.containsKey(user_name))
                throw new Exception("Error: cannot add user, user alredy exists!!");
        }
        catch(Exception e) {
            System.out.println(e);
        }

        users.put(user_name, new UserImpl(user_name));
    }


    // Method used to add new movie in the movies hashmap
    @Override
    public void add_movie(String movie_name, int year, String genre) {
        try {
            if(movies.containsKey(movie_name))
                throw new Exception("Error: cannot add movie, movie alredy exists!!");
        }
        catch(Exception e) {
            System.out.println(e);
        }

        movies.put(movie_name, new MovieImpl(movie_name, year, genre));
    }

    // Method used to add a review by a user for a movie
    @Override
    public void add_review(String user_name, String movie_name, int rating) {
        
        try {
            User curr_user = users.get(user_name);
            Movie curr_movie = movies.get(movie_name);
            if(curr_movie.getYear()>CURR_YEAR)
                throw new Exception("Error - Movie not released yet!!");
            else if(rating>10 || rating<1)
                throw new Exception("Error - Cannot rate the movie, Rating can only be in range 1 - 10");
            
            try {
            curr_user.addReview(movie_name, rating);
            String user_type = curr_user.getUserType();
            curr_movie.addRating(rating, user_type);
            }
            catch(Exception e) {
                System.out.println(e);
                // If exception occours in adding review for a particular movie, this method removes that review for the user
                // curr_user.removeReview(movie_name, rating);
            }
            
        }

        catch(Exception e) {
            System.out.println(e);
        }
        
    }

    // Method returns average rating for a movie_name
    public int get_average_movie(String movie_name) {
        return movies.get(movie_name).getAverage();
    }

    // Method returns average rating for a particular year
    public int get_average_year(int year) {
        int count = 0;
        int total = 0;
        for(Movie movie : movies.values()) {
            if(movie.getYear()==year) {
                total += movie.getTotal();
                count++;
            }
        }
        
        return total/count;
    }

    public void getTopByCritics(int n) {
        HashMap<String, Integer> top_movies = new HashMap<>();
        for(Movie movie: movies.values()) {
            top_movies.put(movie.getName(), movie.getTotalByCritic());
        }
        top_movies = sortByValue(top_movies);

        int i=0;
        for (String movie_name : top_movies.keySet()) {
            System.out.println(movie_name);
            i++;
            if(i==n) break;
        }

    }

    public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm)
    {
        // Create a list from elements of HashMap
        List<Map.Entry<String, Integer> > list =
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet());
  
        // Sort the list
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() {
            public int compare(Map.Entry<String, Integer> o1, 
                               Map.Entry<String, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
          
        // put data from sorted list to hashmap 
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>();
        for (Map.Entry<String, Integer> aa : list) {
            temp.put(aa.getKey(), aa.getValue());
        }
        return temp;
    }



}

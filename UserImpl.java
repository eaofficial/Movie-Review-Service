import Models.User;

// This class inherits User Model


public class UserImpl extends User {    
    public UserImpl(String user_name) {
        super(user_name);
    }
    

    @Override
    public String getUserType() {
        return user_type;
    }

    @Override
    public String getName() {
        return name;
    }

    // This method checks if the user has already rated the movie
    @Override
    public boolean isRated(String movie_name) {
        return movies_rated.containsKey(movie_name);
    }

    // This methods checks if the user has rated enough movies to be upgraded; Insert more conditionals to scale to more usertypes
    @Override
    public void checkUser() {
        if(no_movies==3) {
            user_type = "Critic";
            System.out.println("Since " + this.name + " has published 3 reviews, the user is being promoted to ‘critic’ now.");
        }
    }

    // Method used to add a review
    @Override
    public void addReview(String movie_name, int rating) throws Exception {
        String msg="";
        if(isRated(movie_name)) {
            msg = "Error - multiple reviews not allowed";
            throw new Exception(msg);
        }
        if(user_type.equals("Critic"))
            movies_rated.put(movie_name, rating*2);
        else
            movies_rated.put(movie_name, rating);
        
        no_movies++;
        checkUser();
    }

    @Override
    public void removeReview(String movie_name, int rating) {
        movies_rated.remove(movie_name);
    }
    
}

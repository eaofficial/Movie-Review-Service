package Models;

public abstract class Movie {
    private String name;
    private int year;
    private String genre;
    

    public Movie(String name, int year, String genre) {
        this.name = name;
        this.year = year;
        this.genre = genre;
    } 

    public int getYear() {
        return year;
    }

    public String getName() {
        return name;
    }

    public String getgenre() {
        return genre;
    }

    public abstract void addRating(int rating, String user_type) throws Exception;

    public abstract int getAverage();

    public abstract int getTotal();

    public abstract int getTotalByCritic();

    

}

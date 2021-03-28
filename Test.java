
// This class inherits MovieReviewService class, this class is just for convenience purpose,
// you can also instantiate an object of MovieReviewService class and perform below operations

class Test extends MovieReviewService{


    public void add_movies() {
        add_movie("Don", 2006, "Action");
        add_movie("Tiger", 2008, "Drama");
        add_movie("Padmavat", 2006, "Comedy");
        add_movie("Guru", 2006, "Drama");
        add_movie("Lunchbox", 2022, "Drama");
        add_movie("Metro", 2006, "Romance");
        add_movie("Metro", 2006, "Romance");


        System.out.println("----------Movies added----------");
    }

    public void add_users() {
        add_user("SRK");
        add_user("Salman");
        add_user("Deepika");
        add_user("Deepika");

        
        System.out.println("----------Users added----------");
    }


    public void executeTestCases() {
        add_movies();
        add_users();
        add_review("SRK", "Don", 2);
        System.out.println("Test case 1 executed");

        add_review("SRK", "Padmavat", 2);
        System.out.println("Test case 2 executed");

        add_review("Salman", "Don", 5);
        System.out.println("Test case 3 executed");

        add_review("Deepika", "Don", 9);
        System.out.println("Test case 4 executed");

        add_review("Deepika", "Guru", 6);
        System.out.println("Test case 5 executed");

        add_review("SRK", "Don", 10);
        System.out.println("Test case 6 executed");

        add_review("Deepika", "Lunchbox", 5);
        System.out.println("Test case 7 executed");

        add_review("SRK", "Tiger", 5);
        System.out.println("Test case 8 executed");

        add_review("SRK", "Metro", 7);
        System.out.println("Test case 9 executed");

        System.out.println(get_average_movie("Don"));
        System.out.println("Test case 10 executed");

        System.out.println(get_average_year(2006));
        System.out.println("Test case 11 executed");

        getTopByCritics(5);
        System.out.println("All test cases executed Successfully!!");
    }

    


    public static void main(String[] args) {
        Test test = new Test();

        test.executeTestCases();
    }

}

class Movie {
    String title;
    String director;
    int yearOfRelease;
    double rating;
    Movie next;
    Movie prev;

    public Movie(String title, String director, int yearOfRelease, double rating) {
        this.title = title;
        this.director = director;
        this.yearOfRelease = yearOfRelease;
        this.rating = rating;
        this.next = null;
        this.prev = null;
    }
}

class MovieList {
    Movie head;
    Movie tail;

    public MovieList() {
        head = null;
        tail = null;
    }

    // Add movie at the beginning
    public void addAtBeginning(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (head == null) {
            head = tail = newMovie;
        } else {
            newMovie.next = head;
            head.prev = newMovie;
            head = newMovie;
        }
    }

    // Add movie at the end
    public void addAtEnd(String title, String director, int yearOfRelease, double rating) {
        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        if (tail == null) {
            head = tail = newMovie;
        } else {
            tail.next = newMovie;
            newMovie.prev = tail;
            tail = newMovie;
        }
    }

    // Add movie at a specific position
    public void addAtPosition(int position, String title, String director, int yearOfRelease, double rating) {
        if (position == 0) {
            addAtBeginning(title, director, yearOfRelease, rating);
            return;
        }

        Movie newMovie = new Movie(title, director, yearOfRelease, rating);
        Movie current = head;
        int count = 0;

        while (current != null && count < position - 1) {
            current = current.next;
            count++;
        }

        if (current == null) {
            System.out.println("Position out of bounds");
            return;
        }

        newMovie.next = current.next;
        if (current.next != null) {
            current.next.prev = newMovie;
        }
        current.next = newMovie;
        newMovie.prev = current;
    }

    // Remove movie by title
    public void removeByTitle(String title) {
        Movie current = head;

        while (current != null && !current.title.equals(title)) {
            current = current.next;
        }

        if (current == null) {
            System.out.println("Movie not found");
            return;
        }

        if (current == head) {
            head = current.next;
            if (head != null) head.prev = null;
        } else {
            current.prev.next = current.next;
            if (current.next != null) current.next.prev = current.prev;
        }

        if (current == tail) {
            tail = current.prev;
        }

        current = null;
    }

    // Search for a movie by director
    public Movie searchByDirector(String director) {
        Movie current = head;
        while (current != null) {
            if (current.director.equals(director)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Search for a movie by rating
    public Movie searchByRating(double rating) {
        Movie current = head;
        while (current != null) {
            if (current.rating == rating) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Update movie rating by title
    public void updateRating(String title, double newRating) {
        Movie movie = searchByTitle(title);
        if (movie != null) {
            movie.rating = newRating;
        } else {
            System.out.println("Movie not found");
        }
    }

    // Search for a movie by title (used for updating rating)
    public Movie searchByTitle(String title) {
        Movie current = head;
        while (current != null) {
            if (current.title.equals(title)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Display all movie records in forward order
    public void displayForward() {
        Movie current = head;
        if (current == null) {
            System.out.println("No movie records.");
            return;
        }

        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.next;
        }
    }

    // Display all movie records in reverse order
    public void displayReverse() {
        Movie current = tail;
        if (current == null) {
            System.out.println("No movie records.");
            return;
        }

        while (current != null) {
            System.out.println("Title: " + current.title + ", Director: " + current.director + ", Year: " + current.yearOfRelease + ", Rating: " + current.rating);
            current = current.prev;
        }
    }
}

public class TestMovieManagement {
    public static void main(String[] args) {
        MovieList movieList = new MovieList();

        // Add movies to the list
        movieList.addAtEnd("Inception", "Christopher Nolan", 2010, 8.8);
        movieList.addAtEnd("The Dark Knight", "Christopher Nolan", 2008, 9.0);
        movieList.addAtEnd("Interstellar", "Christopher Nolan", 2014, 8.6);

        // Display all movies in forward order
        System.out.println("Movie Records (Forward):");
        movieList.displayForward();

        // Add a movie at the beginning
        movieList.addAtBeginning("The Prestige", "Christopher Nolan", 2006, 8.5);
        System.out.println("\nAfter adding The Prestige at the beginning:");
        movieList.displayForward();

        // Add a movie at position 2
        movieList.addAtPosition(2, "Memento", "Christopher Nolan", 2000, 8.4);
        System.out.println("\nAfter adding Memento at position 2:");
        movieList.displayForward();

        // Update the rating of a movie
        movieList.updateRating("Inception", 9.2);
        System.out.println("\nAfter updating Inception's rating:");
        movieList.displayForward();

        // Search for a movie by director
        Movie searchedMovie = movieList.searchByDirector("Christopher Nolan");
        if (searchedMovie != null) {
            System.out.println("\nFound movie by Christopher Nolan: " + searchedMovie.title);
        } else {
            System.out.println("Movie not found by this director.");
        }

        // Search for a movie by rating
        searchedMovie = movieList.searchByRating(9.0);
        if (searchedMovie != null) {
            System.out.println("\nFound movie with rating 9.0: " + searchedMovie.title);
        } else {
            System.out.println("Movie not found with this rating.");
        }

        // Remove a movie by title
        movieList.removeByTitle("The Dark Knight");
        System.out.println("\nAfter removing The Dark Knight:");
        movieList.displayForward();

        // Display movies in reverse order
        System.out.println("\nMovie Records (Reverse):");
        movieList.displayReverse();
    }
}

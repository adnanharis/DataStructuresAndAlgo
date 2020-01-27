// "static void main" must be defined in a public class.
// https://www.interviewcake.com/question/java/inflight-entertainment?course=fc1&section=hashing-and-hash-tables
import java.util.*;

public class InflightIntertainment {
    public static void main(String[] args) {
        System.out.println("Hello World!");

        // int flightTime = 5; // instead read from console
        Scanner in = new Scanner(System.in);
        int flightTime = in.nextInt();
        int[] movies = new int[]{1, 2, 3, 4, 5, 6};


        System.out.println("Got: " + getMovies(flightTime, movies));
    }

    private static List<Integer> getMovies(int target, int[] movies) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer> selectedMovies = new ArrayList<>();

        for (int i = 0; i < movies.length; i++) {
            int d = movies[i];
            if (map.containsKey(d)) {
                selectedMovies.add(map.get(d));
                selectedMovies.add(d);
            } else {
                map.put(target - d, d);
            }
        }

        return selectedMovies;
    }
}

/*

Bonus

    1. What if we wanted the movie lengths to sum to something close to the flight length (say, within 20 minutes)?
    2. What if we wanted to fill the flight length as nicely as possible with any number of movies (not just 2)?
    3. What if we knew that movieLengths was sorted? Could we save some space and/or time?


*/
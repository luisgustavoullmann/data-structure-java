package search_sort;

import java.time.Duration;
import java.time.Instant;

public class TimeTest {
    static void myFunction() {
        double x = 10;
        for (long i = 0; i < 100000000L; i++) {
            x = -x;
        }
    }

    static void duration(Instant start, Instant end, String duration) {
        duration = duration.toLowerCase();
        Duration between = Duration.between(start, end);
        if (duration.equals("millis")) {
            long time = between.toMillis();
            System.out.printf("Duration milliseconds: %dms\n", time);
        } else if (duration.equals("nano")) {
            long time = between.toNanos();
            System.out.printf("Duration nanoseconds: %dms\n", time);
        }

    }

    public static void main(String[] args) {
        Instant start = Instant.now();
        myFunction();
        Instant end = Instant.now();
        duration(start, end, "millis");
    }
}

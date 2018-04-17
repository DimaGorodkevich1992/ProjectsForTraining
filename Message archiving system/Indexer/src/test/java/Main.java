
import java.lang.reflect.Array;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Collection<Integer> collection = Arrays.asList(1,2,3,4,5);
        collection.stream().forEach(i -> {
            System.out.println(i);
        });
    }
}

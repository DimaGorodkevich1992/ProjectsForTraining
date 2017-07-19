package factorials;

/**
 * Created by dima on 11.07.2017.
 */
public class Factorials {
    int fact(int a) {
        int result;

        if (a == 1) return 1;
        result = fact(a - 1) * a;
        return result;
    }
}


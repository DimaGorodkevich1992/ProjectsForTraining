package com.gorodkevichApp.Atm;
import java.util.ArrayList;
import java.util.List;
/**
 * Created by dima on 17.10.2017.
 */
public class AtmConfig {
    private static final List<Integer> banknotes = new ArrayList<>();

    public static List<Integer> getBanknotes() {
        return banknotes;
    }

    static {
        banknotes.add(5);
        banknotes.add(10);
        banknotes.add(20);

    }
}

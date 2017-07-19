package test1;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;

/**
 * Created by dima on 19.07.2017.
 */
public class Test {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        String[] name = new String[10];
        for (int i = 0; i <= name.length - 1; i++) {
            String string = bufferedReader.readLine();
            name[i]= string;
        }
        for (int i = 0; i <= name.length - 1; i++) {
            System.out.println(name[i]);
        }
    }
}

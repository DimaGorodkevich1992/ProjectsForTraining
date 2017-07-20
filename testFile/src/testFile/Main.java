package testFile;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

/**
 * Created by dima on 19.07.2017.
 */
public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String path = bufferedReader.readLine();
        File file = new File(path);
        recurs(file, 0);
    }

    public static void recurs(File file, int i) {
        System.out.println(getSpace(i++) + file.getName());
        for (File inFile : file.listFiles()) {
            if (inFile.isDirectory()) {
                recurs(inFile, i);
            } else System.out.println(inFile.getName());
        }
    }

    public static String getSpace(int length) {
        String result = "";
        for (int index = 0; index < length; index++) {
            result += "\t";
        }
        return result;
    }
}

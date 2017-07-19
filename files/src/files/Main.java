package files;

import java.io.File;
import java.lang.reflect.Array;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by dima on 09.07.2017.
 */
public class Main {
    public static void main(String[] args) {
        File file = new File("C:/Test");

        recursionFiles(file, 0);

    }

    public static void recursionFiles(File file, int i) {
        System.out.println(getSpace(i++) + file.getName());
        for (File entry : file.listFiles())  {

            recursionFiles(entry, i);
        }
    }

    public static String getSpace(int length) {
        String result = "";
        for (int index = 0; index < length; index++) {
            result += "\t";
        }
        return result;
    }

    public static void noRecurs(File file) {
        Queue<File> queue = new PriorityQueue<File>();
        queue.add(file);
        while (!queue.isEmpty()) {
            File entry = queue.poll();
            System.out.println(entry.getName());
            for (File childEntry : entry.listFiles()) {
                queue.add(childEntry);
            }

        }

    }
}


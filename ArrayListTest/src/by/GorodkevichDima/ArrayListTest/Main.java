package by.GorodkevichDima.ArrayListTest;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.io.File;
import java.util.ArrayList;

public class Main {

    public static ArrayList<String> fileSystem = new ArrayList<>();

    public static void main(String[] args) {
        File file = new File("C:/project java");
        recurs(file);
        for (int i = 0; i < fileSystem.size(); i++){
            System.out.println(fileSystem.get(i));
        }


    }

    public static void recurs(File file) {
        fileSystem.add(file.getName());
        for (File fileSys : file.listFiles()) {
            if (fileSys.isDirectory()) {
                recurs(fileSys);
            } else {
                fileSystem.add(fileSys.getName());
            }

        }

    }
}
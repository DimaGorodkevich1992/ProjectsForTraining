package List;

import java.util.LinkedList;

/**
 * Created by dima on 02.08.2017.
 */
public class Main {
    public static void main(String[] args) {
        MyList<String> myListStrings = new MyList<>();
        myListStrings.pushElem("Dima");
        myListStrings.pushElem("Tanya");
        myListStrings.pushElem("Usia");
        myListStrings.removeElem(2);
        System.out.println(myListStrings.getSize());
        myListStrings.setElem(2, "Dimasik");
        myListStrings.getElem(2);


    }
}
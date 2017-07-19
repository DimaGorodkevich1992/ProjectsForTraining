package by.GorodkevichDima.AdmissionToTheClub;

/**
 * Created by dima on 08.07.2017.
 */
public class ArrayPerson {
    public static void main(String[] args) {

        Persons[] listPersons = Persons.getListPerson();
        for (int i =0;i<listPersons.length;i++){
            System.out.println(listPersons[i]);
        }
        for (int i = 0; i < listPersons.length; i++) {
            if (listPersons[i].getAge() < 18) {
                System.out.println(listPersons[i].getName() + " " + "вы не проходите по возрасту т.к вам менше 18 лет");
            } else System.out.println(listPersons[i].getName() + " " + "проходите");


        }
    }
}











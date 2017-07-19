package by.GorodkevichDima.AdmissionToTheClub;

import java.lang.reflect.Array;

/**
 * Created by dima on 08.07.2017.
 */
public class Persons {
    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;

    }

    public void setName(String name) {
        this.name = name;
    }

    public void getInfo() {
        System.out.println(age + " " + name);
        ;
    }

    @Override
    public String toString() {
        return age + " " + name;
    }

    public static Persons[] getListPerson(){
        Persons[] persons = new Persons[20];
        for (int i = 0; i < persons.length; i++) {
            Persons human = new Persons();
            human.setName("human" + (i+1));
            human.setAge((int)(Math.random()*50));
            persons[i] = human;
        }
        return persons;
    }
}

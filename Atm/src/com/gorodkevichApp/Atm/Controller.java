package com.gorodkevichApp.Atm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dima on 17.10.2017.
 */
public class Controller {


    public static void compliteAnOperation() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));




        Service service = new Service();
        System.out.println();
        System.out.println("Если хотите посмотреть ваш баланс напишите \"баланс\"" + "\n" +
                "Для того что бы положить деньги напишите \"зачислить\" и сумму в цифрах," + "\n" +
                "снять напишите \"снять\" и сумму в цифрах " + "\n" +
                "ВНИМАНИЕ БАНКОМАТ ХРАНИТ КУПЮРЫ НОМИНАЛОМ 5, 10, 15");
        String keyWord = bufferedReader.readLine();
        switch (keyWord) {
            case "зачислить":
                System.out.print("введите сумму : ");
                int putMoneyValue = Integer.parseInt(bufferedReader.readLine());
                service.putMoney(putMoneyValue);
                break;
            case "снять":
                System.out.print("введите сумму : ");
                int takeMoneyValue = Integer.parseInt(bufferedReader.readLine());
                service.takeMoney(takeMoneyValue);
                break;
            case "баланс":
                System.out.println(service.giveMyCardAccount());
                break;
                default:
                    System.out.println("некоректно введен текст");
        }
    }
}








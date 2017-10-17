package com.gorodkevichApp.Atm;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dima on 17.10.2017.
 */
public class ApplicationCycle {


    public static void compliteAnOperation() throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));




        Service service = new Service();
        System.out.println();
        System.out.println("Если хотите посмотреть ваш баланс напишите \"баланс\"" + "\n" +
                "Для того что бы положить деньги напишите \"зачислить\" и сумму в цифрах," + "\n" +
                "снять напишите \"снять\" и сумму в цифрах " + "\n" +
                "ВНИМАНИЕ БАНКОМАТ ХРАНИТ КУПЮРЫ НОМИНАЛОМ 5, 10, 20"+"\n" +
                "Если хотите выйти \"выход\" ");
        while (true){

            String keyWord = bufferedReader.readLine();
            if("выход".equals(keyWord))break;
            switch (keyWord) {
                case "зачислить":
                    System.out.print("введите сумму : ");
                    int putMoneyValue = Integer.parseInt(bufferedReader.readLine());
                    service.putMoney(putMoneyValue);
                    break;
                case "снять":
                    service.takeMoney();
                    break;
                case "баланс":
                    System.out.println(service.giveMyCardAccount());
                    break;
                default:
                    System.out.println("некоректно введен текст");
            }
        }
    }
}








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
                "ВНИМАНИЕ БАНКОМАТ ХРАНИТ КУПЮРЫ НОМИНАЛОМ 5, 10, 20" + "\n" +
                "Если хотите выйти \"выход\"");
        while (true) {

            String keyWord = bufferedReader.readLine();
            if ("выход".equals(keyWord)) break;
            switch (keyWord) {
                case "зачислить":
                    System.out.print("введите сумму : ");
                    int putMoneyValue = Integer.parseInt(bufferedReader.readLine());
                    service.putMoney(putMoneyValue);
                    break;
                case "снять":
                    System.out.print("введите сумму : ");
                    boolean identifier = false;
                    while (!identifier) {
                        int takeValue = Integer.parseInt(bufferedReader.readLine());
                        if (takeValue > service.giveMyCardAccount()) {
                            System.out.print("Введенная вами сумма превышает ваш баланс , баланс вашего счета "
                                    + service.giveMyCardAccount() + " введите сумму : ");
                            continue;
                        }
                        int size = AtmConfig.getBanknotes().size();
                        for (int index = 0; index < size; index++) {
                            if (takeValue % AtmConfig.getBanknotes().get(index) == 0) {
                                service.takeMoney(takeValue);
                                identifier = true;
                                break;
                            } else if (index == size - 1) {
                                System.out.print("Вы ввели не корректную сумму , банкомат выдает купюры 5, 10, 20" + " введите сумму : ");
                                continue;
                            }
                        }
                    }
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








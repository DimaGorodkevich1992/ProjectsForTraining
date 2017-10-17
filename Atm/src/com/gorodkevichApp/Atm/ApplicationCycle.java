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
        System.out.println("Check your balance enter \"balance\"" + "\n" +
                "To put money enter \"put\" "+ "\n" +
                "To take money enter \"take\"  " + "\n" +
                "Attention ATM has bank notes 5, 10, 20" + "\n" +
                "To exit enter \"exit\"");
        while (true) {

            String keyWord = bufferedReader.readLine();
            if ("exit".equals(keyWord)) break;
            switch (keyWord) {
                case "put":
                    System.out.print("enter money amount : ");
                    int putMoneyValue = Integer.parseInt(bufferedReader.readLine());
                    service.putMoney(putMoneyValue);
                    break;
                case "take":
                    System.out.print("enter money amount : ");
                    boolean identifier = false;
                    while (!identifier) {
                        int takeValue = Integer.parseInt(bufferedReader.readLine());
                        if (takeValue > service.giveMyCardAccount()) {
                            System.out.print("Wrong money amount , your balance "
                                    + service.giveMyCardAccount() + " enter money amount : ");
                            continue;
                        }
                        int size = AtmConfig.getBanknotes().size();
                        for (int index = 0; index < size; index++) {
                            if (takeValue % AtmConfig.getBanknotes().get(index) == 0) {
                                service.takeMoney(takeValue);
                                identifier = true;
                                break;
                            } else if (index == size - 1) {
                                System.out.print("Wrong money amount , ATM has bank notes 5, 10, 20" + " enter money amount : ");
                                continue;
                            }
                        }
                    }
                    break;
                case "balance":
                    System.out.println(service.giveMyCardAccount());
                    break;
                default:
                    System.out.println("Wrong request");
            }
        }
    }
}








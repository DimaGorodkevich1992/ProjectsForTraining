package com.gorodkevichApp.Atm;

import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.regex.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by dima on 17.10.2017.
 */
public class ApplicationCycle {


    public static void startApplicationCycle() throws IOException, RuntimeException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        Pattern p = Pattern.compile("\\d+");

        Service service = new Service();
        String menu = "Check your balance enter \"balance\"" + "\n" +
                "To put money enter \"put\" " + "\n" +
                "To take money enter \"take\"  " + "\n" +
                "Attention ATM has bank notes 5, 10, 20" + "\n" +
                "To exit enter \"exit\"";

        while (true) {
            System.out.println();
            System.out.println(menu);
            String keyWord = bufferedReader.readLine();
            if ("exit".equals(keyWord)) break;
            switch (keyWord) {
                case "put":
                    System.out.print("enter money amount to put : ");
                    while (true) {
                        String putValue = bufferedReader.readLine();
                        Matcher putMatcer = p.matcher(putValue);
                        if (putMatcer.matches()) {
                            int tmpPutValue = Integer.parseInt(putValue);
                            service.putMoney(tmpPutValue);
                        } else if (putValue.equals("exit")){
                            break;
                        }else{
                            System.out.print("You entered letter but you need number !!! enter money amount : ");
                        }
                        break;
                    }
                    break;
                case "take":

                    System.out.print("enter money amount to take : ");

                    while (true) {
                        String takeValue = bufferedReader.readLine();
                        Matcher m = p.matcher(takeValue);
                        if (m.matches()) {
                            int tmpTakeValue = Integer.parseInt(takeValue);
                            if (tmpTakeValue > service.giveMyCardAccount()) {
                                System.out.print("Entered money amount exceeds your balance "
                                        + service.giveMyCardAccount() + " enter money amount : ");
                                continue;
                            } else if (service.takeMoney(tmpTakeValue)) {
                                break;
                            } else continue;
                        } else if (takeValue.equals("exit")) {
                            break;
                        } else {
                            System.out.print("You entered letter but you need number !!! enter money amount : ");
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








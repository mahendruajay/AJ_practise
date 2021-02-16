/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playground.Homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author ajay
 */
public class MyFileWriter {

    public static void writeToFile(String fileName) {
        String[] merchantNames = {"StarBucks", "Adiddas", "Sub Way", "Chipotle", "Garbanzo", "Pizza Hut", "Dominos", "Pizzeria", "Jimmy Johns", "Local Canteen"};
        String[] contactNames = {"Ajay", "Joey", "Sam", "Bryan", "Ryan", "Rob", "Steve", "Vijay", "Richard", "Daniel"};
        String[] phoneNumbers = {"573 814 2424", "573-815-9822", "+44 232 345 4567", "574-987-6543", "786-876-9876", "902 543 2345", "765-908-4234", "666 777 8888", "206-339-8966", "206-339-4535"};
        Long loopVar = 0L;
        Long var = Long.MAX_VALUE >> 40;
        PrintWriter printWriter = null;
        try {
            File file = new File(fileName);
            printWriter = new PrintWriter(file);
            StringBuilder stringBuilder = new StringBuilder();

            for (; loopVar < 1500; loopVar++) {
                Random generator = new Random();

                int num1 = generator.nextInt(217) % 10;
                String merchantName = merchantNames[num1];
                stringBuilder.append(merchantName);
                stringBuilder.append(",");

                stringBuilder.append(loopVar.toString());
                stringBuilder.append(",");

                num1 = generator.nextInt(113) % 10;
                String phoneNumber = phoneNumbers[num1];
                stringBuilder.append(phoneNumber);
                stringBuilder.append(",");

                num1 = generator.nextInt(113) % 10;
                String contactName = contactNames[num1];
                stringBuilder.append(contactName);


                printWriter.println(stringBuilder.toString());
                stringBuilder.setLength(0);
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(MyFileWriter.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            printWriter.close();
        }


    }

    public static void main(String args[]) {

        String fileName = "C://Books/one_thousand.txt";
        MyFileWriter.writeToFile(fileName);

    }

}

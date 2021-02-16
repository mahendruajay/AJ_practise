/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package playground.Homework;


/**
 * @author ajay
 */
public class MerchantTester {


    public static void main(String args[]) {
        MerchantRecordsHandler merRecHandler = new MerchantRecordsHandler("C://Books/one_thousand.txt");
        long maxBytes = Runtime.getRuntime().maxMemory();
        System.out.println("Max memory: " + maxBytes / 1024 / 1024 + "M");
        boolean openFile1 = merRecHandler.openFile();
        System.out.println("openFile1 : " + openFile1);
        System.out.println(merRecHandler.findMerchantByID("1500"));
        System.out.println(merRecHandler.findMerchantByID("1499"));
        System.out.println(merRecHandler.findMerchantByID("747"));
        System.out.println(merRecHandler.findMerchantByID("9000000"));
        System.out.println(merRecHandler.findMerchantByID("0"));
        int i = 0;
        for (MerchantRecord merRec : merRecHandler.findMerchantByName("Sub Way")) {
            System.out.println(merRec);
            i++;
            if (i == 10) {
                break;
            }
        }
        i = 0;
        for (MerchantRecord merRec : merRecHandler.findMerchantByName("Adiddas")) {
            System.out.println(merRec);
            i++;
            if (i == 10) {
                break;
            }
        }

        MerchantRecord merchantRecord = new MerchantRecord("Chipotle", "1200", "573-976-9876", "Richard");
        boolean add1 = merRecHandler.addMerchant(merchantRecord);
        System.out.println("add1 : " + add1);
        merchantRecord = new MerchantRecord("TukarMerchant", "1500", "573-976-9876", "Anu");
        boolean add2 = merRecHandler.addMerchant(merchantRecord);
        System.out.println("add2 : " + add2);

//        Chipotle,15,573-815-9822,Richard;
//        Garbanzo,0,786-876-9876,Joey;
        boolean update1 = merRecHandler.updateMerchantRecord("15", "TukarMerchant", null, null);
        System.out.println("update1 : " + update1);
        boolean update2 = merRecHandler.updateMerchantRecord("0", "TukarMerchant", "111-111-1111", "AnuGanu");
        System.out.println("update2 : " + update2);
        boolean update3 = merRecHandler.updateMerchantRecord("-1", "TukarMerchant", "111-111-1111", "AnuGanu");
        System.out.println("update3 : " + update3);

        boolean commitFile1 = merRecHandler.commitFile();
        System.out.println("commitFile1 : " + commitFile1);

        merchantRecord = new MerchantRecord("TukarMerchant", "2000", "999-999-9999", "Anu");
        boolean add3 = merRecHandler.addMerchant(merchantRecord);
        System.out.println("add3 : " + add3);

        boolean commitFile2 = merRecHandler.commitFile();
        System.out.println("commitFile2 : " + commitFile2);

        boolean openFile2 = merRecHandler.openFile();
        System.out.println("openFile2 : " + openFile2);

        boolean commitFile3 = merRecHandler.commitFile();
        System.out.println("commitFile3 : " + commitFile3);


    }

}

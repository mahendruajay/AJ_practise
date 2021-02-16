package playground.Miscellaneous;

import java.util.ArrayList;
import java.util.List;

public class TaxCalculation {

    /**
     * @param args
     */
    public static void main(String[] args) {
        List<TaxValue> taxList = new ArrayList<TaxValue>();
        taxList.add(new TaxValue(10.0, 8.0));
        taxList.add(new TaxValue(40.0, 7.0));
        taxList.add(new TaxValue(450.0, 6.0));
        taxList.add(new TaxValue(9500.0, 5.0));
        taxList.add(new TaxValue(990500.0, 4.0));

        double amount = 610.0;

        TaxCalculation calc = new TaxCalculation();

        double tax = calc.calculateTax(taxList, amount);

        System.out.println(tax);

    }

    public double calculateTax(List<TaxValue> taxList, double amount) {
        double totalTax = 0.0;

        if (amount < 0.0) {
            return 0.0;
        }

        for (TaxValue item : taxList) {
            if (amount > 0.0) {
                double curr = 0.0;
                if (amount < item.getBracket()) {
                    curr = amount;
                } else {
                    curr = item.getBracket();
                }

                double tax = (item.getRate() / 100) * (curr);

                totalTax = totalTax + tax;

                amount = amount - curr;

            }
        }

        return totalTax;

    }

}

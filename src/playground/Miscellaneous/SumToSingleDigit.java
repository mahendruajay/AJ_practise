package playground.Miscellaneous;

public class SumToSingleDigit {

    /**
     * @param args
     */
    public static void main(String[] args) {
        SumToSingleDigit smd = new SumToSingleDigit();
        int num = smd.singleDigitSum(219);
        System.out.println(num);

    }

    public int singleDigitSum(int num) {
        int sum = 0;
        if (num / 10 == 0) {
            return num;
        } else {
            while (num != 0) {
                sum = sum + (num % 10);
                num = num / 10;
            }

            if (sum / 10 != 0) {
                sum = singleDigitSum(sum);
            }
        }
        return sum;
    }

}

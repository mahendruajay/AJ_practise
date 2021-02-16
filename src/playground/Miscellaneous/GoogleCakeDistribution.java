package playground.Miscellaneous;

public class GoogleCakeDistribution {

    /**
     * @param args
     */
    public static void main(String[] args) {
        GoogleCakeDistribution p = new GoogleCakeDistribution();

        float[] arr = {3.0f, 3.0f, 1.0f};

        System.out.println(p.isDistrubutable(arr, 1.5f, 3));

    }

    public boolean isDistrubutable(float[] cakeSizes, float pieces,
                                   int numberOfPeople) {
        if (numberOfPeople <= 0 || cakeSizes == null || cakeSizes.length == 0
                || pieces <= 0) {
            return false;
        }

        int quotient = 0;

        for (int i = 0; i < cakeSizes.length; i++) {
            int res = (int) (cakeSizes[i] / pieces);
            quotient = quotient + res;
        }

        if (quotient >= numberOfPeople) {
            return true;
        } else {
            return false;
        }
    }

}

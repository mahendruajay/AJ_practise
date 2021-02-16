package uplevel.recursion.cls;

public class DiceSum {

    public static void main(String[] args) {
        int numOfDice = 3;
        int target = 16;
        diceSum(numOfDice, 0, target, 0, new StringBuilder());
    }

    public static void diceSum(int numOfDice, int level, int target, int runningSum, StringBuilder builder) {
        if (runningSum > target) {
            return;
        }
        if (level > numOfDice) {
            return;
        }

        int maxPossible = runningSum + (6 * (numOfDice - level));
        if (target > maxPossible) {
            return;
        }

        int minPossible = runningSum + (1 * (numOfDice - level));
        if (target < minPossible) {
            return;
        }

        if (level == numOfDice) {
            if (runningSum == target) {
                System.out.println(builder.toString());
            }
        } else {

            for (int i = 1; i <= 6; i++) {
                if (level > numOfDice) {
                    continue;
                }

                builder.append(i);
                diceSum(numOfDice, level + 1, target, runningSum + i, builder);
                builder.deleteCharAt(builder.length() - 1);
            }
        }
    }
}

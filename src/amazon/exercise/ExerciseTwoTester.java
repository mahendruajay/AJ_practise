package amazon.exercise;

import java.util.ArrayList;
import java.util.List;

/**
 * This class provides playground cases for Exercise Two
 *
 * @author anu
 */

public class ExerciseTwoTester {

    /**
     * @param args
     */
    public static void main(String[] args) {

        List<Athlete> athletes = new ArrayList<Athlete>();

        /**
         * This tester is written with an assumption that correct values of mass and stregths will be provided.
         * If that assumption is not made then -> Need to add validation while adding the athletes to the list.
         * They should maintain the property of if (mass1 >mass2) then (strength1 > strength2)
         *
         */


        athletes.add(new Athlete(2, 4));
        athletes.add(new Athlete(3, 6));
        athletes.add(new Athlete(3, 6));
        athletes.add(new Athlete(2, 2));
        athletes.add(new Athlete(2, 3));
        athletes.add(new Athlete(7, 13));
        athletes.add(new Athlete(4, 10));
        athletes.add(new Athlete(7, 14));
        athletes.add(new Athlete(1, 1));

        AthleteCollection ac = new AthleteCollection(athletes);
        System.out.println("Max no of athletes in the tower : " + ac.findHighestTower());


    }

}

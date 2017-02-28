package com.playground.sort.search;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AcrobatTester {
    public static void main(String[] args) {
        List<Acrobat> acrobats = new ArrayList<Acrobat>();
        acrobats.add(new Acrobat(3, 4));
        acrobats.add(new Acrobat(2, 2));
        acrobats.add(new Acrobat(7, 6));
        acrobats.add(new Acrobat(4, 5));

        Collections.sort(acrobats);

        for (Acrobat acrobat : acrobats) {
            System.out.println("Acrobat : " + acrobat.getHeight() + ", "
                    + acrobat.getWeight());
        }

        AcrobatTester acrobatTester = new AcrobatTester();

        acrobatTester.getLargestSequence(acrobats);

    }

    public void getLargestSequence(List<Acrobat> acrobats) {
        List<List<Acrobat>> solutions = new ArrayList<List<Acrobat>>();

        getlargestSequence(acrobats, solutions, 0);

        List<Acrobat> bestSequence = null;
        for (List<Acrobat> acrobatList : solutions) {
            bestSequence = getBestSequence(bestSequence, acrobatList);
        }

        for (Acrobat acrobat : bestSequence) {
            System.out.println("Best Sequence Acrobat :" + acrobat.getHeight()
                    + ", " + acrobat.getWeight());
        }

    }

    private void getlargestSequence(List<Acrobat> acrobats,
                                    List<List<Acrobat>> solutions, int index) {
        if (index >= acrobats.size() || index < 0) {
            return;
        }

        Acrobat currentElement = acrobats.get(index);
        // List<Acrobat> bestSequence = null;
        //
        // for(int i=0; i< index; i++)
        // {
        // if(acrobats.get(i).isBefore(currentElement))
        // {
        // bestSequence = getBestSequence(bestSequence, solutions.get(i));
        // }
        // }
        //
        // List<Acrobat> newSolution= new ArrayList<Acrobat>();
        //
        // if(bestSequence != null)
        // {
        // newSolution.addAll(bestSequence);
        // }
        //
        // newSolution.add(currentElement);
        // solutions.add(index, newSolution);
        //
        // getlargestSequence(acrobats, solutions, index+1);

        List<Acrobat> newSolution = new ArrayList<Acrobat>();
        List<Acrobat> lastBestSequence = null;
        if (index != 0) {
            lastBestSequence = solutions.get(index - 1);
            Acrobat lastElement = lastBestSequence
                    .get(lastBestSequence.size() - 1);
            if (lastElement.isBefore(currentElement)) {
                newSolution.addAll(lastBestSequence);
                newSolution.add(currentElement);
                solutions.add(index, newSolution);
            } else {
                newSolution.add(currentElement);
                solutions.add(index, newSolution);
            }

        } else {
            newSolution.add(currentElement);
            solutions.add(index, newSolution);
        }

        getlargestSequence(acrobats, solutions, index + 1);

    }

    private List<Acrobat> getBestSequence(List<Acrobat> bestSequence,
                                          List<Acrobat> solutions) {
        if (bestSequence == null) {
            return solutions;
        }
        if (solutions == null) {
            return bestSequence;
        }

        return bestSequence.size() > solutions.size() ? bestSequence
                : solutions;
    }

}

package playground.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Try {


    public static class Position{
        private int pRow;
        private int pCol;

        public Position(int pRow, int pCol){
            this.pRow = pRow;
            this.pCol = pCol;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Position position = (Position) o;
            return pRow == position.pRow &&
                    pCol == position.pCol;
        }

        @Override
        public int hashCode() {
            return Objects.hash(pRow, pCol);
        }
    }

    public static void main(String[] args) {
        List<Position> positions = new ArrayList<>();
        Try.Position pos = new Position(0,0);
        Try.Position pos1 = new Position(1,2);
        Try.Position pos2 = new Position(3,3);
        Try.Position pos3 = new Position(3,3);

        positions.add(pos);
        positions.add(pos1);
        positions.add(pos2);
        positions.add(pos3);

        System.out.println(positions.contains(new Position(1,2)));
        System.out.println(positions.contains(pos1));

        List<int[]> n = new ArrayList<>();
        n.add(new int[]{1,2});

        String test = "awe";

        for(int k=0; k< test.length()-1; k++){
            String first = test.substring(0, k+1);
            String second = test.substring(k+1);
            System.out.println("First: " + first + " Second: " + second);
        }

        System.out.println(4 % (1000000000+7) + 4 % (1000000000+7));


    }
}

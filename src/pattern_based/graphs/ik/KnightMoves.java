package pattern_based.graphs.ik;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class KnightMoves {


    public int find_minimum_number_of_moves(int rows, int cols, int start_row, int start_col, int end_row, int end_col) {
        // Write your code here.

        int res = minMoveBFS(rows,cols, start_row, start_col, end_row, end_col);

        return res;
    }

    public int minMoveBFS(int rows, int cols, int start_row, int start_col, int end_row, int end_col){
        // perform BFS traversal from start until we reach end, and calculate distance along the way.
        // When we reach destincation return number of ops required to reach end.

        int [][] visited = new int[rows][cols];

        int num_hops = -1;
        Deque<Position> queue = new ArrayDeque<>();
        queue.offer(new Position(start_row, start_col));
        visited[start_row][start_col] = -1;
        while(!queue.isEmpty()){
            int qSize = queue.size();
            num_hops++;
            for(int i=0; i< qSize; i++){
                Position curr = queue.poll();
                if(curr.pRow == end_row && curr.pCol == end_col){
                    return num_hops;
                } else{
                    List<Position> neighbors = getNextPositions(curr.pRow, curr.pCol, rows, cols);

                    for(Position pos: neighbors){
                        if(visited[pos.pRow][pos.pCol] != -1){
                            visited[pos.pRow][pos.pCol] = -1;
                            queue.offer(pos);
                        }
                    }
                }
            }

        }

        return -1;
    }

    public static class Position{
        int pRow;
        int pCol;

        public Position(int pRow, int pCol){
            this.pRow = pRow;
            this.pCol = pCol;
        }

    }

    public static boolean isValid(Position pos, int rows, int cols){
        if((pos.pRow >= rows || pos.pCol >= cols) || (pos.pRow < 0 || pos.pCol < 0)){
            return false;
        }
        return true;
    }

    static List<Position> getNextPositions(int row, int col, int rows, int cols){

        List<Position> neighbors = new ArrayList<>();
        Position pos1 = new Position(row+2, col-1);
        if(isValid(pos1, rows, cols)){
            neighbors.add(pos1);
        }
        Position pos2 = new Position(row+2, col+1);
        if(isValid(pos2, rows, cols)){
            neighbors.add(pos2);
        }
        Position pos3 = new Position(row-2, col-1);
        if(isValid(pos3, rows, cols)){
            neighbors.add(pos3);
        }
        Position pos4 = new Position(row-2, col+1);
        if(isValid(pos4, rows, cols)){
            neighbors.add(pos4);
        }


        Position pos5 = new Position(row-1, col+2);
        if(isValid(pos5, rows, cols)){
            neighbors.add(pos5);
        }
        Position pos6 = new Position(row+1, col+2);
        if(isValid(pos6, rows, cols)){
            neighbors.add(pos6);
        }
        Position pos7 = new Position(row-1, col-2);
        if(isValid(pos7, rows, cols)){
            neighbors.add(pos7);
        }
        Position pos8 = new Position(row+1, col-2);
        if(isValid(pos8, rows, cols)){
            neighbors.add(pos8);
        }

        return neighbors;
    }

    public static void main(String[] args) {
        KnightMoves knightMoves = new KnightMoves();
        System.out.println(knightMoves.find_minimum_number_of_moves(5,5,0,0,4,1));
    }
}

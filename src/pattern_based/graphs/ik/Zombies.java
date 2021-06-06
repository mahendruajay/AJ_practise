package pattern_based.graphs.ik;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Zombies {

    /*
     * Complete the 'zombieCluster' function below.
     *
     * The function accepts STRING ARRAY as parameter.
     */
    public int zombieCluster(List<String> zombies) {
        // Write your code here

        int n = zombies.size();
        int m = zombies.get(0).length();

        char[][] grid = new char[n][m];
        for(int i=0; i< n; i++){
            String row = zombies.get(i);
            for(int j=0; j< row.length(); j++){
                grid[i][j] = row.charAt(j);
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println();


        boolean[][] visited = new boolean[n][m];

        int count = 0;

        for(int i=0; i<n; i++ ){
            for(int j=0; j< m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    dfs(i, j, n, m, grid, visited);
                    count++;
                }

            }



        }

        return count;


    }

    public void dfs(int row, int col, int rsize, int csize, char[][] grid, boolean[][] visited){
        visited[row][col] = true;
        List<int[]> neighbors = getNeighbors(row, col, rsize, csize);
        for(int[] neighbor : neighbors){
            int r = neighbor[0];
            int c = neighbor[1];
            if(!visited[r][c] && grid[r][c] == '1'){
                dfs(r,c,rsize,csize,grid,visited);
            }
        }
    }

    public List<int[]> getNeighbors(int row, int col, int rsize, int csize){
        List<int[]> neighbors = new ArrayList<>();
        int[][] offsets = {{-1,0}, {1, 0}, {0, -1}, {0, 1}};

        for(int i=0; i< offsets.length; i++){
            int nRow = row + offsets[i][0];
            int nCol = col + offsets[i][1];
            if((nRow >= 0 && nRow < rsize) && (nCol >=0 && nCol < csize)){
                neighbors.add(new int[]{nRow, nCol});
            }
        }

        return neighbors;
    }

    public static void main(String[] args) {

        Zombies zombies = new Zombies();
        List<String> inp = Arrays.asList(new String[]{
                "110000",
                "010111",
                "011101",
                "100001"});

        int res = zombies.zombieCluster(inp);
        System.out.println(res);
    }


}

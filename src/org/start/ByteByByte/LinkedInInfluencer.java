package org.start.ByteByByte;

public class LinkedInInfluencer {

    public static int getInfluencer(boolean[][] M) {
        int cand = 0;
        for (int i = 1; i < M.length; i++) {
            if (M[cand][i] || !M[i][cand]) {
                cand = i;
            }
        }
        // now verify cand is indeed an influencer
        for (int j = 0; j < M.length; j++) {
            if (j == cand) continue;
            if (M[cand][j] || !M[j][cand]) return -1;
        }
        return cand;
    }

    public static void main(String[] args) {
        boolean[][] mat = {
                {false, true, true, false},
                {false, false, false, false},
                {false, true, false, false},
                {true, true, true, false}};

        int res = getInfluencer(mat);
        System.out.println("Result is: " + res);
    }


}

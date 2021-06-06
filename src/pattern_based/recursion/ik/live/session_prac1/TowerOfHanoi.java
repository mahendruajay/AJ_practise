package pattern_based.recursion.ik.live.session_prac1;

public class TowerOfHanoi {

    public static void main(String[] args) {
        TowerOfHanoi towerOfHanoi = new TowerOfHanoi();
        towerOfHanoi.towerOfHanoi(3);

    }

    public void towerOfHanoi(int n) {
        towerOfHanoiHelper(3, 1, 3, 2);
    }

    public void towerOfHanoiHelper(int n, int src, int dst, int buff) {
        if (n == 1) {
            System.out.println("Move disk from " + src + " to " + dst);
        } else {
            towerOfHanoiHelper(n - 1, src, buff, dst);
            System.out.println("Move disk from " + src + " to " + dst);
            towerOfHanoiHelper(n - 1, buff, dst, src);
        }
    }
}

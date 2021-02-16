package uplevel.sorting;

public class DutchFlag {
    public static void main(String[] args) {
        char[] input = {'G','B','G','G','R','B','R','G'};
//        dutch_flag_sort(input);
        dutchFlag3WayPartitioning(input);
        System.out.println(input);

    }

    public static void dutchFlag3WayPartitioning(char[] balls){
        int start = 0;
        int mid =0;
        int end = balls.length-1;

        while(mid<=end){
            if(balls[mid] == 'R'){
                char temp = balls[mid];
                balls[mid] = balls[start];
                balls[start] = temp;

                start++;
                mid++;
            } else if(balls[mid] == 'G'){
                mid++;
            }
            else {
                char temp = balls[mid];
                balls[mid] = balls[end];
                balls[end] = temp;
                end--;
            }
        }

    }

    public static void dutch_flag_sort(char[] balls) {

        int r = -1;
        int g = -1;
        int b = -1;

        for(int i=0; i< balls.length; i++){

            // case R
            if(balls[i] == 'R'){
                if(r == -1){
                    r = 0;
                    balls[r] = 'R';
                }
                else{
                    r = r+1;
                    balls[r] = 'R';
                }
                if(g != -1){
                    g = g+1;
                    balls[g] = 'G';
                }
                if(b != -1){
                    b = b+1;
                    balls[b] = 'B';
                }
                continue;
            }

            // case G
            if(balls[i] == 'G'){

                if(g == -1 && r == -1){
                    g = 0;
                    balls[g] = 'G';
                }
                else if(g == -1 && r != -1){
                    g = r+1;
                    balls[g] = 'G';
                }
                else{
                    g = g+1;
                    balls[g] = 'G';
                }

                if(b != -1){
                    b = b+1;
                    balls[b] = 'B';
                }
                continue;
            }

            // case B
            if(balls[i] == 'B'){
                if(b == -1 && g!= -1){
                    b = g+1;
                    balls[b] = 'B';
                }
                else if (b == -1 && r != -1){
                    b = r+1;
                    balls[b] = 'B';
                }
                else if(b == -1 && r == -1 && g == -1){
                    b = 0;
                    balls[b] = 'B';
                }
                else{
                    b = b+1;
                    balls[b] = 'B';
                }

            }

        }

    }
}

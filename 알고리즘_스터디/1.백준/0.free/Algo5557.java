
import java.util.Scanner;

public class Main {

    static int N;
    static int[] array;
    static long[][] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        array = new int[N];
        dp = new long[N][21];
        for(int i=0;i<N;i++){
            array[i] = sc.nextInt();
        }

        dp[0][array[0]] = 1;
        for(int i=1;i<N-1;i++){
            int num = array[i];
            for(int j=0;j<21;j++){
                if(dp[i-1][j] != 0){
                    if(j+num<=20 && j+num>=0){
                        dp[i][j+num]+=dp[i-1][j];
                    }
                    if(j-num<=20 && j-num>=0){
                        dp[i][j-num]+=dp[i-1][j];
                    }
                }
            }
        }

//        for(int i=0;i<N;i++){
//            for(int j=0;j<21;j++){
//                System.out.print(dp[i][j]+ " ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[N-2][array[N-1]]);
    }

}

import java.util.Arrays;
import java.util.Scanner;

public class Main {

    static int N;
    static int[] dp;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        dp = new int[N+1];

        for(int i=1;i<=N;i++){
            dp[i] = sc.nextInt();
        }

        for(int i=1;i<=N;i++){
            for(int j=1;j<i;j++) {
                dp[i] = Math.max(dp[j] + dp[i - j], dp[i]);
            }
        }

        System.out.println(dp[N]);


    }
}

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Algo12865 {
    static int pi(String a) {
        return Integer.parseInt(a);
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] a = br.readLine().split(" ");

        int N = pi(a[0]), K = pi(a[1]), thing[][] = new int[N+1][2], dp[][] = new int[N+1][K+1];
        for(int i=1; i<N+1; ++i) {
            a = br.readLine().split(" ");

            thing[i][0] = pi(a[0]);
            thing[i][1] = pi(a[1]);
        }

        for(int i=1; i<N+1; ++i) {
            for(int j=1; j<K+1; ++j) {
                dp[i][j] = dp[i-1][j];
                if(j - thing[i][0]>=0) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-thing[i][0]]+thing[i][1]);
                }
            }
        }
        System.out.println(dp[N][K]);

    }
}
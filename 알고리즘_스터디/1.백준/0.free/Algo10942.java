import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;

public class Main {
    static int N,M;
    static int[] array;
    static boolean[][] dp;
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
;
        array = new int[N+1];
        dp = new boolean[N+1][N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1;i<=N;i++){
            array[i] = Integer.parseInt(st.nextToken());
            dp[i][i] = true;
        }

        for(int x=1;x<=N;x++){
            for(int y=1;y<=N;y++){
                int dx = y+x;// 2,3,4, ....  3,4,5 ......
                if(dx>N) break;

                if(array[y] == array[dx]){
                    if(dp[y+1][dx-1]) dp[y][dx] = true;
                    else if(dx-y == 1) dp[y][dx] = true;
                }else dp[y][dx] = false;
            }
        }
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        for(int tc=0;tc<M;tc++){
            st = new StringTokenizer(br.readLine());
            int one = Integer.parseInt(st.nextToken());
            int two = Integer.parseInt(st.nextToken());

            if(dp[one][two]) bw.write(1 + "\n");
            else bw.write(0 + "\n");
        }
        bw.flush();
        bw.close();
    }



}

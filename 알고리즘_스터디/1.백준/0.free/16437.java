import java.io.*;
import java.util.StringTokenizer;
import java.util.ArrayList;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static int[] cnt;
    static ArrayList<Integer>[] adj;

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        cnt = new int[N+1];
        adj = new ArrayList[N+1];
        for(int i=0; i<N+1; i++)
            adj[i] = new ArrayList<Integer>();
        for(int i = 2; i <= N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int sh = 1;
            if(st.nextToken().charAt(0) == 'W') sh = -1; //늑대는 음수
            cnt[i] = Integer.parseInt(st.nextToken())*sh; // 몇마리
            int parent = Integer.parseInt(st.nextToken());
            adj[parent].add(i);
        }
        br.close();
        sb.append(treedp(1)).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
    static long treedp(int root){
        long ret = 0;
        for(int i = 0 ;i < adj[root].size(); ++i){
            ret += treedp(adj[root].get(i));
        }
        return ret+cnt[root] > 0? ret+cnt[root] : 0;
    }
}

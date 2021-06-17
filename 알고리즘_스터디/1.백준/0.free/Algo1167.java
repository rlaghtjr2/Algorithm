import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge>{
        int next;
        int dist;
        Edge(){ }
        Edge( int n, int d){
            this.next = n;
            this.dist = d;
        }

        @Override
        public int compareTo(Edge o) {
            return this.dist - o.dist;
        }
    }
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static boolean[] visit ;
    static int[] dist;
    static ArrayList<Edge> edges[];
    static PriorityQueue<Edge> pq = new PriorityQueue<>(Collections.reverseOrder());

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        dist = new int[N+1];
        visit = new boolean[N+1];
        edges = new ArrayList[N+1];
        for(int i=0; i<N+1; i++)
            edges[i] = new ArrayList<Edge>();
        for(int i = 0; i < N; ++i){
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int now = Integer.parseInt(st.nextToken());
            while(st.hasMoreTokens()){
                int nxt = Integer.parseInt(st.nextToken());
                if(nxt == -1) break;
                int d = Integer.parseInt(st.nextToken());
                edges[now].add(new Edge(nxt, d));
            }
        }
        br.close();
        Arrays.fill(dist,Integer.MAX_VALUE);
        dijkstra(1);

        int idx = getIdx().get(0);
        Arrays.fill(dist, Integer.MAX_VALUE);
        dijkstra(idx);
        int mxd = getIdx().get(1);
        sb.append(mxd).append('\n');
        bw.write(sb.toString());
        bw.flush();
    }
    static ArrayList<Integer> getIdx(){
        int idx = -1;
        int mxd = -1;
        for(int i = 0; i < dist.length; ++i){
            if(dist[i] == Integer.MAX_VALUE) continue;
            if(mxd < dist[i]){
                idx = i;
                mxd = dist[i];
            }
        }
        ArrayList<Integer> al = new ArrayList<>();
        al.add(idx);
        al.add(mxd);
        return al;
    }
    static void dijkstra(int root) {
        int ret = -1;
        dist[root] = 0;
        pq.add(new Edge(root, dist[root]));
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            int dis = e.dist;
            int nxt = e.next;
            dist[nxt] = dis;
            if (dist[nxt] < dis) continue;

            for (int i = 0; i < edges[nxt].size(); ++i) {
                Edge ed = edges[nxt].get(i);
                if (dist[ed.next] > dis + ed.dist) {
                    dist[ed.next] = dis + ed.dist;
                    pq.add(new Edge(ed.next, dist[ed.next]));
                }
            }

        }
    }
    
}

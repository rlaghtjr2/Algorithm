import java.util.Arrays;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
	int start;
	int end;
	int weight;

	Edge(int _start, int _end, int _weight) {
		start = _start;
		end = _end;
		weight = _weight;
	}

	@Override
	public int compareTo(Edge o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
}

public class Algo14621 {
	static int N, M,sum;
	static String[] s;
	static Edge[] edges;
	static int[] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.next());
		M = Integer.parseInt(sc.next());

		s = new String[N + 1];
		edges = new Edge[M];
		v = new int[N+1];
		
		
		for (int i = 1; i <= N; i++) {
			s[i] = sc.next();
			v[i] = i;
		}

		for (int i = 0; i < M; i++) {
			int start = Integer.parseInt(sc.next());
			int end = Integer.parseInt(sc.next());
			int weight = Integer.parseInt(sc.next());
			

			Edge edge = new Edge(start,end,weight);
			
			edges[i] = edge;
		}
		
		Arrays.sort(edges);
		
		for(int i=0;i<M;i++) {
			Edge e = edges[i];
			
			if(s[e.start].equals(s[e.end])) continue;
			
			int x = find(e.start);
			int y = find(e.end);
			
			if(x==y) continue;
			
			v[y] = x;
			sum+=e.weight;
		}
		int start = find(v[1]);
		for(int i=2;i<=N;i++) {
			if(start!=find(v[i])) {
				System.out.println(-1);
				System.exit(0);
			}
		}
		
		System.out.println(sum);
	}
	
	private static int find(int end) {
		if(v[end]==end) return end;
		
		return find(v[end]);
	}
}	

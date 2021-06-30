import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

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
public class Algo1647 {
	static int N,M,sum,max;
	static int[] v;
	static PriorityQueue<Edge> pq;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		max = Integer.MIN_VALUE;
		pq = new PriorityQueue<>();
		v = new int[N+1];
		for(int i=1;i<=N;i++) {
			v[i] = i;
		}
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			
			Edge edge = new Edge(start,end,weight);
			
			pq.add(edge);
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			
			int x = find(edge.start);
			int y = find(edge.end);
			
			if(x==y) continue;
			
			max = Math.max(max, edge.weight);
			union(x,y);
			sum+=edge.weight;
		}
		
		System.out.println(sum-max);
	}

	private static void union(int x, int y) {
		if(x<y) v[y] = x;
		else if(x>y) v[x] = y;
		
	}

	private static int find(int x) {
		if(v[x] == x) return x;
		return v[x] = find(v[x]);
	}

}

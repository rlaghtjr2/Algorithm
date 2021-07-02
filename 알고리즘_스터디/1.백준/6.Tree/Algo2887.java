import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
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
class Pair implements Comparable<Pair>{
	int start;
	int weight;
	
	Pair(int _start, int _weight){
		start = _start;
		weight = _weight;
	}

	@Override
	public int compareTo(Pair o) {
		// TODO Auto-generated method stub
		return weight - o.weight;
	}
	
	
}

public class Algo2887 {
	static int N,sum;
	static Pair[] x,y,z;
	static int[] v;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		
		x = new Pair[N];
		y = new Pair[N];
		z = new Pair[N];
		v = new int[N];
		
		pq = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			v[i] = i;
		}
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			x[i] = new Pair(i,Integer.parseInt(input[0]));
			y[i] = new Pair(i,Integer.parseInt(input[1]));
			z[i] = new Pair(i,Integer.parseInt(input[2]));
		}
		
		Arrays.sort(x);
		Arrays.sort(y);
		Arrays.sort(z);
		
		for(int i=0;i<N-1;i++) {
			Edge edgex = new Edge(x[i].start,x[i+1].start,Math.abs(x[i].weight-x[i+1].weight));
			Edge edgey = new Edge(y[i].start,y[i+1].start,Math.abs(y[i].weight-y[i+1].weight));
			Edge edgez = new Edge(z[i].start,z[i+1].start,Math.abs(z[i].weight-z[i+1].weight));
			
			pq.add(edgex);
			pq.add(edgey);
			pq.add(edgez);
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int x = find(edge.start);
			int y = find(edge.end);
			
			if(x==y) continue;
			
			union(x,y);
			sum+=edge.weight;
		}
		
		System.out.println(sum);
	}
	
	
	private static void union(int x2, int y2) {
		if(x2<y2) v[y2] = x2;
		else if(x2>y2) v[x2] = y2;
	}


	private static int find(int start) {
		if(v[start] == start) return start;
		return v[start] = find(v[start]);
	}

}

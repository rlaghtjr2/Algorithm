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
public class Algo16398 {
	static int N,line;
	static long sum;
	static int[] v;
	static PriorityQueue<Edge> pq;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		pq = new PriorityQueue<>();
		v = new int[N+1];
		for(int i=1;i<=N;i++) {
			v[i] = i;
		}
		
		for(int i=1;i<=N;i++) {
			input = br.readLine().split(" ");
			for(int j=i;j<N;j++) {
				Edge edge = new Edge(i,j+1,Integer.parseInt(input[j]));
				System.out.println(edge.start+" "+edge.end+" "+edge.weight);
				pq.add(edge);
			}
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			int x = find(edge.start);
			int y = find(edge.end);
			
			if(x==y) continue;
			
			union(x,y);
			sum+=edge.weight;
			line++;
			
			if(line==N-1) break;
		}
		
		System.out.println(sum);
	}
	
	
	public static void union(int x, int y) {
		if(x<y) v[y] = x;
		else if(x>y) v[x] = y;
	}
	public static int find(int end) {
		if(v[end] == end) return end;
		
		return v[end] = find(v[end]);
	}
}

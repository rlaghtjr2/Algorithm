import java.util.Arrays;
import java.util.Scanner;
class Edge implements Comparable<Edge>{
	int start;
	int end;
	int weight;
	
	Edge(int _start, int _end, int _weight){
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
public class Algo1197 {
	static int V,E,sum;
	static Edge[] edges;
	static int[] v;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		V = sc.nextInt();
		E = sc.nextInt();
		
		edges = new Edge[E];
		v = new int[V+1];
		
		for(int i=1;i<=V;i++) {
			v[i] = i;
		}
		
		for(int i=0;i<E;i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			int weight = sc.nextInt();
			
			Edge edge = new Edge(start,end,weight);
			
			edges[i] = edge;
		}
		Arrays.sort(edges);
		
		for(int i=0;i<E;i++) {
			Edge e = edges[i];
			int x = find(e.start);
			int y = find(e.end);
			if(x==y) continue;
			
			union(x,y);
			sum+=edges[i].weight;
		}
		
		System.out.println(sum);
	}
	private static void union(int start, int end) {
		int x = find(start);
		int y = find(end);
		
		v[y] = x;
		
	}
	private static int find(int end) {
		if(v[end]==end) return end;
		
		return find(v[end]);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
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
public class Algo6497 {
	static int M,N,line,sum;
	static int[] v;
	static PriorityQueue<Edge> pq;
	static ArrayList<Integer> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		list = new ArrayList<>();
		while(true) {
			String[] input = br.readLine().split(" ");
			M = Integer.parseInt(input[0]);
			N = Integer.parseInt(input[1]);
			
			if(M==0 && N==0) break;
			
			pq = new PriorityQueue<>();
			v = new int[M];
			sum=0;
			
			for(int i=0;i<M;i++) {
				v[i] = i;
			}
			
			for(int i=0;i<N;i++) {
				input = br.readLine().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				int weight = Integer.parseInt(input[2]);
				
				Edge edge = new Edge(start,end,weight);
				
				pq.add(edge);
				sum+=weight;
			}
			
			
			while(!pq.isEmpty()) {
				Edge edge = pq.poll();
				int x = find(edge.start);
				int y = find(edge.end);
				
				if(x==y) continue;
				
				
				union(x,y);
				sum-=edge.weight;
			}
//			
//			System.out.println(sum);
			pq.clear();
			list.add(sum);
		}
		for(int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
		}
	}
	
	
	public static void union(int x, int y) {
		if(x<y) v[y] = x;
		else if(x>y) v[x] = y;
	}
	
	public static int find(int x) {
		if(v[x] == x) return x;
		
		return v[x] = find(v[x]);
	}
}

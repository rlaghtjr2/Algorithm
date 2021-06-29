import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
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

public class Algo2406 {
	static int N,M,line,weight;
	static int[] v;
	static PriorityQueue<Edge> pq;
	static ArrayList<Edge> list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		v = new int[N+1];
		pq = new PriorityQueue<>();
		list = new ArrayList<>();
		
		for(int i=1;i<=N;i++) {
			v[i] = i;
		}
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			
			int x = find(start);
			int y = find(end);
			
			if(x==y) continue;
			
			line++;
			union(x,y);
			
		}
		
		for(int i=1;i<=N;i++) {
			input = br.readLine().split(" ");
			if(i==1) continue;
			
			for(int j=i;j<N;j++) {
				Edge edge = new Edge(i,j+1,Integer.parseInt(input[j]));
				pq.add(edge);
			}
		}
		
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			int x = find(edge.start);
			int y = find(edge.end);
			
			if(x==y) continue;
			
			union(x,y);
			
			weight += edge.weight;
			list.add(edge);
			line++;
			if(line==N-2) break;
		}
		
		System.out.println(weight+" "+list.size());
		for(int i=0;i<list.size();i++) {
			Edge edge = list.get(i);
			System.out.println(edge.start+" "+edge.end);
		}
	}
	
	
	public static void union(int x, int y) {
		if(x<y) {
			v[y] = x;
		}else if(x>y){
			v[x] = y;
		}
	}
	public static int find(int end) {
		if(v[end] == end) return end;
		
		return v[end] = find(v[end]);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

class Node{
	int num;
	int weight;
	
	Node(int _num, int _weight){
		num = _num;
		weight = _weight;
	}
}
public class Algo1967 {
	static int N,ans;
	static List<Node>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[N+1];
		for(int i=0;i<=N;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<N-1;i++) {
			String[] input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight =Integer.parseInt(input[2]);
			
			graph[start].add(new Node(end,weight));
			graph[end].add(new Node(start,weight));
		}
		
		int node = dfs(-1);
//		System.out.println(node);
		int answer = dfs(node);
		System.out.println(answer);
	}
	
	public static int dfs(int num) {
		int sum = 0;
		int maxNode = 0;
		Stack<Node> stk = new Stack<>();
		boolean[] v = new boolean[N+1];
		if(num==-1) {
			stk.add(new Node(1,0));
			v[1] = true;
		}else {
			stk.add(new Node(num,0));
			v[num] = true;
		}
		
		while(!stk.isEmpty()) {
			Node current = stk.pop();
//			System.out.println(current.num+ " " + current.weight);
			v[current.num] = true;
			if(current.weight>sum) {
				sum = current.weight;
				maxNode = current.num;
			}
			
			for(Node next : graph[current.num]) {
				if(v[next.num]) continue;
				
				v[next.num] = true;
				stk.add(new Node(next.num,current.weight+next.weight));
			}
		}
//		System.out.println("A" + maxNode+" " +sum);
		
		if(num==-1) return maxNode;
		else return sum;
//		return sum;
	}
}

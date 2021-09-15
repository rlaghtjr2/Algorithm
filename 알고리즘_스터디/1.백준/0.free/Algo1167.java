import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Node{
	int num;
	int weight;
	
	Node(int _num, int _weight){
		num = _num;
		weight = _weight;
	}
}
public class Algo1167 {
	static int V;
	static List<Node>[] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		V = Integer.parseInt(br.readLine());
		
		graph = new ArrayList[V+1];
		for(int i=0;i<graph.length;i++) {
			graph[i] = new ArrayList<>();
		}
		
		for(int i=0;i<V;i++) {
			String[] input = br.readLine().split(" ");
			int current = Integer.parseInt(input[0]);
			for(int j=1;j<input.length;j=j+2) {
				int next = Integer.parseInt(input[j]);
				if(next==-1) break;
				int weight = Integer.parseInt(input[j+1]);
				
				graph[current].add(new Node(next,weight));
			}
		}
		
		int node = dfs(-1);
		int answer = dfs(node);
		System.out.println(answer);
	}
	public static int dfs(int num) {
		int sum = 0;
		int maxNode = 0;
		Stack<Node> stk = new Stack<>();
		boolean[] v = new boolean[V+1];
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

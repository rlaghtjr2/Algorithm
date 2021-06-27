import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Algo1238 {
	static int N;
	static ArrayList<Integer>[] list;
	static int[] degree,cost,result;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		
		list = new ArrayList[N+1];
		degree = new int[N+1];
		cost = new int[N+1];
		result = new int[N+1];
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			int time = sc.nextInt();
			cost[i] = time;
			while(true) {
				int num = sc.nextInt();
				if(num==-1) break;
				
				degree[i]++;
				list[num].add(i);
			}
		}
		
		topologicalSort();
		for(int i=1;i<=N;i++) {
			System.out.println(result[i]);
		}
	}
	
	static public void topologicalSort() {
		Queue<Integer> que = new LinkedList<>();
		
		for(int i=1;i<=N;i++) {
			result[i] = cost[i];
			if(degree[i] == 0) {
				que.add(i);
			}
		}
		
		while(!que.isEmpty()) {
			int node = que.poll();
			
			for(int i=0;i<list[node].size();i++) {
				int num = list[node].get(i);
				
				result[num] = Math.max(result[num], result[node]+cost[num]);
				degree[num]--;
				
				if(degree[num]==0) {
					que.add(num);
				}
			}
		}
	}
}

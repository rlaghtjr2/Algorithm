import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class Algo1707 {
	static int K,V,E;
	static List<Integer>[] list;
	static boolean[] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<K;tc++) {
			String[] input = br.readLine().split(" ");
			V = Integer.parseInt(input[0]);
			E = Integer.parseInt(input[1]);
			
			v = new boolean[V+1];
			list = new ArrayList[V+1];
			for(int i=0;i<=V;i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0;i<E;i++) {
				input = br.readLine().split(" ");
				int one = Integer.parseInt(input[0]);
				int two = Integer.parseInt(input[1]);
				
				list[one].add(two);
				list[two].add(one);
			}
			
			for(int i=1;i<=V;i++) {
				if(!v[i]) {
					boolean check = solve(i);
					
					if(!check) {
						System.out.println("NO");
						break;
					}
				}
				if(i==V) {
					System.out.println("YES");
				}
			}
		}
	}
	
	public static boolean solve(int num) {
		Queue<Integer> que = new LinkedList<>();
		int[] nodes = new int[V+1];
		
		que.add(num);
		nodes[num] = 1;
		v[num] = true;
		
		while(!que.isEmpty()) {
			int current = que.poll();
			v[current] = true;
			for(int next : list[current]) {
				if(v[next]) continue;
				if(nodes[next]==nodes[current]) {
					return false;
				}
				
				que.add(next);
				if(nodes[current]==1) {
					nodes[next] = 2;
				}else if(nodes[current]==2) {
					nodes[next] = 1;
				}
			}
		}
		
		return true;
	}
	

}

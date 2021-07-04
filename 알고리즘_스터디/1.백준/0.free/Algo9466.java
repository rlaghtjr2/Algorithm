import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo9466 {
	static int T,N,sum,start;
	static int[] students;
	static boolean[] cycle,visited;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		T = Integer.parseInt(input[0]);
		
		for(int tc = 0; tc<T ; tc ++) {
			input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			
			students = new int[N+1];
			cycle = new boolean[N+1];
			visited = new boolean[N+1];
			sum = 0;
		
			input = br.readLine().split(" ");
			for(int i=1;i<=N;i++) {
				students[i] = Integer.parseInt(input[i-1]);
				if(students[i] == i) {
					sum++;
					cycle[i] = true;
				}
			}
			
			for(int i=1;i<=N;i++) {
				if(!cycle[i]) check(i);
//				System.out.println(Arrays.toString(cycle));
				
					
					//System.out.println(Arrays.toString(finished));
					//System.out.println(Arrays.toString(cycle));
				
			}
			
			System.out.println(N-sum);
		}
		
	}
	
	public static void check(int now) {
		if(visited[now]) {
			cycle[now] = true;
			sum++;
		}else {
			visited[now] = true;
		}
		
		int next = students[now];
		if(!cycle[next]) {
			check(next);
		}
		
		visited[now] = false;
		cycle[now] =true;
		
	}
}

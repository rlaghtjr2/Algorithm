import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Algo16928 {
	static int N,M,x,y,u,v;
	static int[] ladder;
	static boolean[] check;
	static Queue<Integer> que;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		ladder = new int[101];
		check = new boolean[101];
		que = new LinkedList<>();
		for(int i=0;i<N;i++) {
			input = br.readLine().split(" ");
			int one = Integer.parseInt(input[0]);
			int two = Integer.parseInt(input[1]);
			
			ladder[one] = two;
		}
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			int one = Integer.parseInt(input[0]);
			int two = Integer.parseInt(input[1]);
			
			ladder[one] = two;
		}
		que.add(1);
		check[0] =  true;
		System.out.println(bfs()+1);
	}
	
	public static int bfs() {
		int answer = 0;
		while(!que.isEmpty()) {
			int queSize = que.size();
			for(int size=0;size<queSize;size++) {
				int current = que.poll();
				for(int i=1;i<=6;i++) {
					int next = current+i;
					
					if(ladder[next]!=0) next=ladder[next];
					
					if(next>=100) return answer;
					if(check[next]) continue;
					
					check[next] = true;
					que.add(next);
				}
			}
			answer++;
		}
		
		return answer;
	}

}

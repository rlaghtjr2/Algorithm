import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Algo2660 {
	static int N;
	static int[][] friends;
	static int[] scores;
	static ArrayList<Integer> list;
	static final int max = 251;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		
		friends = new int[N+1][N+1];
		scores = new int[N+1];
		list = new ArrayList<>();
		for(int i=0;i<=N;i++) {
			for(int j=0;j<=N;j++) {
				friends[i][j] = max;
			}
		}
		
		while(true) {
			input = br.readLine().split(" ");
			int one = Integer.parseInt(input[0]);
			int two = Integer.parseInt(input[1]);
			
			if(one == -1 && two == -1) break;
			
			friends[one][two] = 1;
			friends[two][one] = 1;
		}
		
		for(int k=1;k<=N;k++) {
			friends[k][k] = 1;
			for(int i=1;i<=N;i++) {
				for(int j=1;j<=N; j++) {
					if(friends[i][j]>friends[i][k]+friends[k][j]) {
						friends[i][j] = friends[i][k] + friends[k][j];
					}
				}
			}
		}
		
		int min = Integer.MAX_VALUE;
		
		for(int i=1; i<=N;i++) {
			for(int j=1;j<=N;j++) {
				scores[i] = Math.max(scores[i], friends[i][j]);
			}
			min = Math.min(min, scores[i]);
		}
		
		for(int i=1;i<=N;i++) {
			if(scores[i] == min) list.add(i);
		}
		
		System.out.println(min+" "+list.size());
		for(int i=0;i<list.size();i++) {
			System.out.print(list.get(i)+" ");
		}
	}

}

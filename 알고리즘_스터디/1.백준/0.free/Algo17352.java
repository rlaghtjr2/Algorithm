import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo17352 {
	static int N,ans1,ans2;
	static int[] parent;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		parent = new int[N+1];
		for(int i=0;i<N+1;i++) {
			parent[i] = i;
		}
		for(int i=0;i<N-2;i++) {
			String[] input = br.readLine().split(" ");
			
			int first = Integer.parseInt(input[0]);
			int second = Integer.parseInt(input[1]);
			
			union(first,second);
			
		}
		
		for(int i=2;i<N+1;i++) {
			if(find(1)!=find(i)) {
				System.out.println(1+" "+i);
				break;
			}
		}
	}
	
	public static int find(int x) {
		if(parent[x]==x) return x;
		
		return parent[x] = find(parent[x]);
	}
	
	public static void union(int x, int y) {
		x = find(x);
		y = find(y);
		
		if(x!=y) {
			if(x<y) parent[y] = x;
			else parent[x] = y;
		}
	}
}

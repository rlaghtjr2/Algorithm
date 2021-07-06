import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1043 {
	static int N,M;
	static int[] v;
	static int[] know;
	static int[][] partys;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		input = br.readLine().split(" ");
		know = new int[Integer.parseInt(input[0])];
		v = new int[N+1];
		partys = new int[M][M];
		
		for(int i=1;i<=N;i++) {
			v[i] = i;
		}
		for(int i=1;i<input.length;i++) {
			know[i-1] = Integer.parseInt(input[i]);
		}
		
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			
			if(Integer.parseInt(input[0])==0) continue;
			partys[i] = new int[Integer.parseInt(input[0])];
			int prev = Integer.parseInt(input[1]);
			int current;
			
			partys[i][0] = prev;
			for(int j=2;j<input.length;j++) {
				current = Integer.parseInt(input[j]);
				partys[i][j-1] = current;
				int x = find(prev);
				int y = find(current);
				
				union(x,y);
				prev = current;
				
			}
		}
		
		for(int i=0;i<partys.length;i++) {
			int[] party = partys[i];
			
			boolean flag = false;
			for(int j=0;j<party.length;j++) {
				int person = party[j];
				int findPerson = find(person);
				for(int k=0;k<know.length;k++) {
					int knowPeople = know[k];
					if(findPerson == find(knowPeople)) {
						flag = true;
						break;
					}
				}
				if(flag) break;
			}
			if(flag) M--;
		}
		
		System.out.println(M);
		
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

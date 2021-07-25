import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo14620 {
	static int N,answer;
	static int[][] map;
	static boolean[][] v;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		v = new boolean[N][N];
		answer = Integer.MAX_VALUE;
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		setFlower(0, 1, 1, 0);
		System.out.println(answer);
	}
	
	public static void setFlower(int cnt,int row, int column, int cost) {
		if(cnt == 3) {
			answer = Math.min(answer, cost);
			return;
		}
		
		for(int i=row;i<N-1;i++) {
			for(int j=1;j<N-1;j++) {
				if(i==row && j<column) 	continue;
				
				if(v[i][j]) continue;
				if(!check(i,j)) continue;
				
				bloom(i,j);
				setFlower(cnt+1,i,j,cost+getMoney(i,j));
				bloom(i,j);
			}
		}
	}
	
	public static boolean check(int row, int column) {
		if(v[row][column] || v[row-1][column] || v[row+1][column] || v[row][column-1]||
				v[row][column+1]) return false;
		return true;
	}
	public static void bloom(int row, int column) {
		v[row][column] = !v[row][column];
		v[row-1][column] = !v[row-1][column];
		v[row+1][column] = !v[row+1][column];
		v[row][column-1] = !v[row][column-1];
		v[row][column+1] = !v[row][column+1];
	}
	public static int getMoney(int row, int column) {
		return map[row][column]+map[row+1][column]+map[row-1][column]+map[row][column-1]+map[row][column+1];
	}
}

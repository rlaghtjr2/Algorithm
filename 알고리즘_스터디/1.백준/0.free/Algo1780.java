import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo1780 {
	static int N,minus,zero,one;
	static int[][] map;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(input[j]);
			}
		}
		
		solve(0,0,N);
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	private static void solve(int starty, int startx, int cnt) {
		int num = map[starty][startx];
		boolean isSet = true;
		for(int i=starty;i<starty+cnt;i++) {
			for(int j=startx;j<startx+cnt;j++) {
				if(num!=map[i][j]) {
					isSet = false;
					for(int k=0;k<3;k++) {
						for(int m=0;m<3;m++) {
							solve(starty+((cnt/3)*k),startx+((cnt/3)*m),cnt/3);
						}
					}
					break;
				}
			}
			if(!isSet) break;
		}
		if(isSet) {
//			System.out.println(starty+" "+startx+ " "+cnt);
			if(num==-1) minus++;
			else if(num==1) one++;
			else zero++;
		}
		
	}

}

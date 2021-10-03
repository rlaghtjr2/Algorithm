import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo6987 {
	static int[][] group;
	static int[][] check;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int tc=0;tc<4;tc++) {
			group = new int[6][3];
			check = new int[6][3];
			boolean isRunning = true;
			String[] input = br.readLine().split(" ");
			int cnt = 0;
			for(int i=0;i<6;i++) {
				for(int j=0;j<3;j++) {
					group[i][j] = Integer.parseInt(input[cnt]);
					cnt++;
				}
			}
			for(int i=0;i<6;i++) {
				int sum = 0;
				for(int j=0;j<3;j++) {
					sum+=group[i][j];
				}
				if(sum>=6) {
					isRunning = false;
					break;
				}
			}
			if(!isRunning) {
				System.out.print(0+" ");
				continue;
			}
			if(solve(0,0,1)) System.out.print(1+" ");
			else System.out.print(0+" ");
			
		}
	}
	
	public static boolean solve(int n, int team1, int team2) {
//		System.out.println(team1+" "+team2);
		boolean v = false;
		int nextTeam1 = 0;
		int nextTeam2 = 0;
		if(team1 == 5 && team2 == 6) {
			return true;
		}
		if(team2==5) {
			nextTeam1 = team1+1;
			nextTeam2 = nextTeam1+1;
		}else {
			nextTeam1 = team1;
			nextTeam2 = team2+1;
		}
		
		
		//team1이 이길떄 
		if(check[team1][0]<group[team1][0] && check[team2][2]<group[team2][2]) {
			check[team1][0]++;
			check[team2][2]++;
			v = v || solve(n+1,nextTeam1,nextTeam2);
			check[team1][0]--;
			check[team2][2]--;
		}
		if(v) return v;
		//비길떄
		if(check[team1][1]<group[team1][1] && check[team2][1]<group[team2][1]) {
			check[team1][1]++;
			check[team2][1]++;
			v = v || solve(n+1,nextTeam1,nextTeam2);
			check[team1][1]--;
			check[team2][1]--;
		}
		if(v) return v;
		//team1이 질때
		if(check[team1][2]<group[team1][2] && check[team2][0]<group[team2][0]) {
			check[team1][2]++;
			check[team2][0]++;
			v = v || solve(n+1,nextTeam1,nextTeam2);
			check[team1][2]--;
			check[team2][0]--;
		}
		return v;
	}
}

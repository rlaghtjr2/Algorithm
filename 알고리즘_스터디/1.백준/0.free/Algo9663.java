import java.util.Scanner;

public class Main {
	
	static int count;
	static int col[];
	static int n;
	
	static boolean isPossible(int level) {//열이 겹치거나 대각선에 퀸이 존재하거나 하면 false
		for(int i = 1; i<level; i++) {//퀸이 위치한 열이 겹칠때
			if(col[i] == col[level])
				return false;
		}
		
		for(int i =1; i<level; i++) {//퀸이 서로 대각선에 존재할때
			if(Math.abs(col[i]-col[level]) == level-i) {
				return false;
			}
		}
		return true;
	}

	
	static boolean setQueen(int level) {
		
		if(!isPossible(level)) {//퀸이 정상적인 위치에 존재하지 않으면 false
			return false;
		}
		
		else if(level == n) {//모든 행에 퀸을 배치하였을 경우 true
			count++;
			return true;
		}
		
		for(int i = 1; i<=n; i++) {
			col[level+1] = i; //열에 퀸을 배치한다
			setQueen(level+1); //다음 행에 퀸을 배치한다
			}
		return false;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); //n개의 퀸 입력
		col = new int[n+1];
		setQueen(0);
		System.out.println(count);
	}

}

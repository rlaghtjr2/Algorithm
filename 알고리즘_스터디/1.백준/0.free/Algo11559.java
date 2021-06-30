import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair{
	int y;
	int x;
	
	Pair(int y, int x){
		this.y = y;
		this.x = x;
	}
}
public class Algo11559 {
	
	static final int N = 12;
	static final int M = 6;
	static String[][] map;
	static String[][] check;
	static int answer;
	static int[] dx = {0,1,0,-1};
	static int[] dy = {1,0,-1,0};
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		map = new String[N][M];
		check = new String[N][M];
		for(int i=0;i<N;i++) {
			map[i] = sc.nextLine().split("");
		}
		setCheck();
//		print();
		while(bubble()) {
			answer++;
			drop();
			setCheck();
//			print();
		}
//		
//		bubble();
//		drop();
		
		
//		print();
		System.out.println(answer);
	}
	
	//check 배열 초기화 하는 함수 -> 현재 map과 똑같이 복사함.
	public static void setCheck() {
		for(int i=0;i<N;i++) {
			check[i] = Arrays.copyOfRange(map[i], 0,N);
		}
	}
	
	
	public static boolean bubble() {
		boolean v = false;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(!check[i][j].equals(".")) {
					if(bfs(new Pair(i,j))) {
						v = true;
					}
				}
			}
		}
		
		return v;
	}
	
	public static boolean bfs(Pair start) {
		boolean v = false;
		Queue<Pair> bfsQue = new LinkedList<>();
		Queue<Pair> allQue = new LinkedList<>();
		
		bfsQue.add(start);
		allQue.add(start);
		check[start.y][start.x]= "."; 
		while(!bfsQue.isEmpty()) {
			int queSize = bfsQue.size();
			
			for(int i=0;i<queSize;i++) {
				Pair p = bfsQue.poll();
				for(int j=0;j<4;j++) {
					int y = p.y+dy[j];
					int x = p.x+dx[j];
					
					
					if(y>=N || y<0 || x>=M || x<0) continue;
					if(check[y][x].equals(".") || !check[y][x].equals(map[p.y][p.x])) continue;
					
					bfsQue.add(new Pair(y,x));
					allQue.add(new Pair(y,x));
					
					check[y][x] = ".";
				}
			}
		}
		//allQue사이즈 4개이상일경우 터지게 됨으로, allQue에 있는 모든 Pair를꺼내서 빈공간으로 바꿔줌.
		if(allQue.size()>=4) {
			v = true;
			while(!allQue.isEmpty()) {
				Pair p = allQue.poll();
				map[p.y][p.x] = ".";
			}
		}
		
		return v;
	}
	
	
	public static void drop() {
		for(int j=0;j<M;j++) {
			for(int i=N-1;i>=0;i--) {
//				System.out.println(i+" "+j);
				//색깔만 내릴거니까 그공간이 빈공간일경우 패스 -> continue아닌경우 그공간이 색깔임
				if(map[i][j].equals(".")) continue;
				//색깔인데 그게 맨밑인경우는 패스 -> continue아닌경우 맨밑이아님
				if(i==N-1) continue;
				//색깔이면서 맨밑이아닌데, 밑에가 빈공간이 아닌경우 패스
				if(!map[i+1][j].equals(".")) continue;
				//색깔이면서 맨밑도아니고 밑에가 빈공간임
				map[i+1][j] = map[i][j]; // 하나 내려주고
				map[i][j] = "."; //내려준공간은 빈공간으로내림
				i+=2; // i를 두개 추가해줘서, 내린거부터 다시 시작 -> 하나가 -되니까 for문에서 2개추가해줘야함
//				print();
//				System.out.println(i+" "+j);
			}
		}
	}
	
	public static void print() {
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				System.out.print(map[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
	}
}

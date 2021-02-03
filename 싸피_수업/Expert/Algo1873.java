package expert;

import java.util.Scanner;

class Pair{
	int x;
	int y;
	public Pair() {
		x = 0;
		y = 0;
	}
	public Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	
	public int first() {
		return x;
	}
	
	public int second() {
		return y;
	}
	
}

public class Algo1873 {
	static int T,H,W,N;
	static String[][] map;
	static int[] dx = {0,-1,0,1};
	static int[] dy = {1,0,-1,0};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		T = Integer.parseInt(sc.nextLine());
		
		for(int tc = 1; tc<=T; tc++) {
			String[] nums = sc.nextLine().split(" ");
			
			H = Integer.parseInt(nums[0]);
			W = Integer.parseInt(nums[1]);
			
			map = new String[H][W];
			for(int i=0;i<H;i++) {
				String a = sc.nextLine();
				map[i] = a.split("");
			}
			
			N = Integer.parseInt(sc.nextLine());
			String[] inputs = sc.nextLine().split("");
			Pair start = new Pair();
			
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j].equals("<") || map[i][j].equals(">") ||
							map[i][j].equals("^") || map[i][j].equals("v")) {
						start = new Pair(i,j);
						break;
					}
				}
				if(start.first()!=0) {
					break;
				}
			}
			
			for(int i=0;i<inputs.length;i++) {
				start = input(inputs[i],start.first(),start.second());
			}
			
			System.out.print("#"+tc+" ");
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					System.out.print(map[i][j]);
				}
				System.out.println();
			}
		}
	}
	
	
	
	//방향을 숫자로 변환
	public static int toDirInt(String direction) {
		int num = 0;
		if(direction.equals("<")) {
			num = 1;
		}else if(direction.equals(">")) {
			num = 3;
		}else if(direction.equals("^")) {
			num = 2;
		}else {
			num = 0;
		}
		return num;
	}
	
	//맵에있는거 변환
	public static Pair changeDir(String inputs,int x, int y) {
		if(inputs.equals("U")) {
			map[x][y] = "^";
		}else if(inputs.equals("D")) {
			map[x][y] = "v";
		}else if(inputs.equals("L")) {
			map[x][y] = "<";
		}else if(inputs.equals("R")){
			map[x][y] = ">";
		}else {
			
		}
		return move(x,y);
	}
	
	//이동
	public static Pair move(int y, int x) {
		Pair start = new Pair(y,x);
		int dirY = dy[toDirInt(map[y][x])];
		int dirX = dx[toDirInt(map[y][x])];
		if(y+dirY>=H || y+dirY<0 || x+dirX>=W || x+dirX<0 
				||map[y+dirY][x+dirX].equals("#") || map[y+dirY][x+dirX].equals("-") 
				||map[y+dirY][x+dirX].equals("*")) {
			return start;
		}
		map[y+dirY][x+dirX] = map[y][x];
		map[y][x] = ".";
		
		start = new Pair(y+dirY,x+dirX);
		
		return start;
	}
	
	//슛
	public static void shoot(int y, int x) {
		int dirY = dy[toDirInt(map[y][x])];
		int dirX = dx[toDirInt(map[y][x])];
		
		while(true) {
			if(y+dirY>=H || y+dirY<0 || x+dirX>=W || x+dirX<0
					|| map[y+dirY][x+dirX].equals("#")) {
				break;
			}else if(map[y+dirY][x+dirX].equals("*")) {
				map[y+dirY][x+dirX] = ".";
				break;
			}
			 
			y+=dirY;
			x+=dirX;
		}
	}
	public static Pair input(String inputs,int y, int x) {
		Pair start = new Pair(y,x);
		if(!inputs.equals("S")) {
			start = changeDir(inputs, y, x);
		}else {
			shoot(y,x);
		}
		
		return start;
	}

	
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Robot{
	int y;
	int x;
	int dir;
	
	Robot(int _y, int _x, int _dir){
		y = _y;
		x = _x;
		dir = _dir;
	}
}
public class Algo2174 {
	static int A,B,N,M;
	static int dx[] = {0,1,0,-1};
	static int dy[] = {-1,0,1,0};
	static Robot robots[];
	static int[][] map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		B = Integer.parseInt(input[1]);
		input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		robots = new Robot[N+1];
		map = new int[B][A];
		
		for(int i=1;i<=N;i++) {
			input = br.readLine().split(" ");
			int dir = 0;
			if(input[2].equals("N")) dir = 0;
			else if(input[2].equals("E")) dir=1;
			else if(input[2].equals("S")) dir=2;
			else dir=3;
			robots[i] = new Robot(B-Integer.parseInt(input[1]),Integer.parseInt(input[0])-1,dir);	
			map[robots[i].y][robots[i].x] = i;
		}

		for(int tc=0;tc<M;tc++) {
			input = br.readLine().split(" ");
			int robotNum = Integer.parseInt(input[0]);
			String command = input[1];
			int repeat = Integer.parseInt(input[2]);
			for(int i=0;i<repeat;i++) {
				if(!moveRobot(robotNum,command)) {
					System.exit(0);
				}
			}
		}
		System.out.println("OK");
	}
	private static boolean moveRobot(int robotNum, String command) {
		if(command.equals("L")) {
			int dir = robots[robotNum].dir;
			if(dir==0) dir=3;
			else dir--;
			robots[robotNum].dir = dir;
		}else if(command.equals("R")) {
			int dir = robots[robotNum].dir;
			dir = (dir+1)%4;
			robots[robotNum].dir = dir;
		}else if(command.equals("F")) {
			int y = robots[robotNum].y;
			int x = robots[robotNum].x;
			int dir = robots[robotNum].dir;
			
			if(y+dy[dir]==B || y+dy[dir]<0 || x+dx[dir]==A || x+dx[dir]<0) {
				System.out.println("Robot "+robotNum+ " crashes into the wall");
				return false;
			}else if(map[y+dy[dir]][x+dx[dir]]!=0) {
				System.out.println("Robot "+robotNum+ " crashes into robot "+map[y+dy[dir]][x+dx[dir]]);
				return false;
			}
			
			map[y][x] = 0;
			map[y+dy[dir]][x+dx[dir]] = robotNum;
			robots[robotNum].y = y+dy[dir];
			robots[robotNum].x = x+dx[dir];
		}
		return true;
	}
}

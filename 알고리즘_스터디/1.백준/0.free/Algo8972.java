import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Pair {
	int y;
	int x;

	Pair(int _y, int _x) {
		y = _y;
		x = _x;
	}
}

public class Algo8972 {
	static boolean flag;
	static int R, C;
	static String[][] map;
	static String[] moving;
	static int[][] check;
	static int[] dx = { 0, -1, 0, 1, -1, 0, 1, -1, 0, 1 };
	static int[] dy = { 0, 1, 1, 1, 0, 0, 0, -1, -1, -1 };
	static Pair aduino;
	static Queue<Pair> madAduino;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		String[] size = sc.nextLine().split(" ");
		R = Integer.parseInt(size[0]);
		C = Integer.parseInt(size[1]);

		madAduino = new LinkedList<Pair>();

		map = new String[R][C];

		for (int i = 0; i < R; i++) {
			String[] s = sc.nextLine().split("");
			map[i] = s;
			for (int j = 0; j < s.length; j++) {
				if (s[j].equals("I"))
					aduino = new Pair(i, j);
				else if (s[j].equals("R"))
					madAduino.add(new Pair(i, j));
			}

		}

		moving = sc.nextLine().split("");

		for (int m = 0; m < moving.length; m++) {
			int direction = Integer.parseInt(moving[m]);
			check = new int[R][C];
			
			//chapter 1 - 종수 아두이노 옮기기.
			map[aduino.y][aduino.x] = ".";
			aduino = new Pair(aduino.y + dy[direction], aduino.x + dx[direction]);
			
			//chapter 2 - 종수 아두이노 옮긴칸에 미친 아두이노 있을경우 끝.
			if (map[aduino.y][aduino.x].equals("R")) {
				System.out.println("kraj " + (m + 1));
				System.exit(0);
			}

			map[aduino.y][aduino.x] = "I";
			//chapter 1,2 Finish
			
			// chapter 3 -미친 아두이노들 옮기기.
			int queSize = madAduino.size();

			for (int i = 0; i < queSize; i++) {
				int min = Integer.MAX_VALUE;

				Pair newAduino = new Pair(0, 0);
				Pair p = madAduino.poll();

				map[p.y][p.x] = ".";

				int aduinoY = aduino.y; //종수 아두이노 y
				int aduinoX = aduino.x; //종수 아두이노 x

				for (int j = 1; j <= 9; j++) {
					int y = p.y + dy[j]; // 미친아두이노 y
					int x = p.x + dx[j]; // 미친아두이노 x
					int dis = Math.abs(aduinoY - y) + Math.abs(aduinoX - x); // 거리
					if (y >= R || y < 0 || x >= C || x < 0)
						continue; // 맵밖일경우 컨티뉴

					if (dis < min) { // 거리가 최소거리보다 작은경우 업데이트
						min = dis;
						newAduino = new Pair(y, x);
					}
				}
				
				// chapter - 4
				if (map[newAduino.y][newAduino.x].equals("I")) {
					// 미친아두이노가 이동했는데 거기에 종수 아두이노있을경우 -> 게임짐
					System.out.println("kraj " + (m + 1));
					System.exit(0);
				}

				// check의 옮긴 미친아두이노 좌표에 추가를해줌.
				check[newAduino.y][newAduino.x]++;
			}
			
			// chapter - 5
			for (int i = 0; i < R; i++) {
				for (int j = 0; j < C; j++) {
					if (check[i][j] == 1) { //맵돌면서 1인경우 -> 그쪽으로간 미친아두이노 1개임 2개이상은 터진거.
						madAduino.add(new Pair(i, j));
						map[i][j] = "R";
					}
				}
			}
		}

		print();
	}

	public static void print() {
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
}

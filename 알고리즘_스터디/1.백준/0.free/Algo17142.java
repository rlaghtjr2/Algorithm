import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/* Ǯ�� ����
 * 1. ���̷���(2)�� ���� ���� virusList�� �ֱ�
 * 2. nCm �� �������� ��� ��쿡 ���� �ð� ���
 * 3. m�� �ݺ��ϸ� BFS�� ���̷��� Ȯ�� ó��
 */

// ���̷����� �ð��� ��ġ�� ����ϱ� ���� ��ü
class Pair {
	int x;
	int y;
	int time;
	
	public Pair(int x, int y, int level) {
		this.x = x;
		this.y = y;
		this.time = level;
	}
}

public class Algo17142 {
	
	static int N, M;
	static int[] picked; // ���� ������ ���

	static ArrayList<Pair> virusList = new ArrayList<>();
	
	static int[][] map;
	static boolean[][] isVisit;
	static int blank;		// ��ĭ ���
	
	static int[] dx = {-1,1,0,0};
	static int[] dy = {0,0,-1,1};
	
	static int min = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws Exception {
		
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]); // ������ ũ��
		M = Integer.parseInt(input[1]); // ���̷��� ����
		
		map = new int[N][N];
		
		// ==============
		//  * ������ �Է�
		// ==============
		for (int i = 0; i < N; i++) {
			input = br.readLine().split(" ");
			for (int j = 0; j < N; j++) {
				int num = Integer.parseInt(input[j]);
				
				map[i][j] = num;
				
				if(num == 2) {
					virusList.add(new Pair(i,j,1));
				}else if(num == 0) {
					blank++;			// ����ִ� ĭ(���̷����� ������ ��)�� ���� 
				}
			}
		}
		
		// ��ĭ ���� ��� �ٷ� ��
		if(blank == 0) {
			System.out.println(0);
			return;
		}
		
		// ���� ������ �����ϱ� ���� �迭
		picked = new int[M];
		
		// ���� + Ž�� ����
		combination(0, 0);
		
		// �� ��ä��� �׳� ���� ->
		if(min == Integer.MAX_VALUE) {
			System.out.println(-1);
			return;
		}
		
		System.out.println(min);
		
	}

	// cnt(������� ���� ��), cur(���� ����Ű�� ��ȣ)
	private static void combination(int cnt, int cur) {
		if(cnt == M) {
			BFS();		//������ �ϼ��Ǹ� Ž�� ����
			return;
		}
		
		for (int i = cur; i < virusList.size(); i++) {
			picked[cnt] = i;
			combination(cnt+1, i+1);
		}
	}

	private static void BFS() {
		Queue<Pair> q = new LinkedList<>();
		isVisit = new boolean[N][N];
		
		// ���� ����� ���̷��� ����Ʈ�� �����ؼ� Q�� ����
		for (int i = 0; i < M; i++) {
			q.add(virusList.get(picked[i]));
			isVisit[virusList.get(picked[i]).x][virusList.get(picked[i]).y] = true;
		}
		
		int time = 0;		// �ɸ� �ð� ���
		int count = 0;		// ��ĭ Ȯ�� ī����
		
		while(!q.isEmpty()) {
			Pair v = q.poll();
			
			for (int k = 0; k < 4; k++) {
				int nx = v.x + dx[k];
				int ny = v.y + dy[k];
				
				
				// ������ �ִ� ���̷����� �ð����� �޾ƿ��Ƿ� ��� ������ �� �ۿ� ����
				time = v.time;
				
				// ���� �� OR �̹� �湮 = �ƿ�
				if(!(0 <= nx && nx < N && 0 <= ny && ny < N) || isVisit[nx][ny]) continue;
				
				// ��ĭ�̾ Ȯ���� ���)
				if(map[nx][ny] == 0) {
					isVisit[nx][ny] = true;
					count++;
					q.add(new Pair(nx,ny,v.time+1));
				}
				
				// Ȯ���� �������� ������ �� �ִ� ���)
				if(map[nx][ny] == 2) {
					isVisit[nx][ny] = true;
					q.add(new Pair(nx,ny,v.time+1));
				}
				
			}
			
			// ���� �̹� ��ĭ�� ä�����ٸ� ������ �����Ŵ���ν� �ð����� ��� ������ ����
			if(count == blank) {
				time++;	// �̰��, ���� ���� �ð��� �Ҵ��� �ȵǹǷ�, ���Ƿ� 1 ����
				break;
			}
		};
	
		if(count != blank) return;	// �� ��ä��� �׳� ������
		
		// time-1�� ���� : �������� +1�� ���¸� q�� ������ ����
		min = Math.min(min, time-1);
	}

}
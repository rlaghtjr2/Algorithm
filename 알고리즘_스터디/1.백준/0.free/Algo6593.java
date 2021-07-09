import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
class Node implements Comparable<Node>{
	int x;
	int y;
	int z;
	
	Node(int _z, int _y, int _x){
		z = _z;
		x = _x;
		y = _y;
	}

	@Override
	public int compareTo(Node o) {
		return 0;
	}

	
}
public class Algo6593 {
	static int L,R,C;
	static boolean flag;
	static int[][][] dist;
	static char[][][] map;
	static boolean[][][] visit;
	static PriorityQueue<Node> pq;
	static Node start,end;
	static int[] dx = {0,0,0,1,0,-1};
	static int[] dy = {0,0,1,0,-1,0};
	static int[] dz = {1,-1,0,0,0,0};
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			String[] input = br.readLine().split(" ");
			L = Integer.parseInt(input[0]);
			R = Integer.parseInt(input[1]);
			C = Integer.parseInt(input[2]);
			flag = false;
			
			if(L==0 && R == 0 && C == 0) break;
			
			map = new char[L][R][C];
			dist = new int[L][R][C];
			visit = new boolean[L][R][C];
			pq = new PriorityQueue<Node>();
			for(int i=0;i<L;i++) {
				for(int j=0;j<R;j++) {
					input = br.readLine().split("");
					for(int k=0;k<input.length;k++) {
						map[i][j][k] = input[k].charAt(0);
						if(input[k].equals("S")) {
							start = new Node(i,j,k);
						}else if(input[k].equals("E")) {
							end = new Node(i,j,k);
						}
					}
					//Arrays.fill(dist[i][j], 10000000);
				}
				br.readLine();
			}
			
			dij();
			if(!flag) {
				System.out.println("Trapped!");
			}else {
				System.out.println("Escaped in "+dist[end.z][end.y][end.x]+" minute(s).");
			}
//			for(int i=0;i<L;i++) {
//				for(int j=0;j<R;j++) {
//					for(int k=0;k<C;k++) {
//						System.out.print(dist[i][j][k]+" ");
//					}
//					System.out.println();
//				}
//				System.out.println();
//			}
		}
	}
	
	public static void dij() {
		pq.add(start);
		dist[start.z][start.y][start.x] = 0;
		visit[start.z][start.y][start.x] = true;
		while(!pq.isEmpty()) {
			Node node = pq.poll();
			System.out.println(node.z+" "+node.y+" "+node.x);
			if(node.z == end.z && node.y == end.y && node.x == end.x) {
				flag = true;
				return;
			}
			for(int i=0;i<6;i++) {
				int nz = node.z+dz[i];
				int ny = node.y+dy[i];
				int nx = node.x+dx[i];
				
				if(nz>=L || nz<0 || ny>=R || ny<0 || nx>=C || nx<0) continue;
				if(visit[nz][ny][nx]) continue;
				if(map[nz][ny][nx]=='#') continue;
				
				dist[nz][ny][nx] = dist[node.z][node.y][node.x]+1;
				pq.add(new Node(nz,ny,nx));
				visit[nz][ny][nx] = true;
			}
		}
	}
}

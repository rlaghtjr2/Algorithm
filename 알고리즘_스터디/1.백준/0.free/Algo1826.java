import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
class Info implements Comparable<Info>{
	int dis;
	int oil;
	
	Info(int _dis, int _oil){
		dis = _dis;
		oil = _oil;
	}

	@Override
	public int compareTo(Info o) {
		if(dis>o.dis)return 1;
		else return -1;
	}
}
public class Algo1826 {
	static int N,L,P,ans;
	static Info[] infos;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		infos = new Info[N];
		pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			infos[i] = new Info(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
		}
		
		String[] input = br.readLine().split(" ");
		L = Integer.parseInt(input[0]);
		P = Integer.parseInt(input[1]);
		
		Arrays.sort(infos);
//		for(int i=0;i<N;i++) {
//			System.out.println(infos[i].dis+ " "+infos[i].oil);
//		}
		int idx = 0;
		int current = P;
		while(current<L) {
			for(int i=idx;i<N;i++) {
				if(infos[i].dis<=current) pq.add(infos[i].oil);
				else {
					idx = i;
					break;
				}
			}
			
			if(pq.isEmpty()) {
				System.out.println(-1);
				System.exit(0);
			}
			current += pq.poll();
			ans++;
		}
		System.out.println(ans);
	}

}

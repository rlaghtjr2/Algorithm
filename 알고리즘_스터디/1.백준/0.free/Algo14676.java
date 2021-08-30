import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;

public class Algo14676 {
	static int N,M,K;
	static int[] cnt,visit;
	static List<Integer>[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		K = Integer.parseInt(input[2]);
		
		list = new ArrayList[N+1];
		cnt = new int[N+1];
		visit = new int[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			list[Integer.parseInt(input[0])].add(Integer.parseInt(input[1]));
			cnt[Integer.parseInt(input[1])]++;
		}
		
		for(int i=0;i<K;i++) {
			input = br.readLine().split(" ");
			if(Integer.parseInt(input[0])==1) building(Integer.parseInt(input[1]));
			else destroy(Integer.parseInt(input[1]));
//			System.out.println(i);
//			System.out.println(Arrays.toString(cnt));
//			System.out.println(Arrays.toString(visit));
//			System.out.println("-------------------");
		}
		System.out.println("King-God-Emperor");
	}
	
	public static void building(int num) {
		if(cnt[num]!=0) {
			System.out.println("Lier!");
			System.exit(0);
		}
		if(visit[num]==0) {
			for(int i=0;i<list[num].size();i++) {
				int next = list[num].get(i);
				cnt[next]--;
			}
		}
		
		visit[num]++;
	}
	
	public static void destroy(int num) {
		if(visit[num]<=0) {
			System.out.println("Lier!");
			System.exit(0);
		}
		
		visit[num]--;
		if(visit[num]==0) {
			for(int i=0;i<list[num].size();i++) {
				int next = list[num].get(i);
				cnt[next]++;
			}
		}
	}
}

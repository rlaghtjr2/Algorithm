import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Algo2056 {
	static int N,maxTime;
	static Queue<Integer> que;
	static int[] time,cnt,ans; //ans 는 끝난시간 time은 소요시간
	static List<Integer>[] list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		que = new LinkedList<>();
		time = new int[N+1];
		list = new ArrayList[N+1];
		cnt = new int[N+1];
		ans = new int[N+1];
		for(int i=0;i<list.length;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=1;i<=N;i++) {
			String[] input = br.readLine().split(" ");
			time[i] = Integer.parseInt(input[0]);
			ans[i] = Integer.parseInt(input[0]);
			int size = Integer.parseInt(input[1]);
			
			for(int j=0;j<size;j++) {
				list[Integer.parseInt(input[j+2])].add(i);
				
			}
			cnt[i] += size;
			if(size==0) que.add(i);
		}
		wisang();
		for(int i=1;i<=N;i++) {
			maxTime = Math.max(maxTime, ans[i]);
		}
		System.out.println(maxTime);
	}
	
	
	public static void wisang() {
		
		while(!que.isEmpty()) {
			int current = que.poll();
//			System.out.println(current);
			for(int i=0;i<list[current].size();i++) {
				int next = list[current].get(i);
				cnt[next]--;
				ans[next] = Math.max(ans[next], ans[current]+time[next]);
				if(cnt[next]==0) que.add(next);
			}
		}
	}
}

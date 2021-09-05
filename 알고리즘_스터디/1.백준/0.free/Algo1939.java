import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Pair{
	int end;
	int weight;
	
	Pair(int _end, int _weight) {
		end = _end;
		weight = _weight;
	}
}
public class Algo1939 {
	static int N,M,start,end,min,max,ans;
	static boolean[] visit;
	static List<Pair>[] list;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		list = new ArrayList[N+1];
		
		for(int i=0;i<=N;i++) {
			list[i] = new ArrayList<>();
		}
		
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			int one = Integer.parseInt(input[0]);
			int two = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			max = Math.max(max, weight);
			list[one].add(new Pair(two,weight));
			list[two].add(new Pair(one,weight));
		
		}
		input = br.readLine().split(" ");
		start = Integer.parseInt(input[0]);
		end = Integer.parseInt(input[1]);
		min = 1;
		binarySearch();
		
		System.out.println(ans);
	}
	private static void binarySearch() {
		while(min<=max) {
			int mid = (max+min)/2;
			if(check(mid)) {
				ans = Math.max(ans, mid);
				min = mid+1;
			}else {
				max = mid-1;
			}
		}
	}
	private static boolean check(int mid) {
		visit = new boolean[N+1];
		Queue<Integer> que = new LinkedList<>();
		que.add(start);
		visit[start] = true;
		while(!que.isEmpty()) {
			int p = que.poll();
			for(int i=0;i<list[p].size();i++) {
				Pair pair = list[p].get(i);
				if(pair.weight<mid) continue;
				if(visit[pair.end]) continue;
				
				if(pair.end == end) return true;
				
				visit[pair.end] = true; 
				que.add(pair.end);
			}

			
		}
		return false;
	}

}

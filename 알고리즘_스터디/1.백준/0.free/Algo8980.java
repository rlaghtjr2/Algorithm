import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Info implements Comparable<Info>{
	int start;
	int end;
	int weight;
	
	Info(int _start, int _end, int _weight){
		start = _start;
		end = _end;
		weight = _weight;
	}

	@Override
	public int compareTo(Info o) {
		if(end>o.end) return 1;
		else return -1;
	}
}
public class Algo8980 {
	static int N,C,M,ans;
	static Info[] infos;
	static int[] v;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		
		N = Integer.parseInt(input[0]);
		C = Integer.parseInt(input[1]);
		
		M = Integer.parseInt(br.readLine());
		
		infos = new Info[M];
		v = new int[N+1];
		Arrays.fill(v, C);
		for(int i=0;i<M;i++) {
			input = br.readLine().split(" ");
			int start = Integer.parseInt(input[0]);
			int end = Integer.parseInt(input[1]);
			int weight = Integer.parseInt(input[2]);
			
			infos[i] = new Info(start,end,weight);
		}
		
		Arrays.sort(infos);
		
		for(int i=0;i<M;i++) {
			int start = infos[i].start;
			int end = infos[i].end;
			int weight = infos[i].weight;
			int min = Integer.MAX_VALUE;
			for(int j=start;j<end;j++) {
				min = Math.min(min, v[j]);
			}
			
			min = Math.min(min, weight);
			for(int j=start;j<end;j++) {
				v[j] -= min;
			}
			ans+=min;
		}
		System.out.println(ans);
//		for(int i=0;i<M;i++) {
//			System.out.println(infos[i].start+" "+infos[i].end+" "+infos[i].weight);
//		}
	}

}

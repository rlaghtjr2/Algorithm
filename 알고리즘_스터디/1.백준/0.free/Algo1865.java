import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Road{
	int end;
	int weight;
	
	Road(int _end, int _weight){
		end = _end;
		weight = _weight;
	}
}
public class Algo1865 {
	static int T,N,M,W;
	static int[] dist;
	static List<Road>[] list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			M = Integer.parseInt(input[1]);
			W = Integer.parseInt(input[2]);
			
			dist = new int[N+1];
			list = new ArrayList[N+1];
			
			for(int i=0;i<=N;i++) {
				list[i] = new ArrayList<>();
			}
			
			for(int i=0;i<M+W;i++) {
				input = br.readLine().split(" ");
				int start = Integer.parseInt(input[0]);
				int end = Integer.parseInt(input[1]);
				int weight = Integer.parseInt(input[2]);
				
				if(i<M) {
					list[start].add(new Road(end,weight));
					list[end].add(new Road(start,weight));
				}else {
					list[start].add(new Road(end, -weight));
				}
			}
			
			boolean c = false;
			
			for(int i=1;i<=N;i++) {
				if(bellmanFord(i)) {
					c = true;
					System.out.println("YES");
					break;
				}
			}
			
			if(!c) {
				System.out.println("NO");
			}
		}
	}
	
	private static boolean bellmanFord(int start) {
		Arrays.fill(dist,5000000);
		dist[start] = 0;
		
		boolean u = false;
		for(int i=1;i<N;i++) {
			
			u = false;
			for(int j=1;j<=N;j++) {
				for(Road road : list[j]) {
					if(dist[j] != 5000000 && dist[road.end]>dist[j]+road.weight) {
						dist[road.end]= dist[j] + road.weight;
						u = true;
					}
				}
			}
			
			if(!u) break;
		}
		
		if (u) {
            for (int i = 1; i <= N; i++) {
                for (Road road : list[i]) {
                    if (dist[i] != 5000000 && dist[road.end] > dist[i] + road.weight) {
                        return true;
                    }
                }
            }
        }
		
		return false;
	}
}

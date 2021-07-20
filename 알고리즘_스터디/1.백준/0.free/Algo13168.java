import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;

public class Algo13168 {
	static final int max = 1000000000;
	static int N,R,M,K;
	static int noSum, sum;
	static String[] goCity;
	static float[][] noTicket, ticket;
	static HashMap<String,Integer> map;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		R = Integer.parseInt(input[1]);
		
		map = new HashMap<>();
		
		input = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			map.put(input[i], i);
		}
		
		M = Integer.parseInt(br.readLine());
		goCity = br.readLine().split(" ");
		
		K= Integer.parseInt(br.readLine());
		
		noTicket = new float[N][N];
		ticket = new float[N][N];
		for(int i=0;i<N;i++) {
			Arrays.fill(noTicket[i], max);
			Arrays.fill(ticket[i], max);
		}
		for(int i=0;i<K;i++) {
			input = br.readLine().split(" ");
			int startIndex = map.get(input[1]);
			int endIndex = map.get(input[2]);
			float cost = Integer.parseInt(input[3]);
			String trans = input[0];
			
			if(noTicket[startIndex][endIndex]>cost) noTicket[startIndex][endIndex] = cost;
			if(noTicket[endIndex][startIndex]>cost) noTicket[endIndex][startIndex] = cost;
			if(trans.equals("Mugunghwa") || trans.equals("ITX-Saemaeul") ||
					trans.equals("ITX-Cheongchun")) {
				ticket[startIndex][endIndex] = 0;
				ticket[endIndex][startIndex] = 0;
			}else if(trans.equals("S-Train") || trans.equals("V-Train")) {
				if(ticket[startIndex][endIndex]>cost/2) ticket[startIndex][endIndex] = cost/2;
				if(ticket[endIndex][startIndex]>cost/2) ticket[endIndex][startIndex] = cost/2;
				
			}else {
				if(ticket[startIndex][endIndex]>cost) ticket[startIndex][endIndex] = cost;
				if(ticket[endIndex][startIndex]>cost) ticket[endIndex][startIndex] = cost;
			}
		}
		
		
		floydWarshall(noTicket);
		floydWarshall(ticket);
		
		if(getSum(noTicket)>getSum(ticket)+R) {
			System.out.println("Yes");
		}else {
			System.out.println("No");
		}
	}
	
	
	public static void floydWarshall(float[][] graph) {
		for(int k=0;k<N;k++) {
			graph[k][k] = 0 ;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					if(graph[i][j]>graph[i][k]+graph[k][j]) {
						graph[i][j] = graph[i][k]+graph[k][j];
					}
				}
			}
		}
	}
	
	public static float getSum(float[][] graph) {
		float sum = 0;
		int currentIndex = map.get(goCity[0]);
		int nextIndex = 0;
		for(int i=1;i<goCity.length;i++) {
			nextIndex = map.get(goCity[i]);
			
			sum += graph[currentIndex][nextIndex];
			currentIndex = nextIndex;
		}
		return sum;
		
	}
}

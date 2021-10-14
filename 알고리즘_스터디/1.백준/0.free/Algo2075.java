import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;

public class Algo2075 {
	static int N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new  BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		pq = new PriorityQueue<>(Collections.reverseOrder());
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			
			for(int j=0;j<N;j++) {
				pq.add(Integer.parseInt(input[j]));
			}
		}
		
		for(int i=0;i<N;i++) {
			if(i==N-1) System.out.println(pq.poll());
			else pq.poll();
		}
	}

}

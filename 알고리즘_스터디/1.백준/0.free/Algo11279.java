import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Algo11279 {
	static int N;
	static PriorityQueue<Integer> pq;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		pq = new PriorityQueue<>(Collections.reverseOrder());
		
		N = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine());
			
			if(num!=0) pq.add(num);
			else {
				if(pq.isEmpty()) bw.write("0\n");
				else bw.write(Integer.toString(pq.poll())+"\n");
			}
		}
		
		bw.flush();
		bw.close();
	}

}

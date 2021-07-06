import java.io.*; 
import java.util.*;

public class Algo11728 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); StringBuilder sb = new StringBuilder(); 
		PriorityQueue<Integer> pq = new PriorityQueue<>(); 
		br.readLine(); 
		
		Arrays.stream((br.readLine() + " " + br.readLine()).split(" ")).
		mapToInt(Integer::parseInt).forEach(pq::offer); 
		
		while (!pq.isEmpty()) {
			sb.append(pq.poll() + " "); 
		}
		
		System.out.print(sb);

		
	}

}

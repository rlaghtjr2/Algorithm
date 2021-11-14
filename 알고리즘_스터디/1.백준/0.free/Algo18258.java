import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;

public class Algo18258 {
	static int N;
	static Deque<Integer> deq;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		deq = new ArrayDeque<>();
		N = Integer.parseInt(br.readLine());
		
		for(int t=0;t<N;t++) {
			String[] command = br.readLine().split(" ");
			
			if(command[0].equals("push")) {
				deq.add(Integer.parseInt(command[1]));
			}else if(command[0].equals("pop")) {
				if(deq.isEmpty()) bw.write("-1");
				else bw.write(String.valueOf(deq.pollFirst()));
			}else if(command[0].equals("size")) {
				bw.write(String.valueOf(deq.size()));
			}else if(command[0].equals("empty")) {
				if(deq.isEmpty()) bw.write("1");
				else bw.write("0");
			}else if(command[0].equals("front")) {
				if(deq.isEmpty()) bw.write("-1");
				else bw.write(String.valueOf(deq.peekFirst()));
			}else if(command[0].equals("back")) {
				if(deq.isEmpty()) bw.write("-1");
				else bw.write(String.valueOf(deq.peekLast()));
			}
			if(!command[0].equals("push")) bw.write("\n");
		}
		
		bw.flush();
		bw.close();
	}

}

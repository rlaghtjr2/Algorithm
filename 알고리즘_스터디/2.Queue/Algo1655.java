package acmpic;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class Algo1655 {
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine().split(" ")[0]);
		
		
		Queue<Integer> prev = new PriorityQueue<>(Collections.reverseOrder());
		Queue<Integer> next = new PriorityQueue<>();
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(br.readLine().split(" ")[0]);
			
			if(prev.size()==0) {
				prev.add(num);
			}else if(prev.size()==next.size()) {
				prev.add(num);
				if(prev.peek()>next.peek()) {
					next.add(prev.poll());
					prev.add(next.poll());
				}
			}else if(prev.size()!=next.size()) {
				next.add(num);
				if(prev.peek()>next.peek()) {
					next.add(prev.poll());
					prev.add(next.poll());
				}
			}
			
			String s = String.valueOf(prev.peek());
			bw.write(s+"\n");
		}
		bw.flush();
		bw.close();
		br.close();
	}

}

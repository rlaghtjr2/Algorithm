import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Algo10845 {
	static int N,back;
	static Queue<Integer> que;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		que = new LinkedList<>();
		for(int i=0;i<N;i++) {
//			System.out.println("A" + i);
			String[] input = br.readLine().split(" ");
			if(input[0].equals("push")) {
				que.add(Integer.parseInt(input[1]));
				back = Integer.parseInt(input[1]);
			}else if(input[0].equals("pop")) {
				if(!que.isEmpty()) {
					System.out.println(que.poll());
				}else {
					System.out.println(-1);
				}
			}else if(input[0].equals("size")) {
				System.out.println(que.size());
			}else if(input[0].equals("empty")) {
				if(que.isEmpty()) System.out.println(1);
				else System.out.println(0);
			}else if(input[0].equals("front")) {
				if(!que.isEmpty()) System.out.println(que.peek());
				else System.out.println(-1);
			}else {
				if(que.isEmpty()) System.out.println(-1);
				else System.out.println(back);
			}
		}
	}

}

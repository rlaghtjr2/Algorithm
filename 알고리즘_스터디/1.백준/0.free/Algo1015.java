import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


public class Algo1015 {
	static int N;
	static int[] nums;
	static Queue<Integer> que;
	static Queue<Integer>[] queList;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		nums = new int[N];
		String[] input = br.readLine().split(" ");
		
		que = new LinkedList<>();
		queList = new Queue[1001];
		
		for(int i=0;i<1001;i++) {
			queList[i] = new LinkedList<>();
		}
		
		for(int i=0;i<N;i++) {
			int num = Integer.parseInt(input[i]);
			nums[i] = num;
			que.add(num);
		}
		
		Arrays.sort(nums);
		
		for(int i=0;i<N;i++) {
			queList[nums[i]].add(i);
		}
		
		while(!que.isEmpty()) {
			int num = que.poll();
			
			System.out.print(queList[num].poll()+" ");
		}
	}

}

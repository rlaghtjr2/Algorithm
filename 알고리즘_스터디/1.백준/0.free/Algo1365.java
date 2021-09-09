import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Algo1365 {
	static int N,down,up;
	static List<Integer> list;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		list = new ArrayList<>();
		String[] input = br.readLine().split(" ");
		
		list.add(Integer.parseInt(input[0]));
		
		for(int i=1;i<N;i++) {
			int num = Integer.parseInt(input[i]);
			
			if(list.get(list.size()-1)<num) list.add(num);
			else if(list.get(list.size()-1)>num) {
				int start = 0;
				int end = list.size()-1;
				
				while(start<=end) {
					int mid = (start+end)/2;
					if(list.get(mid)>num) end = mid-1;
					else start = mid+1;
				}
				list.set(start, num);
			}
		}
		
		System.out.println(N-list.size());
	}
	
}

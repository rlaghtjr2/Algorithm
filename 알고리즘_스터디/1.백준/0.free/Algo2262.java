import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Algo2262 {
	static int N,ans;
	static List<Integer> list;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		list = new ArrayList<>();
		String[] input = br.readLine().split(" ");
		for(int i=0;i<input.length;i++) {
			list.add(Integer.parseInt(input[i]));
		}
		int max = N;
		for(int i=0;i<N-1;i++) {
			int idx = list.indexOf(max);
			
			if(idx==0) ans+=list.get(idx)-list.get(idx+1);
			else if(idx==list.size()-1) ans+=list.get(idx)-list.get(idx-1); 
			else ans+=Math.min(list.get(idx)-list.get(idx+1), list.get(idx)-list.get(idx-1));
			
			list.remove(idx);
			max--;
		}
		
		System.out.println(ans);
	}

}

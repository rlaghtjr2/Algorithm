import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algo1461 {
	static int N,M,longDis,sum;
	static List<Integer> minus,plus;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		M = Integer.parseInt(input[1]);
		
		minus = new ArrayList<>();
		plus = new ArrayList<>();
		
		input = br.readLine().split(" ");
		for(int i =0;i<input.length;i++) {
			if(Integer.parseInt(input[i])>0) {
				plus.add(Integer.parseInt(input[i]));
			}else {
				minus.add(Integer.parseInt(input[i]));
			}
		}
		
		Collections.sort(minus);
		Collections.sort(plus,Collections.reverseOrder());
		if(plus.isEmpty()) longDis = minus.get(0);
		else if(minus.isEmpty()) longDis = minus.get(0);
		else {
			if(Math.abs(minus.get(0))>Math.abs(plus.get(0))) {
				longDis = minus.get(0);
			}else {
				longDis = plus.get(0);
			}
		}
		for(int i=0;i<plus.size();i=i+M) {
			sum+=(plus.get(i)*2);
		}
		for(int i=0;i<minus.size();i=i+M) {
			sum+=(Math.abs(minus.get(i))*2);
		}
		
		
		sum-= Math.abs(longDis);
		System.out.println(sum);
	}
}

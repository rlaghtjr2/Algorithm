import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo4307 {
	static int T,n,l,max,min;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<T;tc++) {
			String[] input = br.readLine().split(" ");
			l = Integer.parseInt(input[0]);
			n = Integer.parseInt(input[1]);
			
			max = Integer.MIN_VALUE;
			min = Integer.MIN_VALUE;
			
			for(int i=0;i<n;i++) {
				int ant = Integer.parseInt(br.readLine());
				int startToAnt = ant;
				int antToEnd = l-ant;
				max = Math.max(max, Math.max(startToAnt, antToEnd));
				min = Math.max(min, Math.min(startToAnt, antToEnd));
			}
			
			System.out.println(min+" "+max);
		}
	}

}

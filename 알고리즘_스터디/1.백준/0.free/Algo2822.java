import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Pair implements Comparable<Pair>{
	int x;
	int index;
	
	Pair(int _x, int _index){
		x = _x;
		index = _index;
	}

	@Override
	public int compareTo(Pair o) {
		if(x>o.x)return -1;
		else if(x==o.x) {
			if(index<o.index)return -1;
			else return 1;
		}
		return 1;
	}
}
public class Algo2822 {
	static Pair[] pairs;
	static int[] sums;
	static int sum;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		pairs = new Pair[8];
		sums = new int[5];
		for(int i=0;i<8;i++) {
			int score = Integer.parseInt(br.readLine());
			
			pairs[i] = new Pair(score,i);
		}
		Arrays.sort(pairs);
		
		for(int i=0;i<5;i++) {
			sums[i] = pairs[i].index+1;
			sum+=pairs[i].x;
		}
		
		Arrays.sort(sums);
		System.out.println(sum);
		for(int i=0;i<5;i++) {
			System.out.print(sums[i]+" ");
		}
	}

}

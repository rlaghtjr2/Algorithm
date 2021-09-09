import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
class Dot implements Comparable<Dot>{
	int start;
	int end;
	
	Dot(int _start, int _end){
		start = _start;
		end = _end;
	}

	@Override
	public int compareTo(Dot o) {
		if(start<o.start) return -1;
		else if(start==o.start) {
			if(end<o.end) return -1;
			else return 1;
		}else {
			return 1;
		}
	}
	
}
public class Algo2170 {
	static int N,ans;
	static Dot[] dots;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		dots = new Dot[N];
		
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			dots[i] = new Dot(Integer.parseInt(input[0]),Integer.parseInt(input[1]));
		}
		
		Arrays.sort(dots);
		
		int start = dots[0].start;
		int end = dots[0].end;
		if(N==1) {
			ans= end-start;
		}
		for(int i=1;i<N;i++) {
			System.out.println(start+" " +end);
			if(dots[i].start>=start && dots[i].start<=end) {
				if(dots[i].end>end) end = dots[i].end;
			}else if(dots[i].start>end) {
				ans+=end-start;
				start = dots[i].start;
				end = dots[i].end;
			}
			
			if(i==N-1) {
				ans+=end-start;
			}
		}
		
		System.out.println(ans);
	}

}

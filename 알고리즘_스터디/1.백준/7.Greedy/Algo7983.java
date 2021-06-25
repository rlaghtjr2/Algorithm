import java.util.Arrays;
import java.util.Scanner;

class Subject implements Comparable<Subject>{
	int d;
	int t;
	
	Subject(int _d, int _t){
		d = _d;
		t = _t;
	}

	@Override
	public int compareTo(Subject o) {
		// TODO Auto-generated method stub
		return o.t - t;
	}
}
public class Algo7983 {
	static int N,max,answer;
	static int min = Integer.MAX_VALUE;
	static Subject[] sbjs;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		N = sc.nextInt();
		sbjs = new Subject[N];
		
		for(int i=0;i<N;i++) {
			int d = sc.nextInt();
			int t = sc.nextInt();
			Subject sbj = new Subject(d,t);
			sbjs[i] = sbj;
		}
		
		Arrays.sort(sbjs);
		
		for(int i=0;i<N;i++) {
			int d = sbjs[i].d;
			int t = sbjs[i].t;
			
			min = Math.min(min, t);
			min = min-d;
		}
		
		
		System.out.println(min);
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
class Pair{
	long num;
	String s;
	
	Pair(long _num, String _s){
		num = _num;
		s = _s;
	}
}
public class Algo14395 {
	static long S,T;
	static Set<Long> set;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		S = Long.parseLong(input[0]);
		T = Long.parseLong(input[1]);
		set = new HashSet<>();
		if(S==T) {
			System.out.println(0);
		}else {
			solve(S);
		}
	}
	
	private static void solve(long s) {
		Queue<Pair> que = new LinkedList<>();
		set.add(s);
		que.add(new Pair(s,""));
		while(!que.isEmpty()) {
			Pair p = que.poll();
			long num = p.num;
			String str = p.s;
			if(num==T) {
				System.out.println(str);
				return;
			}
			
			if(!set.contains(num*num) && num*num<=T) {
				set.add(num*num);
				que.add(new Pair(num*num,str+"*"));
			}
			
			if(!set.contains(num+num) && num+num<=T) {
				set.add(num+num);
				que.add(new Pair(num+num,str+"+"));
			}
			
			if(!set.contains(num-num) && num-num<=T) {
				set.add(num-num);
				que.add(new Pair(num-num,str+"-"));
			}
			
			if(num!=0 && !set.contains(num/num) && num/num<=T) {
				set.add(num/num);
				que.add(new Pair(num/num,str+"/"));
			}
		}
		System.out.println(-1);
	}
}

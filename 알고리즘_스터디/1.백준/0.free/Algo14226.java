import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
class Emoticon{
	int num;
	int clip;
	int time;
	
	Emoticon(int _num, int _clip, int _time) {
		num = _num;
		clip = _clip;
		time = _time;
	}
}
public class Algo14226 {
	static int S;
	static boolean[][] check;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		
		check = new boolean[2001][2001];
		
		solve();
	}
	private static void solve() {
		Queue<Emoticon> que = new LinkedList<>();
		que.add(new Emoticon(1, 0, 0));
		
		while(!que.isEmpty()) {
			Emoticon emoticon = que.poll();
			
			int num = emoticon.num;
			int clip = emoticon.clip;
			int time = emoticon.time;
			if(num==S) {
				System.out.println(time);
				return;
			}
			//복사
			if(num>0 && num+clip<=2000 && !check[num][num+clip]) {
				check[num][num+clip] = true;
				que.add(new Emoticon(num, num, time+1));	
			}
			
			//붙여넣기
			if(clip>0 && num+clip<=2000 && !check[num+clip][clip]) {
				check[num+clip][clip] = true;
				que.add(new Emoticon(num+clip,clip,time+1));
			}
			
			//삭제
			if(num>0 && !check[num-1][clip]) {
				check[num-1][clip] = true;
				que.add(new Emoticon(num-1,clip,time+1));
			}
		}
	}
}

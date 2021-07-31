import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Algo14891 {
	static LinkedList<Integer>[] geers;
	static int K,N,dir,ans;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		geers = new LinkedList[4];
		for(int i=0;i<4;i++) {
			String[] input = br.readLine().split("");
			geers[i] = new LinkedList<>();
			for(int j=0;j<8;j++) {
				geers[i].add(Integer.parseInt(input[j]));
			}
		}
		
		K = Integer.parseInt(br.readLine());
		
		for(int t = 0; t<K; t++) {
			String[] input = br.readLine().split(" ");
			N = Integer.parseInt(input[0]);
			dir = Integer.parseInt(input[1]);
			
			move(N-1,dir,0);
		}
		
		for(int i=0;i<4;i++) {
			if(geers[i].get(0)==1) {
				ans += Math.pow(2, i);
			}
		}
		System.out.println(ans);
	}
	private static void move(int n, int d, int t) {
		//t == 0 둘다가는거
		//t == -1 왼쪽으로만
		//t == 1 오른쪽으로만
		
		if(n<3 && geers[n].get(2) != geers[n+1].get(6) && t>=0) {
			move(n+1,-d,1); //오른쪽으로가기
		}
		
		if(n>0 && geers[n].get(6)!= geers[n-1].get(2) && t<=0) {
			move(n-1,-d,-1);
		}
		
		if(d==1) {
			geers[n].add(0, geers[n].get(7));
			geers[n].remove(8);
		}else if(d==-1) {
			geers[n].add(geers[n].get(0));
			geers[n].remove(0);
		}
	}

}

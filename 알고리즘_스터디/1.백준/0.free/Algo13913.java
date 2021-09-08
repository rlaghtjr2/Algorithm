import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

class Subin{
	int position;
	String path;
	
	Subin(int _postion, String _path){
		position = _postion;
		path = _path;
	}
}
public class Algo13913 {
	static int N,K,ans;
	static Queue<Subin> que;
	static boolean[] v ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		K = Integer.parseInt(input[1]);
		v = new boolean[200001];
		que = new LinkedList<>();
		
		que.add(new Subin(N,""));
		
		while(!que.isEmpty()) {
			int size = que.size();
			
			for(int i=0;i<size;i++) {
				Subin subin = que.poll();
				
				if(subin.position==K) {
					int start = N;
					System.out.println(ans);
					System.out.print(start+ " ");
					for(int j=0;j<subin.path.length();j++) {
						if(subin.path.charAt(j)== '1') { // -1
							start--;
							System.out.print(start+ " ");
						}else if(subin.path.charAt(j)=='2') { // +1
							start++;
							System.out.print(start+" ");
						}else { // *2
							start*=2;
							System.out.print(start+" ");
						}
					}
					System.exit(0);
				}
				if(subin.position-1>=0 && !v[subin.position-1]  ) {
					que.add(new Subin(subin.position-1,subin.path.concat("1")));
					v[subin.position-1] = true;
				}
				
				if(subin.position+1<=100000 && !v[subin.position+1]) {
					que.add(new Subin(subin.position+1,subin.path.concat("2")));
					v[subin.position+1] = true;
				}
				
				if(subin.position*2<=200000 && !v[subin.position*2]) {
					que.add(new Subin(subin.position*2,subin.path.concat("3")));
					v[subin.position*2] = true;
				}
			}
			ans++;
		}
	}

}

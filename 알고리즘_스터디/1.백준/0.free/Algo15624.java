import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo15624 {
	static int N;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
	
		int first = 0;
		int second = 1;
		int third = 1;
		for(int i=1;i<N;i++) {
			third = (first+second)%1000000007;
			first = second;
			second = third;
		}
		if(N==0) System.out.println(0);
		else System.out.println(third);
	}

}

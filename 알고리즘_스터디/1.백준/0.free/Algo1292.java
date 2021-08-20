import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Algo1292 {
	static int A,B;
	static int[] array;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		A = Integer.parseInt(input[0]);
		B = Integer.parseInt(input[1]);
		array = new int[1001];
		int cnt = 0;
		int num = 1;
		for(int i=1;i<1001;i++) {
			cnt++;
			array[i] = num;
			if(cnt==num) {
				cnt = 0;
				num++;
			}
		}
		int sum = 0;
		for(int i=A;i<=B;i++) {
			sum+=array[i];
		}
		System.out.println(sum);
	}

}

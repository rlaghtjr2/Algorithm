import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Algo1669 {
	static int N,ans;
	static int[] array;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		array = new int[N+1];
		
		for (int i = 1; i <= N; i++){
            array[i] = i;
            for (int j = 1; j*j <= i; j++){
                if (array[i] > array[i-j*j]+1){
                    array[i] = array[i-j*j]+1;
                }
            }
        }
		
		System.out.println(array[N]);
	}

}

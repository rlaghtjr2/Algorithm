import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Algo2143 {
	static int T,n,m;
	static long ans;
	static int[] A,B;
	static List<Integer> sumA,sumB;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		T = Integer.parseInt(br.readLine());
		n = Integer.parseInt(br.readLine());
		A = new int[n];
		sumA = new ArrayList<>();
		String[] input = br.readLine().split(" ");
		
		for(int i=0;i<n;i++) {
			A[i] = Integer.parseInt(input[i]);
		}
		setSum(A,sumA);
		Collections.sort(sumA);
		m = Integer.parseInt(br.readLine());
		
		B = new int[m];
		sumB = new ArrayList<>();
		input = br.readLine().split(" ");
		for(int i=0;i<m;i++) {
			B[i] = Integer.parseInt(input[i]);
		}
		setSum(B,sumB);
		Collections.sort(sumB);
//		System.out.println("A");
//		for(int i=0;i<sumA.size();i++) {
//			System.out.print(sumA.get(i)+" ");
//		}
//		System.out.println();
//		System.out.println("B");
//		for(int i=0;i<sumB.size();i++) {
//			System.out.print(sumB.get(i)+" ");
//		}
//		System.out.println();
		twoPointer();
		System.out.println(ans);
	}
	
	public static void setSum(int[] array, List<Integer> list) {
		list.add(array[0]);
		for(int i=1;i<array.length;i++) {
			list.add(array[i]+list.get(i-1));
		}
		int size = list.size();
		for(int i=0;i<size;i++) {
			for(int j=0;j<i;j++) {
				list.add(list.get(i)-list.get(j));
			}
		}
	}
	
	public static void twoPointer() {
		int startA = 0;
		int startB = sumB.size()-1;
		
		while(startA<sumA.size() && startB>=0) {
			int sum = sumA.get(startA) + sumB.get(startB);
//			System.out.println(sumA.get(startA)+ " "+sumB.get(startB)+ " "+sum);
			if(sum>T) {
				startB--;
			}else if(sum<T) {
				startA++;
			}else {
				int numA = sumA.get(startA);
				int numB = sumB.get(startB);
				startA++;
				startB--;
				long cntA = 1;
				long cntB = 1;
				while(startA<sumA.size()) {
					if(sumA.get(startA)==numA) cntA++;
					else break;
					
					startA++;
				}
				while(startB>=0) {
					if(sumB.get(startB)==numB) cntB++;
					else break;
					startB--;
				}
				ans+=(cntA*cntB);
			}
			
		}
	}
}

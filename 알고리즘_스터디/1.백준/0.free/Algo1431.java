import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Algo1431 {
	static int N;
	static String[] s;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String input = br.readLine();
		
		N = Integer.parseInt(input);
		
		s = new String[N];
		
		for(int i=0;i<N;i++) {
			input = br.readLine();
			s[i] = input;
		}
		
		Arrays.sort(s,new Comparator<String>() {

			@Override
			public int compare(String o1, String o2) {
				if(o1.length()<o2.length()) return -1;
				else if(o1.length()>o2.length()) return 1;
				else {
					int num1 = 0;
					int num2 = 0;
					
					for(int i=0;i<o1.length();i++) {
						if(o1.charAt(i)>='0' && o1.charAt(i)<='9') {
							num1 += Integer.parseInt(Character.toString(o1.charAt(i)));
						}
					}
					
					for(int i=0;i<o2.length();i++) {
						if(o2.charAt(i)>='0' && o2.charAt(i)<='9') {
							num2 += Integer.parseInt(Character.toString(o2.charAt(i)));
						}
					}
					
					if(num1<num2) return -1;
					else if(num1>num2) return 1;
					else {
						return o1.compareTo(o2);
					}
				}
			}
		});
		
		for(int i=0;i<s.length;i++) {
			System.out.println(s[i]);
		}
	}

}

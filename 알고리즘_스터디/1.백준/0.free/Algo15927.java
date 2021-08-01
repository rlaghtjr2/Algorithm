import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo15927 {
	static String s;
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		s = br.readLine();
		//ȸ���̸� (���ڿ� ���� -1)
		// ȸ���� �ƴϸ� ���ڿ� ����
		// ȸ���ε�, ��繮�ڰ� �ٰ����� -1
		if(checkPelin(s)) {
			if(checkCharacter(s)) System.out.println(-1);
			else System.out.println(s.length()-1);
			
		}else {
			System.out.println(s.length());
		}
	}
	
	
	public static boolean checkPelin(String s) {
		for(int i=0;i<s.length()/2;i++) {
			if(s.charAt(i)!=s.charAt(s.length()-1-i)) return false;
		}
		return true;
	}
	
	public static boolean checkCharacter(String s) {
		char c = s.charAt(0);
		for(int i=1;i<s.length();i++) {
			if(c != s.charAt(i)) return false; //�ٸ����
		}
		
		return true; // �ٰ������
	}
}

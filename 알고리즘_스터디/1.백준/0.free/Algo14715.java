import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Algo14715 {
	static int K,cnt,ans;
	static boolean isRunning;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine());
		cnt = 1;
		while(true) {
			//�Ҽ��� ��ִ��� ���ϴ°�
			if(!getRemainder()) break;
			else cnt++;
		}
		//�Ϻ�����Ʈ�����ϱ�
		ans = baseLog(cnt, 2);
		System.out.println(ans);
	}

	public static boolean getRemainder() {
		for(int i=2;i*i<=K;i++) {
			if(K%i == 0) {
				K = K/i;
				return true;
			}
		}
		return false;
	}
	
	static int baseLog(double x, double base) {
		return (int)Math.ceil(Math.log(x)/Math.log(base));
	}
}

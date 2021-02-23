package acmicpc;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Scanner;
/*
 * 문제
엄지 생일 기념으로 학생들은 파티를 하고 있다. 엄지는 N(1≤N≤100,000)명의 학생에게 1부터 N번까지 차례대로 번호를 부여하였고 그들을 순서대로 빙 둘러앉아 원을 만들게 하였다. (즉 i번째 학생은 i-1과 i+1학생 사이에 앉아있다. 단, N번째 학생은 N-1번째 학생과 첫 번째 학생 사이에 앉아있다.)

N명의 학생은 둘러앉아 "머리톡톡" 게임을 하려한다. 게임 규칙은 다음과 같다. 각각의 학생은 자신의 머리 위에 1,000,000 이하의 자연수 중 하나를 쓴다. 그리고 1번부터 N번 학생까지 한 명씩 차례대로 일어나 원을 돌면서 자신이 쓴 숫자가 다른 사람이 쓴 숫자의 배수이면 그 학생의 머리를 "톡톡" 친다.

문제는 각각의 학생이 일어나 자신의 자리로 돌아올 때까지 총 몇 명의 학생의 머리를 치는지 구하는 것이다.

입력
첫째 줄에 학생의 수 N이 입력되고 다음 N개의 줄에는 1번부터 N번까지 각각의 학생이 자신의 머리에 쓴 숫자를 입력받는다.

출력
총 N개의 줄로 i번째 줄에는 i번째 학생이 한 바퀴를 돌면서 머리를 친 학생의 수를 출력한다.
 */
public class Algo1241 {
	static int N;
	static int[] stu,num;
	static int max = Integer.MIN_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc = new Scanner(System.in);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	    
		N = Integer.parseInt(br.readLine());
		stu = new int[N];
		for(int i=0;i<N;i++) {
			stu[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, stu[i]);
		}
		
		num = new int[max+1];
		
		for(int i=0;i<N;i++) {
			num[stu[i]]++;
		}
		
		for(int i=0;i<N;i++) {
			int sum = 0;
			for(int k=1;k*k<=stu[i];k++) {
				if(stu[i]%k==0) {
					if(k*k == stu[i]) {
						sum += num[k];
					}else {
						sum += num[k] + num[stu[i]/k];
					}
				}
			}
			String s = Integer.toString(sum-1);
			bw.write(s+"\n");
		}
		bw.flush();
		bw.close();
	}

}

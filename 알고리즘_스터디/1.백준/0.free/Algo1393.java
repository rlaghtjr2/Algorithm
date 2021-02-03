package acmicpc;

import java.util.Scanner;
/*
 문제
최백준은 음하철도 구구팔에 탔다.

문제는 구구팔의 기장인 조교 김재홍이 반쯤 미쳐서 열차를 멈추지 않는다는 것이다. 그래서 최백준은 달리고 있는 열차에서 뛰어내려야 한다.

그런데 뛰어내릴 때 정류장 까지 거리가 너무 멀면 마이 아플 수 있다.

그래서 철도가 정류장에 가장 많이 근접했을 때 뛰어내리고자 한다.

어디서 뛰어내려야 하는가?

입력
첫번째 줄에는 xs와 ys가 주어진다. 이는 정류장의 위치가 (xs, ys)임을 의미한다.

두번째 줄에는 xe, ye, dx, dy가 주어진다. 이는 현재 열차 위치가 (xe, ye)이고, 열차가 1초마다 x가 증가하는 방향으로 dx만큼, y가 증가하는 방향으로 dy만큼 이동함을 의미한다

주어지는 모든 수는 -100이상, 100이하의 정수이다.

출력
최백준이 뛰어내릴 위치의 x좌표와 y좌표를 출력한다. 뛰어내릴 위치의 좌표가 항상 정수인 입력만 주어진다.
 */
public class Algo1393 {
	static int[] x = new int[3];
	static int[] y = new int[3];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		double prev = 0;
		double current = 0;
		for(int i=0;i<3;i++) {
			x[i]=sc.nextInt();
			y[i]=sc.nextInt();
		}
		
		int gcdNum = gcd(x[2],y[2]);
		x[2] /= gcdNum;
		y[2] /= gcdNum;
		prev = getDis(x[0],y[0],x[1],y[1]);
		while(true) {
			x[1] += x[2];
			y[1] += y[2];
			current = getDis(x[0],y[0],x[1],y[1]);
			if(current>=prev) {
				System.out.println((x[1]-x[2])+" "+(y[1]-y[2]));
				break;
			}else {
				prev = current;
				current = 0;
			}
		}
	}
	
	public static int gcd(int a, int b) {
		a = Math.abs(a);
		b = Math.abs(b);
		int num = 1;
		if(a==0 && b==0) {
			return 1;
		}else if(a==0 || b==0) {
			return Math.max(a, b);
		}
		for(int i=2;i<=Math.min(a, b);i++) {
			if((a%i == 0) && (b%i == 0)) {
				num = i;
			}
		}
		return num;
	}
	
	public static double getDis(int x1, int y1, int x2, int y2) {
		double dis = 0;
		dis = Math.sqrt(Math.pow((x1-x2),2) + Math.pow((y1-y2),2));
		return dis;
	}
}

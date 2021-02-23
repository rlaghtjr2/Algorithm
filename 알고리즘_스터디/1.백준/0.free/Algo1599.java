package acmicpc;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;
/*
문제
무엇인가를 창조하는 것은 어렵다. 오민식은 지금까지 어려운 다른나라의 언어를 쓰면서 백성들이 고통에 받는 것을 슬퍼하고 새로운 언어를 만들고자 했다. 그는 창조의 고통에 시달리던 중에 결국 오영식에게 자신의 못다 이룬 꿈을 꼭 이루어달라면서 오영식에게 창조의 임무를 넘겼다.

오영식은 자신의 형이 창조에 고통에 시달리는 모습을 보고 마음이 아파서 자신은 창조를 하지 않기로 했다. 영식이는 표절을 하기로 했는데 세계적인 추세에 맞게 영어를 표절하기로 했다.

영식이는 자신의 형의 이름을 따서 민식어라고 이름붙였다.

민식어에는 알파벳이 20개가 있다.

영어는 a b c d e f g h i j k l m n o p q r s t u v w x y z의 순서이지만, 민식어는 a b k d e g h i l m n ng o p r s t u w y의 순서이다.

민식어는 영어의 순서를 따르기는 하지만, 약간 변형시켜서 따른다. 그리고 ng는 n과 o사이에 오는 하나의 알파벳이다. ng는 무조건 이 알파벳으로 생각한다.

영식이는 사람들이 쉽게 민식어를 배울 수 있도록 민식어 사전을 만들려고 한다. 따라서 몇 개의 단어를 정렬하고자 한다. 민식어 단어가 주어졌을 때, 그것을 민식어의 순서대로 정렬하는 프로그램을 작성하시오.

입력
첫째 줄에 민식어 단어의 개수 N이 주어진다. N은 1,000보다 작거나 같은 자연수이다. 둘째 줄부터 한 줄에 하나씩 단어가 입력으로 들어온다. 단어의 길이는 최대 50자이다. 민식어에 없는 알파벳이 입력으로 주어지는 경우는 없다. 모든 단어는 중복되지 않는다.

출력
첫째 줄부터 차례대로 정렬한 결과를 출력한다.
*/
public class Algo1599 {
	static int N;
	static String[] s;
	static int[] score = new int[123];
	static int[][] sco;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		N = Integer.parseInt(sc.nextLine());
		
		s = new String[N];
		
		for(int i=0;i<N;i++) {
			s[i] = sc.nextLine();
		}
		sco = new int[N][52];
		setScore();
		for(int i=0;i<N;i++) {
			int index = 0;
			for(int j=0;j<s[i].length();j++) {
				if(j!=s[i].length()-1 && s[i].charAt(j)=='n' 
						&& s[i].charAt(j+1)=='g'){
					sco[i][index] = 11;
					j++;
					index++;
					continue;
				}
				sco[i][index]=score[s[i].charAt(j)];
				index++;
			}
			sco[i][index] = -1;
			sco[i][51] = i;
		}
		
		Arrays.sort(sco,new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				for(int i=0;i<51; i++) {
					if(o1[i] == -1 && o2[i] != -1) {
						return -1;
					}else if(o1[i] != -1 && o2[i] == -1) {
						return 1;
					}else if(o1[i]==-1 && o2[i] == -1) {
						return 0;
					}else {
						if(o1[i]!=o2[i]) return o1[i]-o2[i];
						else continue;
					}
				}
				return 0;
			}
		});
		for(int i=0;i<N;i++) {
			System.out.println(s[sco[i][51]]);
		}
	}
	
	static public void setScore() {
		score[(int)'b'] = 1;
		score[(int)'k'] = 2;
		score[(int)'d'] = 3;
		score[(int)'e'] = 4;
		score[(int)'g'] = 5;
		score[(int)'h'] = 6;
		score[(int)'i'] = 7;
		score[(int)'l'] = 8;
		score[(int)'m'] = 9;
		score[(int)'n'] = 10;
		score[(int)'o'] = 12;
		score[(int)'p'] = 13;
		score[(int)'r'] = 14;
		score[(int)'s'] = 15;
		score[(int)'t'] = 16;
		score[(int)'u'] = 17;
		score[(int)'w'] = 18;
		score[(int)'y'] = 19;
	}
}

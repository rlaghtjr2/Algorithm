package acmicpc;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 문제
이진 트리를 입력받아 전위 순회(preorder traversal), 중위 순회(inorder traversal), 후위 순회(postorder traversal)한 결과를 출력하는 프로그램을 작성하시오.



예를 들어 위와 같은 이진 트리가 입력되면,

전위 순회한 결과 : ABDCEFG // (루트) (왼쪽 자식) (오른쪽 자식)
중위 순회한 결과 : DBAECFG // (왼쪽 자식) (루트) (오른쪽 자식)
후위 순회한 결과 : DBEGFCA // (왼쪽 자식) (오른쪽 자식) (루트)
가 된다.

입력
첫째 줄에는 이진 트리의 노드의 개수 N(1≤N≤26)이 주어진다. 둘째 줄부터 N개의 줄에 걸쳐 각 노드와 그의 왼쪽 자식 노드, 오른쪽 자식 노드가 주어진다. 노드의 이름은 A부터 차례대로 영문자 대문자로 매겨지며, 항상 A가 루트 노드가 된다. 자식 노드가 없는 경우에는 .으로 표현된다.

출력
첫째 줄에 전위 순회, 둘째 줄에 중위 순회, 셋째 줄에 후위 순회한 결과를 출력한다. 각 줄에 N개의 알파벳을 공백 없이 출력하면 된다.
 */
public class Algo1991 {
	static int N;
	static String[][] tree;
	static String s = "";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		N = Integer.parseInt(sc.nextLine());
		tree = new String[91][2];
		for(int i=65;i<91;i++) {
			Arrays.fill(tree[i], ".");
		}
		for(int i=0;i<N;i++) {
			String[] node = sc.nextLine().split(" ");
			tree[(int)node[0].charAt(0)][0] = node[1];
			tree[(int)node[0].charAt(0)][1] = node[2];
		}
		System.out.println(pre(65));
		s = "";
		System.out.println(middle(65));
		s = "";
		System.out.println(post(65));
		
	}

	public static String pre(int start) {
		if(Character.toString((char)start).equals(".")){
			return "";
		}
		s += Character.toString((char)start);
		pre((int)tree[start][0].charAt(0));
		pre((int)tree[start][1].charAt(0));
		
		return s;
	}
	
	public static String middle(int start) {
		if(Character.toString((char)start).equals(".")){
			return "";
		}
		middle((int)tree[start][0].charAt(0));
		s += Character.toString((char)start);
		middle((int)tree[start][1].charAt(0));
		return s;
	}
	
	public static String post(int start) {
		if(Character.toString((char)start).equals(".")){
			return "";
		}
		post((int)tree[start][0].charAt(0));
		post((int)tree[start][1].charAt(0));
		s += Character.toString((char)start);
		return s;
	}
}

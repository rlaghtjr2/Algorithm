package algo;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
/*
 * 크기가 N×M인 배열이 있을 때, 배열을 돌려보려고 한다. 배열은 다음과 같이 반시계 방향으로 돌려야 한다.

A[1][1] ← A[1][2] ← A[1][3] ← A[1][4] ← A[1][5]
   ↓                                       ↑
A[2][1]   A[2][2] ← A[2][3] ← A[2][4]   A[2][5]
   ↓         ↓                   ↑         ↑
A[3][1]   A[3][2] → A[3][3] → A[3][4]   A[3][5]
   ↓                                       ↑
A[4][1] → A[4][2] → A[4][3] → A[4][4] → A[4][5]
예를 들어, 아래와 같은 배열을 2번 회전시키면 다음과 같이 변하게 된다.

1 2 3 4       2 3 4 8       3 4 8 6
5 6 7 8       1 7 7 6       2 7 8 2
9 8 7 6   →   5 6 8 2   →   1 7 6 3
5 4 3 2       9 5 4 3       5 9 5 4
 <시작>         <회전1>        <회전2>
배열과 정수 R이 주어졌을 때, 배열을 R번 회전시킨 결과를 구해보자.

입력
첫째 줄에 배열의 크기 N, M과 수행해야 하는 회전의 수 R이 주어진다.

둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

출력
입력으로 주어진 배열을 R번 회전시킨 결과를 출력한다.

제한
2 ≤ N, M ≤ 300
1 ≤ R ≤ 109
min(N, M) mod 2 = 0
1 ≤ Aij ≤ 108
 */
public class Algo16927 {
   static int N,M,R;
   static int[][] map;
   static boolean[][] isCheck;
   static int[] dy = {0,1,0,-1};
   static int[] dx = {1,0,-1,0};
   static Queue<Integer> que = new LinkedList<>();
   
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      M = sc.nextInt();
      R = sc.nextInt();
      
      map = new int[N][M];
      isCheck = new boolean[N][M];
      for(int i=0;i<N;i++) {
         for(int j=0;j<M;j++) {
            map[i][j] = sc.nextInt();
         }
      }
      int first = 0;
      int second = 0;
      while(true) {
         if(first>=N/2 || second>=M/2)
            break;
         que.clear();
         push(first,second);
         int r = R%((N-first*2)*2 + (M-second*2)*2 -4);
         for(int i=0;i<r;i++) {
            que.add(que.poll());
         }
         pop(first,second);
         first++;
         second++;
      }
      
      for(int i=0;i<N;i++) {
         for(int j=0;j<M;j++) {
            System.out.print(map[i][j]);
            if(j!=M-1) {
               System.out.print(" ");
            }
         }
         if(i!=N-1)
            System.out.println();
      }
   }
   
   public static void push(int a, int b) {
      int d = 0;
      int first = a;
      int second = b;
      que.add(map[a][b]);
      while(true) {
         if(a+dy[d]<0 || a+dy[d]>=N || b+dx[d] <0 || b+dx[d]>=M || isCheck[a+dy[d]][b+dx[d]]) {
            if(d==3) {
               break;
            }
            d = (d+1)%4;
            continue;
         }else if(a+dy[d] == first && b+dx[d] == second) {
            break;
         }
         que.add(map[a+dy[d]][b+dx[d]]);
         a = a+dy[d];
         b = b+dx[d];
      }
   }
   
   public static void pop(int a, int b) {
      int d = 0;
      int first = a;
      int second = b;
      map[a][b] = que.poll();
      isCheck[a][b] = true;
      while(!que.isEmpty()) {
         if(a+dy[d]<0 || a+dy[d]>=N || b+dx[d] <0 || b+dx[d]>=M ||isCheck[a+dy[d]][b+dx[d]]) {
            d = (d+1)%4;
            continue;
         }else if(a+dy[d] == first && b+dx[d] == second) {
            break;
         }
         map[a+dy[d]][b+dx[d]] = que.poll();
         
         
         isCheck[a+dy[d]][b+dx[d]] = true;
         a = a+dy[d];
         b = b+dx[d];
         
      }
   }
}
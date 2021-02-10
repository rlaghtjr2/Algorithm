package algo;

import java.util.Scanner;
/*
 * 크기가 N×M인 배열이 있을 때, 배열에 연산을 R번 적용하려고 한다. 연산은 총 6가지가 있다.

1번 연산은 배열을 상하 반전시키는 연산이다.

1 6 2 9 8 4 → 4 2 9 3 1 8
7 2 6 9 8 2 → 9 2 3 6 1 5
1 8 3 4 2 9 → 7 4 6 2 3 1
7 4 6 2 3 1 → 1 8 3 4 2 9
9 2 3 6 1 5 → 7 2 6 9 8 2
4 2 9 3 1 8 → 1 6 2 9 8 4
   <배열>       <연산 결과>
2번 연산은 배열을 좌우 반전시키는 연산이다.

1 6 2 9 8 4 → 4 8 9 2 6 1
7 2 6 9 8 2 → 2 8 9 6 2 7
1 8 3 4 2 9 → 9 2 4 3 8 1
7 4 6 2 3 1 → 1 3 2 6 4 7
9 2 3 6 1 5 → 5 1 6 3 2 9
4 2 9 3 1 8 → 8 1 3 9 2 4
   <배열>       <연산 결과>
3번 연산은 오른쪽으로 90도 회전시키는 연산이다.

1 6 2 9 8 4 → 4 9 7 1 7 1
7 2 6 9 8 2 → 2 2 4 8 2 6
1 8 3 4 2 9 → 9 3 6 3 6 2
7 4 6 2 3 1 → 3 6 2 4 9 9
9 2 3 6 1 5 → 1 1 3 2 8 8
4 2 9 3 1 8 → 8 5 1 9 2 4
   <배열>       <연산 결과>
4번 연산은 왼쪽으로 90도 회전시키는 연산이다.

1 6 2 9 8 4 → 4 2 9 1 5 8
7 2 6 9 8 2 → 8 8 2 3 1 1
1 8 3 4 2 9 → 9 9 4 2 6 3
7 4 6 2 3 1 → 2 6 3 6 3 9
9 2 3 6 1 5 → 6 2 8 4 2 2
4 2 9 3 1 8 → 1 7 1 7 9 4
   <배열>       <연산 결과>
5, 6번 연산을 수행하려면 배열을 크기가 N/2×M/2인 4개의 부분 배열로 나눠야 한다. 아래 그림은 크기가 6×8인 배열을 4개의 그룹으로 나눈 것이고, 1부터 4까지의 수로 나타냈다.

1 1 1 1 2 2 2 2
1 1 1 1 2 2 2 2
1 1 1 1 2 2 2 2
4 4 4 4 3 3 3 3
4 4 4 4 3 3 3 3
4 4 4 4 3 3 3 3
5번 연산은 1번 그룹의 부분 배열을 2번 그룹 위치로, 2번을 3번으로, 3번을 4번으로, 4번을 1번으로 이동시키는 연산이다.

3 2 6 3 1 2 9 7 → 2 1 3 8 3 2 6 3
9 7 8 2 1 4 5 3 → 1 3 2 8 9 7 8 2
5 9 2 1 9 6 1 8 → 4 5 1 9 5 9 2 1
2 1 3 8 6 3 9 2 → 6 3 9 2 1 2 9 7
1 3 2 8 7 9 2 1 → 7 9 2 1 1 4 5 3
4 5 1 9 8 2 1 3 → 8 2 1 3 9 6 1 8
     <배열>            <연산 결과>
6번 연산은 1번 그룹의 부분 배열을 4번 그룹 위치로, 4번을 3번으로, 3번을 2번으로, 2번을 1번으로 이동시키는 연산이다.

3 2 6 3 1 2 9 7 → 1 2 9 7 6 3 9 2
9 7 8 2 1 4 5 3 → 1 4 5 3 7 9 2 1
5 9 2 1 9 6 1 8 → 9 6 1 8 8 2 1 3
2 1 3 8 6 3 9 2 → 3 2 6 3 2 1 3 8
1 3 2 8 7 9 2 1 → 9 7 8 2 1 3 2 8
4 5 1 9 8 2 1 3 → 5 9 2 1 4 5 1 9
     <배열>            <연산 결과>
입력
첫째 줄에 배열의 크기 N, M과 수행해야 하는 연산의 수 R이 주어진다.

둘째 줄부터 N개의 줄에 배열 A의 원소 Aij가 주어진다.

마지막 줄에는 수행해야 하는 연산이 주어진다. 연산은 공백으로 구분되어져 있고, 문제에서 설명한 연산 번호이며, 순서대로 적용시켜야 한다.

출력
입력으로 주어진 배열에 R개의 연산을 순서대로 수행한 결과를 출력한다.

제한
2 ≤ N, M ≤ 100
1 ≤ R ≤ 1,000
N, M은 짝수
1 ≤ Aij ≤ 108
 */
public class Algo16935 {
   static int N,M,R;
   static int[][] map;
   public static void main(String[] args) {
      // TODO Auto-generated method stub
      Scanner sc = new Scanner(System.in);
      
      N = sc.nextInt();
      M = sc.nextInt();
      R = sc.nextInt();
      
      map = new int[N][M];
      for(int i=0;i<N;i++) {
         for(int j=0;j<M;j++) {
            map[i][j] = sc.nextInt();
         }
      }
      
      for(int i=0;i<R;i++) {
         int num = sc.nextInt();
         if(num==1) {
            one();
         }else if(num==2) {
            two();
         }else if(num==3) {
            three();
         }else if(num==4) {
            four();
         }else if(num==5) {
            five();
         }else {
            six();
         }
      }
      for(int i=0;i<map.length;i++) {
         for(int j=0;j<map[i].length;j++) {
            System.out.print(map[i][j]+" ");
         }
         System.out.println();
      }
   }
   
   public static void one() {
      for(int i=0;i<map.length/2;i++) {
         int[] tmp = map[i];
         map[i] = map[map.length-i-1];
         map[map.length-i-1] = tmp;
      }
   }
   
   public static void two() {
      for(int i=0;i<map.length;i++) {
         for(int j=0;j<(map[i].length)/2;j++) {
            int tmp = map[i][j];
            map[i][j] = map[i][map[i].length-j-1];
            map[i][map[i].length-j-1] = tmp;
         }
      }
   }
   
   public static void three() {
      int[][] newM = new int[map[0].length][map.length];
      for(int i=0;i<map.length;i++) {
         for(int j=0;j<map[0].length;j++) {
            newM[j][map.length-i-1] = map[i][j];
         }
      }
      map = newM;
   }
   public static void four() {
      int[][] newM = new int[map[0].length][map.length];
      for(int i=0;i<map.length;i++) {
         for(int j=0;j<map[0].length;j++) {
            newM[map[0].length-1-j][i] = map[i][j];
         }
      }
      map = newM;
   }
   public static void five() {
      int[][] newM = new int[map.length][map[0].length];
      
      for(int i=0;i<map.length;i++) {
         for(int j=0;j<map[i].length;j++) {
            if(j<map[i].length/2 && i<map.length/2) {
               newM[i][j+map[i].length/2] = map[i][j];
            }else if(j>=map[i].length/2 && i<map.length/2) {
               newM[i+map.length/2][j] = map[i][j];
            }else if(j<map[i].length/2 && i>=map.length/2) {
               newM[i-map.length/2][j] = map[i][j];
            }else {
               newM[i][j-map[0].length/2] = map[i][j];
            }
         }
      }
      map = newM;
   }
   
   public static void six() {
      int[][] newM = new int[map.length][map[0].length];
      
      for(int i=0;i<map.length;i++) {
         for(int j=0;j<map[i].length;j++) {
            if(j<map[i].length/2 && i<map.length/2) {
               newM[i+map.length/2][j] = map[i][j];
            }else if(j>=map[i].length/2 && i<map.length/2) {
               newM[i][j-map[i].length/2] = map[i][j];
            }else if(j<map[i].length/2 && i>=map.length/2) {
               newM[i][j+map[i].length/2] = map[i][j];
            }else {
               newM[i-map.length/2][j] = map[i][j];
            }
         }
      }
      map = newM;
   }
}
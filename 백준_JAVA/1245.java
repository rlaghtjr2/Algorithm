
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
    static int[] dx = {1,0,-1,0,1,1,-1,-1};
    static int[] dy = {0,1,0,-1,1,-1,1,-1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int ans = 0;
        int max = 0;
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] mountain = new int[n][m];
        boolean[][] isCheck = new boolean[n][m];

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                int a = sc.nextInt();
                if(i==0 && j==0){
                    max = a;
                }else{
                    if(a>max){
                        max = a;
                    }
                }
                mountain[i][j] = a;
            }
        }

        max++;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(mountain[i][j]!=0){
                    if(isCheck[i][j]){
                        continue;
                    }

                    Queue<Integer> first = new LinkedList<Integer>();
                    Queue<Integer> second = new LinkedList<Integer>();
                    boolean isStop = false;
                    first.offer(i);
                    second.offer(j);
                    while(!first.isEmpty()){
                        int a = first.poll();
                        int b = second.poll();

                        if(isCheck[a][b]){
//                            isStop = true;
                            continue;
                        }
//                        System.out.println(i+" "+j+" 값: "+mountain[i][j]+" "+a+" "+b);
                        isCheck[a][b] = true;

                        for(int offset=0;offset<8;offset++){
                            int x = a+dx[offset];
                            int y = b+dy[offset];

                            if(x<0||y<0||x>=n||y>=m){
                                continue;
                            }

                            if(mountain[x][y] == mountain[i][j] && !isCheck[x][y]){
                                first.offer(x);
                                second.offer(y);
                            }else if(mountain[x][y]>mountain[i][j]){
                                isStop = true;
                            }
                        }
                    }
                    if(!isStop){
//                        System.out.println(i+" "+j+" up");
                        ans++;
                    }
                }
            }
        }
        System.out.println(ans);
    }
}

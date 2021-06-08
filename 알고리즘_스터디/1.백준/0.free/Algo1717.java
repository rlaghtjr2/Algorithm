
import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] array;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();
        M = sc.nextInt();

        array = new int[N+1];
        for(int i=0;i<N+1;i++){
            array[i] = i;
        }
        for(int tc=0;tc<M;tc++){
            int a,b,c;
            a = sc.nextInt();
            b = sc.nextInt();
            c = sc.nextInt();

            if(a==0){
                union(b,c);
            }else{
                if(find(b)==find(c)){
                    System.out.println("YES");
                }else{
                    System.out.println("NO");
                }
            }
        }
    }
    public static int find(int a){
        if(array[a] == a) return a;
        int b = find(array[a]);
        array[a] = b;
        return b;
    }

    public static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa<fb){
            array[fb] = fa;
        }else if(fa>fb){
            array[fa] = fb;
        }
    }

}

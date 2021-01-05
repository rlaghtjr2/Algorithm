
import java.util.Scanner;
import java.util.Vector;

public class Main {

    public static void main(String[] args) {
        // write your code here
        int n,p,score;
        int ans = 1;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        score = sc.nextInt();
        p = sc.nextInt();

        Vector<Integer> ranking = new Vector<Integer>();

        for(int i=0;i<p;i++){
            if(i<n){
                int a = sc.nextInt();
                ranking.add(a);
            }else{
                ranking.add(-1);
            }
        }
        if(ranking.get(p-1)>=score){
            ans = -1;
        }else {
            for (int i = 0; i < p; i++) {
                if (ranking.get(i) > score) {
                    ans++;
                } else if (ranking.get(i) < score) {
                    break;
                } else if (ranking.get(i) == score) {
                    break;
                }
            }
        }

        System.out.println(ans);
    }
}

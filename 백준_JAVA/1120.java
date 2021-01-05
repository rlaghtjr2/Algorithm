import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        String A,B;
        int cnt = 0;
        int min = 999999;
        Scanner sc = new Scanner(System.in);
        A = sc.next();
        B = sc.next();

        for(int i=0;i<=B.length()-A.length();i++){
            cnt = 0;
            for(int j=0;j<A.length();j++){
                if(A.charAt(j) != B.charAt(j+i)){
                    cnt++;
                }
            }
            if(cnt<min){
                min = cnt;
            }
        }

        System.out.println(min);

    }
}
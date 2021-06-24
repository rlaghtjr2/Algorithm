import java.util.*;

public class Main {
    static int N;
    static long T;

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        T = Long.parseLong(sc.nextLine());

        for(int tc=0;tc<T;tc++){
            boolean flag = true;
            N = Integer.parseInt(sc.nextLine());

            String[] array = new String[N];
            for(int i=0;i<N;i++){
                array[i] = sc.nextLine();
            }

            Arrays.sort(array);

            for(int i=0;i<N-1;i++){
                String current = array[i];
                String next = array[i+1];

                if(next.indexOf(current)==0){
                    flag = false;
                    break;
                }
            }

            if(flag) System.out.println("YES");
            else System.out.println("NO");
        }
    }



}

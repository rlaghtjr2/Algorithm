import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = pi(br.readLine());
        for(int t=0; t<T; ++t) {
            Deque<Integer> a = new LinkedList<>();
            String command = br.readLine();
            int n = pi(br.readLine());
            String a_ = br.readLine();
            a_ = a_.substring(1, a_.length()-1);
            boolean front = true;
            String[] aa = a_.split(",");
            for(int i=0; i<n; ++i)
                a.add(pi(aa[i]));
            if(countChar(command, 'D') > n) {
                System.out.print("error\n");
            }
            else {
                for(int i=0; i<command.length(); ++i) {
                    if(command.charAt(i)=='D') {
                        if(front)
                            a.pollFirst();
                        else
                            a.pollLast();
                    }
                    else {
                        front = !front;
                    }
                    if(i==command.length()-1) {
                        StringBuilder sb = new StringBuilder();
                        sb.append("[");
                        if(front) {
                            while(a.size()>1)
                                sb.append(String.format("%d,", a.pollFirst()));
                        }
                        else {
                            while(a.size()>1)
                                sb.append(String.format("%d,", a.pollLast()));
                        }
                        if(a.size()!=0)
                            sb.append(a.getFirst());
                        sb.append("]");
                        System.out.println(sb.toString());
                    }
                }

            }

        }

    }
    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static long countChar(String str, char ch) {
        return str.chars()
                .filter(c -> c == ch)
                .count();
    }
}

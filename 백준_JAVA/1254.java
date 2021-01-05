import java.util.*;

public class Main {
    public static boolean checking(String s){
        for(int i=0;i<s.length()/2;i++){
            if(s.charAt(i) != s.charAt(s.length()-i-1)){
                return false;
            }
        }

        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        String subS ="";
        String s2=s+subS;
        int a = 0;
        while(!checking(s2)){
//            for(int i=0;i<s2.length()/2;i++){
//                if(s2.charAt(i)!=s2.charAt(s2.length()-i-1)){
//                    subS=s2.charAt(i)+subS;
//                    break;
//                }
//            }
//            a++;
//            s2 = s+subS;
            subS = s2.charAt(a)+subS;
            s2 = s+subS;
            a++;
//           System.out.println(s2);
        }
//        System.out.println(s.length());
        System.out.println(s2.length());
//        System.out.println(s);
//        System.out.println(s2);
    }
}

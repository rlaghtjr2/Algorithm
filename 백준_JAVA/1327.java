
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int k = sc.nextInt();
        int initial = 0;
        int ans = 0;
        boolean isStop = false;

        Vector<Integer> vec = new Vector<Integer>();
        Vector<Integer> cmpVec = new Vector<Integer>();
        //Vector<Boolean> isCheck = new Vector<Boolean>(100000000);
        boolean[] isCheck = new boolean[100000000];
        Queue< Vector<Integer> > que = new LinkedList< Vector<Integer> >();

        for(int i=0;i<n;i++){
            int a = sc.nextInt();
            vec.add(a);
            cmpVec.add(a);
        }


        for(int i=0;i<n;i++){
            initial = initial+ ((int)Math.pow(10,n-i-1)*vec.get(i));
        }
        isCheck[initial] = true;
        que.offer(vec);

        Collections.sort(cmpVec);
        if(!vec.equals(cmpVec)) {
            while (!que.isEmpty() && !isStop) {
                ans++;
                int queSize = que.size();
                for (int i = 0; i < queSize; i++) {
                    for (int j = 0; j <= n - k; j++) {
                        Vector<Integer> vec2 = (Vector<Integer>)que.peek().clone();
                        int last = j + k - 1;
                        int num = 0;
                        for (int q = j; q < j + (k / 2); q++) {
                            int a = vec2.get(q);
                            vec2.set(q, vec2.get(last));
                            vec2.set(last, a);
                            last--;
                        }
                        if (vec2.equals(cmpVec)) {
                            isStop = true;
                            break;
                        }
                        for (int q = 0; q < n; q++) {
                            num = num + ((int) Math.pow(10, n - q - 1) * vec2.get(q));
                        }

                        if (!isCheck[num]) {
                            isCheck[num] = true;
                            que.offer(vec2);
                        }
                    }
                    if (isStop) {
                        break;
                    }
                    que.poll();
                }
                if (que.isEmpty()) {
                    ans = -1;
                }
            }
        }
        System.out.println(ans);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
public class Tuple implements Comparable<Tuple>{
        int cost;
        int endLimit;

        public Tuple(int cost, int b) {
            this.cost = cost;
            this.endLimit = b;
        }

        @Override
        public int compareTo(Tuple o) {
            return o.endLimit - this.endLimit;
        }
}
public class Algo1263 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        final int testcase = Integer.parseInt(br.readLine());
        List<Tuple> tasks = new ArrayList<>();

        for (int i = 0; i < testcase; i++) {
            final String[] inputs = br.readLine().split(" ");
            tasks.add(new Tuple(Integer.parseInt(inputs[0]), Integer.parseInt(inputs[1])));
        }

        int totalTaskTime = 0;

        Collections.sort(tasks);
        int maxTime = tasks.get(0).endLimit;

        boolean[] isAssigned = new boolean[maxTime];

        for (int i = 0; i < testcase; i++) {
            Tuple task = tasks.get(i);

            int remain = task.cost;
            for (int j = task.endLimit - 1; j >= 0 && remain != 0; j--) {
                if (!isAssigned[j]) {
                    isAssigned[j] = true;
                    remain--;
                }
            }
            totalTaskTime += task.cost;

            if (totalTaskTime > maxTime || remain != 0) {
                System.out.println("-1");
                System.exit(0);
            }
        }

        int result = maxTime;
        for (int i = 0; i < maxTime; i++) {
            if (isAssigned[i]) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    
}
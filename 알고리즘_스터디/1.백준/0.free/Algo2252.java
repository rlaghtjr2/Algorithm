import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int N, M;

    static int pi(String a) {
        return Integer.parseInt(a);
    }

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        N = pi(st.nextToken());
        M = pi(st.nextToken());
        int[] cntOfLink = new int[N + 1]; // 간선의 수에 대한 배열
        // 가중치가 없는 그래프(인접 리스트 이용)
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<Integer>());
        }
        // 단방향 연결 설정
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken()), v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            cntOfLink[v2]++;
        }
        topologicalSort(graph, cntOfLink);

    }
    static void topologicalSort(ArrayList<ArrayList<Integer>> graph, int[] cntOfLink) {
        Queue<Integer> queue = new LinkedList();
        // 초기: 선행 정점을 가지지 않는 정점을 큐에 삽입

        for (int i = 1; i < N + 1; i++) {
            if (cntOfLink[i] == 0) { // 해당 정점의 간선의 수가 0이면
                queue.add(i);
            }
        }
        // 정점의 수 만큼 반복
        for (int i = 0; i < N; i++) {
            int v = queue.remove(); // 1. 큐에서 정점 추출
            System.out.printf("%d ", v);

            // 2. 해당 정점과 연결된 모든 정점에 대해
            for (int nextV : graph.get(v)) {
                cntOfLink[nextV]--; // 2-1. 간선의 수 감소
                // 2-2. 선행 정점을 가지지 않는 정점을 큐에 삽입
                if (cntOfLink[nextV] == 0) { // 해당 정점의 간선의 수가 0이면
                    queue.add(nextV);
                }

            }
        }
    }
}

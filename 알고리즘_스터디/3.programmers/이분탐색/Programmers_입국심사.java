import java.util.Arrays;

public class Programmers_입국심사 {

	public static long solution(int n, int[] times) {
		long answer = Long.MAX_VALUE;
		Arrays.sort(times);

		long right = (long) times[times.length - 1] * n;
		long left = 1;
		long middle = (right + left) / 2;
		long sum = 0;
		while (left <= right) {
			sum = 0;
			middle = (right + left) / 2;
//       	System.out.println(maximum+" "+minimum+" "+middle);
			for (int i = 0; i < times.length; i++) {
				sum += (middle / times[i]);
			}

			if (sum >= n) {
				right = middle - 1;
				answer = Math.min(middle, answer);
			} else if (sum < n) {
				left = middle + 1;
			}
		}
//       System.out.println();
		return answer;
	}

	public static void main(String[] args) {
		int n = 10;
		int[] times = { 1, 5 };
		System.out.println(solution(n, times));

	}

}

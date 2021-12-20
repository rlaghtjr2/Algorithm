import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
class Spot{
	String direction;
	int number;
	
	Spot(String _direction, int _number){
		direction = _direction;
		number = _number;
	}
}
public class Algo15558 {
	static int N,k;
	static int[] left,right;
	static boolean[] v;
	static Queue<Spot> que;
	static boolean finish;
	static boolean[] leftCheck, rightCheck;
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] input = br.readLine().split(" ");
		N = Integer.parseInt(input[0]);
		k = Integer.parseInt(input[1]);
		left = new int[N];
		right = new int[N];
		leftCheck = new boolean[N];
		rightCheck = new boolean[N];
		finish = false;
		
		input = br.readLine().split("");
		
		for(int i=0;i<input.length;i++) {
			left[i] = Integer.parseInt(input[i]);
		}
		
		input = br.readLine().split("");
		
		for(int i=0;i<input.length;i++) {
			right[i] = Integer.parseInt(input[i]);
		}
		
		int count = 0;
		que = new LinkedList<>();
		que.add(new Spot("L",0));
		leftCheck[0] = true;
		if(bfs()) System.out.println(1);
		else System.out.println(0);
		
	}
	
	public static boolean bfs() {
		int count = 0;
		while(!que.isEmpty()) {
			int queSize = que.size();
			for(int i=0;i<queSize;i++) {
				Spot spot = que.poll();
				
				String direction = spot.direction;
				int number = spot.number;
				
//				System.out.println(direction+" "+number+" "+count);
				if(direction.equals("L")) {
					if(number+1 >=N || number+k >=N) return true;	
					if(left[number+1]==1 && !leftCheck[number+1]) {
						leftCheck[number+1] = true;
						que.add(new Spot("L",number+1));
					}
					if(right[number+k]==1&& !rightCheck[number+k]) {
						rightCheck[number+k] = true;
						que.add(new Spot("R",number+k));
					}
					
					if(number-1<count) continue;
					if(left[number-1]==1 && !leftCheck[number-1]) {
						leftCheck[number-1] = true;
						que.add(new Spot("L",number-1));
					}
					
				}else {
					if(number+1 >=N || number+k >=N) return true;
					
					if(right[number+1]==1 && !rightCheck[number+1]) {
						rightCheck[number+1] = true;
						que.add(new Spot("R",number+1));
					}
					if(left[number+k]==1 && !leftCheck[number+k]) {
						leftCheck[number+k] = true;
						que.add(new Spot("L",number+k));
					}
					
					if(number-1<=count) continue;
					if(right[number-1]==1 && !rightCheck[number-1]) {
						rightCheck[number-1] = true;
						que.add(new Spot("R",number-1));
					}
					
				}
				
			}
			
			count++;
		}
		
		
		return false;
	}

}

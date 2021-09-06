import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

class Person{
	int height;
	int weight;
	int rank;
	Person(int _height, int _weight){
		height = _height;
		weight = _weight;
		rank = 1;
	}

}
public class Algo7568 {
	static int N,sum;
	static Person[] people;
	static int[] rank;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		people = new Person[N];
		rank = new int[N];
		for(int i=0;i<N;i++) {
			String[] input = br.readLine().split(" ");
			Person person = new Person(Integer.parseInt(input[1]),Integer.parseInt(input[0]));
			people[i] = person;
		}
		
	
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(i==j) continue;
				if(people[i].height < people[j].height && people[i].weight < people[j].weight)
					people[i].rank++;
			}
			System.out.println(people[i].rank);
		}
	}

}

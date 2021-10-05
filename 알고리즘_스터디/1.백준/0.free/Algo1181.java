import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;


class Word implements Comparable<Word>{
	String s;

	Word(String _s){
		s = _s;
	}
	@Override
	public int compareTo(Word o) {
		if(s.length()<o.s.length()) return -1;
		else if(s.length()==o.s.length()) {
			return s.compareTo(o.s);
		}else {
			return 1;
		}
	}
}
public class Algo1181 {
	static int N;
	static Word[] words;
	static TreeSet<Word> set;
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		N = Integer.parseInt(br.readLine());
		set = new TreeSet<>();
		words = new Word[N];
		for(int i=0;i<N;i++) {
			String input = br.readLine();
//			words[i] = new Word(input);
			set.add(new Word(input));
		}
		
//		Arrays.sort(words);
//		for(int i=0;i<N;i++) {
//			bw.write(words[i].s+"\n");
//		}
		Iterator iter = set.iterator();
		while(iter.hasNext()) {
			bw.write(((Word)iter.next()).s+"\n");
		}
		bw.flush();
		bw.close();
	}

}

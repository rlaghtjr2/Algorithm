import java.util.*;
public class Programmers_모음사전 {
	class Solution {
	    String[] words = {"A","E","I","O","U"};
	    int ans,num;
	    public int solution(String word) {
	        int answer = 0;
	        
	        comb("",word,0);
	        return ans-1;
	    }
	    
	    private void comb(String current, String word, int cnt){
	        if(cnt==6) return;
	        num++;
	        // System.out.println(current+" "+num);
	        if(current.equals(word)) {
	            ans = num;
	            return;
	        }
	        for(int i=0;i<5;i++){
	            comb(current+words[i],word,cnt+1);
	            if(ans!=0) return;
	        }
	    }
	}
}

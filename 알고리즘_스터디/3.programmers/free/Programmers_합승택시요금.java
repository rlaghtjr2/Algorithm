
public class Programmers_гу╫бец╫ц©Д╠щ {
	class Solution {
	    int[][] map;
	    public int solution(int n, int s, int a, int b, int[][] fares) {
	        int answer = Integer.MAX_VALUE;
	        map = new int[n+1][n+1];
	        for(int i=1;i<n+1;i++){
	            for(int j=1;j<n+1;j++){
	                map[i][j] = 1000001;
	            }
	        }
	        for(int i=1;i<map.length;i++){
	            map[i][i] = 0;
	        }
	        for(int i=0;i<fares.length;i++){
	            int start = fares[i][0];
	            int end = fares[i][1];
	            int weight = fares[i][2];
	            
	            map[start][end] = weight;
	            map[end][start] = weight;
	        }
	        
	        floydWarshall();
	        
	        for(int i=1;i<map.length;i++){
	            int cost = map[s][i] + map[i][a] + map[i][b];
	            answer = Math.min(answer,cost);
	        }
	        // for(int i=1;i<map.length;i++){
	        //     for(int j=1;j<map.length;j++){
	        //         System.out.print(map[i][j]+" ");
	        //     }
	        //     System.out.println();
	        // }
	        return answer;
	    }
	    
	    private void floydWarshall(){
	        for(int k=1;k<map.length;k++){
	            for(int i=1;i<map.length;i++){
	                for(int j=1;j<map.length;j++){
	                    if(map[i][k]+map[k][j]<map[i][j]) map[i][j] = map[i][k]+map[k][j];
	                }
	            }
	        }
	    }
	}
}

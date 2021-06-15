import java.io.*;
import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static ArrayList<Integer> al = new ArrayList<Integer>();

    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        for(int i = 0; i < N; ++i){
            al.add(Integer.parseInt(br.readLine()));
        }
        System.out.println(histo(0, N-1));
        br.close();

    }

    static long histo(int begin, int end){
        if(begin == end) return al.get(begin);
        int mid = (begin + end)/2;
        int left = mid, right = mid+1;
        long area = max(histo(begin, mid), histo(mid+1, end));
        int height = min(al.get(left), al.get(right));

        while(begin <= left || right <= end){
            area = max(area, (long)height*((long)right-(long)left+1));
            if(begin==left && right == end) break;
            if(begin == left && right < end){
                height = min(height, al.get(++right));
            }
            else if(right == end && begin < left){
                height = min(height, al.get(--left));
            }
            else if (al.get(left - 1) > al.get(right + 1)) {
                height = min(height, al.get(--left));
            }
            else {
                height = min(height, al.get(++right));
            }
        }
        return area;
    }
}

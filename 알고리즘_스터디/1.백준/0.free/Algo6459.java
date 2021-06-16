
import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

import static java.lang.Math.max;
import static java.lang.Math.min;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> al = new ArrayList<Integer>();
    static ArrayList<String> sl = new ArrayList<String>();

    public static void main(String[] args) throws IOException {

        while(true){
            //스트링 토크나이저를 이용해 readLine()을 통해 한 줄을 한번에 입력받은것을 띄어쓰기(" ")를 기준으로 쪼갬
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            //쪼갠 값이 존재할때까지 반복
            while(st.hasMoreTokens()){
                //nextToken()을 통해 띄어쓰기(" ")를 제거하고 남은 숫자를 스트링 형태에서 int로 형변환하여 al 저장.
                 al.add( Integer.parseInt(st.nextToken()) );
            }
            if(al.get(0) == 0) break;
            sb.append(histo(1, al.get(0))).append('\n');
            al.clear();
        }

        bw.write(sb.toString());
        bw.flush();
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

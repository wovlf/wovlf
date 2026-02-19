import java.io.*;
import java.util.*;



public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        long start = 1;
        long end = k;
        long ans = 0;
        while(start <= end) {
            long mid = (start + end) / 2;

            long count = 0;
            for(int i = 1;i<=n;i++){
                count = count + Math.min(n , mid / i);
            }
            if(count >= k){
                end = mid - 1;
                ans = mid;
            }else{
                start = mid + 1;
            }
        }
        System.out.println(ans);
    }
}

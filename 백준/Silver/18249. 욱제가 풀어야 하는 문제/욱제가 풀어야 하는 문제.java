import java.io.*;
import java.util.*;




public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int [] dp = new int[191231];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i < 191231; i++){
            dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007) % 1000000007;
        }
        int test = Integer.parseInt(br.readLine());
        for(int i = 0; i < test; i++){
            int n = Integer.parseInt(br.readLine());
            bw.write(dp[n] + "\n");
        }
        bw.close();


    }
}

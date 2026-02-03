    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int num = Integer.parseInt(br.readLine());
            int [] dp = new int[50010];
            dp[1] = 1;
            dp[2] = 1;
            dp[3] = 2;
            for(int i = 4;i<=num;i++){
                dp[i] = ((dp[i - 1] %  1000000009) + (dp[i - 3] % 1000000009)) % 1000000009 ;
            }
            System.out.println(dp[num]);
        }
    }
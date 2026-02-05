    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            int [] dp = new int[1000010];
            dp[0] = 0;
            dp[1] = 1;
            for(int i = 2; i <= Math.abs(n); i++){
                dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000000;
            }
            if(n < 0 && n % 2 == 0){
                System.out.println("-1");
                System.out.println(dp[Math.abs(n)]);
            }else if(n == 0){
                System.out.println("0");
                System.out.println("0");
            }else{
                System.out.println("1");
                System.out.println(dp[Math.abs(n)]);
            }

        }
    }
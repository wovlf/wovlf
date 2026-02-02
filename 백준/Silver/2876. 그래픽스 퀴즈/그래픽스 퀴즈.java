    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            int [][] tmp = new int[n][2];
            int [][] dp = new int[n][2];
            for(int i = 0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<2;j++){
                    tmp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            dp[0][0] = 1;
            dp[0][1] = 1;
            for(int i = 1;i<n;i++){
                for(int j = 0;j<2;j++){
                    dp[i][j] = 1;
                    if(tmp[i - 1][0] == tmp[i][j]){
                        dp[i][j] = dp[i - 1][0] + 1;
                    }

                    if(tmp[i - 1][1] == tmp[i][j]){
                        dp[i][j] = dp[i - 1][1] + 1;
                    }
                }
            }
            int max = 0;
            int index = 10;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<2;j++){
                    if(dp[i][j] > max){
                        max = dp[i][j];
                        index = tmp[i][j];
                    }else if(dp[i][j] == max){
                        if(index > tmp[i][j]){
                            index = tmp[i][j];
                        }
                    }
                }
            }
            System.out.println(max + " " + index);


        }
    }
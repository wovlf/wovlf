import java.io.*;
import java.util.*;

public class Main
{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long [][] tmp = new long[n + 1][n + 1];
        int max = 100000010;
        for(int i = 0;i <= n;i++){
            Arrays.fill(tmp[i],max);
        }
        for(int i = 0;i <= n;i++){
            tmp[i][i] = 0;
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            tmp[a][b] = Math.min(tmp[a][b], c);
        }

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                for(int k = 1;k <= n;k++){
                    if(tmp[j][i] != max && tmp[i][k] != max){
                        tmp[j][k] = Math.min(tmp[j][i] + tmp[i][k], tmp[j][k]);
                    }
                }
            }


        }

        for(int i = 1;i <= n;i++){
            for(int j = 1;j <= n;j++){
                if(tmp[i][j] == max){
                    System.out.print(0 + " ");
                } else{
                    System.out.print(tmp[i][j] + " ");
                }
            }
            System.out.println();
        }
    }
}
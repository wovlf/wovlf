import java.io.*;
import java.util.*;




public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        boolean [][] tmp = new boolean[n + 1][n + 1];
        for(int i = 1; i < n; i++) {
            int num = Integer.parseInt(br.readLine());

            st = new  StringTokenizer(br.readLine());
            if(num == 0){
                continue;
            }
            for(int j = 0;j<num;j++){
                int a = Integer.parseInt(st.nextToken());
                tmp[i][a] = true;
            }
        }
        for(int k = 1; k <= n; k++){
            for(int i = 1; i <= n; i++){
                for(int j = 1; j <= n; j++){
                    if(!tmp[i][j]){
                        tmp[i][j] = tmp[i][k] && tmp[k][j];
                    }
                }
            }
        }
        for(int i = 1;i<n;i++){
            if(tmp[1][i] && tmp[i][i]){
                System.out.println("CYCLE");
                return;
            }
        }
        System.out.println("NO CYCLE");


    }
}

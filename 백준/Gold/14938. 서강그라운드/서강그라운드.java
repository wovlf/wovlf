import java.io.*;
import java.util.*;


public class Main
{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        int [] item = new int [n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            item[i] = Integer.parseInt(st.nextToken());
        }
        int [][] tmp = new int [n + 1][n + 1];
        int max = 100000100;
        for(int i = 1; i <= n; i++){
            Arrays.fill(tmp[i], max);
        }

        for(int i = 0; i < r; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            if(tmp[a][b] > l && l <= m){
                tmp[a][b] = l;
                tmp[b][a] = l;
            }
        }
        for(int i = 1; i <= n; i++){
            tmp[i][i] = 0;
        }
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                for(int k = 1; k <= n; k++){
                    if(tmp[j][i] != max && tmp[i][k] != max){
                        if(tmp[j][i] + tmp[i][k] <= m && tmp[j][k] > tmp[j][i] + tmp[i][k]){
                            tmp[j][k] = tmp[j][i] + tmp[i][k];
                        }
                    }
                }
            }
        }
//        for(int i = 1; i <= n; i++){
//            for(int j = 1; j <= n; j++){
//                System.out.print(tmp[i][j] + " ");
//            }
//            System.out.println();
//        }
        int get = 0;
        for(int i = 1; i <= n; i++){
            int sum = 0;
            for(int j = 1; j <= n; j++){
                if(tmp[i][j] != max){
                    sum = sum + item[j];
                }
            }
            if(get < sum){
                get = sum;
            }
        }

        System.out.println(get);
    }
}
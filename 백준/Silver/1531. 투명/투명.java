import java.io.*;
import java.util.*;



public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new  StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [][] tmp = new int[101][101];
            for(int i = 1;i<=n;i++){
                st = new StringTokenizer(br.readLine());
                int x1 = Integer.parseInt(st.nextToken());
                int y1 = Integer.parseInt(st.nextToken());
                int x2 = Integer.parseInt(st.nextToken());
                int y2 = Integer.parseInt(st.nextToken());
                for(int a = y1; a <= y2; a++){
                    for(int b = x1; b <= x2; b++){
                        tmp[a][b]++;
                    }
                }
            }
            int count = 0;
            for(int i = 1;i<=100;i++){
                for(int j = 1;j<=100;j++){
                    if(tmp[i][j] > m){
                        count++;
                    }
                }
            }
            System.out.println(count);

        }
    }
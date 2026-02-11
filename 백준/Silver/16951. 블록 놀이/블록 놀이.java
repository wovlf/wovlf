import java.io.*;
import java.util.*;



public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [] tmp = new int[n];
            st =  new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++) {
                tmp[i] = Integer.parseInt(st.nextToken());
            }

            int [] get = new int[1010];
            int count = 0;
            for(int i = 0;i<n;i++){
                int x = tmp[i] - i * m;
                if(x >= 1){
                    get[x]++;
                    count = Math.max(count,get[x]);
                }
            }
            System.out.println(n - count);


        }
    }
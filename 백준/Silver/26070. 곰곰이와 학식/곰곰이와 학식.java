import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int x;
    int y;
    int time;
    public Node(int x,int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;

    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.time, o.time);
    }
}

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int [] dx = {1,2,0};
        long [] a = new long[3];
        for(int i = 0; i < 3; i++){
            a[i] = Long.parseLong(st.nextToken());
        }
        st  = new StringTokenizer(br.readLine());
        long [] b = new long[3];
        for(int i = 0; i < 3; i++){
            b[i] = Long.parseLong(st.nextToken());
        }
        long count = 0;
        for(int i = 0; i < 3; i++){
            if(a[i] - b[i] > 0){
                count = count + b[i];
                a[i] = a[i] - b[i];
                b[i] = 0;
            }else{
                count = count + a[i];
                b[i] = b[i] - a[i];
                a[i] = 0;
            }
        }
        for(int i = 0; i < 3; i++){
           if(b[i] / 3  > 0){
               b[dx[i]] = b[dx[i]] + b[i] / 3;
               b[i] = b[i] % 3;
           }
           if(a[dx[i]] > 0){
               if(a[dx[i]] - b[dx[i]] > 0){
                   count = count + b[dx[i]];
                   a[dx[i]] = a[dx[i]] - b[dx[i]];
                   b[dx[i]] = 0;
               }else{
                   count = count + a[dx[i]];
                   b[dx[i]] = b[dx[i]] - a[dx[i]];
                   a[dx[i]] = 0;
               }
           }
        }
        for(int i = 0; i < 3; i++){
            if(b[i] / 3  > 0){
                b[dx[i]] = b[dx[i]] + b[i] / 3;
                b[i] = b[i] % 3;
            }
            if(a[dx[i]] > 0){
                if(a[dx[i]] - b[dx[i]] > 0){
                    count = count + b[dx[i]];
                    a[dx[i]] = a[dx[i]] - b[dx[i]];
                    b[dx[i]] = 0;
                }else{
                    count = count + a[dx[i]];
                    b[dx[i]] = b[dx[i]] - a[dx[i]];
                    a[dx[i]] = 0;
                }
            }
        }
        System.out.println(count);

    }
}

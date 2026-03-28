import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int num;
    int time;
    public Node(int num, int time) {
        this.num = num;
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
        long n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long num =  m  * 100 / n;
        long start = 1;
        long end = 1000000000;
        long get = -1;
        while(start <= end){
            long mid = (start + end) / 2;
            if((m + mid) * 100 / (n + mid) > num){
                get = mid;
                end = mid - 1;

            }else{
                start = mid + 1;
            }
        }
        System.out.println(get);

    }
}

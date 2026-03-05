import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int end;
    long index;
    public Node(int end, long index){
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.index, o.index);
    }
}

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st =  new StringTokenizer(br.readLine());
        int [] tmp = new int[m];
        for(int i = 0; i < m; i++){
            tmp[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        int sum = 0;
        while(start < m - 1){
            int left = 0;
            int end = start + 1;
            int left_max = 0;
            while(left < start){
                if(tmp[left] > left_max){
                    left_max = tmp[left];
                }
                left++;
            }
            int right_max = 0;
            while(end < m){
                if(tmp[end] > right_max){
                    right_max = tmp[end];
                }
                end++;
            }
            int get = Math.min(left_max, right_max);
            if(get - tmp[start] > 0){
                sum = sum + (get - tmp[start]);
            }
//            System.out.println(get - tmp[start]);
            start++;
        }
        System.out.println(sum);
    }
}

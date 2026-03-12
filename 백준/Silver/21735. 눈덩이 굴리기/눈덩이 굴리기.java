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

    static int n,m,ans;
    static int [] tmp;
    static void DFS(int start, int time, int size){
        if(time == m || start >= n){
            ans = Math.max(ans, size);
            return;
        }

        if(start + 1 <= n){
            DFS(start + 1, time + 1, size + tmp[start + 1]);
        }
        if(start + 2 <= n){
            DFS(start + 2, time + 1, size / 2 + tmp[start + 2]);
        }

        ans = Math.max(ans, size);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        ans = 0;
        tmp = new int[n + 1];
        st = new StringTokenizer(br.readLine());
        for(int i = 1; i <= n; i++){
            tmp[i] = Integer.parseInt(st.nextToken());
        }
        DFS(0,0,1);
        System.out.println(ans);
    }
}

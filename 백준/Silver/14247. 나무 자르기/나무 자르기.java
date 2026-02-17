import java.io.*;
import java.util.*;


class Node {
    int start;
    long tree;
    public Node(int start, long tree){
        this.start = start;
        this.tree = tree;
    }

}
public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] start = new  int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            start[i] = Integer.parseInt(st.nextToken());
        }
        Node [] tmp = new Node[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            tmp[i] = new  Node(start[i], Integer.parseInt(st.nextToken()));
        }
        Arrays.sort(tmp, (a,b) -> Long.compare(a.tree, b.tree));
        long sum = 0;
        for(int i = 0; i < n; i++){
            sum = sum + (tmp[i].tree * (i)) + tmp[i].start;
        }
        System.out.println(sum);

    }
}

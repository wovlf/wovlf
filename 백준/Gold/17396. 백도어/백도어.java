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

    static int n,m;
    static long [] dist;
    static int [] check;
    static ArrayList<Node> [] list;
    static void BFS(){
        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0,0));
        dist[0] = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.end == n - 1){
                System.out.println(node.index);
                return;
            }
            if(node.index != dist[node.end]){
                continue;
            }
            for(Node no : list[node.end]){
                if(dist[no.end] > dist[node.end] + no.index){
                    dist[no.end] = dist[node.end] + no.index;
                    queue.add(new Node(no.end, dist[no.end]));
                }
            }

        }
        System.out.println("-1");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new  ArrayList[n];
        dist = new long[n];
        check = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i=0;i<n;i++){
            list[i] = new ArrayList<>();
            check[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.fill(dist,Long.MAX_VALUE);
        for(int i=0;i<m;i++){
            st = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(!((check[a] == 1 && a != n - 1) || (check[b] == 1 && b != n - 1))){
                list[a].add(new Node(b,c));
                list[b].add(new Node(a,c));
            }
        }
        BFS();
    }
}

import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int index;
    int num;
    public Node(int index,int num){
        this.index=index;
        this.num=num;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.num,o.num);
    }
}

public class Main {

    static int a,b,n;
    static int [] tmp;
    static boolean [] visited;
    static PriorityQueue<Node> queue;
    static void BFS(){

        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.index == b){
                System.out.println(node.num);
                return;
            }
            if(node.index + 1 < 1000 && !visited[node.index + 1]){
                visited[node.index + 1] = true;
                queue.add(new  Node(node.index+1,node.num + 1));
            }
            if(node.index - 1 > 0 && !visited[node.index - 1]){
                visited[node.index - 1] = true;
                queue.add(new  Node(node.index - 1,node.num + 1));
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        a =  Integer.parseInt(st.nextToken());
        b =  Integer.parseInt(st.nextToken());
        n = Integer.parseInt(br.readLine());
        tmp = new int[n + 1];
        visited = new boolean[1010];
        queue = new PriorityQueue<>();
        for(int i = 0;i<n;i++){
            int k = Integer.parseInt(br.readLine());
            queue.add(new Node(k,  1));
            visited[k] = true;
        }
        queue.add(new Node(a,0));
        visited[a] = true;
        BFS();
    }
}

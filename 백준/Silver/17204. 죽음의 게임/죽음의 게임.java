import java.io.*;
import java.util.*;

class Node{
    int num;
    int count;
    public Node(int num, int count){
        this.num = num;
        this.count = count;
    }
}

public class Main {

    static int n,m;
    static ArrayList<Node> [] list;
    static boolean[] visited;
    static void BFS(){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.addFirst(new  Node(m,0));
        visited[m] = true;
        while(!queue.isEmpty()){
            Node node = queue.pollFirst();
            if(node.num == 0){
                System.out.println(node.count);
                return;
            }
            for(Node no: list[node.num]){
                if(!visited[no.num]){
                    visited[no.num] = true;
                    queue.addLast(new Node(no.num,node.count+1));
                }
            }
        }
        System.out.println("-1");
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new  StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        list = new ArrayList[n];
        visited = new boolean[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            st = new  StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            list[num].add(new Node(i, 0));
        }
        BFS();

    }
}

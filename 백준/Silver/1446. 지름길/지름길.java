import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int end;
    int index;
    public Node(int end, int index){
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.index, o.index);
    }
}

public class Main {

    static int n,m;
    static HashMap<Integer, ArrayList<Node>> map;
    static PriorityQueue<Node> queue;
    static void BFS(){
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.end == m){
                System.out.println(node.index);
                return;
            }
            if(map.containsKey(node.end)){
                for(Node no : map.get(node.end)){
                    queue.add(new Node(no.end, node.index + no.index));
                }
            }
            queue.add(new  Node(node.end + 1, node.index+1));
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        queue = new PriorityQueue<>();
        map = new HashMap<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());
            if(!map.containsKey(x)){
                map.put(x,new ArrayList<>());
            }
            map.get(x).add(new Node(y,z));
        }
        queue.add(new Node(0,0));
        BFS();
    }
}

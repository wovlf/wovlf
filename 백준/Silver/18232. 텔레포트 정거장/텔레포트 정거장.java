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

    static int n,m,s,e;
    static boolean [] visited;
    static HashMap<Integer, Integer> map;
    static PriorityQueue<Node> queue;
    static ArrayList<Integer> [] list;
    static void BFS(){
        queue = new PriorityQueue<>();
        queue.add(new Node(s, 0));
        visited[s] = true;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(node.num == e){
                System.out.println(node.time);
                return;
            }

            if(node.num - 1 > 0 && !visited[node.num - 1]){
                visited[node.num - 1] = true;
                queue.add(new Node(node.num - 1, node.time + 1));
            }

            if(node.num + 1 <= n && !visited[node.num + 1]){
                visited[node.num + 1] = true;
                queue.add(new Node(node.num + 1, node.time + 1));
            }

            if(!list[node.num].isEmpty()){
                for(Integer num :  list[node.num]){
                    if(!visited[num]){
                        visited[num] = true;
                        queue.add(new Node(num, node.time + 1));
                    }
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        s = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        visited = new boolean[n + 1];
        map = new HashMap<>();
        list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            list[x].add(y);
            list[y].add(x);
        }
        BFS();
    }
}

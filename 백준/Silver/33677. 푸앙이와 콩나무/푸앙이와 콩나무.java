import java.io.*;
import java.util.*;
import java.util.function.Predicate;

class Node implements Comparable<Node>{
    int num;
    int time;
    int water;
    public Node(int num, int time,int water){
        this.num = num;
        this.time = time;
        this.water = water;
    }
    @Override
    public int compareTo(Node o) {
        int tmp = Integer.compare(this.time, o.time);
        if(tmp!=0){
            return tmp;
        }
        return Integer.compare(this.water,o.water);
    }
}

public class Main
    {

        static int n;
        static PriorityQueue<Node> queue;
        static boolean[] visited;
        static void DFS(){
            queue = new PriorityQueue<>();
            queue.add(new Node(1,1, 1));
            visited[1] = true;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                visited[node.num] = true;
                if(node.num == n){
                    System.out.println(node.time + " " + node.water);
                    return;
                }
                if(node.num + 1 <= n && !visited[node.num + 1]){
                    queue.add(new Node(node.num + 1, node.time + 1, node.water + 1));
                }
                if(node.num * 3 <= n && !visited[node.num * 3]){
                    queue.add(new Node(node.num * 3, node.time + 1, node.water + 3));
                }
                if((int) Math.pow(node.num, 2) <= n && !visited[(int) Math.pow(node.num, 2)]){
                    queue.add(new Node((int) Math.pow(node.num, 2), node.time + 1, node.water + 5));
                }
            }

        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            n = Integer.parseInt(br.readLine());
            visited = new boolean[1000010];
            if(n == 0){
                System.out.println(0 + " " + 0);
                return;
            }
            DFS();
        }
    }
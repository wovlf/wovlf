import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    String universe;
    String name;
    int solve;
    int penalty;
    Node(String universe, String name, int solve, int penalty){
        this.universe = universe;
        this.name = name;
        this.solve = solve;
        this.penalty = penalty;
    }
    @Override
    public int compareTo(Node o) {
        int tmp = Integer.compare(o.solve, this.solve);
        if(tmp == 0){
            return Integer.compare(this.penalty, o.penalty);
        }
        return tmp;
    }
}

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> map  = new HashMap<>();
        PriorityQueue<Node> queue = new PriorityQueue<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String universe = st.nextToken();
            String name = st.nextToken();
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            queue.add(new Node(universe, name, a, b));
        }
        int tmp = 0;
        for(int i = 0; i < n; i++){
            if(tmp == m){
                break;
            }
            Node node =  queue.poll();

            if(!map.containsKey(node.universe)){
                map.put(node.universe, true);
                System.out.println(node.name);
                tmp++;
            }
        }

    }
}

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

public class Main
{
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        PriorityQueue<Node> queue = new PriorityQueue<>();
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        ArrayList<Node> [] list = new ArrayList[n + 1];
        boolean [] visited = new boolean[n + 1];
        for(int i = 1; i <= n; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a =  Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a == b){
                continue;
            }
            list[a].add(new Node(b,c));
            list[b].add(new Node(a,c));
        }
        queue.add(new Node(1,0));
        int sum = 0;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            if(!visited[node.index]){
                visited[node.index] = true;
                sum += node.num;
            }
            for(Node no : list[node.index]){
                if(!visited[no.index]){
                    queue.add(no);
                }
            }

        }
        System.out.println(sum);
    }
}
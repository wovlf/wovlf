import java.io.*;
import java.util.*;
class Node {
    int num;
    int count;
    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

public class Main
{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        ArrayList<Node> [] list = new ArrayList[n + 1];
        for(int i = 0; i <= n; i++){
            list[i] = new ArrayList<>();
        }


        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b, 1));
            list[b].add(new Node(a, 1));
        }

        ArrayDeque<Node> queue;
        int get = 0;
        boolean [] visited;
        int min = Integer.MAX_VALUE;
        for(int i = 1;i<=n;i++){
            visited = new boolean[n + 1];
            queue = new ArrayDeque<>();
            queue.add(new Node(i,0));
            visited[i] = true;
            int sum = 0;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                sum = sum + node.count;
                for(Node no : list[node.num]){
                    if(!visited[no.num]){
                        queue.add(new Node(no.num, node.count+1));
                        visited[no.num] = true;
                    }
                }
            }
            if(sum < min){
                min = sum;
                get = i;
            }
        }
        System.out.println(get);
    }
}
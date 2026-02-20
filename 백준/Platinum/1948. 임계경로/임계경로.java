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


    static int n,m;
    static ArrayList<Node> [] list;
    static int [] data;
    static int [] dist;
    static ArrayList<Integer> [] prev;
    static PriorityQueue<Node> queue;
    static int start,end;
    static boolean [][] visited;
    static int count;

    static void BFS(){

        for(int i = 1;i<=n;i++){
            if(data[i]==0){
                queue.add(new Node(i,0));
            }
        }

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(node.index == n){
                System.out.println(node.num);
            }
            for(Node no : list[node.index]){
                data[no.index]--;
                int tmp = dist[no.index];
                dist[no.index]= Math.max(dist[no.index],dist[node.index]+no.num);
                if(tmp < dist[no.index]){
                    prev[no.index] = new ArrayList<>();
                    prev[no.index].add(node.index);
                }else if(tmp == dist[node.index]+no.num){
                    prev[no.index].add(node.index);
                }
                if(data[no.index] == 0){
                    queue.add(new Node(no.index,dist[no.index]));
                }
            }
        }

        DFS(end);

    }

    static void DFS(int k){
        for(Integer num : prev[k]){
            if(!visited[num][k]){
                visited[num][k]=true;
                count++;
                DFS(num);
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());
        list = new ArrayList[n+1];
        data = new int[n+1];
        dist = new int[n+1];
        queue = new PriorityQueue<>();
        prev = new ArrayList[n+1];
        visited = new boolean[n + 1][n + 1];
        for(int i = 0;i<=n;i++){
            list[i] = new ArrayList<>();
            prev[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            list[a].add(new Node(b,c));
            data[b]++;
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());
        BFS();
        System.out.println(count);
//        for(int i = 1;i<=n;i++){
//            for(Integer num : prev[i]){
//                System.out.print(num+" ");
//            }
//            System.out.println();
//        }


    }
}

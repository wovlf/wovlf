    import java.io.*;
    import java.util.*;

    class Node implements Comparable<Node>{
        int index;
        int num;
        public Node(int index, int num){
            this.index = index;
            this.num = num;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.num, o.num);
        }
    }

    public class Main
    {
        static int n;
        static int m;
        static int [] dist;
        static ArrayList<Node>[] list;
        static boolean[] visited;

        static void BFS(){
            dist[1] = 0;
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(1,0));
            visited[1] = true;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                for(Node no : list[node.index]){
                    if(dist[no.index] > dist[node.index] + no.num){
                        dist[no.index] = dist[node.index] + no.num;
                        queue.add(new Node(no.index, dist[no.index]));
                    }
                }
            }
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st =  new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            dist = new int[n + 1];
            list = new ArrayList[n + 1];
            visited = new boolean[n + 1];
            for(int i = 0;i<=n;i++){
                list[i] = new ArrayList<>();
                dist[i] = Integer.MAX_VALUE;
            }

            for(int i = 0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int num = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b, num));
                list[b].add(new Node(a, num));
            }

            BFS();

            System.out.println(dist[n]);
        }
    }
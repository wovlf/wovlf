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
        static int n;
        static int d;
        static int c;
        static ArrayList<Node> [] list;
        static int [] dist;
        static void BFS(int start){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(start,0));
            dist[start]=0;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                for(Node no : list[node.index]){
                    if (dist[no.index] > dist[node.index] + no.num) {
                        dist[no.index] = dist[node.index] + no.num;
                        queue.add(new Node(no.index,dist[no.index]));
                    }
                }
            }

        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int test = Integer.parseInt(br.readLine());
            for(int t=0;t<test;t++){
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                list = new ArrayList[n + 1];
                dist = new  int [n + 1];
                Arrays.fill(dist,Integer.MAX_VALUE);
                for(int i = 0;i<=n;i++){
                    list[i] = new ArrayList<>();
                }
                for(int i = 0;i<d;i++){
                    st = new  StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int s = Integer.parseInt(st.nextToken());
                    list[b].add(new Node(a, s));
                }

                BFS(c);
                int count = 0;
                int max = 0;
                for(int i = 1;i<=n;i++){
                    if(dist[i] != Integer.MAX_VALUE){
                        count++;
                        if(dist[i] > max){
                            max = dist[i];
                        }
                    }
                }
                System.out.println(count + " " + max);
            }
        }
    }
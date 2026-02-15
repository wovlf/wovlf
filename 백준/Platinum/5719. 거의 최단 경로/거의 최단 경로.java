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
        static int n,m,s,d;
        static ArrayList<Node> [] list;
        static int [] dist;
        static ArrayList<Integer> [] prev;
        static boolean [][] visited;
        static PriorityQueue<Node> queue;

        static void BFS(int s, int d){
            queue = new PriorityQueue<>();
            dist[s] = 0;
            queue.add(new Node(s, 0));
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.num != dist[node.index]){
                    continue;
                }

                for(Node no : list[node.index]){
                    if(dist[no.index] > dist[node.index] + no.num){
                        dist[no.index] = dist[node.index] + no.num;
                        prev[no.index] = new ArrayList<>();
                        prev[no.index].add(node.index);
                        queue.add(new Node(no.index, dist[no.index]));
                    }
                    else if(dist[no.index] == dist[node.index] + no.num) {
                        prev[no.index].add(node.index);
                    }
                }

            }
            search(prev[d], d);

        }
        static void search(ArrayList<Integer> list2, int index){
            for(Integer i : list2){
                if(!visited[i][index]){
                    visited[i][index] = true;
                    search(prev[i], i);
                }
            }
        }
        static void BFS2(int s, int d){
            queue = new PriorityQueue<>();
            dist[s] = 0;
            queue.add(new Node(s, 0));
            boolean flag = false;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.index == d){
                    flag = true;
                    System.out.println(node.num);
                    break;
                }
                if(node.num != dist[node.index]){
                    continue;
                }

                for(Node no : list[node.index]){
                    if(dist[no.index] > dist[node.index] + no.num && !visited[node.index][no.index]){
                        dist[no.index] = dist[node.index] + no.num;
                        queue.add(new Node(no.index, dist[no.index]));
                    }
                }

            }
            if(!flag){
                System.out.println("-1");
            }

        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            while(true){
                st = new StringTokenizer(br.readLine());
                n = Integer.parseInt(st.nextToken());
                m = Integer.parseInt(st.nextToken());
                if(n == 0 && m == 0){
                    return;
                }
                st = new StringTokenizer(br.readLine());
                s = Integer.parseInt(st.nextToken());
                d = Integer.parseInt(st.nextToken());
                list = new ArrayList[n];
                dist = new int[n];
                prev =  new ArrayList[n];
                visited = new boolean[n][n];
                Arrays.fill(dist, Integer.MAX_VALUE);
                for(int i=0;i<n;i++){
                    list[i] = new ArrayList<>();
                    prev[i] = new ArrayList<>();
                }

                for(int i=0;i<m;i++){
                    st = new StringTokenizer(br.readLine());
                    int a = Integer.parseInt(st.nextToken());
                    int b = Integer.parseInt(st.nextToken());
                    int c = Integer.parseInt(st.nextToken());
                    list[a].add(new Node(b,c));
                }

                BFS(s,d);
                Arrays.fill(dist, Integer.MAX_VALUE);
                BFS2(s,d);


            }

        }
    }
import java.io.*;
import java.util.*;

class Node implements Comparable<Node>{
    int index;
    int num;
    boolean visited; 

    public Node(int index, int num, boolean visited){
        this.index = index;
        this.num = num;
        this.visited = visited;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.num, o.num);
    }
}

public class Main {

    static int n, m, t;
    static int s, g, h;
    static ArrayList<Node>[] list;
    static int[] dist;
    static HashSet<Integer> num;
    static boolean[] best;
    static ArrayList<Integer> get;
    static boolean[] added;

    static void BFS(int start){
        PriorityQueue<Node> queue = new PriorityQueue<>();

        dist[start] = 0;
        best[start] = false;

        queue.add(new Node(start, 0, false));

        while(!queue.isEmpty()){
            Node node = queue.poll();

            if(dist[node.index] != node.num) continue;

            boolean cur = best[node.index];
            if(num.contains(node.index) && cur && !added[node.index]){
                added[node.index] = true;
                get.add(node.index);
            }

            for(Node no : list[node.index]){
                int nd = dist[node.index] + no.num;
                boolean ngh = cur || no.visited;

                if(dist[no.index] > nd){
                    dist[no.index] = nd;
                    best[no.index] = ngh;
                    queue.add(new Node(no.index, nd, ngh));
                }
                else if(dist[no.index] == nd){
                    if(ngh && !best[no.index]){
                        best[no.index] = true;
                        queue.add(new Node(no.index, nd, true));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int test = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < test; test_case++){
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            t = Integer.parseInt(st.nextToken());

            st = new StringTokenizer(br.readLine());
            s = Integer.parseInt(st.nextToken());
            g = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            list = new ArrayList[n + 1];
            dist = new int[n + 1];
            best = new boolean[n + 1];
            added = new boolean[n + 1];

            get = new ArrayList<>();
            Arrays.fill(dist, Integer.MAX_VALUE);

            for(int i = 1; i <= n; i++){
                list[i] = new ArrayList<>();
            }

            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());

              
                if((a == g && b == h) || (a == h && b == g)){
                    list[a].add(new Node(b, c, true));
                    list[b].add(new Node(a, c, true));
                } else {
                    list[a].add(new Node(b, c, false));
                    list[b].add(new Node(a, c, false));
                }
            }

            num = new HashSet<>();
            for(int i = 0; i < t; i++){
                int k = Integer.parseInt(br.readLine());
                num.add(k);
            }

            BFS(s);

            Collections.sort(get);
            for(Integer x : get){
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }
}

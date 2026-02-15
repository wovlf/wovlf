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

        static int n,m;
        static int a,b,c;
        static int d,r;
        static ArrayList<Node> [] list;
        static boolean [] visited;
        static PriorityQueue<Node> queue;
        static boolean BFS(int mid){
            queue = new PriorityQueue<>();
            queue.add(new Node(d,0));
            visited[d] = true;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.index == r){
                    return true;
                }
                for(Node no : list[node.index]){
                    if(no.num >= mid && !visited[no.index]){
                        visited[no.index] = true;
                        queue.add(new Node(no.index,no.num));
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new  ArrayList[n+1];
            for(int i = 0;i<=n;i++){
                list[i] = new ArrayList<>();
            }
            for(int i = 0;i<m;i++){
                st = new StringTokenizer(br.readLine());
                a = Integer.parseInt(st.nextToken());
                b = Integer.parseInt(st.nextToken());
                c = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b,c));
                list[b].add(new Node(a,c));
            }

            st = new StringTokenizer(br.readLine());
            d = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            int start = 1;
            int end = 1000000000;
            int ans = 0;
            while(start <= end){
                visited = new boolean[n + 1];
                int mid = (start + end) / 2;
                if(!BFS(mid)){
                    end = mid - 1;
                }else{
                    ans = mid;
                    start = mid + 1;
                }
            }
            System.out.println(ans);


        }
    }
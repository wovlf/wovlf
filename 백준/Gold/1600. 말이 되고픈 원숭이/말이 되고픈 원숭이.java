import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;


class Node implements Comparable<Node> {
    int x;
    int y;
    int count;
    int time;
    public Node(int x, int y, int count, int time){
        this.x = x;
        this.y = y;
        this.count = count;
        this.time = time;
    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.time, o.time);
    }

}

public class Main
    {
        static int k,n,m;
        static int [] dx = {1,-1,0,0};
        static int [] dy = {0,0,1,-1};
        static int [] jump_dx = {-1,-2,-2,-1,1,2,2,1};
        static int [] jump_dy = {-2,-1,1,2,-2,-1,1,2};
        static boolean in_range(int x, int y){
            if(x >= 0 && x < n && y >= 0 && y < m){
                return true;
            }
            return false;
        }

        static int [][] tmp;
        static boolean [][][] visited;
        static void BFS(){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(0,0,0,0));
            visited[0][0][0] = true;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.x == n -1 && node.y == m - 1){
                    System.out.println(node.time);
                    return;
                }
                if(node.count < k){
                    for(int t = 0; t < 8; t++){
                        int x = node.x + jump_dx[t];
                        int y = node.y + jump_dy[t];
                        if(in_range(x, y) && !visited[x][y][node.count + 1] && tmp[x][y] != 1){
                            queue.add(new Node(x, y, node.count + 1, node.time + 1));
                            visited[x][y][node.count + 1] = true;
                        }
                    }
                }

                for(int t = 0; t < 4; t++){
                    int x = node.x + dx[t];
                    int y = node.y + dy[t];
                    if(in_range(x, y) && !visited[x][y][node.count] && tmp[x][y] != 1){
                        queue.add(new Node(x, y, node.count, node.time + 1));
                        visited[x][y][node.count] = true;
                    }
                }

            }
            System.out.println("-1");
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            k = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            tmp = new int[n][m];
            visited = new boolean[n][m][k + 1];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j = 0;j<m;j++){
                    tmp[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            BFS();

        }
    }
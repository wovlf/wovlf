import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int x;
    int y;
    int time;
    public Node(int x,int y, int time) {
        this.x = x;
        this.y = y;
        this.time = time;

    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.time, o.time);
    }
}

public class Main {

    static int n,m;
    static int x1,x2,y1,y2;
    static int [][] tmp;
    static boolean [][] visited;
    static int [] dx = {1,-1,0,0};
    static int [] dy = {0,0,1,-1};
    static PriorityQueue<Node> queue;
    static boolean in_range(int x, int y){
        if(x > 0 && x<=n && y > 0 && y <=m){
            return true;
        }
        return false;
    }
    static int BFS(int x1, int y1){
        queue = new PriorityQueue<>();
        queue.add(new Node(x1,y1,0));
        while(!queue.isEmpty()){
            Node node = queue.poll();
            visited[node.x][node.y] = true;
            for(int k = 0;k<4;k++){
                int x = node.x + dx[k];
                int y = node.y + dy[k];
                if(in_range(x,y) && !visited[x][y]){
                    if(tmp[x][y] == 2){
                        return node.time + 1;
                    }
                    if(tmp[x][y] == 0){
                        tmp[x][y] = 3;
                        queue.add(new Node(x,y,node.time));
                    }else if(tmp[x][y] == 1){
                        tmp[x][y] = 3;
                        queue.add(new Node(x,y,node.time + 1));
                    }
                }
            }
        }

        return -1;

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tmp =  new int [n+1][m+1];
        st = new  StringTokenizer(br.readLine());
        x1 = Integer.parseInt(st.nextToken());
        y1 = Integer.parseInt(st.nextToken());
        x2 = Integer.parseInt(st.nextToken());
        y2 = Integer.parseInt(st.nextToken());
        visited = new boolean [n+1][m+1];
        for(int i = 1;i<=n;i++){
            String s = br.readLine();
            for(int j = 1;j<=m;j++){
                if(s.charAt(j - 1)=='#'){
                    tmp[i][j] = 2;
                }else if(s.charAt(j - 1)=='*'){
                    tmp[i][j] = 3;
                }else{
                    tmp[i][j] = s.charAt(j - 1) - 48;
                }
            }
        }
//        for(int i = 1;i<=n;i++){
//            for(int j = 1;j<=m;j++){
//                System.out.print(tmp[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(BFS(x1,y1));

    }
}

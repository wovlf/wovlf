import java.io.*;
import java.util.*;


class Node{
    int x;
    int y;
    public Node(int x, int y){
        this.x = x;
        this.y = y;
    }
}

public class Main {

    static int n,m,k;
    static int [][] tmp;
    static int [] dx = {-1,1,0,0};
    static int [] dy = {0,0,-1,1};
    static boolean in_range(int x , int y){
        if(x >= 0 && x < n && y >= 0 && y < n){
            return true;
        }
        return false;
    }
    static double BFS(int a, int b){
        ArrayDeque<Node> queue = new ArrayDeque<>();
        queue.add(new Node(a,b));
        int count = 0;
        tmp[a][b] = 2;
        count++;
        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(int t = 0; t < 4; t++){
                int x = node.x + dx[t];
                int y = node.y + dy[t];
                if(in_range(x , y) && tmp[x][y] == 0){
                    queue.add(new Node(x,y));
                    tmp[x][y] = 2;
                    count++;
                }
            }
        }
        return Math.ceil( (double) count / k);

    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new  StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        tmp = new int[n][n];
        for(int i = 0;i<n;i++){
            st = new  StringTokenizer(br.readLine());
            for(int j = 0;j<n;j++){
                tmp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 0;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(tmp[i][j] == 0 && m - count > 0){
                    double num = BFS(i,j);
                    count = count + (int)num;
                }
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<n;j++){
                if(tmp[i][j] == 0){
                    System.out.println("IMPOSSIBLE");
                    return;
                }
            }
        }

        if(count > 0){
            System.out.println("POSSIBLE");
            System.out.println(m - count);
        }else{
            System.out.println("IMPOSSIBLE");
        }



    }
}

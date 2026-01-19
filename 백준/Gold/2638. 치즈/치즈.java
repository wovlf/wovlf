    import java.io.*;
    import java.util.*;

    class Node {
        int x;
        int y;
        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }

    }


    public class Main
    {
        static int n;
        static int m;
        static int [][] tmp;
        static boolean [][] visited;
        static int [] dx = {1,0,-1,0};
        static int [] dy = {0,1,0,-1};
        static boolean in_range(int x, int y){
            if(x >= 0 && x < n && y >= 0 && y < m){
                return true;
            }
            return false;
        }

        static void BFS(int x, int y){
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(new Node(x,y));
            visited[x][y] = true;
            while(!queue.isEmpty()){
                Node node = queue.poll();
                for(int k = 0; k < 4; k++){
                    int nx =  node.x + dx[k];
                    int ny =  node.y + dy[k];
                    if(in_range(nx, ny) && !visited[nx][ny] && (tmp[nx][ny] == 0 || tmp[nx][ny] == 2)){
                        tmp[nx][ny] = 2;
                        queue.add(new Node(nx,ny));
                        visited[nx][ny] = true;
                    }
                }
            }
        }

        static void print(int [][] tmp){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    System.out.print(tmp[i][j] + " ");
                }
                System.out.println();
            }
        }

        static void check(int x, int y){
            int count = 0;
            for(int k = 0; k < 4; k++){
                int nx = x + dx[k];
                int ny = y + dy[k];
                if(in_range(nx, ny) && tmp[nx][ny] == 2){
                    count++;
                }
            }
            if(count >= 2){
                tmp[x][y] = 0;
            }
        }

        static boolean search(){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(tmp[i][j] == 1){
                        return false;
                    }
                }
            }
            return true;
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            tmp = new int[n][m];
            visited = new boolean[n][m];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                for(int j=0;j<m;j++){
                    tmp[i][j] = Integer.parseInt(st.nextToken());
                }
            }


            tmp[0][0] = 2;
            int clock = 0;
            while(true){

                visited = new boolean[n][m];
                BFS(0,0);
                if(search()){
                    break;
                }
                for(int i=0;i<n;i++){
                    for(int j=0;j<m;j++){
                        if(tmp[i][j] == 1){
                            check(i,j);
                        }
                    }
                }

                clock++;
            }
            System.out.println(clock);
        }
    }
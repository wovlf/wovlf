    import java.io.*;
    import java.util.*;

    class Node {
        int x;
        int y;
        int z;
        public Node(int x, int y, int z){
            this.x = x;
            this.y = y;
            this.z = z;
        }

    }


    public class Main
    {
        static int n;
        static int m;
        static int h;
        static int [][][] tmp;
        static boolean [][][] visited;
        static int [] dx = {1,0,-1,0,0,0};
        static int [] dy = {0,1,0,-1,0,0};
        static int [] dz = {0,0,0,0,1,-1};
        static ArrayList<Node > list;
        static ArrayDeque<Node> queue;
        static boolean in_range(int x, int y, int z){
            if(x >= 0 && x < n && y >= 0 && y < m && z >= 0  && z < h){
                return true;
            }
            return false;
        }

        static void BFS(){
            while(!queue.isEmpty()){
                Node node = queue.poll();
                for(int k = 0;k<6;k++){
                    int x = node.x + dx[k];
                    int y = node.y + dy[k];
                    int z = node.z + dz[k];
                    if(in_range(x, y, z) && tmp[x][y][z] == 0 && !visited[x][y][z]){
                        tmp[x][y][z] = 1;
                        list.add(new  Node(x, y, z));
                        visited[x][y][z] = true;
                    }
                }
            }
        }

        static void print(int [][][] tmp){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    for(int k = 0; k < h; k++){
                        System.out.print(tmp[i][j][k] + " ");
                    }
                    System.out.println();
                }
                System.out.println();
            }
            System.out.println();
        }

        static void check(int x, int y){

        }


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            tmp = new int[n][m][h];
            visited = new boolean[n][m][h];

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    st = new  StringTokenizer(br.readLine());
                    for(int k = 0; k < h; k++){
                        tmp[i][j][k] = Integer.parseInt(st.nextToken());
                    }
                }
            }

            queue = new ArrayDeque<>();

            list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    for(int k = 0; k < h; k++){
                        if(tmp[i][j][k] == 1 && !visited[i][j][k]){
                            list.add(new  Node(i, j, k));
                            visited[i][j][k] = true;
                        }
                    }
                }
            }

            int clock = -1;
            while(true){
                queue.addAll(list);
//                System.out.println(list.size());
//                print(tmp);
                if(list.isEmpty()){
                    break;
                }
                list.clear();
                BFS();
                clock++;
            }
            boolean flag = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    for(int k = 0; k < h; k++){
                        if(tmp[i][j][k] == 0){
                            flag = true;
                        }
                    }
                }
            }
            if(flag){
                System.out.println("-1");
            }else{
                System.out.println(clock);
            }

        }
    }
    import java.io.*;
    import java.util.*;

    class Node implements Comparable<Node>{
        int index;
        long num;
        int time;
        public Node(int index,long num, int time){
            this.index=index;
            this.num=num;
            this.time=time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.num,o.num);
        }
    }

    public class Main
    {
        static int n;
        static int m;
        static int [][] tmp;
        static ArrayList<Node> [] list;
        static long [][] dist;
        static boolean [][] check;

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new  StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            tmp = new int[n + 1][n + 1];
            dist = new long[n+1][n + 1];
            check = new boolean[n+1][n+1];
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    tmp[i][j] = 10000000;
                }
            }
            for(int i = 1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                if(tmp[a][b] > c){
                    tmp[a][b] = c;
                }
                if(tmp[b][a] > c){
                    tmp[b][a] = c;
                }
            }
            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(i == j){
                        continue;
                    }
                    dist[i][j] = j;
                }
            }
            for(int k = 1;k<=n;k++){
                for(int i = 1;i<=n;i++){
                    for(int j = 1;j<=n;j++){
                        if(i == j){
                            continue;
                        }
                        if(tmp[i][j] > tmp[i][k] + tmp[k][j]){
                            tmp[i][j] = tmp[i][k] + tmp[k][j];
                            dist[i][j] = dist[i][k];
                        }
                    }
                }
            }

            for(int i = 1;i<=n;i++){
                for(int j = 1;j<=n;j++){
                    if(i == j){
                        System.out.print("- ");
                    }else{
                        System.out.print(dist[i][j] + " ");
                    }
                }
                System.out.println();
            }



        }
    }
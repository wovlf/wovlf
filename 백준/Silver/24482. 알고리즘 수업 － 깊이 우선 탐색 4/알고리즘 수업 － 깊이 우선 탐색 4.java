import java.io.*;
import java.util.*;



public class Main
    {

        static void DFS(int r){

            for(int i : list[r]){
                if(!visited[i]){
                    dist[i] = dist[r] + 1;
                    visited[i] = true;
                    DFS(i);
                }
            }
        }

        static int n, m, r;
        static ArrayList<Integer> [] list;
        static int [] dist;
        static boolean [] visited;
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            list = new ArrayList[n + 1];
            for (int i = 0; i <= n; i++) {
                list[i] = new ArrayList<>();
            }

            for(int i = 1;i<=m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                list[a].add(b);
                list[b].add(a);
            }
            for(int i = 1;i<=n;i++){
                list[i].sort(Collections.reverseOrder());
            }
            dist = new int[n + 1];
            visited = new boolean[n + 1];
            Arrays.fill(dist, -1);
            dist[r] = 0;
            visited[r] = true;
            DFS(r);

            for(int i = 1;i<=n;i++){
                System.out.println(dist[i]);
            }


        }
    }
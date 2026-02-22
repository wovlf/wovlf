import java.io.*;
import java.util.*;




public class Main {

    static int n,m;
    static int [] parent;
    static boolean [] cycle;

    static boolean union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x == y){
            cycle[x] = true;
            return true;
        }

        parent[y] = x;         // union
        cycle[x] = cycle[x] || cycle[y];
        return false;
    }

    static int find(int a){
        if(a != parent[a]){
            return parent[a] = find(parent[a]);
        }

        return a;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String str;
        int test = 0;
        while(true){
            st = new  StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            if(n == 0 && m == 0){
                break;
            }
            test++;
            parent = new int[n + 1];
            for(int i = 1; i <= n; i++){
                parent[i] = i;
            }
            cycle = new boolean[n + 1];
            for(int i = 1; i <= m; i++){
                st = new StringTokenizer(br.readLine());
                int a1 = Integer.parseInt(st.nextToken());
                int b1 = Integer.parseInt(st.nextToken());
                union(a1, b1);
            }
            boolean [] check = new boolean[n + 1];
            int count = 0;
            for(int i = 1; i <= n; i++){
                int r = find(i);
                if(!check[r] && !cycle[r]){
                    check[r] = true;  
                    count++;
                }
            }

            if(count > 1){
                System.out.println("Case " + test + ": A forest of " + count + " trees.");
            }else if(count == 1){
                System.out.println("Case " + test + ": There is one tree.");
            }else{
                System.out.println("Case " + test + ": No trees.");
            }

        }

    }
}

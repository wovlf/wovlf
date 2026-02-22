import java.io.*;
import java.util.*;




public class Main {

    static int n,m;
    static int [] parent;
    static boolean flag;
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);

        if(x==y){
            flag = true;
        }
        parent[y]=x;
    }

    static int find(int x){
        if(x != parent[x]){
            return parent[x] = find(parent[x]);
        }
        return x;
    }


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new  StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        for(int i = 1; i <= m; i++){
            flag = false;
            st = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
            if(flag){
                System.out.println(i);
                return;
            }
        }
        System.out.println("0");

    }
}

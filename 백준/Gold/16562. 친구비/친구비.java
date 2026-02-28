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

public class Main {

    static int n,m,k;
    static int [] tmp;
    static int [] parent;
    static boolean [] visited;
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x!=y){
            if(tmp[x] <= tmp[y]){
                parent[y] = x;
            }else{
                parent[x] = y;
            }
        }
    }
    static int find(int x){
        if(parent[x]!=x){
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        st = new  StringTokenizer(br.readLine());
        tmp = new int[n + 1];
        parent = new int[n + 1];
        visited = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            tmp[i] = Integer.parseInt(st.nextToken());
            parent[i] = i;
        }
        for(int i = 0; i<m;i++){
            st = new  StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if(tmp[a] <= tmp[b]){
                union(a,b);
            }else{
                union(b,a);
            }

        }
        int sum = 0;
        for(int i = 1; i <= n; i++){
            if(!visited[parent[find(i)]]){
                sum = sum + tmp[parent[find(i)]];
                visited[parent[find(i)]] = true;
            }
        }
        if(sum > k){
            System.out.println("Oh no");
        }else{
            System.out.println(sum);
        }
    }
}

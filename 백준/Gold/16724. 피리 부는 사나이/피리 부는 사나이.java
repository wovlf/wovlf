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

    static int n,m;
    static char [][] tmp;
    static boolean[] visited;
    static int [] parent;
    static void union(int a1, int b1, int a2, int b2){
        int x = find((a1 - 1) * m + b1);
        int y = find((a2 - 1) * m + b2);
        if(x != y){
            parent[y] = x;
        }
    }
    static int find(int x){
        if(x != parent[x]){
            return parent[x] = find(parent[x]);
        }
        return x;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tmp = new char[n + 1][m + 1];
        visited = new boolean[(n * m) + 1];
        parent = new int[(n * m) + 1];
        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            for(int j = 1; j <= m; j++) {
                tmp[i][j] = s.charAt(j-1);
            }
        }
        for (int i = 1; i < parent.length; i++) {
            parent[i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if(tmp[i][j]=='U'){
                    union(i - 1, j, i,j);
                }else if(tmp[i][j]=='D'){
                    union(i + 1, j, i,j);
                }else if(tmp[i][j]=='L'){
                    union(i, j - 1, i,j);
                }else{
                    union(i, j + 1, i,j);
                }
            }
        }
        int count = 0;
        for(int i = 1; i<parent.length; i++){
            if(!visited[find(i)]){
                visited[find(i)]=true;
                count++;
            }
        }
        System.out.println(count);


    }
}

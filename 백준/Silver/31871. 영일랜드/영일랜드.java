import java.io.*;
import java.util.*;


class Node{
    int  data;
    int  index;
    public Node(int data, int index) {
        this.data = data;
        this.index = index;

    }
}

public class Main {

    static int n,m;
    static ArrayList<Node> [] list;
    static boolean [] visited;
    static int [][] tmp;
    static int max;

    static void DFS(int index, int sum){
        if(index == 0 && sum > 0){
            for(int i = 1;i<=n;i++){
                if(!visited[i]){
                    return;
                }
            }

            if(max < sum){
                max = sum;
            }
            return;
        }

        for(Node node : list[index]){
            if(!visited[node.data]){
                visited[node.data] = true;
                DFS(node.data,sum+node.index);
                visited[node.data] = false;
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(br.readLine());
        visited = new boolean[n + 1];
        list = new  ArrayList[n + 1];
        tmp = new int[n + 1][n + 1];
        max = 0;
        for (int i = 0; i < n + 1; i++) {
            list[i] = new ArrayList<>();
        }
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(tmp[a][b] < c){
                tmp[a][b] = c;
            }
        }
        for(int i = 0;i<=n;i++){
            for(int j = 0;j<=n;j++){
                if(tmp[i][j] > 0 && i != j){
                    list[i].add(new Node(j,tmp[i][j]));
                }
            }
        }
        DFS(0, 0);
        if(max == 0){
            System.out.println("-1");
        }else{
            System.out.println(max);
        }
    }
}

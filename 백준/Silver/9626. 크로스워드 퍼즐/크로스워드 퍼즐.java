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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new  StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        char [][] tmp = new char[n + a + d][m + b + c];
        for(int i = 0;i<tmp.length;i++){
            for(int j = 0;j<tmp[i].length;j++){
                if((i + j) % 2 == 0){
                    tmp[i][j] = '#';
                }else{
                    tmp[i][j] = '.';
                }
            }
        }
        for(int i = a;i< a + n;i++){
            String str = br.readLine();
            int k = 0;
            for(int j = b;j < b + m;j++){
                tmp[i][j] = str.charAt(k);
                k++;
            }
        }

        for(int i = 0;i<tmp.length;i++){
            for(int j = 0;j<tmp[i].length;j++){
                System.out.print(tmp[i][j]);
            }
            System.out.println();
        }
    }
}

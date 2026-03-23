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
        int test = Integer.parseInt(st.nextToken());
        for(int k = 0;k<test;k++){
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            char [] str = new char[n];
            st = new  StringTokenizer(br.readLine());
            for(int i = 0;i<n;i++){
                String s = st.nextToken();
                str[i] = s.charAt(0);
            }
            ArrayDeque<Character> queue = new ArrayDeque<>();
            queue.add(str[0]);
            for(int i = 1;i<n;i++){
                if(queue.peekFirst() >= str[i]){
                    queue.addFirst(str[i]);
                }else{
                    queue.addLast(str[i]);
                }
            }
            for(Character c : queue){
                System.out.print(c);
            }
            System.out.println();
        }
    }
}

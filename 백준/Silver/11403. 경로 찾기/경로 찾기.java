import java.io.*;
import java.util.*;
class Node {
    int num;
    int count;
    public Node(int num, int count) {
        this.num = num;
        this.count = count;
    }
}

public class Main
{

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        long [][] tmp = new long[n + 1][n + 1];
        for(int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 1; j <= n; j++) {
                tmp[i][j] = Long.parseLong(st.nextToken());
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                for(int k = 1; k <= n; k++) {
                    if(tmp[j][i] != 0 && tmp[i][k] != 0){
                        tmp[j][k] = 1;
                    }
                }
            }
        }
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= n; j++) {
                System.out.print(tmp[i][j] + " ");
            }
            System.out.println();
        }
    }
}
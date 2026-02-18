import java.io.*;
import java.util.*;



public class Main {

    static int [] dx = {-1,-1,-1,0,0,1,1,1};
    static int [] dy = {-1,0,1,-1,1,-1,0,1};
    static int n,m;
    static boolean in_range(int x, int y){
        if(x >= 0 && x < n && y >= 0 && y < m){
            return true;
        }
        return false;
    }
    static void search(int x, int y, int k){
        tmp[x][y] = k;
        for(int s = 0;s<8;s++){
            int x1 = x + dx[s];
            int y1 = y + dy[s];
            if(in_range(x1,y1)){
                count[x1][y1][k] = true;
            }
        }
    }
    static int [][] tmp;
    static boolean [][][] count;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        tmp = new int[n][m];
        count = new boolean[n][m][5];
        boolean flag = false;
        int memo = 0;
        for(int k = 1; k < 5; k++){
            flag = false;
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(!count[i][j][k] && tmp[i][j] == 0){
                        search(i,j,k);
                        flag = true;
                    }
                }
            }
            if(flag){
                memo = k;
            }
        }
        bw.write(memo+"\n");
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                bw.write(tmp[i][j]+" ");
            }
            bw.newLine();
        }
        bw.close();
    }
}

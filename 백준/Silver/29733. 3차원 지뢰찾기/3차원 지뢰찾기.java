import java.io.*;
import java.util.*;




public class Main {

    static int n,m,h;
    static int [] dx = {-1,-1,-1,-1,-1,-1,-1,-1,-1,0,0,0,0,0,0,0,0,1,1,1,1,1,1,1,1,1};
    static int [] dy = {-1,-1,-1,0,0,0,1,1,1,-1,-1,-1,0,0,1,1,1,-1,-1,-1,0,0,0,1,1,1};
    static int [] dh = {-1,0,1,-1,0,1,-1,0,1,-1,0,1,-1,1,-1,0,1,-1,0,1,-1,0,1,-1,0,1};
    static boolean in_range(int x, int y, int z){
        if(x >= 0 && x < n && y >= 0 && y < m && z >= 0 && z < h){
            return true;
        }
        return false;
    }
    static char [][][] tmp;
    static int [][][] get;
    static void BFS(int h, int x, int y){
        int count = 0;
        for(int k = 0;k<26;k++){
            int a = h + dh[k];
            int b = x + dx[k];
            int c = y + dy[k];
            if(in_range(b,c,a) && tmp[a][b][c] == '*'){
                count++;
            }
        }
        get[h][x][y] = (count % 10);
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());
        tmp = new char[h][n][m];
        get = new int[h][n][m];
        for(int i=0;i<h;i++){
            for(int j=0;j<n;j++){
                String s = br.readLine();
                for(int k=0;k<m;k++){
                    tmp[i][j] = s.toCharArray();
                }
            }
        }
        for(int k = 0;k<h;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    BFS(k,i,j);
                }
            }
        }
        for(int k = 0;k<h;k++){
            for(int i=0;i<n;i++){
                for(int j=0;j<m;j++){
                    if(tmp[k][i][j] == '*'){
                        bw.write(tmp[k][i][j]+"");
                    }else{
                        bw.write(get[k][i][j]+"");
                    }
                }
                bw.write("\n");
            }
        }
        bw.close();


    }
}

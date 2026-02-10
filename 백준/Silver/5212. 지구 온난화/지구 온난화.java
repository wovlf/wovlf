import java.io.*;
import java.util.*;



public class Main
    {
        static int n;
        static int m;
        static char [][] tmp;
        static char [][] ans;
        static int [] dx = {1,-1,0,0};
        static int [] dy = {0,0,1,-1};

        static int search(int x, int y){
            int count = 0;
            for(int k = 0; k < 4; k++){
                int x1 = x + dx[k];
                int y1 = y + dy[k];
                if(!in_range(x1, y1) || tmp[x1][y1] == '.'){
                    count++;
                }
            }
            return count;
        }
        static boolean in_range(int x, int y){
            if(x >= 0 && x < n && y >= 0 && y < m){
                return true;
            }
            return false;
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            st = new  StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            tmp = new char[n][m];
            ans = new char[n][m];
            for(int i = 0;i<n;i++){
                String str = br.readLine();
                tmp[i] = str.toCharArray();
            }

            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(tmp[i][j]=='X'){
                        if(search(i,j) >= 3){
                            ans[i][j] = '.';
                        }else{
                            ans[i][j] = 'X';
                        }
                    }else{
                        ans[i][j] = tmp[i][j];
                    }
                }
            }


            int x1 = 0;
            int y1 = 100;

            int x2 = 100;
            int y2 = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                   if(ans[i][j]=='X'){
                       if(x1 <= i){
                           x1 = i;
                       }
                       if(x2 >= i){
                           x2 = i;
                       }
                       if(y1 >= j){
                           y1 = j;
                       }
                       if(y2 <= j){
                           y2 = j;
                       }
                   }
                }
            }

            for(int i = x2;i<=x1;i++){
                for(int j = y1;j<=y2;j++){
                    System.out.print(ans[i][j]);
                }
                System.out.println();
            }

        }
    }
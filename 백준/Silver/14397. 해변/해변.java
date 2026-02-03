    import java.io.*;
    import java.util.*;


    public class Main
    {
        static int n;
        static int m;
        static char [][] ch;
        static int [] dx = {-1, -1, 0 , 0, 1, 1};
        static int [] dy = {0, 1, -1, 1, 1, 0};
        static int [] dy2 = {-1 ,0, -1, 1, 0, -1};
        static boolean in_range(int x , int y){
            if(x >= 0 && x < n && y >= 0 && y < m){
                return  true;
            }
            return false;
        }
        static int search(int x ,int y){
            int count = 0;
            if(x % 2 == 0){
                for(int k = 0;k<6;k++){
                    int nx = x + dx[k];
                    int ny = y + dy2[k];
                    if(in_range(nx,ny) && ch[nx][ny] == '#'){
                        count++;
                    }
                }
            }else{
                for(int k = 0;k<6;k++){
                    int nx = x + dx[k];
                    int ny = y + dy[k];
                    if(in_range(nx,ny) && ch[nx][ny] == '#'){
                        count++;
                    }
                }
            }
            return count;

        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new  StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            ch = new char[n][m];
            for(int i = 0;i<n;i++){
                String str = br.readLine();
                for(int j = 0;j<m;j++){
                    ch[i][j] = str.charAt(j);
                }
            }
            int count = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if(ch[i][j]=='.'){
                        count = count + search(i,j);
                    }
                }
            }

            System.out.println(count);
        }
    }
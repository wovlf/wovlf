import java.io.*;
import java.util.*;



public class Main {

    static int [] dx = {-1,1,0,0,-1,1,-1,1};
    static int [] dy = {0,0,-1,1,-1,1,1,-1};
    static char [][] ch;
    static char [][] ans;
    static void search(int x, int y){
        for(int i = 0;i<3;i++){
            int count = 0;
            for(int j = 0;j<3;j++){
               if(ch[i][j] == check){
                   count++;
               }
            }
            if(count == 3){
                for(int a = 0;a<3;a++){
                    for(int j = 0;j<3;j++){
                        ans[a][j] = ch[a][j];
                    }
                }
            }

        }

        for(int j = 0;j<3;j++){
            int count = 0;
            for(int i = 0;i<3;i++){
                if(ch[i][j] == check){
                    count++;
                }
            }
            if(count == 3){
                for(int a = 0;a<3;a++){
                    for(int b = 0;b<3;b++){
                        ans[a][b] = ch[a][b];
                    }
                }
            }
        }
        int count = 0;
        for(int i = 0;i<3;i++){
            if(ch[i][i] == check){
                count++;
            }
        }
        if(count == 3){
            for(int a = 0;a<3;a++){
                for(int j = 0;j<3;j++){
                    ans[a][j] = ch[a][j];
                }
            }
        }

        count = 0;
        int t = 2;
        for(int i = 0;i<3;i++){
            if(ch[i][t] == check){
                count++;
            }
            t--;
        }
        if(count == 3){
           for(int i = 0;i<3;i++){
               for(int j = 0;j<3;j++){
                   ans[i][j] = ch[i][j];
               }
           }
        }
    }
    static char check;
    static boolean in_range(int x, int y){
        if(x >= 0 && x < 3 && y >= 0 && y < 3){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int test = Integer.parseInt(br.readLine());
        ch = new char[3][3];
        for(int test_case = 1; test_case <= test; test_case++){
            ans = new char[3][3];
            for(int i = 0; i < 3; i++){
                String s =  br.readLine();
                ch[i] = s.toCharArray();
            }
            check = br.readLine().charAt(0);
            ans[1][1] = '*';
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    if(ch[i][j] == '-'){
                        ch[i][j] = check;
                        search(i,j);
                        ch[i][j] = '-';
                    }
                }
            }
            System.out.println("Case " + test_case + ":");
            for(int i = 0; i < 3; i++){
                for(int j = 0; j < 3; j++){
                    System.out.print(ans[i][j]);
                }
                System.out.println();
            }

        }
    }
}

import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int m;
    static int [][] a;
    static boolean [][] visited;
    static int sum = 0;
    static StringBuilder sb;
    static int [] searchX_dx = {0,-1,1,-1}; // x탐색할때는 위,왼쪽,오른쪽,아래 순서
    static int [] searchX_dy = {1,0,0,-1}; // y탐색할때는 위,왼쪽,오른쪽,아래 순서
    static int [] searchY_dx = {-1,0,0,1}; // x탐색할때는 왼쪽,아래,위,오른쪽 순서
    static int [] searchY_dy = {0,1,-1,0}; // y탐색할때는 왼쪽,아래,위,오른쪽 순서
    static void searchX(int k){ // =|탐색
        for(int i= 2 * k;i<=2 * k + 1;i++) {
            if(i % 2 == 0){
                for(int j = 0;j<m;j++){
                    visited[i][j] = true;
                    if(i == n - 1 && j == m -1){
                        continue;
                    }
                    if(j == m - 1){
                        sb.append("D");
                    }
                    else{
                        sb.append("R");
                    }
                }
            }
            else{
                for(int j = m - 1;j >= 0 ;j--){
                    visited[i][j] = true;
                    if(j == 0){
                        sb.append("D");
                    }
                    else{
                        sb.append("L");
                    }
                }
            }
        }
    }
    static void searchX2(int k){
        for(int i= 2 * k;i<=2 * k + 1;i++) {
            if(i % 2 == 1){
                for(int j = 0;j<m;j++){
                    visited[i][j] = true;
                    if(i == n - 1 && j == m -1){
                        continue;
                    }
                    if(j == m - 1){
                        sb.append("D");
                    }
                    else{
                        sb.append("R");
                    }
                }
            }
            else{
                for(int j = m - 1;j >= 0 ;j--){
                    visited[i][j] = true;
                    if(j == 0){
                        sb.append("D");
                    }
                    else{
                        sb.append("L");
                    }
                }
            }
        }
    }
    static void searchY(int k){
        visited[k * 2][0] = true;
        int x = 0;
        int y = k * 2;
        while(x != m - 1 || y != k * 2 + 1 ){
            for(int test = 0; test < 4;test++){
                x = x + searchY_dx[test];
                y = y + searchY_dy[test];
                if(x >= 0 && x < m && y >= k * 2 && y <= k * 2 + 1 && !visited[y][x]){
                    if(test == 0){
                        visited[y][x] = true;
                        sb.append("L");
                        break;
                    }
                    else if(test == 1){
                        visited[y][x] = true;
                        sb.append("D");
                        break;
                    }
                    else if(test == 2){
                        visited[y][x] = true;
                        sb.append("U");
                        break;
                    }
                    else{
                        visited[y][x] = true;
                        sb.append("R");
                        break;
                    }
                }
                else{
                    x = x - searchY_dx[test];
                    y = y - searchY_dy[test];
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        sb = new StringBuilder();
        a = new int[n][m];
        visited = new boolean[n][m];
        for(int i = 0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0;j<m;j++){
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(n % 2 == 0 && m % 2 == 0){ // 행과열 둘다 짝수인경우
            int num = 1000;
            int x = 0;
            int y = 0;
            for(int i = 0;i<n;i++){
                for(int j = 0;j<m;j++){
                    if((i + j) % 2 == 1){
                        if(a[i][j] < num){
                            y = i;
                            x = j;
                            num = a[i][j];
                        }
                    }
                }
            }
            visited[y][x] = true;
            int k = y / 2;
            for(int i = 0;i<n / 2;i++){ // k횟수만큼 가로탐색 시작
                if(i == k){
                    searchY(i);
                    if(i != n / 2 - 1){
                        sb.append("D");
                    }
                }
                else if(i < k){
                     searchX(i);
                }
                else{
                     searchX2(i);
                   // if(i != n / 2 - 1){
                   //   sb.append("D");
                   // }
                }
            }
        }
        else if(n % 2 == 0){ // 행만 짝수
            for(int j = 0;j<m;j++){
                if(j % 2 == 0){
                    for(int i = 0;i<n;i++){
                        if(i == n - 1 && j == m -1){
                            continue;
                        }
                        if(i == n - 1){
                            sb.append("R");
                        }
                        else{
                            sb.append("D");
                        }
                    }
                }
                else{
                    for(int i = n -1;i >= 0;i--){
                        if(i == 0){
                            sb.append("R");
                        }
                        else{
                            sb.append("U");
                        }
                    }
                }
            }
        }
        else{ // 열만 짝수,둘다 홀수
            for(int i = 0;i<n;i++){
                if(i % 2 == 0){
                    for(int j = 0;j<m;j++){
                        if(i == n - 1 && j == m -1){
                            continue;
                        }
                        if(j == m - 1){
                            sb.append("D");
                        }
                        else{
                            sb.append("R");
                        }
                    }
                }
                else{
                    for(int j = m - 1;j >= 0 ;j--){
                        if(j == 0){
                            sb.append("D");
                        }
                        else{
                            sb.append("L");
                        }
                    }
                }
            }
        }
        System.out.println(sb);

    }
}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        int [] a = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0;i<n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }
        int [] visited = new int[1000001];
        int count = 0;
        for(int i = 0;i<visited.length;i++){
            visited[i] = 0;
        }
        for(int i = 0;i<n;i++){
            if(visited[a[i]] == 0){
                count++;
                visited[a[i] - 1]++;
            }
            else{
                visited[a[i]]--;
                visited[a[i] - 1]++;
            }
        }
        System.out.println(count);
    }
}
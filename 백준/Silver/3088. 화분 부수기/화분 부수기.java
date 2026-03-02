import java.io.*;
import java.util.*;




public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int [][] tmp = new int[n][3];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                tmp[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int count = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(tmp[0][0]);
        set.add(tmp[0][1]);
        set.add(tmp[0][2]);
        for (int i = 1; i < n; i++) {
            boolean flag = false;
            for (int j = 0; j < 3; j++) {
                if(set.contains(tmp[i][j])) {
                    flag = true;
                }
            }
            for (int j = 0; j < 3; j++) {
                set.add(tmp[i][j]);
            }
            if(!flag){
                count++;
            }
        }
        System.out.println(count);

    }
}

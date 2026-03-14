import java.io.*;
import java.util.*;


class Node{
    int end;
    long index;
    public Node(int end, long index){
        this.end = end;
        this.index = index;
    }


}

public class Main {
    static int n,m;
    static int [] dx = {-2, 0 ,0 ,2};
    static int [] dy = {0, -2, 2, 0};
    static boolean in_range(int x, int y){
        if(x > 0 && x <= n && y > 0 && y <= n){
            return true;
        }
        return false;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        HashSet<List<Integer>> set =  new HashSet<>();
        HashMap<List<Integer>, Integer> map = new HashMap<>();
        int [] a = new int[m];
        int [] b = new int[m];
        for(int i = 0;i<m;i++){
            st = new StringTokenizer(br.readLine());
            a[i] = Integer.parseInt(st.nextToken());
            b[i] = Integer.parseInt(st.nextToken());
            map.put(List.of(a[i],b[i]), 1);
        }
        for(int i = 0;i<m;i++){
            for(int k = 0;k<4;k++){
                int x = a[i] + dx[k];
                int y = b[i] + dy[k];
                if(in_range(x,y) && !map.containsKey(List.of(x,y))){
                    set.add(List.of(x,y));
                }
            }
        }

        System.out.println(set.size());
    }
}

import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int end;
    long index;
    public Node(int end, long index){
        this.end = end;
        this.index = index;
    }

    @Override
    public int compareTo(Node o) {
        return Long.compare(this.index, o.index);
    }
}

public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            if(!map.containsKey(str)){
                map.put(str,1);
            }else{
                map.put(str, map.get(str) + 1);
            }
        }
        int max = 0;
        String str = "0";
        for(String s : map.keySet()){
            if(map.get(s) > max){
                max = map.get(s);
                str = s;
            }
        }
        System.out.println(str);
    }
}

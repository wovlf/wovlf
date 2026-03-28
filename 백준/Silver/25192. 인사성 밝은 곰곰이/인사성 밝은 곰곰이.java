import java.io.*;
import java.util.*;


class Node implements Comparable<Node>{
    int num;
    int time;
    public Node(int num, int time) {
        this.num = num;
        this.time = time;

    }

    @Override
    public int compareTo(Node o) {
        return Integer.compare(this.time, o.time);
    }
}

public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        HashMap<String, Boolean> map = new HashMap<>();
        int count = 0;
        for(int i = 0; i < n; i++){
            String s = br.readLine();
            if(s.equals("ENTER")){
                map = new HashMap<>();
            }else{
                if(!map.containsKey(s)){
                    map.put(s, true);
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

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
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean [] tmp = new boolean[21];
        for(int test = 0 ;test<n ;test++){
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("add")){
                int num = Integer.parseInt(st.nextToken());
                tmp[num] = true;
            }else if(str.equals("remove")){
                int num = Integer.parseInt(st.nextToken());
                tmp[num] = false;
            }else if(str.equals("check")){
                int num = Integer.parseInt(st.nextToken());
                if(tmp[num]){
                    bw.write("1"+"\n");
                }else{
                    bw.write("0"+"\n");
                }
            }else if(str.equals("toggle")){
                int num = Integer.parseInt(st.nextToken());
                if(tmp[num]){
                    tmp[num] = false;
                }else{
                    tmp[num] = true;
                }
            }else if(str.equals("all")){
                    for(int i = 1;i<=20;i++){
                        tmp[i] = true;
                    }
            }else if(str.equals("empty")){
                for(int i = 1;i<=20;i++){
                    tmp[i] = false;
                }
            }
        }
        bw.close();
    }
}

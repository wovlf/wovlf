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

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        char [] ch = br.readLine().toCharArray();
        for(int i = 1;i<n;i++){
            String str = br.readLine();
            for(int j = 0;j<ch.length;j++){
                if(ch[j] != str.charAt(j) && ch[j] != '?'){
                    ch[j] = '?';
                }
            }

        }
        for(int i = 0;i<ch.length;i++){
            System.out.print(ch[i]);
        }
    }
}

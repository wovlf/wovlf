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
        String str = br.readLine();
        char [] ch = str.toCharArray();
        long sum = 0;
        int k = 0;
        for(int i = 0;i<ch.length;i++){
            long tmp = 1;
            for(int j = 0;j<i;j++){
                tmp = (tmp * 31) % 1234567891;
            }
            sum = ((sum  % 1234567891 ) + ((ch[i] - 96) * tmp) % 1234567891) % 1234567891;
            k++;
        }
        System.out.println(sum);
    }
}

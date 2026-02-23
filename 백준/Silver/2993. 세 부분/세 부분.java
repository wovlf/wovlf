import java.io.*;
import java.util.*;




public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        String s = br.readLine();
        String [] str = new String[3];
        String ans = null;
        for(int i = 1; i <= s.length() - 2; i++){
            for(int j = i + 1; j <= s.length() - 1; j++){
                str[0] = s.substring(0,i);
                str[1] = s.substring(i,j);
                str[2] = s.substring(j);

//                System.out.println(str[0] + " " + str[1] + " " + str[2]);
                StringBuilder sb;
                String get = new StringBuilder(str[0]).reverse().toString() + new StringBuilder(str[1]).reverse().toString() + new StringBuilder(str[2]).reverse().toString();
                if(ans == null || ans.compareTo(get) > 0){
                    ans = get;
                }
            }
        }
        System.out.println(ans);

    }
}

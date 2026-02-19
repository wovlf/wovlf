import java.io.*;
import java.util.*;



public class Main {



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        String [] str = new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }
        int index = 0;
        while(!str[0].equals("KBS1")) {
            if(!str[index].equals("KBS1")){
                index++;
                sb.append("1");
            }else if(str[index].equals("KBS1")){
                String s = str[index];
                str[index] = str[index - 1];
                str[index - 1] = s;
                index--;
                sb.append("4");
            }
        }
        while(!str[1].equals("KBS2")) {
            if(!str[index].equals("KBS2")){
                index++;
                sb.append("1");
            }else if(str[index].equals("KBS2")){
                String s = str[index];
                str[index] = str[index - 1];
                str[index - 1] = s;
                index--;
                sb.append("4");
            }
        }
        System.out.println(sb);
    }
}

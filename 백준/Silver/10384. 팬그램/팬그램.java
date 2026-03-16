import java.io.*;
import java.util.*;




public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        for(int i = 1; i <= n; i++){
            String s = br.readLine();
            s = s.toLowerCase();
            int [] tmp = new int[27];
            String [] str = s.split(" ");
            for(int j = 0; j < str.length; j++){
                for(int k = 0; k < str[j].length(); k++){
                    int num = (int)str[j].charAt(k) - 96;
                    if(num >= 1 && num < 27){
                        tmp[num]++;
                    }
                }
            }
            int min = Integer.MAX_VALUE;
            for(int k = 1; k < tmp.length; k++){
                if(tmp[k] < min){
                    min = tmp[k];
                }
            }
            if(min == 0){
                System.out.println("Case " + i + ": " + "Not a pangram");
            }else if(min == 1){
                System.out.println("Case " + i + ": " + "Pangram!");
            }else if(min == 2){
                System.out.println("Case " + i + ": " + "Double pangram!!");
            }else{
                System.out.println("Case " + i + ": " + "Triple pangram!!!");
            }
        }

    }
}

    import java.io.*;
    import java.util.*;


    public class Main
    {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new  StringTokenizer(br.readLine());
            String str = st.nextToken();
            int n = Integer.parseInt(st.nextToken());
            double sum = 0;
            char [] ch = str.toCharArray();
            for(int i = 0;i<ch.length;i++){
                if((int)ch[i] >= 65){
                   sum = sum +  ((int)ch[i] - 55) * Math.pow(n,(ch.length - i - 1));
                }else{
                    sum = sum +  ((int)ch[i] - 48) * Math.pow(n,(ch.length - i - 1));
                }
            }
            System.out.println((int)sum);


        }
    }
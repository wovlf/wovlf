    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            String s1 = st.nextToken();
            String s2 = st.nextToken();
            int min = 1000;
            for(int i = 0;i<=s2.length() - s1.length();i++){
                int count = 0;
                for(int j = 0;j<s1.length();j++){
                    if(s1.charAt(j) != s2.charAt(i+j)){
                        count++;
                    }
                }
                if(count < min){
                    min = count;
                }
            }

            System.out.println(min);
        }
    }
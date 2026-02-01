    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;

            double sum = 0;
            double num = 0;
            for(int k = 0; k<20;k++){
                st = new StringTokenizer(br.readLine());
                String s = st.nextToken();
                double a = Double.parseDouble(st.nextToken());
                String str = st.nextToken();
                if(str.equals("P")){
                    continue;
                }
                num = num + a;
                if(str.equals("A+")){
                    sum = sum + (4.5 * a);
                }else if(str.equals("A0")){
                    sum = sum + (4.0 * a);
                }else if(str.equals("B+")){
                    sum = sum + (3.5 * a);
                }else if(str.equals("B0")){
                    sum = sum + (3.0 * a);
                }else if(str.equals("C+")){
                    sum = sum + (2.5 * a);
                }else if(str.equals("C0")){
                    sum = sum + (2.0 * a);
                }else if(str.equals("D+")){
                    sum = sum + (1.5 * a);
                }else if(str.equals("D0")){
                    sum = sum + a;
                }
            }
            System.out.println(String.format("%.6f",sum / num));


        }
    }
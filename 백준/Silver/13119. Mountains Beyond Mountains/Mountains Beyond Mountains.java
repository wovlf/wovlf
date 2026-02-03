    import java.io.*;
    import java.util.*;


    public class Main
    {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringBuffer sb = new StringBuffer();
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            st = new  StringTokenizer(br.readLine());
            int [] tmp = new int [m];
            char [][] ch = new char[n][m];
            for(int i=0;i<m;i++)
            {
                tmp[i] = Integer.parseInt(st.nextToken());
            }

            for(int i = n - 1;i>=0;i--){
                for(int j = 0;j<m;j++){

                    if(i == x - 1){
                        if(tmp[j] > i){
                            sb.append("*");
                        }else{
                            sb.append("-");
                        }
                    }
                    else if(tmp[j] > i){
                        sb.append("#");
                    }else if(j % 3 == 2 && x > i){
                        if(i < x - 1){
                            sb.append("|");
                        }
                    }
                    else{
                        sb.append(".");
                    }
                }
                sb.append("\n");
            }

            System.out.println(sb);
        }
    }
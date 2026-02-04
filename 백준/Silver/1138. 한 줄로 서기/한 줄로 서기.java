    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            int [] tmp = new int[n];
            st = new  StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            int [] ans = new int[n];
            for(int i = 0;i<n;i++){
                int count = tmp[i];
                int get = 0;
                for(int j = 0;j<n;j++){
                    if(ans[j] == 0){
                        if(count == get){
                            ans[j] = i + 1;
                            break;
                        }else{
                            get++;
                        }
                    }
                }
            }

            for(int i = 0;i<n;i++){
                System.out.print(ans[i]+" ");
            }






        }
    }
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
                tmp[i] =  Integer.parseInt(st.nextToken());
            }
            int answer = Integer.parseInt(br.readLine());
            Arrays.sort(tmp);
            int start = 0;
            int end = n - 1;
            int count = 0;
            while(start<end){
                if(tmp[start] + tmp[end] > answer){
                    end--;
                }else if(tmp[start] + tmp[end] < answer){
                    start++;
                }else{
                    count++;
                    start++;
                    end--;
                }
            }
            System.out.println(count);

        }
    }
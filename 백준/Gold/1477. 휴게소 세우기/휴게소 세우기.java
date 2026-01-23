    import java.io.*;
    import java.util.*;



    public class Main
    {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st =  new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int [] tmp = new int[n + 2];
            tmp[0] = 0;
            tmp[n + 1] = l;
            for(int i = 1;i<=n;i++){
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tmp);
            int [] sum = new  int[n + 1];
            for(int i = 1;i<=n + 1;i++){
                sum[i - 1] = tmp[i] - tmp[i - 1];
            }

            int start = 1;
            int end = l - 1;
            int answer = 0;
            while(start<=end){
                int mid = (start+end)/2;
                int count = 0;
                for(int i = 0;i<sum.length;i++){
                    count = count + (sum[i] - 1) / mid;
                }
                if(count > m){
                    start = mid + 1;

                }else{
                    answer = mid;
                    end = mid - 1;
                }
            }
            System.out.println(answer);
        }
    }
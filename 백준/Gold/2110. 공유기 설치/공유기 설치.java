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
            long [] tmp = new long[n];
            for(int i=0;i<n;i++){
                tmp[i] = Integer.parseInt(br.readLine());
            }
            Arrays.sort(tmp);
            long start = 0;
            long end = tmp[tmp.length-1];
            long answer = 0;
            while(start<=end){
                long mid = (start+end)/2;
                int count = 0;
                int index = 0;
                for(int i = 1;i<n;i++){
                    if(tmp[i] - tmp[index] >= mid){
                        count++;
                        index = i;
                    }
                }
                if(count >= m - 1){
                    answer = mid;
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
            System.out.println(answer);

        }
    }
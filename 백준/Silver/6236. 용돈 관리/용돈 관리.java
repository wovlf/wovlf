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
            int [] tmp = new int[n];
            int min = 0;
            int max = 0;
            for(int i = 0; i<n;i++){
                tmp[i] = Integer.parseInt(br.readLine());
                max = max + tmp[i];
                if(tmp[i]>min){
                    min = tmp[i];
                }
            }
            int start = min;
            int end = max;
            int answer = -1;
            while(start<=end){
                int mid =  (start + end)/ 2;
                int count = 1;
                int index = mid;
                for(int i = 0;i<n;i++){
                    if(tmp[i] < index){
                        index = index - tmp[i];
                    }else if(tmp[i] == index){
                        if(i == n - 1){
                            continue;
                        }
                        count++;
                        index = mid;
                    }
                    else{
                        count++;
                        index = mid - tmp[i];
                    }
                }
                if(count <= m){
                    end = mid - 1;
                    answer = mid;
                }else{
                    start = mid + 1;
                }
                // System.out.println(mid + " " + count);
            }
            System.out.println(answer);

        }
    }
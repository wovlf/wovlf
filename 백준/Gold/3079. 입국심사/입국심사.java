    import java.io.*;
    import java.util.*;

    class Node implements Comparable<Node>{
        int num;
        int time;
        public Node(int num, int time){
            this.num = num;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.time, o.time);
        }
    }

    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            long m = Integer.parseInt(st.nextToken());
            long [] tmp = new long[n];
            for(int i=0;i<n;i++){
                tmp[i] = Integer.parseInt(br.readLine());
            }

            long start = 1;
            long end = 1000000000 * m;
            long ans = 0;
            while(start<=end){
                long mid =  (start + end) / 2;
                long sum = 0;
                for(int i=0;i<n;i++){
                    sum = sum + mid / tmp[i];
                    if(sum >= m){
                        break;
                    }
                }
                if(sum >= m){
                    end = mid - 1;
                    ans = mid;
                }else{
                    start = mid + 1;
                }
            }
            System.out.println(ans);

        }
    }
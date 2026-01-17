    import java.io.*;
    import java.util.*;
    
    class Node implements Comparable<Node>{
        int index;
        int num;
        public Node(int index,int num){
            this.index=index;
            this.num=num;
        }
        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.num,o.num);
        }
    }
    
    public class Main
    {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int n = Integer.parseInt(br.readLine());
            int [] tmp = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int i = 0; i < n; i++) {
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tmp);
            int num = Integer.parseInt(br.readLine());
            int start = 1;
            int end = num;
            int mid = (start + end) / 2;
            int sum = 0;
            int answer = 0;
            while(start<=end){
                sum = 0;
                mid = (start + end) / 2;
                for(int i = 0;i<n;i++){
                    if(tmp[i] <= mid){
                        sum += tmp[i];
                    }else{
                        sum = sum + mid;
                    }
                }
                if(sum <= num){
                    answer = mid;
                    start = mid + 1;
                }
                else{
                    end = mid - 1;
                }
            }
            if(tmp[n - 1] < answer){
                System.out.println(tmp[n - 1]);
            }else{
                System.out.println(answer);
            }
        }
    }
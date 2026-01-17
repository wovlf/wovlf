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
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int [] tmp = new int[n];
            st = new  StringTokenizer(br.readLine());
            int sum = 0;
            for (int i=0;i<n;i++){
                tmp[i] = Integer.parseInt(st.nextToken());
                sum = sum + tmp[i];
            }
            int start = 1;
            int end = sum;
            int answer = 0;
            while(start<=end){
                int mid = (start+end)/2;

                int [] a = new int[m];
                int k = 0;
                boolean flag = false;
                for(int i=0;i<n;i++){
                    if(a[k] + tmp[i] <= mid){
                        a[k] += tmp[i];
                    }else{
                        k++;
                        if(k == m){
                            flag = true;
                            break;
                        }
                        if(a[k] + tmp[i] <= mid){
                            a[k] += tmp[i];
                        } else{
                            flag = true;
                            break;
                        }
                    }
                }

//                for(int i=0;i<m;i++){
//                    System.out.print(a[i]+" ");
//                }

                if(flag){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                    answer = mid;
                }
//                System.out.println(answer);
            }
            System.out.println(answer);

        }
    }
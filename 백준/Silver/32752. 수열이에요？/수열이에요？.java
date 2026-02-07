    import java.io.*;
    import java.util.*;

    class Node{
        int start;
        int end;
        public Node(int start, int end){
            this.start = start;
            this.end = end;
        }


    }

    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new  StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            int [] tmp = new int[n];
            st = new StringTokenizer(br.readLine());
            for(int i = 0 ;i<n;i++){
                tmp[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(tmp, l - 1,r);

            for(int i = 0;i<n - 1;i++){
                if(tmp[i] > tmp[i + 1]){
                    System.out.println("0");
                    return;
                }
            }
            System.out.println("1");

        }
    }
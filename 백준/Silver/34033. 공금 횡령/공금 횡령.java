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
            int m = Integer.parseInt(st.nextToken());
            HashMap<String, Integer> map = new HashMap<>();
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                map.put(str,num);
            }
            int count = 0;
            for(int i = 0; i < m; i++){
                st = new StringTokenizer(br.readLine());
                String str = st.nextToken();
                int num = Integer.parseInt(st.nextToken());
                if(map.get(str) * 1.05 < num ){
                    count++;
                }
            }
            System.out.println(count);


        }
    }
    import java.io.*;
    import java.util.*;

    class Node {
        int index;
        int num;
        int get;
        public Node(int index,int num, int get){
            this.index=index;
            this.num=num;
            this.get=get;
        }

    }

    public class Main
    {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            Node [] tmp = new  Node[n];
            int [] score = new int[n];
            for(int i=0;i<n;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                tmp[i] = new Node(a,b, 0);
            }
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    if(i == j){
                        continue;
                    }
                    if(tmp[i].num < tmp[j].num && tmp[i].index < tmp[j].index){
                        tmp[i].get += 1;
                    }
                }
            }

            for(int i=0;i<n;i++){
                System.out.print(tmp[i].get + 1+" ");
            }




        }
    }
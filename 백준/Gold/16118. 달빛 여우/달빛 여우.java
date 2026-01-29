    import java.io.*;
    import java.util.*;

    class Node implements Comparable<Node>{
        int index;
        long num;
        int time;
        public Node(int index,long num, int time){
            this.index=index;
            this.num=num;
            this.time=time;
        }

        @Override
        public int compareTo(Node o) {
            return Long.compare(this.num,o.num);
        }
    }

    public class Main
    {
        static int n;
        static int m;
        static ArrayList<Node> [] list;
        static long [] dist1;
        static long [][] dist2;
        static boolean [] visited;
        static void BFS(){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(1,0,0));
            dist1[1] = 0;
            while (!queue.isEmpty()){
                Node node = queue.poll();
                if(node.num > dist1[node.index]){
                    continue;
                }
                for(Node no : list[node.index]){
                    if(dist1[no.index] > dist1[node.index] + (no.num * 2)){
                        dist1[no.index] = dist1[node.index] + (no.num * 2);
                        queue.add(new Node(no.index,dist1[no.index],0));
                    }
                }
            }
        }

        static void BFS2(){
            PriorityQueue<Node> queue = new PriorityQueue<>();
            queue.add(new Node(1,0,0));
            dist2[1][1] = 0; // 0은 빠르게 가는시간
            while(!queue.isEmpty()){
                Node node = queue.poll();
                if(node.time % 2 == 0){
                    if(node.num > dist2[node.index][1]){
                        continue;
                    }
                }else{
                    if(node.num > dist2[node.index][0]){
                        continue;
                    }
                }
                for(Node no : list[node.index]){
                    if(node.time % 2 == 0){ // 지금이 속도 2배 이벤트일때
                        if(dist2[no.index][0] > dist2[node.index][1] + no.num ){
                            dist2[no.index][0] = dist2[node.index][1] + no.num;
                            queue.add(new Node(no.index, dist2[no.index][0], node.time + 1));
                        }

                    }else{
                        if(dist2[no.index][1] > dist2[node.index][0] + (no.num * 4) ){
                            dist2[no.index][1] = dist2[node.index][0] + (no.num * 4);
                            queue.add(new Node(no.index, dist2[no.index][1], node.time + 1));
                        }
                    }
                }
            }
        }
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st = new  StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            list = new  ArrayList[n+1];
            for(int i = 0;i<=n;i++){
                list[i] = new ArrayList<>();
            }
            dist1 = new long[n+1];
            dist2 = new long[n + 1][2];
            Arrays.fill(dist1,Integer.MAX_VALUE);
            for(int i = 0;i<=n;i++){
                Arrays.fill(dist2[i],Integer.MAX_VALUE);
            }
            for(int i = 0 ;i<m;i++){
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list[a].add(new Node(b,c, 0));
                list[b].add(new Node(a,c, 0));
            }

            BFS();
            BFS2();

//            for(int i = 1;i<=n;i++){
//                System.out.print(dist2[i][0] + " ");
//            }
//            System.out.println();
//            for(int i = 1;i<=n;i++){
//                System.out.print(dist2[i][1] + " ");
//            }

            int count = 0;
            for(int i = 1;i<=n;i++){
                if(dist1[i] < Math.min(dist2[i][0], dist2[i][1])){
                    count++;
                }
            }
            System.out.println(count);



        }
    }
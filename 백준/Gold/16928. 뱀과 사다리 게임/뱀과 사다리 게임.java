    import java.io.*;
    import java.util.*;

    class Node{
        int num;
        int index;
        public Node(int num, int index){
            this.num = num;
            this.index = index;
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
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int i=0;i<n;i++){
                st = new  StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }
            for(int i=0;i<m;i++){
                st = new  StringTokenizer(br.readLine());
                map.put(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
            }

            boolean [] visited = new boolean[101];
            ArrayDeque<Node> queue = new ArrayDeque<>();
            queue.add(new Node(1,0));
            visited[1] = true;
            while(!queue.isEmpty()){
                Node node = queue.poll();

                if(node.num == 100){
                    System.out.println(node.index);
                    break;
                }
                for(int i = 1;i<=6;i++){
                    if(node.num + i <= 100 && !visited[node.num + i]){
                        if(map.containsKey(node.num + i)){
                            if(!visited[map.get(node.num + i)]){
                                queue.add(new Node(map.get(node.num + i), node.index + 1));
                                visited[map.get(node.num + i)] = true;
                            }
                        } else {
                            queue.add(new Node(node.num + i, node.index + 1));
                            visited[node.num + i] = true;
                        }
                    }
                }

            }
        }
    }
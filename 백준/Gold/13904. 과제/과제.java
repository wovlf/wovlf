import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class Node2 implements Comparable<Node2>{
    int d;
    int w;
    public Node2(int d, int w){
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Node2 node2) {
        int tmp = -Integer.compare(this.w, node2.w);
        if(tmp != 0){
            return tmp;
        }
        return -Integer.compare(this.d, node2.d);
    }
}

class  Main {
    public static void main(String[] args) throws Exception{
           BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
           StringTokenizer st;
           int n = Integer.parseInt(br.readLine());
           LinkedList<Node2> list = new LinkedList<>();
           for(int i = 0;i<n;i++){
               st = new StringTokenizer(br.readLine());
               int day = Integer.parseInt(st.nextToken());
               int weight = Integer.parseInt(st.nextToken());
               list.add(new Node2(day, weight));
           }
           Collections.sort(list, (o1, o2) -> {
               int tmp = -Integer.compare(o1.d, o2.d);
               if(tmp != 0){
                   return tmp;
               }
               return -Integer.compare(o1.w, o2.w);
           });
           int sum = 0;
           PriorityQueue<Node2> queue = new PriorityQueue<>();
           for(int i = n;i>0;i--){
               if(list.size() != 0 && list.getFirst().d >= i){
                   while(list.size() != 0 && list.getFirst().d >= i){
                       queue.add(list.getFirst());
                       list.removeFirst();
                   }
               }
               if(!queue.isEmpty()){
                   sum = sum + queue.remove().w;
               }
           }
           System.out.println(sum);
    }

}
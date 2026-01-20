    import java.io.*;
    import java.util.*;




    public class Main
    {
        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            ArrayDeque<Integer> queue = new ArrayDeque<>();
            for(int i = 0; i < n; i++){
                st = new StringTokenizer(br.readLine());
                String str =  st.nextToken();
                if(str.equals("push_back")){
                    int a = Integer.parseInt(st.nextToken());
                    queue.addLast(a);

                }else if(str.equals("push_front")){
                    int a = Integer.parseInt(st.nextToken());
                    queue.addFirst(a);

                }else if(str.equals("pop_back")){
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(queue.pollLast());
                    }
                }else if(str.equals("pop_front")){
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(queue.pollFirst());
                    }
                }else if(str.equals("size")){
                    System.out.println(queue.size());
                }else if(str.equals("empty")){
                    if(queue.isEmpty()){
                        System.out.println("1");
                    }else{
                        System.out.println("0");
                    }
                }else if(str.equals("front")){
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(queue.peekFirst());
                    }
                }else if(str.equals("back")){
                    if(queue.isEmpty()){
                        System.out.println("-1");
                    }else{
                        System.out.println(queue.peekLast());
                    }
                }
            }

        }
    }
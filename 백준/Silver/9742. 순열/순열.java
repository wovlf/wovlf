    import java.io.*;
    import java.util.*;


    public class Main
    {
        static char [] ch;
        static char [] tmp;
        static int num;
        static int get;
        static boolean [] visited;
        static String s;
        static boolean flag;
        static void DFS(int count){
            if(count == ch.length){
                get++;
                if(get == num){
                    System.out.print(s + " " + num + " = ");
                    for(int i = 0;i<tmp.length;i++){
                        System.out.print(tmp[i]);
                    }
                    System.out.println();
                    flag = true;
                }

                return;
            }
            for(int i = 0;i<ch.length;i++){
                if(!visited[i]){
                    visited[i]=true;
                    tmp[count] = ch[i];
                    DFS(count+1);
                    visited[i]=false;
                }
            }
        }

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            String str = "";
            while((str = br.readLine()) != null){
                StringTokenizer st = new StringTokenizer(str);
                s = st.nextToken();
                num = Integer.parseInt(st.nextToken());
                get = 0;
                ch = s.toCharArray();
                visited = new boolean[ch.length];
                tmp = new char[ch.length];
                flag = false;
                DFS(0);
                if(!flag){
                    System.out.println(s + " " + num + " = No permutation");
                }
            }

        }
    }
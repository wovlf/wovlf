import java.io.*;
import java.util.*;




public class Main {

    static int n,m, trust;
    static int [] people;
    static int [] parent;
    static void union(int a, int b){
        int x = find(a);
        int y = find(b);
        if(x != y){
            parent[y] = x;
        }
    }
    static int find(int x){
        if(x == parent[x]){
            return x;
        }else{
            return parent[x] = find(parent[x]);
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        st = new  StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        parent = new int[n+1];
        st =  new  StringTokenizer(br.readLine());
        trust = Integer.parseInt(st.nextToken());
        if(trust > 0){
            people = new int[trust];
            for(int i = 0;i<people.length;i++){
                people[i] = Integer.parseInt(st.nextToken());
            }
        }
        for(int i = 1; i <= n; i++){
            parent[i] = i;
        }
        int [][] party = new int[m + 1][];
        for(int k = 1; k <= m;k++){
            st = new StringTokenizer(br.readLine());
            int num1 = Integer.parseInt(st.nextToken());
            party[k] = new int[num1];
            for(int i = 0; i < num1; i++){
                party[k][i] = Integer.parseInt(st.nextToken());
            }

            for(int i = 0; i < num1; i++){
                union(party[k][0], party[k][i]);
            }
        }

        HashSet<Integer> set = new HashSet<>();
        if(trust > 0){
            for(Integer i : people){
                set.add(find(i));
            }
        }
        int count = 0;
        for(int i = 1;i<=m;i++){
            boolean flag = false;
            for(Integer n : party[i]){
                if(set.contains(find(n))){
                    flag = true;
                    break;
                }
            }
            if(!flag){
                count++;
            }
        }

        System.out.println(count);


    }
}

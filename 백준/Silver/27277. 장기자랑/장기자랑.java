import java.io.*;
import java.util.*;



public class Main {


    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        ArrayList<Integer> list = new ArrayList<>();
        st = new  StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            list.add(Integer.parseInt(st.nextToken()));
        }
        Collections.sort(list);
        int start = 0;
        int end = list.size()-1;
        int sum = 0;
        sum = sum + list.get(end);
        int num = 1;
        while(start<end){
            if(num % 2 == 0){
                sum = sum + Math.max(0, list.get(end) - list.get(start));
                start++;
            }else{
                sum = sum + Math.max(0, list.get(start) - list.get(end));
                end--;
            }
            num++;
        }
        System.out.println(sum);


    }
}

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.function.Predicate;



public class Main
    {

        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            long [] tmp = new long[n];
            ArrayList<Long> low_list = new ArrayList<>();
            ArrayList<Long> high_list = new ArrayList<>();
            for(int i = 0; i < n; i++){
                tmp[i] = Integer.parseInt(br.readLine());
                if(tmp[i] <= 0){
                    low_list.add(tmp[i]);
                }else{
                    high_list.add(tmp[i]);
                }
            }
            Collections.sort(low_list);
            Collections.sort(high_list, Collections.reverseOrder());
            long sum = 0;
            for(int i = 0; i < low_list.size(); i++){
                if(i == low_list.size()-1){
                    sum += low_list.get(i);
                    continue;
                }

                sum += low_list.get(i) * low_list.get(i + 1);
                i++;
            }

            for(int i = 0;i < high_list.size(); i++){
                if(i == high_list.size()-1){
                    sum += high_list.get(i);
                    continue;
                }
                if(high_list.get(i) > 1 && high_list.get(i + 1) == 1){
                    sum += high_list.get(i);
                }
                else if(high_list.get(i) == 1){
                    sum += high_list.get(i);
                }else{
                    sum += high_list.get(i) * high_list.get(i + 1);
                    i++;
                }
            }
            System.out.println(sum);
        }
    }
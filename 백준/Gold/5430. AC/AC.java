import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;



class  Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int test_case = 1;test_case<=T;test_case++) {
            String str = br.readLine();
            StringBuilder sb = new StringBuilder();
            char[] query = str.toCharArray();
            int n = Integer.parseInt(br.readLine());
            LinkedList<Integer> list = new LinkedList<>();
            str = br.readLine();
            str = str.substring(1, str.length() - 1);
            String [] s;
            if(!str.equals("")){
                s = str.split(",");
            }else{
                s = new String[0];
            }
            for (int i = 0; i < s.length; i++) {
                list.add(Integer.parseInt(s[i]));
            }
            boolean flag = false;
            int point = 0;
            for (int i = 0; i < query.length; i++) {
                if (query[i] == 'D') { // 앞의 정수 제거
                    if (!list.isEmpty()) {
                        list.remove(point);
                        if(point != 0){
                            point--;
                        }
                    } else {
                        flag = true;
                        break;
                    }
                } else { // 펠린드롬
                    if(point == 0){
                        point = list.size() - 1;
                    }else{
                        point = 0;
                    }
                }
            }
            if (!flag) {
                sb.append("[");
                if(point != 0){
                    Collections.reverse(list);
                }
                int count = 1;
                for(int i : list){
                    sb.append(i);
                    if(count != list.size()){
                        sb.append(",");
                        count++;
                    }
                }
                sb.append("]");
                sb.append(" ");
            } else{
                sb.append("error");
                sb.append(" ");
            }
            System.out.println(sb);
        }
    }

}
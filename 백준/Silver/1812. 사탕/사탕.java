    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            int [] tmp = new int[n + 1]; // 진짜 값
            int [] get = new int[n + 1]; // 합친 값
            for(int i = 1;i<=n;i++){
                get[i] = Integer.parseInt(br.readLine());
            }
            boolean flag = false;
            for(int i = 0;i<= get[1];i++){
                tmp[1] = i;
                flag = false;
                for(int j = 1;j<=n;j++){
                    if(j == n){
                        if(tmp[n] + tmp[1] != get[n]){
                            flag = true;
                            break;
                        }else{
                            break;
                        }
                    }

                    if(get[j] - tmp[j] > 0){
                        tmp[j + 1] = get[j] - tmp[j];
                    }else{
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    break;
                }

            }

            for(int i = 1;i<=n;i++){
                System.out.println(tmp[i]);
            }

        }
    }
import java.io.*;
import java.util.*;



public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            int num;
            boolean [] tmp = new boolean[11];
            boolean flag = false;
            while(true){
                num = Integer.parseInt(br.readLine());
                if(num == 0){
                    break;
                }

                String str2 = br.readLine();

                if(str2.equals("too high")){
                    for(int i = num; i < 11;i++){
                        tmp[i] = true;
                    }

                }else if(str2.equals("too low")){
                    for(int i = num; i > 0;i--){
                        tmp[i] = true;
                    }
                }else{
                    for(int i = 1;i<11;i++){
                        if(!tmp[i]){
                            if(i == num){
                                flag = true;
                            }
                        }
                    }
                    if(!flag){
                        System.out.println("Stan is dishonest");
                    }else{
                        System.out.println("Stan may be honest");
                    }
                    tmp = new boolean[11];
                    flag = false;
                }



            }

        }
    }
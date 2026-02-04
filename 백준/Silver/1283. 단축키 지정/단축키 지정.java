    import java.io.*;
    import java.util.*;


    public class Main
    {


        public static void main(String[] args) throws Exception {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
            StringTokenizer st;
            int n = Integer.parseInt(br.readLine());
            HashMap<Character, Boolean> map = new HashMap<Character, Boolean>();
            String key ="";
            for(int i = 0;i<n;i++){
                key = br.readLine();
                String [] str = key.split(" ");
                boolean flag = false;
                for(int k = 0;k<str.length;k++){
                    if(!map.containsKey(str[k].toLowerCase().charAt(0))){
                        map.put(str[k].toLowerCase().charAt(0),true);
                        String s = "[" + str[k].charAt(0) + "]";
                        for(int t = 1;t<str[k].length();t++){
                            s = s + str[k].charAt(t);
                        }
                        str[k] = s;
                        flag = true;
                        break;
                    }
                }

                if(!flag){
                    for(int k = 0;k<str.length;k++){
                        for(int t = 1;t<str[k].length();t++){
                            if(!map.containsKey(str[k].toLowerCase().charAt(t))){
                                map.put(str[k].toLowerCase().charAt(t),true);
                                String s = "";
                                for(int h = 0;h<str[k].length();h++){
                                    if(h == t){
                                        s = s + "[" + str[k].charAt(t) + "]";
                                    }else{
                                        s = s + str[k].charAt(h);
                                    }
                                }
                                str[k] = s;
                                flag = true;
                                break;
                            }
                        }
                        if(flag){
                            break;
                        }
                    }
                }



                for(int j = 0;j<str.length;j++){
                    System.out.print(str[j] + " ");
                }
                System.out.println();
            }




        }
    }
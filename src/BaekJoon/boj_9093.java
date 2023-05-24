package BaekJoon;
import java.io.*;

// TODO: 2023/05/24 : 단어 뒤집기 https://www.acmicpc.net/problem/9093 
public class boj_9093  {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

            int n = Integer.parseInt(br.readLine());
            for (int i = 0; i <= n; i++) {
                String str = br.readLine();
                String[] str_arr = str.split(" ");
                for(int j = 0; j < str_arr.length ; j ++){
                    char[] ch = str_arr[j].toCharArray();
                    for(int k = ch.length-1;k>=0;k--){
                        bw.append(ch[k]);
                    }
                    if(j < str_arr.length-1){
                        bw.append(" ");
                    }
                }
                bw.flush();
                bw.write("\n");
            }
            bw.close();

    }
}

package BaekJoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// TODO: 2023/06/12 115655번 ROT13 (브론즈 1)
// TODO: 2023/06/12 !!성공!!
public class boj_11655 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int cat = 'z'-'a'+1;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(Character.isUpperCase(c)){
                if(c+13>'Z'){
                    c= (char) ((c+13-'Z')+'A'-1);
                }
                else{
                    c = (char)(c+13);
                }
                System.out.print(c);
            }
            else if(Character.isLowerCase(c)){
                if(c+13>'z'){
                    c= (char) ((c+13-'z')+'a'-1);
                }
                else{
                    c = (char)(c+13);
                }
                System.out.print(c);
            }
            else{
                System.out.print(s.charAt(i));
            }
        }
    }
}

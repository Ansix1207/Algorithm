import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringBuilder sb = new StringBuilder(br.readLine());
        String str = br.readLine();
        String[] arr = new String[]{"pi","ka","chu"};
//        System.out.println("start str -> " + str);
        str = str.replaceAll("pi|ka|chu","");
        if(str.length()==0){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
    }
}

import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int input = Integer.parseInt(br.readLine());
		Long answer = 1L;
		for(int i = 1 ; i <= input ; i ++){
			answer = (answer * i)%1_000_000_007;
		}
		System.out.println(answer);
	}
}
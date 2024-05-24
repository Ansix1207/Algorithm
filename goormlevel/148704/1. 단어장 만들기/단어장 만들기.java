import java.io.*;
import java.util.*;
class Main {
	public static void main(String[] args) throws Exception {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			StringTokenizer stk = new StringTokenizer(br.readLine(), " ");
			int N = Integer.parseInt(stk.nextToken());
			int K = Integer.parseInt(stk.nextToken())-1;
			String[] arr = new String[N];
			for (int i = 0; i < N; i++) {
					String temp = br.readLine();
					arr[i] = temp;
			}
			Arrays.sort(arr, ((x1,x2)-> {
					if (x1.length() == x2.length()){
							return x1.compareTo(x2);
					}
					return x1.length() - x2.length();
			}));
		System.out.println(arr[K]);
	}
}
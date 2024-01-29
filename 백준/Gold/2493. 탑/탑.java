
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String values = br.readLine();
        Deque<Integer> dq = new ArrayDeque<>(Stream.of(values.split(" ")).map(Integer::parseInt)
                .collect(Collectors.toCollection(ArrayDeque::new)));
        Deque<Integer> dq2 = new ArrayDeque<>();
        Deque<Integer> dq_h = new ArrayDeque<>();
        int i = 0;
        while(!dq.isEmpty()){
            int value = dq.pollFirst();
            i++;
            while(!dq2.isEmpty()){
                int top = dq2.getLast();
                if(top>=value){
                    System.out.print(dq_h.getLast()+" ");
                    dq2.addLast(value);
                    dq_h.addLast(i);
                    break;
                }else{
                    dq2.pollLast();
                    dq_h.pollLast();
                }
            }
            if(dq2.isEmpty()){
                System.out.print("0 ");
                dq2.addLast(value);
                dq_h.addLast(i);
            }

        }
    }
}

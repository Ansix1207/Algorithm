import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int coin_5 = 0 ;
        int coin_2 = 0;
        if(n/5 >= 1 ) // 1개보다 더 크면
        {
            coin_5 = n/5;
            n=n%5;
        }
        while(n!=0){
            if(n==0)
                break;
            if(coin_5 == 0 &&n%2!=0){
                n=-1;
                System.out.println(-1);
                return;
            }
                if(n%2!=0){
                    coin_5--;
                    n+=5;
                    continue;
                }else if(n%2==0){
//                    coin_5-=i;
                    coin_2=(n)/2;
                    n = 0;
                }
        }
        System.out.println(coin_5+coin_2);
    }
}

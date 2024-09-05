import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class PrimeNumber {
    // 5. 소수(에라토스테네스 체)
    // 설명

    // 자연수 N이 입력되면 1부터 N까지의 소수의 개수를 출력하는 프로그램을 작성하세요.

    // 만약 20이 입력되면 1부터 20까지의 소수는 2, 3, 5, 7, 11, 13, 17, 19로 총 8개입니다.


    // 입력
    // 첫 줄에 자연수의 개수 N(2<=N<=200,000)이 주어집니다.


    // 출력
    // 첫 줄에 소수의 개수를 출력합니다.


    // 예시 입력 1

    // 20
    // 예시 출력 1

    // 8

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        boolean primeNum [] = new boolean[n+1];

        primeNum[0] = true;
        primeNum[1] = true;

        for(int i=2;(i*i)<=n;i++){
            if(primeNum[i]==true) continue;
            for(int j=i*2;j<=n;j+=i){
                if(primeNum[i]==true) continue;
                else primeNum[j] = true;
            }
        }

       
        int ans = 0;
        for(int i=0;i<=n;i++){
            if(primeNum[i]==false) ans+=1;
        }

        System.out.println(ans);
    }
}
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Fibonacci {
    // 4. 피보나치 수열
    // 설명

    // 1) 피보나키 수열을 출력한다. 피보나치 수열이란 앞의 2개의 수를 합하여 다음 숫자가 되는 수열이다.

    // 2) 입력은 피보나치 수열의 총 항의 수 이다. 만약 7이 입력되면 1 1 2 3 5 8 13을 출력하면 된다.


    // 입력
    // 첫 줄에 총 항수 N(3<=N<=45)이 입력된다.


    // 출력
    // 첫 줄에 피보나치 수열을 출력합니다.


    // 예시 입력 1

    // 10
    // 예시 출력 1

    // 1 1 2 3 5 8 13 21 34 55


    static int arr [];
    static StringBuilder sb = new StringBuilder();

    static int fib(int n){
        if(n == 1||n ==2){
            arr[n] = 1;
            return arr[n];
            //return arr[n];
        }else if(arr[n]!=0){
            return arr[n];
        }else{
            arr[n-1] = fib(n-1);
            arr[n-2] = fib(n-2);
            return arr[n-1]+arr[n-2];
        }
    }

    public static void main(String [] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n+1];
        arr[n] = fib(n);

        for(int i=1;i<arr.length;i++){
            sb.append(arr[i]+" ");
        }
        System.out.println(sb.toString());
       
    }

}
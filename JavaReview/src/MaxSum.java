import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaxSum {
    // 9. 격자판 최대합
    // 설명

    // 5*5 격자판에 아래롸 같이 숫자가 적혀있습니다.

    // Image1.jpg

    // N*N의 격자판이 주어지면 각 행의 합, 각 열의 합, 두 대각선의 합 중 가 장 큰 합을 출력합니다.


    // 입력
    // 첫 줄에 자연수 N이 주어진다.(2<=N<=50)

    // 두 번째 줄부터 N줄에 걸쳐 각 줄에 N개의 자연수가 주어진다. 각 자연수는 100을 넘지 않는다.


    // 출력
    // 최대합을 출력합니다.


    // 예시 입력 1

    // 5
    // 10 13 10 12 15
    // 12 39 30 23 11
    // 11 25 50 53 15
    // 19 27 29 37 27
    // 19 13 30 13 19
    // 예시 출력 1

    // 155

    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int tmpSum;
        int tmpSum2;
        int n = Integer.parseInt(br.readLine());
        int [][] arr = new int[n][n];

        String [] in ;
        for(int i=0;i<n;i++){
            in = br.readLine().split(" ");
            for(int j=0;j<n;j++){
                arr[i][j] = Integer.parseInt(in[j]);
            }
        }
       
        for(int i=0;i<n;i++){
            tmpSum=0;
            tmpSum2=0;
            for(int j=0;j<n;j++){
                tmpSum+=arr[i][j];
                tmpSum2+=arr[j][i];
            }
            if(tmpSum >= tmpSum2){
                max = Math.max(max,tmpSum);
            }else{
                max = Math.max(max,tmpSum2);
            }
        }
        tmpSum = 0;
        tmpSum2 =0;

        int idx = n-1;
        for(int i=0;i<n;i++){
            tmpSum+=arr[i][i];
            tmpSum2 += arr[i][idx--];
        }
        max = Math.max(max, tmpSum);
        max = Math.max(max, tmpSum2);

        System.out.println(max);
    }
}
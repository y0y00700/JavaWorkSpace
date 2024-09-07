import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ReversePrimeNumber {
    // 6. 뒤집은 소수
    // 설명
    
    // N개의 자연수가 입력되면 각 자연수를 뒤집은 후 그 뒤집은 수가 소수이면 그 소수를 출력하는 프로그램을 작성하세요.
    
    // 예를 들어 32를 뒤집으면 23이고, 23은 소수이다. 그러면 23을 출력한다. 단 910를 뒤집으면 19로 숫자화 해야 한다.
    
    // 첫 자리부터의 연속된 0은 무시한다.
    
    
    // 입력
    // 첫 줄에 자연수의 개수 N(3<=N<=100)이 주어지고, 그 다음 줄에 N개의 자연수가 주어진다.
    
    // 각 자연수의 크기는 100,000를 넘지 않는다.
    
    
    // 출력
    // 첫 줄에 뒤집은 소수를 출력합니다. 출력순서는 입력된 순서대로 출력합니다.
    
    
    // 예시 입력 1 
    
    // 9
    // 32 55 62 20 250 370 200 30 100
    // 예시 출력 1
    
    // 23 2 73 2 3
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        String [] input = br.readLine().split(" ");
        int [] inputInt = new int[t];
        int maxNum = 0;
        String tmpInput;
        for(int i=0; i<t;i++){
            tmpInput = ""; // Initialize 
            for(int j=input[i].length()-1;j>=0;j--){
                tmpInput += input[i].charAt(j);
            }
            //input[i] = tmpInput;
            inputInt[i] = Integer.parseInt(tmpInput);
            maxNum = Math.max(maxNum,inputInt[i]);
        }

        // test 
        // StringBuilder sb = new StringBuilder();
        // for(int i=0;i<t;i++){
        //     sb.append(inputInt[i]+ " ");
        // }

        // System.out.println(sb.toString());
        // System.out.println(maxNum);

        boolean nPrime [] = new boolean[maxNum+1];
        StringBuilder sb = new StringBuilder();
        nPrime[0] = true;
        nPrime[1] = true;
        // false = prime
        // true = notPrime
        for(int i=2;(i*i)<=maxNum;i++){
            if(nPrime[i]==true) continue;
            for(int j=(i+i);j<maxNum;j+=i){
                if(nPrime[j]==true) continue;
                else nPrime[j] = true;
            }
        }

        for(int i=0;i<t;i++){
            if(nPrime[inputInt[i]] == false) sb.append(inputInt[i]+" ");
        }
        
        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());
    }
}

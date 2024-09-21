import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ArraySum {
    // 1. 두 배열 합치기
    // 설명

    // 오름차순으로 정렬이 된 두 배열이 주어지면 두 배열을 오름차순으로 합쳐 출력하는 프로그램을 작성하세요.


    // 입력
    // 첫 번째 줄에 첫 번째 배열의 크기 N(1<=N<=100)이 주어집니다.

    // 두 번째 줄에 N개의 배열 원소가 오름차순으로 주어집니다.

    // 세 번째 줄에 두 번째 배열의 크기 M(1<=M<=100)이 주어집니다.

    // 네 번째 줄에 M개의 배열 원소가 오름차순으로 주어집니다.

    // 각 리스트의 원소는 int형 변수의 크기를 넘지 않습니다.


    // 출력
    // 오름차순으로 정렬된 배열을 출력합니다.


    // 예시 입력 1 

    // 3
    // 1 3 5
    // 5
    // 2 3 6 7 9
    // 예시 출력 1

    // 1 2 3 3 5 6 7 9
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String [] tmpInput;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());
        int arr1 [] = new int[n];
        tmpInput = br.readLine().split(" ");
        for(int i=0; i<n ; i++){
            arr1[i] = Integer.parseInt(tmpInput[i]);
            // sb.append(arr1[i]+ " ");
        }
        // sb.append("\n");
        int m = Integer.parseInt(br.readLine());
        int arr2 [] = new int[m];
        tmpInput = br.readLine().split(" ");
        for(int i=0; i<m ; i++){
            arr2[i] = Integer.parseInt(tmpInput[i]);
            // sb.append(arr2[i]+" ");
        }

        int ansArr [] = new int[n+m];
        int nCount = 0;
        int mCount = 0;
        // 한쪽 배열의 인덱스가 전부 소진 될 시, 탈출 필요
        for(int i=0;i<(n+m);i++){
            if(nCount>=n ||mCount>=m) break;
            if(arr1[nCount] > arr2[mCount]){
                ansArr[i] =arr2[mCount++];
            }else{
                ansArr[i] =arr1[nCount++];
            }
            sb.append(ansArr[i]+" ");
        }


        // 나머지 남은 배열 처리 로직 효율화 추후 작성 필요
        // if(nCount >= n){
        //     for(int i=mCount;i<(n+m)-mCount;i++){
        //         ansArr[i] = ansArr[mCount++];
        //     }
        // }else{
        //     for(int i=nCount;i<(n+m)-nCount;i++){
        //         ansArr[i] = ansArr[mCount++];
        //     }
        // }
        System.out.println(sb.toString());
        
    }
    
}

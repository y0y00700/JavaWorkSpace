import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class ShortestStrDistance {
//    10. 가장 짧은 문자거리
//            설명
//    한 개의 문자열 s와 문자 t가 주어지면 문자열 s의 각 문자가 문자 t와 떨어진 최소거리를 출력하는 프로그램을 작성하세요.
//    입력
//    첫 번째 줄에 문자열 s와 문자 t가 주어진다. 문자열과 문자는 소문자로만 주어집니다.
//
//    문자열의 길이는 100을 넘지 않는다.
//            출력
//    첫 번째 줄에 각 문자열 s의 각 문자가 문자 t와 떨어진 거리를 순서대로 출력한다.
//
//
//    예시 입력 1
//
//    teachermode e
//    예시 출력 1
//
//            1 0 1 2 1 0 1 2 2 1 0
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> idx = new ArrayList<>();
        String [] strInput = br.readLine().split(" ");
        String s = strInput[0];
        char c = strInput[1].charAt(0);
        int [] ansArr = new int[s.length()];

        for(int i=0; i<s.length(); i++){
            if(s.charAt(i)==c){
                idx.add(i);
            }
        }
        int [] iidx = new int[idx.size()];

        for(int i=0; i<idx.size(); i++){
            iidx[i] = idx.get(i);
        }

        int min;
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<s.length(); i++){
            min = Integer.MAX_VALUE;
            for(int j=0;j<iidx.length;j++){
                min = Math.min(min, Math.abs(i-iidx[j]));
            }
            ansArr[i] = min;
            sb.append(ansArr[i]+ " ");
        }

        sb.deleteCharAt(sb.length()-1);
        System.out.println(sb.toString());

    }

}

import java.io.IOException;
import java.util.Arrays;
import java.util.HashSet;

public class SetPr {

//    앞서 살펴본 출력 결과에 이상한 점이 있다. 분명 H, e, l, l, o라는 문자열 배열로 HashSet 자료형을 만들었는데 출력된 자료형에는 l 문자가 빠져 있고 순서도 뒤죽박죽이다.
//    그 이유는 집합 자료형에는 2가지 큰 특징이 있기 때문이다.
//
//    중복을 허용하지 않는다.
//    순서가 없다(unordered).
//    리스트나 배열은 순서가 있기(ordered) 때문에 인덱싱을 통해 자료형의 값을 얻을 수 있지만
//    집합 자료형은 순서가 없기(unordered) 때문에 인덱싱으로 값을 얻을 수 없다.
//    이는 마치 맵 자료형과 비슷하다. 맵 자료형 역시 순서가 없는 자료형이라 인덱싱을 지원하지 않는다.
//
//    집합 자료형은 중복을 허용하지 않기 때문에 자료형의 중복을 제거하기 위한 필터 역할로 종종 사용한다.
    public static void main(String[] args) throws IOException {

        HashSet <String> hssT = new HashSet<>(Arrays.asList("T","e","s","t"));
        System.out.println(hssT.toString());

    }
}

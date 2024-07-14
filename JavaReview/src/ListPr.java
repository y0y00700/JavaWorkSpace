import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ListPr {
    public static void main(String[] args)throws IOException {
        ArrayList pitches = new ArrayList();
        pitches.add("138");
        pitches.add("129");
        pitches.add("142");
        pitches.add(0,"999");

        pitches.remove("999");
        System.out.println("Array List GEt: "+pitches.get(1));
        System.out.println(pitches.size());
        System.out.println(pitches.contains("142"));

        // double LinkedList Pr
        LinkedList <Integer> llT [];
        System.out.print("Input Test Case");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int t = Integer.parseInt(br.readLine());
        llT = new LinkedList[t];
        for (int i = 0; i < t; i++) {
            llT[i] = new LinkedList();
            System.out.print("Input Array :");
            String tmp []  = br.readLine().split(",");
            sb.append("ArrayList "+i+" Index component: \n  ");
            for(int j=0;j<tmp.length;j++){
                llT[i].add(Integer.parseInt(tmp[j]));
                sb.append(llT[i].get(j)+" ");
            }
            sb.append("\n");
        }
        llT[0].sort(Comparator.naturalOrder()); // 오름 차순 정렬 내림차순 reverseOrder();
        System.out.println(sb.toString());


    }
}

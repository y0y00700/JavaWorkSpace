import java.io.IOException;
import java.util.HashMap;

public class MapPr {
    public static void main(String[] args)throws IOException {
        System.out.println("Test Text! ");

        HashMap <Integer,String> hsMapT = new HashMap<>();

        // Test Code
        hsMapT.put(new Integer(1), "A");
        hsMapT.put(new Integer(2), "B");
        hsMapT.put(new Integer(3), "C");
        hsMapT.put(new Integer(4), "D");
        hsMapT.put(new Integer(5), "E");

        System.out.println(hsMapT.containsKey(7));
        System.out.println(hsMapT.containsKey(5));
        System.out.println(hsMapT.get(3)); // get Key Value

    }
}

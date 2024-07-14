import java.io.IOException;

public class HelloWorld {

    public static void main(String[] args)throws IOException {
        // Hello World Test !
        System.out.println("Hello World");


        //문자열
        String strT = "Hello World2";
        System.out.println(String.format("%s",strT)); // 포매팅된 문자열 사용 가능1
        System.out.printf("%s\n",strT); // 포매팅된 문자열 사용 가능2

        //StringBuffer

        StringBuffer sb = new StringBuffer();
        sb.append("Test \n");
        sb.append("append");
        sb.append("\n to work");
        sb.insert(0,"Insert T ");
        // IntelliJ System.out.Println -> sout  + tab
        String rst = sb.toString();
        System.out.println(rst);

        System.out.println(rst.toUpperCase());



    }
}

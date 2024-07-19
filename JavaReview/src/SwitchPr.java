aimport java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SwitchPr {

    static int adder (int a , int b, char op){
        switch(op) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Input a: ");

        String [] a = br.readLine().split(" ");

        System.out.println(adder(Integer.parseInt(a[0]), Integer.parseInt(a[2]), a[1].charAt(0)));
    }
}

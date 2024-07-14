import java.io.IOException;

public class EnumPr {
    enum coffeType {IceAmericano , MochaLatte , iceTea};
    public static void main(String[] args)throws IOException {

        StringBuilder sb = new StringBuilder();
        System.out.println(coffeType.IceAmericano);
        for(coffeType t : coffeType.values()){
            sb.append(t+ " ");
        }

        System.out.println(sb.toString());
    }
}

import java.util.*;

public class TestProgram {

    private static final Scanner reader = new Scanner(System.in);

    public static void main(String[] args) {
        int n = 1;
        while (n < 2147483647) {
            System.out.print(n + ", ");
            n = (n + 1 ) * 2 - 1;
        }
    }
}
//0 0 3 4 4

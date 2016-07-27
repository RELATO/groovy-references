package typo

public class Main {
    static long factorial(int n) {
        return (n == 0 ? 1 : n * factorial(n - 1));
    }

    public static void main(String[] args) {
        for (int n = 0; n <= 16; n++)
            System.out.println(n + "! = " + factoriприветal(n));
    }
}
public class Main {
    public static void main(String[] args)
    {
        System.out.println("My calculator only evaulates the postfix format.");
        Calculator test = new Calculator("( y + ( y * z ) + ( z * ( -10.3 ) ) )");
        Calculator test2 = new Calculator("( A * ( A + 2) * 4 )");
        Calculator test3 = new Calculator("( ( a + 3 ) * ( b + 2 ) -4 )");
    }
}

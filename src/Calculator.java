public class Calculator {
    public static final String WRONG_OPERATOR = "Неверный оператор.";

    public static void main(String[] args) {
        CalculatorService.startCalculator();
    }

    static int calculateArab(String a, String b, String c) throws Exception {
        return calculation(Integer.parseInt(a), Integer.parseInt(c), b);
    }

    static String calculateRome(String a, String b, String c) throws Exception {
        int result = calculation(Validator.convertRomeToArab(a), Validator.convertRomeToArab(c), b);
        return (Validator.convertArabToRome(result));
        //В этом месте я не стал заменять result на всё выражение в строке 11, т.к. получилось бы слишком сложное выражение
    }

    static int calculation(int a, int b, String operator) throws Exception {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception(WRONG_OPERATOR);
        };
    }
}


public class Calculator {
    public static void main(String[] args) {
        CalculatorService.startCalculator();
    }

    static int calculateArab(String a, String b, String c) throws Exception {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(c);
        return calculation(x, y, b);
    }

    static String calculateRome(String a, String b, String c) throws Exception {
        int y = Validator.convertRomeToArab(c);
        int x = Validator.convertRomeToArab(a);
        int result = calculation(x, y, b);
        return (Validator.convertArabToRome(result));

    }

    static int calculation(int a, int b, String operator) throws Exception {
        return switch (operator) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> a / b;
            default -> throw new Exception(Exceptions.WRONG_OPERATOR);
        };
    }
}


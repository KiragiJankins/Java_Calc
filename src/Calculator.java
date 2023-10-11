import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        CalculatorService.startCalculator();
    }

    static int ArabCalc(String a, String b, String c) throws Exception {
        int x = Integer.parseInt(a);
        int y = Integer.parseInt(c);
        int res;
        switch (b) {
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "*":
                res = x * y;
                break;
            case "/":
                res = x / y;
                break;
            default:
                throw new Exception("Неверный оператор.");
        }
        return res;
    }

    static String RomeCalc(String a, String b, String c) throws Exception {
        int x = Validator.RomeToArab(a);
        int y = Validator.RomeToArab(c);
        int res;
        switch (b) {
            case "+":
                res = x + y;
                break;
            case "-":
                res = x - y;
                break;
            case "*":
                res = x * y;
                break;
            case "/":
                res = x / y;
                break;
            default:
                throw new Exception("Неверный оператор.");
        }
        return (Validator.ArabToRome(res));
    }
}


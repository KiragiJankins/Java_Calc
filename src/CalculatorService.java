import java.util.Scanner;

public class CalculatorService {
    public static void startCalculator() {
        System.out.println("Введите уравнение:");

        Scanner sca = new Scanner(System.in);
        String us = sca.nextLine();
        us = us.trim();
        String[] dat = us.split(" ");

        try {
            int R = Validator.CheckData(dat);
            switch (R) {
                case 1:
                    System.out.println(Calculator.ArabCalc(dat[0], dat[1], dat[2]));
                    break;
                case 2:
                    System.out.println(Calculator.RomeCalc(dat[0], dat[1], dat[2]));
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

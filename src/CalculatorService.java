import java.util.Scanner;

public class CalculatorService {
    public static void startCalculator() {
        System.out.println("Введите уравнение:");
        Scanner sca = new Scanner(System.in);
        String UserInput = sca.nextLine();
        String[] dat = UserInput.split(" ");
        try {
            int R = Validator.checkData(dat);
            switch (R) {
                case 1:
                    System.out.println(Calculator.calculateArab(dat[0], dat[1], dat[2]));
                    break;
                case 2:
                    System.out.println(Calculator.calculateRome(dat[0], dat[1], dat[2]));
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

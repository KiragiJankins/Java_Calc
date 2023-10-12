import java.util.Scanner;

public class CalculatorService {
    public static void startCalculator() {
        System.out.println("Введите уравнение:");
        Scanner sca = new Scanner(System.in);
        String userInput = sca.nextLine();
        String[] data = userInput.split(" ");
        try {
            switch (Validator.checkData(data)) {
                case 1:
                    System.out.println(Calculator.calculateArab(data[0], data[1], data[2]));
                    break;
                case 2:
                    System.out.println(Calculator.calculateRome(data[0], data[1], data[2]));
                    break;
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

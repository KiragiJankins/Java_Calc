import java.util.Scanner;

public class CalculatorService {
    public static void startCalculator(){
        System.out.println("Введите уравнение:");
        Scanner sca = new Scanner(System.in);
        try {
            String userInput = sca.nextLine();
            Validator.checkForSpace(userInput);
            String[] data = userInput.split(" ");
            switch (Validator.checkData(data)) {
                case 1 -> System.out.println(Calculator.calculateArab(data[0], data[1], data[2]));
                case 2 -> System.out.println(Calculator.calculateRome(data[0], data[1], data[2]));
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}

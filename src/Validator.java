import java.util.Scanner;

public class Validator {
    private static final String[] ARAB_IN = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static final String[] ROME_IN = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private static final String[] operators = new String[]{"+", "-", "*", "/"};
    private static final String[] greek_units = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] greek_tens = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] greek_hundreds = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};

    public static int RomeToArab(String a) throws Exception {
        for (int i = 0; i < ROME_IN.length; i++) {
            if (ROME_IN[i].equalsIgnoreCase(a)) {
                return i + 1;
            }
        }
        throw new Exception("Вводимые римские числа должны находиться в диапазоне от 1 до 10.");
    }

    public static String ArabToRome(int a) throws Exception {
        if (a <= 0) throw new Exception("Результат не может быть отрицательным, введите другое уравнение.");
        int units = a % 10;
        int tens = (a % 100) / 10;
        int hundreds = (a % 1000) / 100;

        String units_num = greek_units[units];
        String tens_num = greek_tens[tens];
        String hundred_num = greek_hundreds[hundreds];

        return (hundred_num + tens_num + units_num);
    }

    public static byte CheckData(String[] a) throws Exception {
        if (a.length == 3) {
            String[] data = new String[]{" ", " ", " "};
            for (int i = 0; i < 10; i++) {
                if (a[0].equalsIgnoreCase(ARAB_IN[i])) {
                    data[0] = "arab";
                }
                if (a[0].equalsIgnoreCase(ROME_IN[i])) {
                    data[0] = "rome";
                }
                if (a[2].equalsIgnoreCase(ARAB_IN[i])) {
                    data[2] = "arab";
                }
                if (a[2].equalsIgnoreCase(ROME_IN[i])) {
                    data[2] = "rome";
                }
            }
            for (String operator : operators) {
                if (a[1].equals(operator)) {
                    data[1] = "operator";
                    break;
                }
            }
            if (data[1].equals("operator") && data[0].equals(data[2]) && data[0].equals("arab")) {
                return 1;
            } else if (data[1].equals("operator") && data[0].equals(data[2]) && data[0].equals("rome")) {
                return 2;
            } else if (data[1].equals("operator") && (data[0].equals("arab") || data[0].equals("rome")) && (data[2].equals("arab") || data[2].equals("rome")) && !(data[0].equals(data[2]))) {
                throw new Exception("Вводимые числа должны быть одной системы счисления.");
            } else {
                throw new Exception("Введите корректное уравнение в формате: a [оператор] b. Вводимые числа должны быть в диапазоне от 1 до 10.");
            }
        } else {
            throw new Exception("Введите корректное уравнение в формате: a [оператор] b. Вводимые числа должны быть в диапазоне от 1 до 10.");
        }
    }
}


public class Validator {
    private static final String[] ARAB_INPUT = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static final String[] ROME_INPUT = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private static final String[] OPERATORS = new String[]{"+", "-", "*", "/"};
    private static final String[] GREEK_UNITS = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] GREEK_TENS = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] GREEK_HUNDREDS = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    public static final String INVALID_RANGE = "Вводимые римские числа должны находиться в диапазоне от 1 до 10.";
    public static final String INVALID_FORMAT = "Введите корректное уравнение в формате: a [оператор] b. Вводимые числа должны быть в диапазоне от 1 до 10.";
    public static final String DIFF_NUM_SYSTEMS = "Вводимые числа должны быть одной системы счисления.";
    public static final String NEGATIVE_RESULT = "Результат не может быть отрицательным, введите другое уравнение.";

    public static int convertRomeToArab(String a) throws Exception {
        for (int i = 0; i < ROME_INPUT.length; i++) {
            if (ROME_INPUT[i].equalsIgnoreCase(a)) {
                return i + 1;
            }
        }
        throw new Exception(INVALID_RANGE);
    }

    public static String convertArabToRome(int a) throws Exception {
        if (a <= 0) {
            throw new Exception(NEGATIVE_RESULT);
        }
        int units = a % 10;
        int tens = (a % 100) / 10;
        int hundreds = (a % 1000) / 100;
        return (GREEK_HUNDREDS[hundreds] + GREEK_TENS[tens] + GREEK_UNITS[units]);
    }

    static boolean checkInArchive(String a, String[] b) {
        for (String check : b) {
            if (a.equalsIgnoreCase(check)) {
                return true;
            }
        }
        return false;
    }

    public static byte checkData(String[] a) throws Exception {
        if (a.length != 3) {
            throw new Exception(INVALID_FORMAT);
        }

        boolean numOneIsArab = checkInArchive(a[0], ARAB_INPUT);
        boolean numOneIsRome = checkInArchive(a[0], ROME_INPUT);
        boolean numTwoIsArab = checkInArchive(a[2], ARAB_INPUT);
        boolean numTwoIsRome = checkInArchive(a[2], ROME_INPUT);
        boolean isOperator = checkInArchive(a[1], OPERATORS);
        boolean sameNumSystem = (numOneIsArab && numTwoIsArab) || (numOneIsRome && numTwoIsRome);

        if (isOperator && numOneIsArab && numTwoIsArab) {
            return 1;
        } else if (isOperator && numOneIsRome && numTwoIsRome) {
            return 2;
        } else if (isOperator && (numOneIsArab || numOneIsRome)
                && (numTwoIsArab || numTwoIsRome)
                && !sameNumSystem) {
            throw new Exception(DIFF_NUM_SYSTEMS);
        } else {
            throw new Exception(INVALID_FORMAT);
        }
    }
}



public class Validator {
    private static final String[] ARAB_IN = new String[]{"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static final String[] ROME_IN = new String[]{"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    private static final String[] OPERATORS = new String[]{"+", "-", "*", "/"};
    private static final String[] GREEK_UNITS = new String[]{"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    private static final String[] GREEK_TENS = new String[]{"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    private static final String[] GREEK_HUNDREDS = new String[]{"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};


    public static int convertRomeToArab(String a) throws Exception {
        for (int i = 0; i < ROME_IN.length; i++) {
            if (ROME_IN[i].equalsIgnoreCase(a)) {
                return i + 1;
            }
        }
        throw new Exception(Exceptions.INVALID_RANGE);
    }

    public static String convertArabToRome(int a) throws Exception {
        if (a <= 0) throw new Exception(Exceptions.NEGATIVE_RESULT);
        int units = a % 10;
        int tens = (a % 100) / 10;
        int hundreds = (a % 1000) / 100;
        return (GREEK_HUNDREDS[hundreds] + GREEK_TENS[tens] + GREEK_UNITS[units]);
    }

    static boolean checkForArab(String a) {
        for (String number : ARAB_IN) {
            if (a.equalsIgnoreCase(number)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkForRome(String a) {
        for (String number : ROME_IN) {
            if (a.equalsIgnoreCase(number)) {
                return true;
            }
        }
        return false;
    }

    static boolean checkForOperator(String a) {
        for (String operator : OPERATORS) {
            if (a.equalsIgnoreCase(operator)) {
                return true;
            }
        }
        return false;
    }

    public static byte checkData(String[] a) throws Exception {
        if (a.length != 3) {
            throw new Exception(Exceptions.INVALID_FORMAT);
        }

        boolean NumOneIsArab = checkForArab(a[0]);
        boolean NumOneIsRome = checkForRome(a[0]);
        boolean NumTwoIsArab = checkForArab(a[2]);
        boolean NumTwoIsRome = checkForRome(a[2]);
        boolean IsOperator = checkForOperator(a[1]);
        boolean SameNumSystem = (NumOneIsArab && NumTwoIsArab) || (NumOneIsRome && NumTwoIsRome);

        if (IsOperator && NumOneIsArab && NumTwoIsArab) {
            return 1;
        } else if (IsOperator && NumOneIsRome && NumTwoIsRome) {
            return 2;
        } else if (IsOperator && (NumOneIsArab || NumOneIsRome)
                && (NumTwoIsArab || NumTwoIsRome)
                && !SameNumSystem) {
            throw new Exception(Exceptions.DIFF_NUM_SYSTEMS);
        } else {
            throw new Exception(Exceptions.INVALID_FORMAT);
        }
    }
}



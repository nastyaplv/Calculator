import java.util.Scanner;

public class Main {
    static int cTranslation(char c, int i1, int i2) {
        int result;
        if (i1 < 0 || i1 > 10 || i2 < 0 || i2 > 10) {
            throw new RuntimeException("Числа в недопустимом диапазоне");
        } else {
            switch (c) {
                case '+':
                    result = i1 + i2;
                    break;
                case '-':
                    result = i1 - i2;
                    break;
                case '*':
                    result = i1 * i2;
                    break;
                case '/':
                    result = i1 / i2;
                    break;
                default: {
                    throw new RuntimeException("Выражение неверного формата");
                }
            }
        }
        return result;
    }
    public static String calc(String input) {
        String s1 = input;
        String[] strings = s1.split(" ");
        if (strings.length != 3) {
            throw new RuntimeException("Выражение неверного формата");
        }
        char c = strings[1].charAt(0);
        String s2;
        if (romanSearch(strings[0]) && romanSearch(strings[2])) {
            RomanNumbers roman1 = RomanNumbers.valueOf(strings[0]);
            RomanNumbers roman2 = RomanNumbers.valueOf(strings[2]);
            int j1 = roman1.getValue();
            int j2 = roman2.getValue();
            int result = cTranslation(c, j1, j2);
            if (result < 0) {
                throw new RuntimeException("В римской системе счисления нет отрицательных чисел");
            } else {
                RomanNumbers[] array = RomanNumbers.values();
                RomanNumbers roman3 = array[result];
                s2 = roman3.name();
                System.out.println("Output:");
                System.out.println(s2);
            }
        } else {
            try {
                Integer i1 = Integer.parseInt(strings[0]);
                Integer i2 = Integer.parseInt(strings[2]);
                int result = cTranslation(c, i1, i2);
                s2 = String.valueOf(result);
                System.out.println("Output:");
                System.out.println(s2);
            } catch (NumberFormatException n) {
                System.out.println("Используются одновременно разные системы счисления");
                s2 = null;
            }
        }
        return s2;
    }
    static boolean romanSearch(String str) {
        boolean b = false;
        if (str.startsWith("I") || str.startsWith("V") || str.startsWith("X")) {
            b = true;
        }
        return b;
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Input:");
            calc(scanner.nextLine());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}

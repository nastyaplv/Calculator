import java.util.Scanner;

public class Main {
    public static int cTranslation(char c, int i1, int i2){
        int result;
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
        return result;
    }
    public static String calc(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("Input:");
        String s1=scanner.nextLine();
        String [] strings=s1.split(" ");
        if (strings.length!=3) {
            throw new RuntimeException("Выражение неверного формата");
        }
        char c = strings[1].charAt(0);
        String s2;
        boolean b1=strings[0].contains("I");
        boolean b2=strings[0].contains("V");
        boolean b3=strings[0].contains("X");
        boolean b4=strings[2].contains("I");
        boolean b5=strings[2].contains("V");
        boolean b6=strings[2].contains("X");
        if((b1||b2||b3)&&(b4||b5||b6)) {
            RomanNumbers roman1 = RomanNumbers.valueOf(strings[0]);
            RomanNumbers roman2 = RomanNumbers.valueOf(strings[2]);
            int j1 = roman1.getValue();
            int j2 = roman2.getValue();
            int result = cTranslation(c, j1, j2);
            if (result < 1) {
                throw new RuntimeException("В римской системе счисления нет отрицательных чисел");
            }
            else {
                RomanNumbers[] array = RomanNumbers.values();
                int i = 0;
                while (i != result) {
                    i++;
                }
                RomanNumbers roman3 = array[i];
                s2 = roman3.name();
                System.out.println("Output:");
                System.out.println(s2);
            }
        }
        else {
            try {
                Integer i1 = Integer.parseInt(strings[0]);
                Integer i2 = Integer.parseInt(strings[2]);
                if (i1<0 || i2<0 || i1>10|| i2>10) {
                    throw new RuntimeException("Числа в недопустимом диапазоне");
                }
                int result = cTranslation(c, i1, i2);
                s2 = String.valueOf(result);
                System.out.println("Output:");
                System.out.println(s2);
            }
            catch (NumberFormatException n) {
                System.out.println("Используются одновременно разные системы счисления");
                s2=null;
            }
            }

        return s2;
    }
    public static void main(String[] args) {
        calc();
    }
    }
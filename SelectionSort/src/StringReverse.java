/**
 * Created by dima on 13.09.2017.
 */
public class StringReverse {
    public static void main(String[] args) {
        
    }

    public static void reversString(String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            result = string.charAt(i) + result;
        }
        System.out.println(result);
    }

    public static String reversStringArr(String string) {
        char[] arrString = string.toCharArray();
        for (int i = 0, j = arrString.length - 1; i < j; i++, j--) {
            char a = arrString[i];
            arrString[i] = arrString[j];
            arrString[j] = a;
        }
        String reversString = new String(arrString);
        System.out.println(reversString);
        return reversString;
    }

    public static void upLetter(String string) {
        char[] str = string.toCharArray();
        for (char a : str) {

            if (a < 122 & a > 97) {
                a -= 32;
                System.out.print(a);
            } else {
                System.out.print(a);
            }
        }
    }

    public static void downLetter(String string) {
        char[] str = string.toCharArray();
        for (int i : str) {
            char a = str[i];
            if (a < 90 & a > 65) {
                a += 32;
                System.out.print(a);
            } else {
                System.out.print(a);
            }
        }
    }
}

/**
 * Created by dima on 13.09.2017.
 */
public class StringReverse {
    public static void main(String[] args) {
        System.out.println(upLetter("qWe"));
        System.out.println(downLetter("FdwDwd"));
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

    public static String upLetter(String string) {
        char[] str = string.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char a = str[i];
            if (a < 122 & a > 97) {
                str[i] -= 32;
            }
        }
        String result = new String(str);
        return result;

    }

    public static String downLetter(String string) {
        char[] str = string.toCharArray();
        for (int i = 0; i < str.length; i++) {
            char a = str[i];
            if (a < 90 & a > 65) {
                str[i] += 32;
            }
        }
        String result = new String(str);
        return result;
    }
}

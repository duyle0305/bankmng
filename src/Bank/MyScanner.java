/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bank;

import java.util.Scanner;

/**
 *
 * @author SE140861
 */
public class MyScanner {

    public static Scanner sc = new Scanner(System.in);
    
    public static boolean getBoolean(String message) {
        String s;
        System.out.print(message+"-(T/F, Y/N, 1/0): ");
        s = sc.nextLine().trim().toUpperCase();
        char a = s.charAt(0);
        if (a == 'T' || a == 'Y' || a == '1') {
            return true;
        } else {
            return false;
        }
    }

    public static String getNonBlankStr(String mesage) {
        String a;
        do {
            System.out.print(mesage + "(non-blank): ");
            a = sc.nextLine().trim();
        } while (a.length() == 0);
        return a;

    }

    public static boolean password(String pwd) {
        int L = pwd.length();
        if (L < 6) {
            return false;
        }
        int ks = 0, ktt = 0, kth = 0, ktk = 0;
        for (int i = 0; i < L; i++) {
            char c = pwd.charAt(i);
            if (c >= '0' && c <= '9') {
                ks++;
            } else if (c >= 'a' && c <= 'z') {
                ktt++;
            } else if (c >= 'A' && c <= 'Z') {
                kth++;
            } else {
                ktk++;
            }
        }
        return (ks >= 1 && kth >= 1 && ktt >= 1 && ktk >= 1);
    }

    public static String ceasarCode(String src) {
        String result = "";
        for (int i = 0; i < src.length(); i++) {
            char c = (char) (((int) src.charAt(i) + 12) % 256);
            result += c;
        }
        return result;
    }

    public static String ceasarDecode(String src) {
        String result = "";
        for (int i = 0; i < src.length(); i++) {
            char c = (char) (((int) src.charAt(i) - 12) % 256);
            result += c;
        }
        return result;
    }
}

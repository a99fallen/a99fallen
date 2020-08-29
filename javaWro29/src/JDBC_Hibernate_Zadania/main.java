package JDBC_Hibernate_Zadania;

import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        double a = 0;
//        ex1();
//        ex2(scan);
//        ex3(scan);
    }

    private static void ex3(Scanner scan) {
        System.out.println(countNumberOfSpaces(scan));
    }

    private static int countNumberOfSpaces(Scanner scan) {
        String string = scan.nextLine();
        int count = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == ' ') {
                count++;
            }
        }
        return count;
    }

    //metody
    //zadanie 1

    private static void ex1() {
        for (int i = 0; i < 15; i++) {
            drawStars(i);
            drawLines(i);
            System.out.println();
        }
    }
    private static void drawStars(int linia) {
        if (linia < 10 && linia % 2 != 0) {
            System.out.print("* * * * * *");
        } else if (linia < 10 && linia % 2 == 0) {
            System.out.print(" * * * * * ");
        } else {}
    }

    private static void drawLines(int linia) {
        if (linia < 10) {
            for (int i = 0; i < 35; i++) {
                System.out.print("=");
            }
        } else {
            for (int i = 0; i < 46; i++) {
                System.out.print("=");
            }
        }
    }

    //zadanie 2
    private static void ex2(Scanner scan) {
        double a;
        System.out.println("Podaj długość boku: (double)");
        a = scan.nextInt();
        System.out.println(countArea(a));
        System.out.println(circumferenceLength(a));
        System.out.println(longerCrossingLength(a));
        System.out.println(shorterCrossingLength(a));
        System.out.println(circleRadiusLength(a));
    }

    private static double circleRadiusLength(double a) {
        System.out.print("Długość promienia okręgu wpisaneg: ");
        return a * Math.sqrt(3)/2;
    }

    private static double shorterCrossingLength(double a) {
        System.out.print("Długość krótszej przekątnej: ");
        return a * Math.sqrt(3);
    }

    private static double longerCrossingLength(double a) {
        System.out.print("Długość dłuższej przekątnej: ");
        return 2 * a;
    }

    private static double circumferenceLength(double a) {
        System.out.print("Długoć obwodu: ");
        return 6 * a;
    }

    private static double countArea(double a) {
        System.out.print("Pole powierzchni: ");
        return  3 * Math.pow(a, 2) * Math.sqrt(3)/2;
    }
}

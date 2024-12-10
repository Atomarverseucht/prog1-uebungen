// IntVar.java

package aufgabe1;

import java.util.Scanner;

/**
 * IntVar zeigt den Umgang mit Variablen vom Typ int.
 * &Uuml;bungsaufgabe 1 zur Programmiertechnik 1.
 * @author Tom
 * @version 1
 */
public final class IntVar {
    private IntVar() { }

    private static final Scanner INPUT = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        /*Konstanten min und max definieren. Werden momentan ignoriert */
        final int minValue = Integer.MIN_VALUE;
        final int maxValue = Integer.MAX_VALUE;
        System.out.printf("%nGebe bitte Zahlen zwischen %d und %d ein!%n"
            + "Zahlen bitte im Dezimalsystem eingeben%n", minValue, maxValue);

        /* Eingabeaufforderung */
        System.out.print("Erste Zahl: ");
        int number1 = INPUT.nextInt();
        System.out.print("Zweite Zahl: ");
        int number2 = INPUT.nextInt();

        /* die beiden Zahlen dezimal, oktal und hexadezimal ausgeben */
        System.out.printf("Zahl 1: %d %n", number1);
        System.out.printf(" - Hex: %x %n", number1);
        System.out.printf(" - Oktal: %o %n", number1);
        System.out.printf("%nZahl 2: %d %n", number2);
        System.out.printf(" - Hex: %x %n", number2);
        System.out.printf(" - Oktal: %o %n", number2);

        /* alle zweistelligen arithmetischen Operatoren ausprobieren */
        System.out.printf("%n Arithmetische Operationen: %n");
        System.out.printf("%d + %d = %d%n",
            number1, number2, number1 + number2);
        System.out.printf("%d - %d = %d%n",
            number1, number2, number1 - number2);
        System.out.printf("%d * %d = %d%n",
            number1, number2, number1 * number2);
        System.out.printf("%d / %d = %d%n",
            number1, number2, number1 / number2);
        System.out.printf("%d Mod %d = %d%n",
            number1, number2, number1 % number2);
        System.out.printf("%d ^ %d = %d%n", number1,
            number2, (int) Math.pow((double) number1, (double) number2));

        /* alle Vergleichsoperatoren ausprobieren */
        System.out.printf("%nVergleichsoperationen:%n");
        System.out.printf("%d > %d ist %b%n", number1,
            number2, (number1 > number2));
        System.out.printf("%d >= %d ist %b%n",
            number1, number2, number1 >= number2);
        System.out.printf("%d = %d ist %b%n",
            number1, number2, number1 == number2);
        System.out.printf("%d != %d ist %b%n",
            number1, number2, number1 != number2);
        System.out.printf("%d < %d ist %b%n",
            number1, number2, number1 < number2);
        System.out.printf("%d <= %d ist %b%n",
            number1, number2, number1 <= number2);
    }
}


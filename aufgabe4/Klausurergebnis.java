// Klausurergebnis.java
package aufgabe4;
//import aufgabe4.schweiz.Noten;
import java.util.Locale;
import java.util.Scanner;

/**
 * Klausurergebnis erstellt eine Notenstatistik.
 * <p>
 * Das Programm liest Noten als Strings ein und bestimmt die beste und
 * die schlechteste Note, den Durchschnitt der Bestandenen sowie
 * die Durchfallquote in Prozent.
 * Das Programm ber&uuml;cksichtigt dabei nur die laut Noten.istZulaessig
 * erlaubten Noten. Andere Noten werden unter Ausgabe einer Warnung ignoriert.
 * Welche Noten besser und schlechter sind, welche als bestanden oder
 * durchgefallen gelten und wie die String-Darstellung der Noten aussieht,
 * wird mit Methoden der Klasse Noten bestimmt.
 * </p>
 * Das Programm gibt als Klausurergebnis folgende Werte aus:
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote</li>
 * </ul>
 *
 * @author Atom
 * @version 0
 */
public final class Klausurergebnis {
    private Klausurergebnis() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMAN);
        int anzahlBestanden = 0;
        int anzahlNoten = 0;
        double bestandenNote = 0.0;
        double besteNote = 5.0;
        double schlechtesteNote = 1.0;
        final int X = 10;
        final int C = 100;
        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten Ganze,Zehntel oder Ganze.Zehntel eingeben "
            + "(Ende mit Strg-D/Strg-Z):");

        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            try {
                Double nDouble = Noten.toDouble(note);
                if (!Noten.istZulaessig(note)) {
                    throw new IllegalArgumentException();
                }
                if (Noten.istBestanden(nDouble)) {
                    anzahlBestanden++;
                    bestandenNote += nDouble;
                }
                anzahlNoten++;
                besteNote = Noten.bessere(nDouble, besteNote);
                schlechtesteNote = Noten.schlechtere(schlechtesteNote, nDouble);
            } catch (IllegalArgumentException eae) {
                System.out.println("Unzulaessige Note: " + note
                    + " wird ignoriert!");
            }
        }
        
        System.out.println("\nAnzahl beruecksichtigter Noten: " + anzahlNoten);
        System.out.println("Anzahl bestandener Noten: " + anzahlBestanden);
        if (anzahlNoten != 0) {
            System.out.println("Beste Note: " + String.format(
                    "%.1f", besteNote).replace(".", ","));
            System.out.println("Durchschnitt bestandener Noten: "
                + String.format("%.1f", (double)
                    Math.round(bestandenNote * X / anzahlBestanden) / X));
            System.out.println("Durchfallquote: " + String.format(
                "%.1f", ((double) (anzahlNoten - anzahlBestanden)
                    * C / anzahlNoten)) + "%");
        }
    }
}


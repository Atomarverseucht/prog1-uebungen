// Notenstatistik.java
package aufgabe3;

import java.util.Locale;
import java.util.Scanner;

/**
 * erstellt eine Notenstatistik.
 * <p>
 * Das Programm erwartet Pr&uuml;fungsnoten im Format
 * <code>Ganze,Zehntel</code> oder <code>Ganze.Zehntel</code>,
 * wobei <code>Ganze</code> und <code>Zehntel</code> nur aus
 * je einer Dezimalziffer bestehen d&uuml;rfen.
 * Andere Eingaben werden wegen Formatfehler ignoriert.
 * </p>
 * <p>
 * Das Programm gibt die folgende Statistik aus:
 * </p>
 * <ul>
 * <li>die Anzahl der ber&uuml;cksichtigten Noten</li>
 * <li>die Anzahl der Bestandenen</li>
 * <li>die beste Note</li>
 * <li>die schlechteste Note</li>
 * <li>den Durchschnitt der Bestandenen</li>
 * <li>die Durchfallquote in Prozent</li>
 * </ul>
 * <p>
 * Es werden in der Statistik nur die nach HTWG-Pr&uuml;fungsordnung
 * zul&auml;ssigen Noten (1,0 1,3 1,7 2,0 2,3 2,7 3,0 3,3 3,7 4,0 5,0)
 * ber&uuml;cksichtigt.
 * Andere Eingaben werden wegen falscher Vorkommastelle oder
 * falscher Nachkommastelle ignoriert.
 * Alle Noten bis 4,0 gelten als bestanden, nur die 5,0 als durchgefallen.
 * </p>
 *
 * @author Atom
 * @version 0
 */
public final class Notenstatistik {
    private Notenstatistik() { }

    private static final Scanner EINGABE = new Scanner(System.in);

    /**
     * main ist der Startpunkt des Programms.
     * @param args wird nicht verwendet.
     */
    public static void main(String[] args) {
        Locale.setDefault(Locale.GERMANY);
        int anzahlBestanden = 0;
        int anzahlNoten = 0;
        double bestandenNote = 0.0;
        double besteNote = 5.0;
        double schlechtesteNote = 1.0;


        //--------------------------------------------------- Noten einlesen
        System.out.println("Noten Ganze,Zehntel oder Ganze.Zehntel eingeben "
            + "(Ende mit Strg-D/Strg-Z):");


        while (EINGABE.hasNext()) {
            String note = EINGABE.next();
            //---------------------------------------------- Eingabe pruefen
            try {
                double value = Double.parseDouble(note.replace(',', '.'));
                switch (note.replace(",", ".")) {
                case "1.0", "1.3", "1.7", "2.0", "2.7", "3.0":
                case "3.3", "3.7", "4.0", "5.0":
                    break;
                case "1", "2", "3", "4", "5":
                    throw new NumberFormatException();
                default:
                    if (value >= 6 || value <= 0) {
                        System.out.println("Note " + note
                            + " wird wegen Vorkommastelle ignoriert!");
                    } else {
                        System.out.println("Note " + note
                            + " wird wegen Nachkommastelle ignoriert!");
                    }
                    throw new Exception();
                }

                if (value != 5) {
                    anzahlBestanden++;
                    bestandenNote += value;
                }
                anzahlNoten++;
                if (besteNote > value) {
                    besteNote = value;
                }
                if (schlechtesteNote < value) {
                    schlechtesteNote = value;
                }

            } catch (NumberFormatException e) {
                System.out.println("Note " + note
                    + " wird wegen Formatfehler ignoriert!");
            } catch (Exception ex) {

            }
        }
        System.out.println("\nAnzahl beruecksichtigter Noten: " + anzahlNoten);
        System.out.println("Anzahl bestandener Noten: " + anzahlBestanden);
        if (anzahlNoten != 0) {
            System.out.println("Beste Note: " + String.format(
                    "%.1f", besteNote).replace(".", ","));
            System.out.println("Durchschnitt bestandener Noten: "
                + String.format("%.1f", (double)
                    Math.round(bestandenNote * 10 / anzahlBestanden) / 10));
            System.out.println("Durchfallquote: " + String.format(
                "%.1f", ((double) (anzahlNoten - anzahlBestanden)
                    * 100 / anzahlNoten)) + "%");
        }
    }
}

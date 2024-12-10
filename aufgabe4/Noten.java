package aufgabe4;

/**
 * Diese Klasse hilft beim Umgang mit Noten.
 * @author Atom
 * @version 1.0
 */
public final class Noten {

    /**
    * Bestmöglichste Note.
    */
    static final double BESTE = 1.0;

    /**
     * Schlechteste noch bestandene Note.
     */
    static final double SCHLECHTESTE = 4.0;

    /**
    * Überprüft ob Note legal ist.
    * @param note als String
    * @return legal? ja -> true nein -> false
    */
    public static boolean istZulaessig(String note) {
        switch (note.replace(",", ".")) {
        case "1.0", "1.3", "1.7", "2.0", "2.7", "3.0":
        case "3.3", "3.7", "4.0", "5.0":
            return true;
        default:
            return false;
        }
    }

    /**
    * Macht aus String einen Double.
    * @param note als String
    * @return Note als Double
    * @throws IllegalArgumentException wenn die Eingabe keine Z
    */
    public static Double toDouble(String note) {
        try {
            if (istZulaessig(note)) {
                return Double.parseDouble(note.replace(',', '.'));
            } else {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(nfe);
        }
    }

    /**
    * Formt in einen String um.
    * @param note Note als Double
    * @return Note als String
    * @throws IllegalArgumentException wenn die Note nicht geht
    */
    public static String toString(double note) {
        if (note <= BESTE && note >= SCHLECHTESTE) {
            return String.format("%.1f", note);
        }
        throw new IllegalArgumentException();
    }

    /**
     * gibt zurück ob Note bestanden ist.
     * @param note als double
     * @return ob es bestanden wurde
     */
    public static boolean istBestanden(double note) {
        if (note <= SCHLECHTESTE && note >= BESTE) {
            return true;
        }
        return false;
    }

    /**
     * Vergleicht welche der beiden Noten besser bewertet ist.
     * @param note1
     * @param note2
     * @return bessere Note
     */
    public static double bessere(double note1, double note2) {
        if (note1 < note2) {
            return note1;
        }
        return note2;
    }

    /**
     * Vergleicht welche der beiden Noten schlechter bewertet wurde.
     * @param note1
     * @param note2
     * @return schlechtere Note
     */
    public static double schlechtere(double note1, double note2) {
        if (note1 < note2) {
            return note2;
        }
        return note1;
    }

    /**
    * Konstruktor.
    */
    private Noten() { }
}
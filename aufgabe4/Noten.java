package aufgabe4;
public final class Noten{
    static final double BESTE = 1.0;
    static final double SCHLECHTESTE = 5.0;

    public static boolean istZulaessig(String note){
        switch (note.replace(",", ".")) {
        case "1.0", "1.3", "1.7", "2.0", "2.7", "3.0":
        case "3.3", "3.7", "4.0", "5.0":
            return true;
        default:
            return false;
        } 
    }

    public static Double toDouble (String note){
        try {
            if(istZulaessig(note)){
                return Double.parseDouble(note.replace(',', '.'));
            } else{
                throw new IllegalArgumentException();
            }         
        }
        catch (NumberFormatException nfe) {
            throw new IllegalArgumentException(nfe);
        }
    }

    public static String toString(double note){
        if(note <= BESTE && note >= SCHLECHTESTE) {
            return String.format("%.1f", note);
        }
        throw new IllegalArgumentException();
    }

    public static boolean istBestanden(double note){
        if(note <= SCHLECHTESTE && note >= BESTE){
            return true;
        }
        return false;
    }

    public static double bessere(double note1, double note2){
        if (note1 < note2){ 
            return note1;
        }
        return note2;
    }

    public static double schlechtere(double note1, double note2){
        if (note1 < note2){ 
            return note2;
        }
        return note1;
    }
}
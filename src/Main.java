public class Main {

    public static void main(String[] args) {
        Datenverwaltung daten1 = new Datenverwaltung();
        daten1.zufaelligeDatensaetzeErzeugen(19);
        daten1.printDaten();
        //System.out.println("end");
        daten1.quicksort(0,18);
        daten1.printDaten();
        //GUI_Sortierverfahren Gui = new GUI_Sortierverfahren();
    }
}

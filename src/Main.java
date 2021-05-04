public class Main {

    public static void main(String[] args) {
        Datenverwaltung daten1 = new Datenverwaltung();
        daten1.zufaelligeDatensaetzeErzeugen(5);
        daten1.selectionSort();
        daten1.printDaten();
        //GUI_Sortierverfahren Gui = new GUI_Sortierverfahren();
    }
}

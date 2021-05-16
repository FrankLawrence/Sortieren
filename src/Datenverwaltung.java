public class Datenverwaltung {

    private int[] daten;  //Array, das die zu sortierenden Daten enthält
    private long anzahlVergleiche = 0;  //Variable, speichert die Anzahl der Vergleiche gespeichert werden kann. Inhalt wird automatisch von Oberfläche übernommen.
    // Variable, speichert in die die Laufzeit des Algorithmus in Millisekunden Wert wird automatisch in die Oberfläche übernommen.
    private long laufzeit = 0;

    /*
     * Methode, die die Elemente an den Stellen ersterIndex und zweiterIndex vertauscht
     */
    public void tauscheElementeAnPositionen(int ersterIndex, int zweiterIndex) {
        int temp = daten[ersterIndex];
        daten[ersterIndex] = daten[zweiterIndex];
        daten[zweiterIndex] = temp;
    }

    /*
     * Sortiert die Daten im Array int[] daten mit Hilfe von SelectionSort
     */
    public void selectionSort(  ) {
        long startzeit = System.currentTimeMillis();        // Für Laufzeitüberprüfung Startzeitpunkt ermitteln.
        anzahlVergleiche = 0;        // Anzahl Vergleich auf 0 setzen

        int bestes, speicherzeiger;
        int ende = daten.length-1;
        int anfang = 0;
        while(anfang<ende){
            bestes = anfang;
            speicherzeiger = anfang;
            while(speicherzeiger<ende){
                speicherzeiger++;
                if(daten[speicherzeiger]<daten[bestes]){
                    bestes = speicherzeiger;
                }
            }
            tauscheElementeAnPositionen(anfang,bestes);
            anfang++;
        }

        laufzeit = (System.currentTimeMillis() - startzeit);
    }

    /*
     * sortiert die Daten im Array int[] daten mit Hilfe von BubbleSort
     */
    public void bubbleSort() {
        int ende = daten.length-1;
        int anfang = 0;
        int speicherzeiger;
        while(anfang-ende!=0){
            speicherzeiger = anfang;
            while(speicherzeiger!=ende){
                if(daten[speicherzeiger]>daten[speicherzeiger+1]){
                    tauscheElementeAnPositionen(speicherzeiger,speicherzeiger+1);
                }
                speicherzeiger++;
            }
            ende--;
        }
    }

    /*
     * sortiert die Daten im Array int[] daten mit Hilfe von Insertionsort
     */
    public void insertionSort() {
        int anfang = 0;
        int speicherzeiger;
        int ende = daten.length-1;
        while(anfang<ende){
            speicherzeiger = 0;
            anfang++;
            while (speicherzeiger<=anfang) {
                if (daten[anfang] < daten[speicherzeiger]) {
                    tauscheElementeAnPositionen(anfang, speicherzeiger);
                }
                speicherzeiger++;
            }
        }
    }


    public int teile(int anfang, int ende){
        int left= anfang;
        int right = ende-1;
        int pivot = daten[ende];
        while (left<right){
            while (left< ende && daten[left] <= pivot){
                left++;
            }
            while (right > anfang && daten[right] > pivot){
                right--;
            }
            if (left< right){
                tauscheElementeAnPositionen(left,right);
            }
        }
        if (daten[left] > pivot){
            tauscheElementeAnPositionen(left,ende);
        }
        return left;
    }

    public void quicksort (int anfang, int ende){
        if (anfang<ende){
            int teiler = teile(anfang,ende);
            quicksort(anfang,teiler-1);
            quicksort(teiler+1,ende);
        }
    }

    /**********************************************************
     *
     * AB HIER NICHTS MEHR ÄNDERN!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
     *
     **********************************************************/

    /*
     * stellt das Datensatzarray für die Oberfläche bereit
     *
     * @return Array mit Datensätzen
     */
    public int[] getDaten() {
        return daten;
    }
    /*
     * prints the Array to the console
     */
    public void printDaten() {

        System.out.println(java.util.Arrays.toString(daten));
    }
    /*
     * stellt die Anzahl der Vergleiche für die Oberfläche bereit
     *
     * @return Bei Algorithmus ermittelte Anzahl der Vergleiche
     */
    public long getAnzahlVergleiche() {
        return anzahlVergleiche;
    }

    /*
     * stellt die Laufzeit des Algorithmus für Oberfläche bereit
     *
     * @return Bei Algorithmus ermittelte Laufzeit
     */
    public long getLaufzeit() {
        return  laufzeit;
    }

    /*
     * Füllt das Array daten mit Zufallszahlen zwischen 0 und der Zehnfachen
     * Anzahl
     *
     * @param Anzahl der zu erzeugende Datensätze
     */
    public void zufaelligeDatensaetzeErzeugen(int anzahl) {
        daten = new int[anzahl];
        for (int i= 0;i< anzahl; i++) {
            daten[i] = (int) (Math.random() * anzahl );
        }
    }

    /*
     * Füllt das Array daten mit Zufallszahlen zwischen 0 und der Hälfte der
     * Anzahl -> häufige Wiederholungen
     *
     * @param Anzahl der zu erzeugende Datensätze
     */
    public void datensaetzeMitWiederholungErzeugen(int anzahl) {
        daten = new int[anzahl];
        for (int i= 0;i< anzahl; i++) {
            daten[i] = (int) (Math.random() * anzahl / 2);
        }
    }
}

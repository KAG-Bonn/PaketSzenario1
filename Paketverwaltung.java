public class Paketverwaltung{
    private Stack<Paket> stapelAusgang;
    private Stack<Paket> stapel1;
    private Stack<Paket> stapel2;
    private Stack<Paket> stapel3;
    
    public Paketverwaltung(){
        stapelAusgang = new Stack<Paket>();
        stapel1 = new Stack<Paket>();
        stapel2 = new Stack<Paket>();
        stapel3 = new Stack<Paket>();
    }
    
    //Methode 1
    public void stapeln(Paket pPaket){
        stapelAusgang.push(pPaket);
    }
    //Methode 2
    public void umstapeln(){
        int anzahlPaketeAufStapel1;
        int anzahlPaketeAufStapel2;
        int anzahlPaketeAufStapel3;
        if(stapelAusgang.isEmpty()){
            return;
        }
        Paket paket = stapelAusgang.top();
        anzahlPaketeAufStapel1 = gibAnzahlPaketeAuf(stapel1);
        anzahlPaketeAufStapel2 = gibAnzahlPaketeAuf(stapel2);
        anzahlPaketeAufStapel3 = gibAnzahlPaketeAuf(stapel3);
        if(anzahlPaketeAufStapel1 < anzahlPaketeAufStapel2){
            if(anzahlPaketeAufStapel1 < anzahlPaketeAufStapel3){
                stapel1.push(paket);
            }
            else{
                stapel3.push(paket);
            }
        }
        else{
            stapel2.push(paket);
        }
        stapelAusgang.pop();
    }
    //Methode 3
    public int gibAnzahlPaketeAuf(Stack<Paket> pStapel){
        int anzahl = 0;
        Stack<Paket> tmp = new Stack<Paket>();
        while(!pStapel.isEmpty()){
            tmp.push(pStapel.top());
            pStapel.pop();
            anzahl++;
        }
        pStapel = tmp;
        return anzahl;
    }
    //Methode 4
    public void barcodesAusgebenVon(Stack<Paket> pStapel){
        Stack<Paket> tmp = new Stack<Paket>();
        int i = 1;
        while(!pStapel.isEmpty()){
                tmp.push(pStapel.top());
                System.out.println("Barcode " + i + ":" + " " + pStapel.top().gibBarcode()); 
                i++;
                pStapel.pop();
        }
        pStapel = tmp;
    }
    //Methode 5
    public void findePaket(String pBarcode){
        Stack<Paket>[] alleStapel = {stapel1, stapel2, stapel3};
        
        for(int i = 0; i < alleStapel.length; i++){
            Stack<Paket> tmp = new Stack<Paket>();
            while(!stapel1.isEmpty()){
                if(stapel1.top().equals(pBarcode)){
                    System.out.println("Paket mit Barcode " + pBarcode + " gefunden in Stapel " + i+1);
                    return;
                }
            }
        }
        System.out.println("Paket mit Barcode " + pBarcode + " in keinem Stapel gefunden!");
    }
}
    
    
}
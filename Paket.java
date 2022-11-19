public class Paket{
    private double gewicht;
    private String barcode;
    
    public Paket(double pGewicht, String pBarcode){
        gewicht = pGewicht;
        barcode = pBarcode;
    }
    
    public double gibGewicht(){
        return gewicht;
    }
    public String gibBarcode(){
        return barcode;
    }
}
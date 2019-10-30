package ba.unsa.etf.rpr.tutorijal02;
//staticka metoda ne poziva se nad objektom nad kojim je pozvana vec kao neka obicna funkcija
public class Interval {
   /* konstruktor sa četiri parametra: početna tačka, krajnja tačka (obje tipa double),
    boolean vrijednost koja označava da li početna tačka pripada intervalu ili ne, te isto i za
    krajnju tačku;u slučaju da je početna tačka veća od krajnje treba baciti izuzetak tipa IllegalArgumentException;*/
   double pocetnaTacka = 0, krajnjaTacka = 0;
   boolean daLiPocetnaTackaPripadaIntervalu = false, daLiKrajnjaTackaPripadaIntervalu = false;
   public Interval (double pocetna, double krajnja, boolean pripadanjePocetne, boolean pripadanjeKrajnje){

           if (pocetna > krajnja) throw new IllegalArgumentException("");
           pocetnaTacka = pocetna;
           krajnjaTacka = krajnja;
           daLiPocetnaTackaPripadaIntervalu = pripadanjePocetne;
           daLiKrajnjaTackaPripadaIntervalu = pripadanjeKrajnje;
   }
   /* konstruktor bez parametara koji kreira "null interval" kod kojeg su početna i krajnja tačka
        0 i niti jedna od njih ne pripada intervalu;*/
   public Interval (){}
   // isIn metoda koja prima vrijednost tačke (tipa double) i vraća da li tačka pripada intervalu;
    public boolean isIn(double v) {
       if (v<pocetnaTacka || v>krajnjaTacka) return false;
       else if (v == pocetnaTacka) return daLiPocetnaTackaPripadaIntervalu;
       else if (v == krajnjaTacka) return  daLiKrajnjaTackaPripadaIntervalu;
       else return true;
    }
    //isNull koja vraća boolean vrijednost da li je interval null interval ili nije;
    public boolean isNull() {
       return (pocetnaTacka == 0 && krajnjaTacka == 0 && daLiKrajnjaTackaPripadaIntervalu == false && daLiKrajnjaTackaPripadaIntervalu == false);
    }
   /* metodu intersect koja vraća presjek dva intervala: metoda treba biti urađena kao klasična public
    metoda (prima jedan interval) i kao statička metoda (prima dva intervala);*/
    public Interval intersect(Interval interval) {
        Interval presjekDvaIntervala = new Interval();
        if (interval.getPocetnaTacka() >= pocetnaTacka){
            presjekDvaIntervala.pocetnaTacka = interval.getPocetnaTacka();
            presjekDvaIntervala.daLiPocetnaTackaPripadaIntervalu = interval.getDaLiPocetnaTackaPripadaIntervalu();
        }
        else{
            presjekDvaIntervala.krajnjaTacka = pocetnaTacka;
            presjekDvaIntervala.daLiPocetnaTackaPripadaIntervalu = daLiPocetnaTackaPripadaIntervalu;
        }
        if (interval.getKrajnjaTacka() <= krajnjaTacka) {
            presjekDvaIntervala.krajnjaTacka = interval.getKrajnjaTacka();
            presjekDvaIntervala.daLiKrajnjaTackaPripadaIntervalu = interval.daLiKrajnjaTackaPripadaIntervalu;
        }
        else {
            presjekDvaIntervala.krajnjaTacka = krajnjaTacka;
            presjekDvaIntervala.daLiKrajnjaTackaPripadaIntervalu = daLiKrajnjaTackaPripadaIntervalu;
        }
       return presjekDvaIntervala;
    }
    public static Interval intersect(Interval interval1, Interval interval2) {
        Interval presjekDvaIntervala = new Interval();
        if (interval1.getPocetnaTacka() >= interval2.getPocetnaTacka()) {
            presjekDvaIntervala.pocetnaTacka = interval1.getPocetnaTacka();
            presjekDvaIntervala.daLiPocetnaTackaPripadaIntervalu = interval1.getDaLiPocetnaTackaPripadaIntervalu();
        }
        else{
            presjekDvaIntervala.krajnjaTacka = interval2.getPocetnaTacka();
            presjekDvaIntervala.daLiPocetnaTackaPripadaIntervalu = interval2.getDaLiPocetnaTackaPripadaIntervalu();
        }
        if (interval1.getKrajnjaTacka() <= interval2.getKrajnjaTacka()) {
            presjekDvaIntervala.krajnjaTacka = interval1.getKrajnjaTacka();
            presjekDvaIntervala.daLiKrajnjaTackaPripadaIntervalu = interval1.daLiKrajnjaTackaPripadaIntervalu;
        }
        else {
            presjekDvaIntervala.krajnjaTacka = interval2.getKrajnjaTacka();
            presjekDvaIntervala.daLiKrajnjaTackaPripadaIntervalu = interval2.getDaLiKrajnjaTackaPripadaIntervalu();
        }
        return presjekDvaIntervala;
    }
    private double getPocetnaTacka(){
        return pocetnaTacka;
    }
    private double getKrajnjaTacka(){
        return krajnjaTacka;
    }
    private boolean getDaLiPocetnaTackaPripadaIntervalu(){
        return daLiPocetnaTackaPripadaIntervalu;
    }
    private boolean getDaLiKrajnjaTackaPripadaIntervalu(){
        return daLiKrajnjaTackaPripadaIntervalu;
    }
    @Override
    public String toString() {
        String s = null;
        if (this.isNull()) return "()";
        if (this.daLiPocetnaTackaPripadaIntervalu == true) s ="[";
        else s = s + "(";
        s = s + new Double(this.pocetnaTacka).toString() + "," +  new Double(this.krajnjaTacka).toString(); //prvo moras od double klasu napravit, pa primjenit funkciju
        if (this.daLiKrajnjaTackaPripadaIntervalu == true) s = s + "]";
        else s = s + ")";
        return s;
    }
}







   /*     Potrebno je napraviti klasu Interval koja omogućuje izračunavanje presjeka dva intervala, te provjeru
           da li se tačka nalazi unutar intervala ili ne.
        također treba preklopiti metode klase Object a to su toString i equals, na način koji ima smisla za te metode.

 */
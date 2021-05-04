package de.adesso.jani.Util;

import com.vaadin.flow.component.notification.Notification;

import java.util.Arrays;

public class Handelskalkulation {

    private Double bruttoEinkauf;
    private Double nettoEinkauf;
    private Double zielEinkauf;
    private Double barEinkauf;
    private Double bezugsKosten;
    private Double bezugsPreis;
    private Double selbstKosten;
    private Double barVerkauf;
    private Double zielVerkauf;
    private Double listenPreis;
    private Double bruttoVerkauf;

    private Double lieferantenRabatt;
    private Double lieferantensKonto;
    private Double gemeinKosten;
    private Double gewinnAufschlag;
    private Double kundensKonto;
    private Double verkaufsProvision;
    private Double kundenRabatt;
    private Double mehrWertSteuer;

    public Handelskalkulation(Double bruttoEinkauf, Double nettoEinkauf, Double lieferantenRabatt, Double zielEinkauf, Double lieferantensKonto, Double barEinkauf, Double bezugsKosten, Double bezugsPreis,
                              Double gemeinKosten, Double selbstKosten, Double gewinnAufschlag, Double barVerkauf, Double kundensKonto, Double verkaufsProvision, Double zielVerkauf, Double kundenRabatt,
                              Double listenPreis, Double mehrWertSteuer, Double bruttoVerkauf) {
        this.bruttoEinkauf = bruttoEinkauf;
        this.nettoEinkauf = nettoEinkauf;
        this.zielEinkauf = zielEinkauf;
        this.barEinkauf = barEinkauf;
        this.bezugsKosten = bezugsKosten;
        this.bezugsPreis = bezugsPreis;
        this.selbstKosten = selbstKosten;
        this.barVerkauf = barVerkauf;
        this.zielVerkauf = zielVerkauf;
        this.listenPreis = listenPreis;
        this.bruttoVerkauf = bruttoVerkauf;
        this.lieferantenRabatt = lieferantenRabatt;
        this.lieferantensKonto = lieferantensKonto;
        this.gemeinKosten = gemeinKosten;
        this.gewinnAufschlag = gewinnAufschlag;
        this.kundensKonto = kundensKonto;
        this.verkaufsProvision = verkaufsProvision;
        this.kundenRabatt = kundenRabatt;
        this.mehrWertSteuer = mehrWertSteuer;

    }

    public void completeCalculation() throws ArithmeticException{

        boolean complete;

        int currentRound = 0;

        do{
            complete = calcBruttoEinkauf();
            complete &= calcNettoEinkauf();
            complete &= calcZielEinkauf();
            complete &= calcBarEinkauf();
            complete &= calcBezugsPreis();
            complete &= calcSelbstKosten();
            complete &= calcBarVerkauf();
            complete &= calcZielVerkauf();
            complete &= calcListenPreis();
            complete &= calcBruttoVerkauf();
            complete &= calcLieferantenRabatt();
            complete &= calcLieferantensKonto();
            complete &= calcBezugsKosten();
            complete &= calcGemeinKosten();
            complete &= calcGewinnAufschlag();
            complete &= calcKundensKonto();
            complete &= calcVerkaufsProvision();
            complete &= calcKundenRabatt();
            complete &= calcMehrWertSteuer();

            System.out.println(Arrays.toString(getAllValues()));

            if(++currentRound >= 100) {
                Notification.show("Die Berechnung ist gescheitert. Vielleicht hast du zu wenige Werte eingegeben.");
                throw new ArithmeticException("Calculation did not finish! Maybe too few input");
            }
        } while(!complete);

    }

    public Double[] getAllValues(){
        return new Double[]{bruttoEinkauf, nettoEinkauf, lieferantenRabatt, zielEinkauf, lieferantensKonto, barEinkauf, bezugsKosten, bezugsPreis, gemeinKosten, selbstKosten, gewinnAufschlag,
        barVerkauf, kundensKonto, verkaufsProvision, zielVerkauf, kundenRabatt, listenPreis, mehrWertSteuer, bruttoVerkauf};
    }

    public boolean calcBruttoEinkauf() {

        if (this.bruttoEinkauf != null) return true;

        if (this.nettoEinkauf != null && this.mehrWertSteuer != null) {
            this.bruttoEinkauf = this.nettoEinkauf * (1 + this.mehrWertSteuer);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcNettoEinkauf() {
        if (this.nettoEinkauf != null) return true;

        if (this.bruttoEinkauf != null && this.mehrWertSteuer != null) {
            this.nettoEinkauf = this.bruttoEinkauf / (1 + this.mehrWertSteuer);
            return true;
        } else if (this.lieferantenRabatt != null && this.zielEinkauf != null) {
            this.nettoEinkauf = this.zielEinkauf / (1 - this.lieferantenRabatt);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcZielEinkauf() {
        if (this.zielEinkauf != null) return true;

        if (this.barEinkauf != null && this.lieferantensKonto != null) {
            this.zielEinkauf = this.barEinkauf / (1 - this.lieferantensKonto);
            return true;
        } else if (this.nettoEinkauf != null && this.lieferantenRabatt != null) {
            this.zielEinkauf = this.nettoEinkauf * (1 - this.lieferantenRabatt);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcBarEinkauf() {
        if (this.barEinkauf != null) return true;

        if (this.bezugsPreis != null && this.bezugsKosten != null) {
            this.barEinkauf = this.bezugsPreis - this.bezugsKosten;
            return true;
        } else if (this.zielEinkauf != null && this.lieferantensKonto != null) {
            this.barEinkauf = this.zielEinkauf * (1 - this.lieferantensKonto);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcBezugsKosten() {
        if (this.bezugsKosten != null) return true;

        if (this.bezugsPreis != null && this.barEinkauf != null) {
            this.bezugsKosten = this.bezugsPreis - this.barEinkauf;
            return true;
        } else {
            return false;
        }
    }

    public boolean calcBezugsPreis() {
        if (this.bezugsPreis != null) return true;

        if (this.barEinkauf != null && this.bezugsKosten != null) {
            this.bezugsPreis = barEinkauf + bezugsKosten;
            return true;
        } else if (this.selbstKosten != null && this.gemeinKosten != null) {
            this.bezugsPreis = this.selbstKosten / (1 + this.gemeinKosten);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcSelbstKosten() {
        if (this.selbstKosten != null) return true;

        if (this.barVerkauf != null && this.gewinnAufschlag != null) {
            this.selbstKosten = this.barVerkauf / (1 + this.gewinnAufschlag);
            return true;
        } else if (this.bezugsPreis != null && this.gemeinKosten != null) {
            this.selbstKosten = this.bezugsPreis * (1 + this.gemeinKosten);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcBarVerkauf() {
        if (this.barVerkauf != null) return true;

        if (this.zielVerkauf != null && this.kundensKonto != null && this.verkaufsProvision != null) {
            this.barVerkauf = this.zielVerkauf * (1 - (this.kundensKonto + this.verkaufsProvision));
            return true;
        } else if (this.selbstKosten != null && this.gewinnAufschlag != null) {
            this.barVerkauf = this.selbstKosten * (1 + this.gewinnAufschlag);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcZielVerkauf() {
        if (this.zielVerkauf != null) return true;

        if (this.listenPreis != null && this.kundenRabatt != null) {
            this.zielVerkauf = this.listenPreis * (1 - this.kundenRabatt);
            return true;
        } else if (this.barVerkauf != null && this.kundensKonto != null && this.verkaufsProvision != null) {
            this.zielVerkauf = this.barVerkauf / (1 - (this.kundensKonto + this.verkaufsProvision));
            return true;
        } else {
            return false;
        }
    }

    public boolean calcListenPreis() {
        if (this.listenPreis != null) return true;

        if (this.bruttoVerkauf != null && this.mehrWertSteuer != null) {
            this.listenPreis = this.bruttoVerkauf / (1 + this.mehrWertSteuer);
            return true;
        } else if (this.zielVerkauf != null && this.kundenRabatt != null) {
            this.listenPreis = this.zielVerkauf / (1 - this.kundenRabatt);
            return true;
        } else {
            return false;
        }
    }

    public boolean calcBruttoVerkauf() {
        if (this.bruttoVerkauf != null) return true;

        if (this.listenPreis != null && this.mehrWertSteuer != null) {
            this.bruttoVerkauf = listenPreis * (1 + mehrWertSteuer);
            return true;
        } else {
            return false;
        }
    }


    public boolean calcLieferantenRabatt() {
        if (this.lieferantenRabatt != null) return true;

        if (this.nettoEinkauf != null && this.zielEinkauf != null) {
            this.lieferantenRabatt = 1 - (zielEinkauf / nettoEinkauf);
            return true;
        }

        return false;
    }

    public boolean calcLieferantensKonto() {
        if (this.lieferantensKonto != null) return true;

        if (this.zielEinkauf != null && this.barEinkauf != null) {
            this.lieferantensKonto = 1 - (this.zielEinkauf / this.barEinkauf);
            return true;
        }
        return false;
    }

    public boolean calcGemeinKosten() {
        if (this.gemeinKosten != null) return true;

        if (this.selbstKosten != null && this.bezugsPreis != null) {
            this.gemeinKosten = (this.selbstKosten / this.bezugsPreis) - 1;
            return true;
        }
        return false;
    }

    public boolean calcGewinnAufschlag() {
        if (this.gewinnAufschlag != null) return true;

        if (this.selbstKosten != null && this.barVerkauf != null) {
            this.gewinnAufschlag = 1 - (this.selbstKosten / this.barVerkauf);
            return true;
        }
        return false;
    }

    public boolean calcKundensKonto() {
        if(this.kundensKonto != null) return true;

        if(this.barVerkauf != null && this.verkaufsProvision != null && this.zielVerkauf != null){
            this.kundensKonto = 1 - (this.barVerkauf / this.zielVerkauf) - this.verkaufsProvision;
            return true;
        }
        return false;
    }

    public boolean calcVerkaufsProvision() {
        if(this.verkaufsProvision != null) return true;

        if(this.barVerkauf != null && this.kundensKonto != null && this.zielVerkauf != null){
            this.verkaufsProvision = 1 - (this.barVerkauf / this.zielVerkauf) - this.kundensKonto;
            return true;
        }
        return false;
    }

    public boolean calcKundenRabatt() {
        if(this.kundenRabatt != null) return true;

        if(this.zielVerkauf != null && this.listenPreis != null) {
            this.kundenRabatt = 1 - (this.zielVerkauf / this.listenPreis);
            return true;
        }
        return false;
    }

    public boolean calcMehrWertSteuer() {
        this.mehrWertSteuer = 0.19d;
        return true;
    }
}

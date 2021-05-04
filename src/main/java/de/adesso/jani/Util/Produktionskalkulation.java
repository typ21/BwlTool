package de.adesso.jani.Util;

import com.vaadin.flow.component.notification.Notification;

import java.util.Arrays;

public class Produktionskalkulation {

    private Double fertigungsMaterial;
    private Double materialkosten;
    private Double fertigungsEinzelkosten;
    private Double fertigungsKosten;
    private Double herstellKostenProd;
    private Double selbstKosten;
    private Double barVerkaufsPreis;
    private Double zielVerkaufsPreis;
    private Double listenPreis;
    private Double bruttoVerkaufsPreis;

    private Double matKostenZuschlagsSatz;
    private Double fertigungsGemeinkostenZuschlagsSatz;
    private Double verwaltungsGemeinKostenZuschlag;
    private Double vertriebsGemeinKostenZuschlag;
    private Double gewinnAufschlag;
    private Double kundenSkonto;
    private Double verkaufsProvision;
    private Double rabatt;
    private Double mehrWertSteuer;

    private Double matKostenZuschlagsSatzProz;
    private Double fertigungsGemeinkostenZuschlagsSatzProz;
    private Double verwaltungsGemeinKostenZuschlagProz;
    private Double vertriebsGemeinKostenZuschlagProz;
    private Double gewinnAufschlagProz;
    private Double kundenSkontoProz;
    private Double verkaufsProvisionProz;
    private Double rabattProz;
    private Double mehrWertSteuerProz;

    private Double barProzent;
    private Double zielProzent;

    public Produktionskalkulation(Double fertigungsMaterial, Double matKostenZuschlagsSatzProz, Double matKostenZuschlagsSatz, Double materialkosten,
                                  Double fertigungsEinzelkosten, Double fertigungsGemeinkostenZuschlagsSatzProz, Double fertigungsGemeinkostenZuschlagsSatz,
                                  Double fertigungsKosten, Double herstellKostenProd, Double verwaltungsGemeinKostenZuschlagProz, Double verwaltungsGemeinKostenZuschlag,
                                  Double vertriebsGemeinKostenZuschlagProz, Double vertriebsGemeinKostenZuschlag, Double selbstKosten, Double gewinnAufschlagProz,
                                  Double gewinnAufschlag, Double barVerkaufsPreis, Double kundenSkontoProz, Double kundenSkonto, Double verkaufsProvisionProz,
                                  Double verkaufsProvision, Double zielVerkaufsPreis, Double rabattProz, Double rabatt, Double listenPreis, Double mehrWertSteuerProz,
                                  Double mehrWertSteuer, Double bruttoVerkaufsPreis){
        this.fertigungsMaterial = fertigungsMaterial;
        this.materialkosten = materialkosten;
        this.fertigungsEinzelkosten = fertigungsEinzelkosten;
        this.fertigungsKosten = fertigungsKosten;
        this.herstellKostenProd = herstellKostenProd;
        this.selbstKosten = selbstKosten;
        this.barVerkaufsPreis = barVerkaufsPreis;
        this.zielVerkaufsPreis = zielVerkaufsPreis;
        this.listenPreis = listenPreis;
        this.bruttoVerkaufsPreis = bruttoVerkaufsPreis;
        this.matKostenZuschlagsSatz = matKostenZuschlagsSatz;
        this.fertigungsGemeinkostenZuschlagsSatz = fertigungsGemeinkostenZuschlagsSatz;
        this.verwaltungsGemeinKostenZuschlag = verwaltungsGemeinKostenZuschlag;
        this.vertriebsGemeinKostenZuschlag = vertriebsGemeinKostenZuschlag;
        this.gewinnAufschlag = gewinnAufschlag;
        this.kundenSkonto = kundenSkonto;
        this.verkaufsProvision = verkaufsProvision;
        this.rabatt = rabatt;
        this.mehrWertSteuer = mehrWertSteuer;
        this.matKostenZuschlagsSatzProz = matKostenZuschlagsSatzProz;
        this.fertigungsGemeinkostenZuschlagsSatzProz = fertigungsGemeinkostenZuschlagsSatzProz;
        this.verwaltungsGemeinKostenZuschlagProz = verwaltungsGemeinKostenZuschlagProz;
        this.vertriebsGemeinKostenZuschlagProz = vertriebsGemeinKostenZuschlagProz;
        this.gewinnAufschlagProz = gewinnAufschlagProz;
        this.kundenSkontoProz = kundenSkontoProz;
        this.verkaufsProvisionProz = verkaufsProvisionProz;
        this.rabattProz = rabattProz;
        this.mehrWertSteuerProz = mehrWertSteuerProz;

        Double[][] test = new Double[][]{
                new Double[]{null,                                    null,                                fertigungsMaterial    },
                new Double[]{matKostenZuschlagsSatzProz,              matKostenZuschlagsSatz,              null                  },
                new Double[]{null,                                    null,                                materialkosten        },
                new Double[]{null,                                    null,                                fertigungsEinzelkosten},
                new Double[]{fertigungsGemeinkostenZuschlagsSatzProz, fertigungsGemeinkostenZuschlagsSatz, null                  },
                new Double[]{null,                                    null,                                fertigungsKosten      },
                new Double[]{null,                                    null,                                herstellKostenProd    },
                new Double[]{verwaltungsGemeinKostenZuschlagProz,     verwaltungsGemeinKostenZuschlag,     null                  },
                new Double[]{vertriebsGemeinKostenZuschlagProz,       vertriebsGemeinKostenZuschlag,       null                  },
                new Double[]{null,                                    null,                                selbstKosten          },
                new Double[]{gewinnAufschlagProz,                     gewinnAufschlag,                     null                  },
                new Double[]{null,                                    null,                                barVerkaufsPreis      },
                new Double[]{kundenSkontoProz,                        kundenSkonto,                        null                  },
                new Double[]{verkaufsProvisionProz,                   verkaufsProvision,                   null                  },
                new Double[]{null,                                    null,                                zielVerkaufsPreis     },
                new Double[]{rabattProz,                              rabatt,                              null                  },
                new Double[]{null,                                    null,                                listenPreis           },
                new Double[]{mehrWertSteuerProz,                      mehrWertSteuer,                      null                  },
                new Double[]{null,                                    null,                                bruttoVerkaufsPreis   }
        };

        for (Double[] doubles : test) {
            System.out.println(Arrays.toString(doubles));
        }

    }

    public Double[][] getAllValues() {

        return new Double[][]{
                new Double[]{null,                                    null,                                fertigungsMaterial    },
                new Double[]{matKostenZuschlagsSatzProz,              matKostenZuschlagsSatz,              null                  },
                new Double[]{null,                                    null,                                materialkosten        },
                new Double[]{null,                                    null,                                fertigungsEinzelkosten},
                new Double[]{fertigungsGemeinkostenZuschlagsSatzProz, fertigungsGemeinkostenZuschlagsSatz, null                  },
                new Double[]{null,                                    null,                                fertigungsKosten      },
                new Double[]{null,                                    null,                                herstellKostenProd    },
                new Double[]{verwaltungsGemeinKostenZuschlagProz,     verwaltungsGemeinKostenZuschlag,     null                  },
                new Double[]{vertriebsGemeinKostenZuschlagProz,       vertriebsGemeinKostenZuschlag,       null                  },
                new Double[]{null,                                    null,                                selbstKosten          },
                new Double[]{gewinnAufschlagProz,                     gewinnAufschlag,                     null                  },
                new Double[]{null,                                    null,                                barVerkaufsPreis      },
                new Double[]{kundenSkontoProz,                        kundenSkonto,                        null                  },
                new Double[]{verkaufsProvisionProz,                   verkaufsProvision,                   null                  },
                new Double[]{null,                                    null,                                zielVerkaufsPreis     },
                new Double[]{rabattProz,                              rabatt,                              null                  },
                new Double[]{null,                                    null,                                listenPreis           },
                new Double[]{mehrWertSteuerProz,                      mehrWertSteuer,                      null                  },
                new Double[]{null,                                    null,                                bruttoVerkaufsPreis   }
        };

    }

    public void calcComplete() {
        
       boolean complete;

        int i = 0;

        do {

            Double[][] test = getAllValues();

            boolean complete1  = calcFertigungsMaterial();
            boolean complete2  = calcMaterialKostenZuschlagsSatz();
            boolean complete3  = calcMatKostenZuschlagsSatzProz();
            boolean complete4  = calcMaterialkosten();
            boolean complete5  = calcFertigungsEinzelkosten();
            boolean complete6  = calcFertigungsGemeinKostenZuschlagsSatz();
            boolean complete7  = calcFertigungsGemeinkostenZuschlagsSatzProz();
            boolean complete8  = calcFertigungsKosten();
            boolean complete9  = calcHerstellKostenProd();
            boolean complete10 = calcVerwaltungsGemeinKostenZuschlag();
            boolean complete11 = calcVerwaltungsGemeinKostenZuschlagProz();
            boolean complete12 = calcVertriebsGemeinKostenZuschlag();
            boolean complete13 = calcVertriebsGemeinKostenZuschlagProz();
            boolean complete14 = calcSelbstKosten();
            boolean complete15 = calcGewinnAufschlag();
            boolean complete16 = calcGewinnAufschlagProz();
            boolean complete17 = calcBarProzent();
            boolean complete18 = calcBarVerkaufsPreis();
            boolean complete19 = calcKundenSkonto();
            boolean complete20 = calcKundenSkontoProz();
            boolean complete21 = calcVerkaufsProvision();
            boolean complete22 = calcVerkaufsProvisionProz();
            boolean complete23 = calcZielVerkaufsPreis();
            boolean complete24 = calcZielProzent();
            boolean complete25 = calcRabatt();
            boolean complete26 = calcRabattProz();
            boolean complete27 = calcListenPreis();
            boolean complete28 = calcMehrwertSteuer();
            boolean complete29 = calcMehrWertSteuerProz();
            boolean complete30 = calcBruttoVerkaufsPreis();

            complete = complete1 && complete2 && complete3
                    && complete4&& complete5&& complete6
                    && complete7&& complete8&& complete9
                    && complete10&& complete11&& complete12
                    && complete13&& complete14&& complete15
                    && complete16&& complete17&& complete18
                    && complete19&& complete20&& complete21
                    && complete22&& complete23&& complete24
                    && complete25&& complete26&& complete27
                    && complete28&& complete29&& complete30;
            System.out.println();

            System.out.println(this.bruttoVerkaufsPreis != null && this.mehrWertSteuer != null);

            for (Double[] doubles : test) {
                System.out.println(Arrays.toString(doubles));
            }

            if(++i > 100) {
                Notification.show("Die Berechnung ist gescheitert. Vielleicht hast du zu wenige Werte eingegeben.");
                break;
            }

        }while(!complete);
        
    }

    private boolean calcFertigungsMaterial() {
        if (this.fertigungsMaterial != null) return true;

        if (this.matKostenZuschlagsSatzProz != null && this.materialkosten != null) {
            this.fertigungsMaterial = this.materialkosten / (1 + this.matKostenZuschlagsSatzProz);
            return true;
        } else if (this.matKostenZuschlagsSatz != null && this.materialkosten != null) {
            this.fertigungsMaterial = this.materialkosten - this.matKostenZuschlagsSatz;
            return true;
        }
        return false;
    }


    private boolean calcMaterialKostenZuschlagsSatz() {
        if (this.matKostenZuschlagsSatz != null) return true;

        if (this.materialkosten != null && this.fertigungsMaterial != null) {
            this.matKostenZuschlagsSatz = this.materialkosten - this.fertigungsMaterial;
            return true;
        } else if (this.fertigungsMaterial != null && this.matKostenZuschlagsSatzProz != null) {
            this.matKostenZuschlagsSatz = this.fertigungsMaterial * this.matKostenZuschlagsSatzProz;
            return true;
        }
        return false;
    }

    private boolean calcMaterialkosten() {
        if (this.materialkosten != null) return true;

        if (this.fertigungsMaterial != null && this.matKostenZuschlagsSatz != null) {
            this.materialkosten = this.fertigungsMaterial + this.matKostenZuschlagsSatz;
            return true;
        } else if (this.matKostenZuschlagsSatzProz != null && this.fertigungsMaterial != null) {
            this.materialkosten = this.fertigungsMaterial * (1 + this.matKostenZuschlagsSatzProz);
            return true;
        } else if (this.herstellKostenProd != null && this.fertigungsKosten != null) {
            this.materialkosten = this.herstellKostenProd - this.fertigungsKosten;
        }
        return false;
    }

    private boolean calcFertigungsEinzelkosten() {
        if (this.fertigungsEinzelkosten != null) return true;

        if (this.fertigungsGemeinkostenZuschlagsSatz != null && this.fertigungsKosten != null) {
            this.fertigungsEinzelkosten = this.fertigungsKosten - this.fertigungsGemeinkostenZuschlagsSatz;
            return true;
        } else if (this.fertigungsKosten != null && this.fertigungsGemeinkostenZuschlagsSatzProz != null) {
            this.fertigungsEinzelkosten = this.fertigungsKosten / (1 + this.fertigungsGemeinkostenZuschlagsSatzProz);
            return true;
        }
        return false;
    }

    private boolean calcFertigungsGemeinKostenZuschlagsSatz() {
        if (this.fertigungsGemeinkostenZuschlagsSatz != null) return true;

        if (this.fertigungsGemeinkostenZuschlagsSatzProz != null && this.fertigungsEinzelkosten != null) {
            this.fertigungsGemeinkostenZuschlagsSatz = this.fertigungsEinzelkosten * this.fertigungsGemeinkostenZuschlagsSatzProz;
            return true;
        } else if (this.fertigungsKosten != null && this.fertigungsEinzelkosten != null) {
            this.fertigungsGemeinkostenZuschlagsSatz = this.fertigungsKosten - this.fertigungsEinzelkosten;
            return true;
        }
        return false;
    }

    private boolean calcFertigungsKosten() {
        if (this.fertigungsKosten != null) return true;

        if (this.fertigungsEinzelkosten != null && this.fertigungsGemeinkostenZuschlagsSatz != null) {
            this.fertigungsKosten = this.fertigungsEinzelkosten + this.fertigungsGemeinkostenZuschlagsSatz;
            return true;
        } else if (this.fertigungsEinzelkosten != null && this.fertigungsGemeinkostenZuschlagsSatzProz != null) {
            this.fertigungsKosten = this.fertigungsEinzelkosten * (1 + this.fertigungsGemeinkostenZuschlagsSatzProz);
            return true;
        } else if (this.herstellKostenProd != null && this.materialkosten != null) {
            this.fertigungsKosten = this.herstellKostenProd - this.materialkosten;
            return true;
        }
        return false;
    }

    private boolean calcHerstellKostenProd() {
        if (this.herstellKostenProd != null) return true;
        if (this.fertigungsKosten != null && this.materialkosten != null) {
            this.herstellKostenProd = this.fertigungsKosten + this.materialkosten;
            return true;
        } else if (this.selbstKosten != null && this.vertriebsGemeinKostenZuschlag != null && this.verwaltungsGemeinKostenZuschlag != null) {
            this.herstellKostenProd = this.selbstKosten - (this.vertriebsGemeinKostenZuschlag + this.verwaltungsGemeinKostenZuschlag);
            return true;
        } else if (this.selbstKosten != null && this.verwaltungsGemeinKostenZuschlagProz != null && this.vertriebsGemeinKostenZuschlagProz != null) {
            this.herstellKostenProd = this.selbstKosten / (1 + this.vertriebsGemeinKostenZuschlagProz + this.verwaltungsGemeinKostenZuschlagProz);
            return true;
        }
        return false;
    }

    private boolean calcVerwaltungsGemeinKostenZuschlag() {
        if (this.verwaltungsGemeinKostenZuschlag != null) return true;

        if (this.vertriebsGemeinKostenZuschlag != null && this.herstellKostenProd != null && this.selbstKosten != null) {
            this.verwaltungsGemeinKostenZuschlag = this.selbstKosten - (this.herstellKostenProd + this.vertriebsGemeinKostenZuschlag);
            return true;
        } else if (this.herstellKostenProd != null && this.verwaltungsGemeinKostenZuschlagProz != null) {
            this.verwaltungsGemeinKostenZuschlag = this.herstellKostenProd * this.verwaltungsGemeinKostenZuschlagProz;
            return true;
        }
        return false;
    }

    private boolean calcVertriebsGemeinKostenZuschlag() {
        if (this.vertriebsGemeinKostenZuschlag != null) return true;

        if (this.verwaltungsGemeinKostenZuschlag != null && this.herstellKostenProd != null && this.selbstKosten != null) {
            this.vertriebsGemeinKostenZuschlag = this.selbstKosten - (this.herstellKostenProd + this.verwaltungsGemeinKostenZuschlag);
            return true;
        } else if (this.herstellKostenProd != null && this.vertriebsGemeinKostenZuschlagProz != null) {
            this.vertriebsGemeinKostenZuschlag = this.herstellKostenProd * this.vertriebsGemeinKostenZuschlagProz;
            return true;
        }
        return false;
    }

    private boolean calcSelbstKosten() {
        if (this.selbstKosten != null) return true;

        if (this.herstellKostenProd != null && this.vertriebsGemeinKostenZuschlag != null && this.verwaltungsGemeinKostenZuschlag != null) {
            this.selbstKosten = this.herstellKostenProd + this.vertriebsGemeinKostenZuschlag + this.verwaltungsGemeinKostenZuschlag;
            return true;
        } else if (this.barVerkaufsPreis != null && this.gewinnAufschlag != null) {
            this.selbstKosten = this.barVerkaufsPreis - this.gewinnAufschlag;
            return true;
        } else if (this.barVerkaufsPreis != null && this.gewinnAufschlagProz != null) {
            this.selbstKosten = this.barVerkaufsPreis / (1 + this.gewinnAufschlagProz);
            return true;
        }
        return false;
    }

    private boolean calcGewinnAufschlag() {
        if (this.gewinnAufschlag != null) return true;

        if (this.barVerkaufsPreis != null && this.selbstKosten != null) {
            this.gewinnAufschlag = this.barVerkaufsPreis - this.selbstKosten;
            return true;
        } else if (this.gewinnAufschlagProz != null && this.selbstKosten != null) {
            this.gewinnAufschlag = this.selbstKosten * this.gewinnAufschlagProz;
            return true;
        }
        return false;
    }

    private boolean calcBarVerkaufsPreis() {
        if (this.barVerkaufsPreis != null) return true;

        if (this.zielVerkaufsPreis != null && this.kundenSkonto != null && this.verkaufsProvision != null) {
            this.barVerkaufsPreis = this.zielVerkaufsPreis - verkaufsProvision - kundenSkonto;
            return true;
        } else if (this.zielVerkaufsPreis != null && kundenSkontoProz != null && this.verkaufsProvisionProz != null) {
            this.barVerkaufsPreis = this.zielVerkaufsPreis * (1 - (kundenSkontoProz + verkaufsProvisionProz));
            return true;
        } else if (this.selbstKosten != null && this.gewinnAufschlag != null) {
            this.barVerkaufsPreis = this.selbstKosten + this.gewinnAufschlag;
        }
        return false;
    }

    private boolean calcKundenSkonto() {
        if (this.kundenSkonto != null) return true;

        if (this.barVerkaufsPreis != null && this.zielVerkaufsPreis != null && this.verkaufsProvision != null) {
            this.kundenSkonto = this.zielVerkaufsPreis - this.barVerkaufsPreis - this.verkaufsProvision;
            return true;
        } else if (this.zielVerkaufsPreis != null && this.kundenSkontoProz != null) {
            this.kundenSkonto = this.zielVerkaufsPreis * this.kundenSkontoProz;
            return true;
        }
        return false;
    }

    private boolean calcVerkaufsProvision() {
        if (this.verkaufsProvision != null) return true;

        if (this.barVerkaufsPreis != null && this.zielVerkaufsPreis != null && this.kundenSkonto != null) {
            this.verkaufsProvision = this.zielVerkaufsPreis - this.barVerkaufsPreis - this.kundenSkonto;
            return true;
        } else if (this.zielVerkaufsPreis != null && this.verkaufsProvisionProz != null) {
            this.verkaufsProvision = this.zielVerkaufsPreis * this.verkaufsProvisionProz;
            return true;
        }
        return false;
    }

    private boolean calcZielVerkaufsPreis() {
        if (this.zielVerkaufsPreis != null) return true;

        if (this.barVerkaufsPreis != null && this.kundenSkonto != null && this.verkaufsProvision != null) {
            this.zielVerkaufsPreis = this.barVerkaufsPreis + this.kundenSkonto + this.verkaufsProvision;
            return true;
        } else if (this.listenPreis != null && this.rabattProz != null) {
            this.zielVerkaufsPreis = this.listenPreis * (1 - this.rabattProz);
            return true;
        }else if(this.barVerkaufsPreis != null && this.kundenSkontoProz != null && this.verkaufsProvisionProz !=null){
            this.zielVerkaufsPreis = this.barVerkaufsPreis / (1-(this.kundenSkontoProz+verkaufsProvisionProz));
            return true;
        } else if (this.listenPreis != null && this.rabatt != null) {
            this.zielVerkaufsPreis = this.listenPreis - this.rabatt;
            return true;
        }
        return false;
    }

    private boolean calcRabatt() {
        if (this.rabatt != null) return true;

        if (this.listenPreis != null && this.zielVerkaufsPreis != null) {
            this.rabatt = this.listenPreis - this.zielVerkaufsPreis;
            return true;
        } else if (this.rabattProz != null && this.listenPreis != null) {
            this.rabatt = this.listenPreis * this.rabattProz;
            return true;
        }
        return false;
    }

    private boolean calcListenPreis() {
        if (this.listenPreis != null) return true;

        if (this.zielVerkaufsPreis != null && this.rabatt != null) {
            this.listenPreis = this.zielVerkaufsPreis + this.rabatt;
            return true;
        } else if (this.bruttoVerkaufsPreis != null && this.mehrWertSteuerProz != null) {
            this.listenPreis = this.bruttoVerkaufsPreis / (1 + this.mehrWertSteuerProz);
            return true;
        } else if (this.zielVerkaufsPreis != null && this.rabattProz != null) {
            this.listenPreis = this.zielVerkaufsPreis / (1 - this.rabattProz);
            return true;
        }
        return false;
    }

    private boolean calcMehrwertSteuer() {
        if (this.mehrWertSteuer != null) return true;

        if (this.bruttoVerkaufsPreis != null && this.listenPreis != null) {
            this.mehrWertSteuer = this.bruttoVerkaufsPreis - this.listenPreis;
            return true;
        }
        return false;
    }

    private boolean calcBruttoVerkaufsPreis() {
        if (this.bruttoVerkaufsPreis != null) return true;

        if (this.listenPreis != null && this.mehrWertSteuerProz != null) {
            this.bruttoVerkaufsPreis = this.listenPreis * (1 + this.mehrWertSteuerProz);
            return true;
        }
        return false;
    }

    private boolean calcMatKostenZuschlagsSatzProz() {
        if (matKostenZuschlagsSatzProz != null) return true;

        if (this.materialkosten != null && this.fertigungsMaterial != null) {
            this.matKostenZuschlagsSatzProz = (this.materialkosten / this.fertigungsMaterial) - 1;
            return true;
        } else if (this.matKostenZuschlagsSatz != null && this.fertigungsMaterial != null) {
            this.matKostenZuschlagsSatzProz = this.matKostenZuschlagsSatz / this.fertigungsMaterial;
        }
        return false;
    }

    private boolean calcFertigungsGemeinkostenZuschlagsSatzProz() {
        if (this.fertigungsGemeinkostenZuschlagsSatzProz != null) return true;

        if (this.fertigungsEinzelkosten != null && this.fertigungsKosten != null) {
            this.fertigungsGemeinkostenZuschlagsSatzProz = (this.fertigungsKosten / this.fertigungsEinzelkosten) - 1;
            return true;
        } else if (this.fertigungsEinzelkosten != null && this.fertigungsGemeinkostenZuschlagsSatz != null) {
            this.fertigungsGemeinkostenZuschlagsSatzProz = this.fertigungsGemeinkostenZuschlagsSatz / this.fertigungsEinzelkosten;
            return true;
        }
        return false;
    }

    private boolean calcVerwaltungsGemeinKostenZuschlagProz() {
        if (this.verwaltungsGemeinKostenZuschlagProz != null) return true;

        if (this.herstellKostenProd != null && this.vertriebsGemeinKostenZuschlagProz != null && this.selbstKosten != null) {
            this.verwaltungsGemeinKostenZuschlagProz = (this.selbstKosten / this.herstellKostenProd) - 1 - this.vertriebsGemeinKostenZuschlagProz;
            return true;
        } else if (this.verwaltungsGemeinKostenZuschlag != null && this.herstellKostenProd != null) {
            this.vertriebsGemeinKostenZuschlagProz = this.vertriebsGemeinKostenZuschlag / this.herstellKostenProd;
            return true;
        }
        return true;
    }

    private boolean calcVertriebsGemeinKostenZuschlagProz() {
        if (this.vertriebsGemeinKostenZuschlagProz != null) return true;

        if (this.herstellKostenProd != null && this.verwaltungsGemeinKostenZuschlagProz != null && this.selbstKosten != null) {
            this.vertriebsGemeinKostenZuschlagProz = (this.selbstKosten / this.herstellKostenProd) - 1 - this.verwaltungsGemeinKostenZuschlagProz;
            return true;
        } else if (this.vertriebsGemeinKostenZuschlag != null && this.herstellKostenProd != null) {
            this.vertriebsGemeinKostenZuschlagProz = this.verwaltungsGemeinKostenZuschlag / this.herstellKostenProd;
            return true;
        }
        return true;
    }

    private boolean calcGewinnAufschlagProz() {
        if (this.gewinnAufschlagProz != null) return true;

        if (this.barVerkaufsPreis != null && this.selbstKosten != null) {
            this.gewinnAufschlagProz = (this.barVerkaufsPreis / this.selbstKosten) - 1;
            return true;
        } else if (this.selbstKosten != null && this.gewinnAufschlag != null) {
            this.gewinnAufschlagProz = this.gewinnAufschlag / this.selbstKosten;
            return true;
        }
        return false;
    }

    private boolean calcBarProzent() {
        if (this.barProzent != null) return true;

        if (this.kundenSkontoProz != null && this.verkaufsProvisionProz != null) {
            this.barProzent = 1.0 - (kundenSkontoProz + verkaufsProvisionProz);
            return true;
        } else if (this.barVerkaufsPreis != null && this.zielVerkaufsPreis != null) {
            this.barProzent = this.barVerkaufsPreis / this.zielVerkaufsPreis;
            return true;
        }
        return false;
    }

    private boolean calcKundenSkontoProz() {
        if (this.kundenSkontoProz != null) return true;

        if (this.barProzent != null && this.verkaufsProvisionProz != null) {
            this.kundenSkontoProz = 1.0 - (this.barProzent + this.verkaufsProvisionProz);
            return true;
        } else if (this.kundenSkonto != null && this.barVerkaufsPreis != null) {
            this.kundenSkontoProz = this.kundenSkonto / this.barVerkaufsPreis;
            return true;
        }

        return false;
    }

    private boolean calcVerkaufsProvisionProz() {

        if (this.verkaufsProvisionProz != null) return true;

        if (this.barProzent != null && this.kundenSkontoProz != null) {
            this.verkaufsProvisionProz = 1.0 - (this.barProzent + this.kundenSkontoProz);
            return true;
        } else if (this.verkaufsProvision != null && this.barVerkaufsPreis != null) {
            this.verkaufsProvisionProz = this.verkaufsProvision / this.barVerkaufsPreis;
            return true;
        }

        return false;

    }

    private boolean calcZielProzent() {
        if (this.zielProzent != null) return true;

        if (this.rabattProz != null) {
            this.zielProzent = 1.0 - this.rabattProz;
            return true;
        } else if (this.zielVerkaufsPreis != null && this.listenPreis != null) {
            this.zielProzent = this.zielVerkaufsPreis / this.listenPreis;
            return true;
        }
        return false;
    }


    private boolean calcRabattProz() {
        if (this.rabattProz != null) return true;

        if (this.listenPreis != null && this.rabatt != null) {
            this.rabattProz = this.rabatt / this.listenPreis;
            return true;
        } else if (this.listenPreis != null && this.zielVerkaufsPreis != null) {

            this.rabattProz = (this.listenPreis / this.zielVerkaufsPreis) - 1;
            return true;
        }
        return false;

    }

    private boolean calcMehrWertSteuerProz() {
        if (this.mehrWertSteuerProz != null) return true;

        if (this.listenPreis != null && this.bruttoVerkaufsPreis != null) {
            this.mehrWertSteuerProz = (this.bruttoVerkaufsPreis / this.listenPreis) - 1;
            return true;
        }
        return false;
    }
}

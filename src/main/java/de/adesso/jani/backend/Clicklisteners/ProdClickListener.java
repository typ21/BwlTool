package de.adesso.jani.backend.Clicklisteners;

public class ProdClickListener extends CalcClickListener{


    @Override
    public void onComponentEventAbst(ClickCalcEvent event) {
        dS.incrementProdKalk(event.isSuccess());
        dS.incrementTodayClicks();
    }
}

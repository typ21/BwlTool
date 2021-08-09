package de.adesso.jani.backend.Clicklisteners;

public class BabClickListener extends CalcClickListener{

    @Override
    public void onComponentEventAbst(ClickCalcEvent event) {
        dS.incrementBAB(event.isSuccess());
        dS.incrementTodayClicks();
    }
}

package de.adesso.jani.backend.Clicklisteners;

public class HanClickListener extends CalcClickListener{

    @Override
    public void onComponentEventAbst(ClickCalcEvent event) {
        dS.incrementHanKalk(event.isSuccess());
        dS.incrementTodayClicks();
    }
}

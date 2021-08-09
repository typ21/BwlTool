package de.adesso.jani.backend.Clicklisteners;

public class NetClickListener extends CalcClickListener{

    @Override
    public void onComponentEventAbst(ClickCalcEvent event) {
        dS.incrementNET(event.isSuccess());
        dS.incrementTodayClicks();
    }
}

package de.adesso.jani.backend.Clicklisteners;

public class ABCClickListener extends CalcClickListener{

    @Override
    public void onComponentEventAbst(ClickCalcEvent event) {
        dS.incrementABC(event.isSuccess());
        dS.incrementTodayClicks();
    }
}

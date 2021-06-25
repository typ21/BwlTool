package de.adesso.jani.backend.Clicklisteners;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import de.adesso.jani.backend.DataService;
import de.adesso.jani.backend.UsageDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.xml.crypto.Data;

@Component
public abstract class CalcClickListener implements ComponentEventListener<ClickCalcEvent> {

    @Autowired
    protected DataService dS;


    @Override
    public void onComponentEvent(ClickCalcEvent event) {
        onComponentEventAbst(event);
    }

    public abstract void onComponentEventAbst(ClickCalcEvent event);
}

package de.adesso.jani.backend.Clicklisteners;

import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;

public class ClickCalcEvent extends ComponentEvent<Button> {

    private final boolean success;

    /**
     * Creates a new event using the given source and indicator whether the
     * event originated from the client side or the server side.
     *
     * @param source     the source component
     */

    public ClickCalcEvent(Button source, boolean success) {
        super(source, false);
        this.success = success;
    }

    public boolean isSuccess() {
        return success;
    }
}

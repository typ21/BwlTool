package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
@CssImport("./components/card.css")
public class Card extends VerticalLayout {
    public Card(){
        this.addClassName("card");
    }
}

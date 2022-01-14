package de.adesso.jani.views.sites.info;

import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;

@Route(value="impressum", layout = MainView.class)
@PageTitle("Impressum")
public class Impressum extends VerticalLayoutWithFooter {

    public Impressum(){
        add(
                new H3("Angaben gemäß § 5 TMG"),
                new Span("Arne Abbing"),
                new Span("Eierkampstr. 34"),
                new Span("44225 Dortmund"),
                new H3("Kontakt"),
                new Span("Email: lreg0@web.de")
        );
    }

}

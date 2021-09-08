package de.adesso.jani.views.sites;

import com.vaadin.flow.component.Html;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;

@PageTitle("Datenschutz")
@Route(value = "/datenschutz", layout= MainView.class)
public class Datenschutz extends VerticalLayoutWithFooter {
    public Datenschutz(){
        Html content = new Html("<H1>Titel</H1><p>Text</p>");
        add(content);
    }
}

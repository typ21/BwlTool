package de.adesso.jani.views.sites.info;

import com.vaadin.flow.component.Text;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;

@Route(value="datenschutz", layout = MainView.class)
@PageTitle("Datenschutz")
public class Datenschutz extends VerticalLayoutWithFooter {

    public Datenschutz(){
        add(
               //Datenschutz Content
        );
    }

}

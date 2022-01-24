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
                //Impressum info
        );
    }

}

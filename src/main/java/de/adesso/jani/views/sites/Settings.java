package de.adesso.jani.views.sites;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.main.MainView;

@Route(value="settings", layout= MainView.class)
@PageTitle("Einstellungen")
public class Settings {
    public Settings(){

    }
}

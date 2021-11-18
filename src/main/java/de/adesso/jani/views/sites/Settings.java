package de.adesso.jani.views.sites;

import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.OwnComponents.Card;
import de.adesso.jani.views.OwnComponents.Cluster.Cluster;
import de.adesso.jani.views.OwnComponents.TextCard;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;
import de.adesso.jani.views.sites.editors.AboutBearbeiten;
import de.adesso.jani.views.sites.editors.DatenschutzBearbeiten;
import de.adesso.jani.views.sites.editors.ImpressumBearbeiten;

import java.util.ArrayList;

@Route(value="settings", layout= MainView.class)
@PageTitle("Einstellungen")
public class Settings extends VerticalLayoutWithFooter {

    private Cluster cluster = new Cluster();

    public Settings(){
        cluster.addRow(
                TextCard.createCard()
                        .setTitle("Datenschutz bearbeiten")
                        .setDescription("Editor um die Datenschutzerlärung des BWL-Tools zu bearbeiten")
                        .setNavigationTarget(DatenschutzBearbeiten.class)
        );
        cluster.addRow(
                TextCard.createCard()
                        .setTitle("Impressum bearbeiten")
                        .setDescription("Editor um die Impressumsansicht des BWL-Tools zu bearbeiten")
                        .setNavigationTarget(ImpressumBearbeiten.class)
        );
        cluster.addRow(
                TextCard.createCard()
                        .setTitle("About bearbeiten")
                        .setDescription("Editor um die About Seite des BWL-Tools zu bearbeiten")
                        .setNavigationTarget(AboutBearbeiten.class)
        );
        add(cluster);
    }
}

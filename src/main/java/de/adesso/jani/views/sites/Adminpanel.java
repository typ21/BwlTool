package de.adesso.jani.views.sites;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinSession;
import com.vaadin.flow.server.WebBrowser;
import de.adesso.jani.Util.ChartGenerator;
import de.adesso.jani.views.OwnComponents.Card;
import de.adesso.jani.views.OwnComponents.Cluster.Cluster;
import de.adesso.jani.views.OwnComponents.NumberCard;
import de.adesso.jani.views.OwnComponents.TabPages;
import de.adesso.jani.views.OwnComponents.TopBar;
import de.adesso.jani.views.main.MainView;

@Route(value="admin", layout= MainView.class)
//@Secured("ROLE_ADMIN")
@PageTitle("Adminpanel")
public class Adminpanel extends VerticalLayout{

    Cluster cluster = new Cluster();

    NumberCard visitorsCard = new NumberCard();
    NumberCard calculationsCard = new NumberCard();
    NumberCard badCalculationsCard = new NumberCard();

    Card calculationOverTime = new Card();
    Card visitorsOverTime = new Card();

    TopBar topBar = new TopBar();
    Button settings = new Button();
    Button lessiL = new Button(new Icon(VaadinIcon.THIN_SQUARE));
    Button moreiL = new Button(new Icon(VaadinIcon.GRID));
    Button refresh = new Button(new Icon(VaadinIcon.REFRESH));

    public Adminpanel(){
        settings();
        listener();
        build();
    }

    private void listener() {
        settings.addClickListener(e -> {

        });
        moreiL.addClickListener(e -> {
           if(cluster.getMaxElements() < 3)
               cluster.setMaxElements(cluster.getMaxElements() + 1);
           update();
        });
        lessiL.addClickListener(e -> {
            if(cluster.getMaxElements() > 1)
                cluster.setMaxElements(cluster.getMaxElements() - 1);
            update();
        });
        refresh.addClickListener(e ->{
           update();
        });
    }

    private void build() {
        removeAll();
        cluster.addRow(visitorsCard, calculationsCard, badCalculationsCard);
        cluster.addRow(calculationOverTime, visitorsOverTime);
        add(topBar, cluster);
    }

    private void settings() {
        this.getStyle().set("background-color", "#f0f0f0");
        this.setMinHeight("100%");
        this.setSpacing(false);
        this.setMargin(false);
        this.setPadding(false);

        if(isMobileDevice())
            cluster.setMaxElements(1);
        else
            cluster.setMaxElements(3);

        cardSettings();
        settingCoT();
        settingsVoT();
        topBarSettings();
    }

    private void topBarSettings() {
        settings.setIcon(new Icon(VaadinIcon.COG_O));

        topBar.add(settings, lessiL, moreiL, refresh);
    }

    private void cardSettings(){
        visitorsCard
                .setTitle("Heutige Besucher")
                .setDescription("Aufrufe der Homepage heute")
                .setType(visitorsCard.NORMAL)
                .setNumber(MainView.Visitors);
        calculationsCard
                .setTitle("Heutige Berechnungen")
                .setDescription("Berechnungen, die heute stattgefunden haben")
                .setType(badCalculationsCard.GOOD)
                .setNumber(13);
        badCalculationsCard
                .setTitle("Heute fehlgeschlagene Rechnungen")
                .setDescription("Anzahl der Berechnungen die heute fehlgeschlagen sind.")
                .setType(badCalculationsCard.WARNING)
                .setNumber(25);
    }

    private void settingsVoT() {
        calculationOverTime.removeAll();
        TabPages tabpages = new TabPages();
        VerticalLayout page1 = tabpages.createPage("Tag");
        VerticalLayout page2 = tabpages.createPage("Monat");
        tabpages.selectTab(0);
        page1.add(ChartGenerator.createCoTWeek());
        page2.add(ChartGenerator.createCoTMonth());
        calculationOverTime.add(tabpages);
    }

    private void settingCoT() {
        visitorsOverTime.removeAll();
        TabPages tabpages = new TabPages();
        VerticalLayout page1 = tabpages.createPage("Tag");
        VerticalLayout page2 = tabpages.createPage("Monat");
        tabpages.selectTab(0);
        page1.add(ChartGenerator.createVoTWeek());
        page2.add(ChartGenerator.createVoTMonth());
        visitorsOverTime.add(tabpages);
    }

    private boolean isMobileDevice() {
        WebBrowser webBrowser = VaadinSession.getCurrent().getBrowser();
        return webBrowser.isAndroid() || webBrowser.isIPhone() || webBrowser.isWindowsPhone();
    }

    public void update(){
        cardSettings();
        settingCoT();
        settingsVoT();
    }
}

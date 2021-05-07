package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.H4;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class VerticalLayoutWithFooter extends VerticalLayout {

    private HorizontalLayout footer = new HorizontalLayout();

    public VerticalLayoutWithFooter(){
        super();
        fillStandartFooter();
        super.add(footer);
    }

    private void fillStandartFooter() {
        footer.getStyle().set("background-color", "#233348");
        footer.setWidthFull();
        footer.setMargin(false);
        footer.setPadding(true);
        super.setPadding(false);

        footer.add(createFooterRow("Projekt",
                createNewLink("https://github.com/typ21/BwlTool", "GitHub Repository"),
                createNewLink("https://github.com/typ21/BwlTool/issues", "Fehler melden")));

        footer.add(createFooterRow("Seite",
                createNewLink("", "Admin Panel"),
                createNewLink("", "About"),
                createNewLink("", "Impressum"),
                createNewLink("", "Datenschutz")));
    }
    private VerticalLayout createFooterRow(String title, Anchor... links){
        VerticalLayout vl = new VerticalLayout();
        vl.setSpacing(false);
        H3 titleH = new H3(title);
        titleH.getStyle().set("color", "white");
        vl.add(titleH);
        vl.add(links);
        return vl;
    }

    private Anchor createNewLink(String href, String text){
        Anchor anchor = new Anchor(href, text);
        anchor.getStyle().set("color", "white");
        return anchor;
    }

    public void addToFooter(Component component){
        footer.add(component);
    }

    public void removeFromFooter(Component component){
        footer.remove(component);
    }

    public void hideFooter(boolean hide){
        if(hide){
            footer.setVisible(false);
        }
        else{
            footer.setVisible(true);
        }
    }

    public void add(Component... components){
        super.remove(footer);
        super.add(components);
        super.add(footer);
    }

    public void removeAll(){
        super.removeAll();
        super.add(footer);
    }
}

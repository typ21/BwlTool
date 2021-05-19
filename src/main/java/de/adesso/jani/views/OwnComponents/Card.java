package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
@CssImport("./components/card.css")
public class Card extends VerticalLayout {

    private H2 title = new H2("-");
    private H3 mobileTitle = new H3("-");
    private Span description = new Span("-");
    private Class navigationTarget;
    private boolean mobileVersion = false;

    public static Card createCard(){
        return new Card();
    }

    public Card(){
        settings();
        listener();
        build();
    }

    private void build() {
        removeAll();
        if(mobileVersion)
            add(mobileTitle);
        else
            add(title);
        add(description);
    }

    private void listener() {
        this.addClickListener(e -> {
            e.getSource().getUI().ifPresent(ui -> {
                if(navigationTarget!=null)
                    ui.navigate(navigationTarget);
            });
        });
    }

    private void settings() {
        this.addClassName("card");
        this.addClassName("space");
        this.setSpacing(true);
        description.addClassName("description");
    }

    public Card setNavigationTarget(Class nav){
        this.navigationTarget = nav;
        return this;
    }

    public Card setTitle(String title){
        this.title.setText(title);
        this.mobileTitle.setText(title);
        return this;
    }

    public Card setDescription(String des){
        this.description.setText(des);
        return this;
    }


    public boolean isMobileVersion() {
        return mobileVersion;
    }

    public void setMobileVersion(boolean mobileVersion) {
        this.mobileVersion = mobileVersion;
        build();
    }


}

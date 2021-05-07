package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
@CssImport("./views/home/home-view.css")
public class Card extends VerticalLayout {

    private H2 title = new H2();
    private Span description = new Span();
    private Class navigationTarget;

    public static Card createCard(){
        return new Card();
    }

    public Card(){
        settings();
        listener();
        build();
    }

    private void build() {
        add(title, description);
    }

    private void listener() {
        this.addClickListener(e -> {
           e.getSource().getUI().ifPresent(ui -> {
               ui.navigate(navigationTarget);
           });
        });
    }

    private void settings() {
        title.addClassName("title");
        this.addClassName("shadow");
        this.addClassName("space");
        this.setSpacing(true);
    }

    public Card setNavigationTarget(Class nav){
        this.navigationTarget = nav;
        return this;
    }

    public Card setTitle(String title){
        this.title.setText(title);
        return this;
    }

    public Card setDescription(String des){
        this.description.setText(des);
        return this;
    }



}

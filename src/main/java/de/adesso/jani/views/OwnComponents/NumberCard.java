package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

@CssImport("./components/card.css")
public class NumberCard extends Card {

    public final int NORMAL = 1;
    public final int WARNING = 2;
    public final int GOOD = 3;

    public int type;

    Span title = new Span("-");
    H2 number = new H2("-");
    Span description = new Span("-");

    Class navigationTarget;


    public NumberCard(){
        settings();
        listener();
        build();
    }

    private void build() {
        add(title, number, description);
    }

    private void settings() {
        if(type == GOOD) {
            title.setClassName("good");
            number.setClassName("good");
        }
        else if(type == WARNING) {
            title.setClassName("warning");
            number.setClassName("warning");
        }
        else {
            title.setClassName("normal");
            number.setClassName("normal");
        }
        title.addClassName("title");
        description.setClassName("ncdescription");
        this.addClassName("space");
        number.addClassName("number");
    }

    private void listener() {
        this.addClickListener(e -> {
            e.getSource().getUI().ifPresent(ui -> {
                if(navigationTarget!=null)
                    ui.navigate(navigationTarget);
            });
        });
    }

    public NumberCard setNumber(int number){
        this.number.setText(String.valueOf(number));
        return this;
    }

    public NumberCard setTitle(String title){
        this.title.setText(title);
        return this;
    }

    public NumberCard setDescription(String des){
        this.description.setText(des);
        return this;
    }

    public NumberCard setType(int type){
        assert(type > 0 && type < 4);
        this.type = type;
        settings();
        return this;
    }

    public NumberCard setNavigationTarget(Class nav){
        this.navigationTarget = nav;
        return this;
    }

}

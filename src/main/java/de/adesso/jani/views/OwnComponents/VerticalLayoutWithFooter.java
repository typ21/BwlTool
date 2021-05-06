package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class MyVerticalLayout extends VerticalLayout {

    private HorizontalLayout footer = new HorizontalLayout();

    public MyVerticalLayout(){
        super();
        fillStandartFooter();
        super.add(footer);
    }

    private void fillStandartFooter() {
        footer.getStyle().set("backgroud-color", "grey");
        footer.setWidthFull();
        footer.setHeight("200px");

        Div div = new Div();
        div.add(new Button("test"));

        footer.add(div);
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

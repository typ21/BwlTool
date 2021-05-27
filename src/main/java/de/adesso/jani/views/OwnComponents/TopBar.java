package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.util.Dictionary;
@CssImport("./components/topBar.css")
public class TopBar extends VerticalLayout {

    VerticalLayout openClose = new VerticalLayout();
    boolean openByDefault = false;
    boolean open;
    HorizontalLayout content = new HorizontalLayout();

    Icon down = new Icon(VaadinIcon.ANGLE_DOWN);
    Icon up = new Icon(VaadinIcon.ANGLE_UP);

    public TopBar(){
        settings();
        listener();
        build();
    }

    private void build() {
        this.addToMe(content, openClose);
    }

    private void listener() {
        openClose.addClickListener(e ->  {
            if(open)
                close();
            else
                open();
        });
    }

    private void close() {
        open = false;
        content.setVisible(false);
        up.setVisible(false);
        down.setVisible(true);
    }

    private void settings() {
        openClose.add(up, down);
        openClose.setWidth("100%");
        openClose.setHeight("20px");
        openClose.addClassName("openClose");
        openClose.setMargin(false);
        openClose.setSpacing(false);
        openClose.setPadding(false);
        openClose.setAlignItems(Alignment.CENTER);

        content.setJustifyContentMode(JustifyContentMode.CENTER);
        content.setWidthFull();

        this.setMargin(false);
        this.setPadding(false);
        this.setSpacing(false);
        if(!openByDefault)
            close();
        else
            open();
    }

    private void open(){
        open = true;
        content.setVisible(true);
        up.setVisible(true);
        down.setVisible(false);
    }

    public boolean isOpenByDefault() {
        return openByDefault;
    }

    public void setOpenByDefault(boolean openByDefault) {
        this.openByDefault = openByDefault;
    }

    public void add(Component... components){
        content.add(components);
    }

    public void remove(Component... components){
        content.remove(components);
    }
    public void removeAll(){
        content.removeAll();
    }
    private void addToMe(Component... components){
        super.add(components);
    }
}

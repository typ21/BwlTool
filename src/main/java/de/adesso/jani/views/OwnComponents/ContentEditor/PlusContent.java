package de.adesso.jani.views.OwnComponents.ContentEditor;

import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class PlusContent extends VerticalLayout {

    private boolean hasBorder = true;
    private String borderColor = "#9e9e9e";

    private ContextMenu contextMenu = new ContextMenu();

    private ContentEditor father;

    public PlusContent(ContentEditor father){
        this.father = father;

        settings();
        build();
    }

    private void settings() {
        this.setWidthFull();
        this.setAlignItems(Alignment.CENTER);

        if(hasBorder)
            getStyle().set("border", "1px solid " + borderColor);

        contextMenu.setTarget(this);
        contextMenu.setOpenOnClick(true);
    }

    private void build(){
        contextMenu.addItem("Text hinzufügen", e -> {
            father.addText();
        });
        if(father.isUserCannAddPicture()) {
            contextMenu.addItem("Bild hinzufügen", e -> {
                father.addImage();
            });
        }

        add(new Icon(VaadinIcon.PLUS));
    }
    public boolean isHasBorder() {
        return hasBorder;
    }

    public void setHasBorder(boolean hasBorder) {
        this.hasBorder = hasBorder;
        settings();
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
        settings();
    }

    public ContextMenu getContextMenu() {
        return contextMenu;
    }

    public ContentEditor getFather() {
        return father;
    }

    public void setFather(ContentEditor father) {
        this.father = father;
    }
}

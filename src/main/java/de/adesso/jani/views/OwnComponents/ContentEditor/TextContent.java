package de.adesso.jani.views.OwnComponents.ContentEditor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class TextContent extends HorizontalLayout {

    private String borderColor = "#9e9e9e";
    private boolean hasBorder = true;
    private boolean editable = true;

    private VerticalLayout upDownArea = new VerticalLayout();
    private VerticalLayout buttonArea = new VerticalLayout();
    private TextArea textArea;

    private Button up = new Button();
    private Button down = new Button();
    private Button done = new Button();
    private Button edit = new Button();
    private Button del = new Button();

    private ContentEditor father;

    public TextContent(String text, ContentEditor father){
        textArea = new TextArea();
        textArea.setValue(text);

        this.father = father;

        settings();
        build();
    }

    private void build() {
        //Listener
        up.addClickListener(e ->{
            father.goUp(this);
        });
        down.addClickListener(e ->{
            father.goDown(this);
        });
        edit.addClickListener(e ->{
            this.editable = true;
            settings();
        });
        done.addClickListener(e -> {
            this.editable = false;
            settings();
        });
        del.addClickListener(e -> {
            father.delete(this);
        });
        //Add and remove
        upDownArea.add(up, down);
        buttonArea.add(edit, done, del);
        add(upDownArea, textArea, buttonArea);
    }

    public void settings(){
        //this
        this.setWidthFull();
        if(hasBorder)
            this.getStyle().set("border", "1px solid " + borderColor);
        this.setAlignItems(Alignment.CENTER);
        this.setMaxHeight("1000px");

        //textArea
        textArea.setReadOnly(false);
        textArea.setWidthFull();
        textArea.setHeight("170px");

        //Buttons
        up.setIcon(new Icon(VaadinIcon.ANGLE_UP));
        down.setIcon(new Icon(VaadinIcon.ANGLE_DOWN));

        edit.setIcon(new Icon(VaadinIcon.PENCIL));
        edit.setVisible(!editable);
        done.setIcon(new Icon(VaadinIcon.CHECK));
        done.setVisible(editable);
        del.setIcon(new Icon(VaadinIcon.BAN));

        if(editable){
            edit.setVisible(false);
            textArea.setReadOnly(false);
            done.setVisible(true);
        }
        else{
            done.setVisible(false);
            textArea.setReadOnly(true);
            edit.setVisible(true);
        }

        //Button Areas
        upDownArea.setWidth(up.getWidth());
        buttonArea.setWidth(done.getWidth());
    }

    public String getValue(){
        return textArea.getValue();
    }

    public void setEditable(boolean editable){
        this.editable = editable;
        settings();
    }
    public boolean getEditable(){
        return editable;
    }

    public void setValue(String value){
        textArea.setValue(value);
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void focus(){
        textArea.focus();
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
        if(hasBorder)
            this.getStyle().set("border", "1px solid " + borderColor);
    }

    public boolean isHasBorder() {
        return hasBorder;
    }

    public void setHasBorder(boolean hasBorder) {
        this.hasBorder = hasBorder;
        if(hasBorder)
            this.getStyle().set("border", "1px solid " + borderColor);
    }

    public TextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(TextArea textArea) {
        this.textArea = textArea;
    }

    public ContentEditor getFather() {
        return father;
    }

    public void setFather(ContentEditor father) {
        this.father = father;
    }
}

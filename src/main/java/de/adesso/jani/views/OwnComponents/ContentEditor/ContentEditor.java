package de.adesso.jani.views.OwnComponents.ContentEditor;

import com.vaadin.flow.component.dependency.CssImport;
import de.adesso.jani.views.OwnComponents.ContentEditor.MemoryImage;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;

import java.util.ArrayList;
import java.util.Collections;
@CssImport("./components/contenteditor.css")
public class ContentEditor extends VerticalLayout {

    private boolean hasHeader = true;
    private boolean hasOuterBorder = true;
    private boolean hasInnerBorder = true;
    private boolean userCanAdd = true;
    private boolean userCannAddPicture = true;

    private String borderColor = "#9e9e9e";
    private String widthAsString = "70%";

    private PlusContent plus = new PlusContent(this);
    private TextField header = new TextField();

    private ArrayList<Component> components = new ArrayList<>();

    public ContentEditor(){
        settings();
        build();
    }

    private void settings(){
        //this
        this.setWidth(widthAsString);
        if(this.hasOuterBorder)
            this.getStyle().set("border", "2px solid " + borderColor);

        this.setAlignItems(Alignment.CENTER);
        this.addClassName("shadow");

        //header
        header.setWidth("75%");
        header.setLabel("Überschrift ändern");

        //plus
        plus.setHasBorder(hasInnerBorder);
        plus.setBorderColor(borderColor);

        //settings auf components übertragen
        for(Component c : components){
            if(c instanceof TextContent){
                ((TextContent) c).setHasBorder(hasInnerBorder);
                ((TextContent) c).setBorderColor(borderColor);
            }
            if(c instanceof ImageContent){
                ((ImageContent) c).setHasBorder(hasInnerBorder);
                ((ImageContent) c).setBorderColor(borderColor);
            }
        }
    }

    private void build(){
        //Alles von vorher löschen
        removeAll();

        //adds
        if(hasHeader)
            add(header);

        for(Component c : components){
            if(c instanceof TextContent){
                add(c);
            }
            if(c instanceof ImageContent)
                add(c);
        }

        if(userCanAdd)
            add(plus);
    }

    public void goUp(Component component){
        if(components.indexOf(component) > 0 ){
            Collections.swap(components, components.indexOf(component), components.indexOf(component) - 1);
        }
        build();
    }
    public void goDown(Component component){
        if(components.indexOf(component) < components.size() - 1 ){
            Collections.swap(components, components.indexOf(component), components.indexOf(component) + 1);
        }
        build();
    }

    public void addText(String text){
        TextContent textContent = new TextContent(text, this);
        textContent.setBorderColor(borderColor);
        textContent.setHasBorder(hasInnerBorder);
        if(text.equals(""))
            textContent.setEditable(true);
        else {
            textContent.setEditable(false);
            textContent.focus();
        }
        components.add(textContent);
        build();
    }

    public void addText(){
        this.addText("");
    }

    public void addImage(MemoryImage memoryImage){
        ImageContent imageContent = new ImageContent(memoryImage, this);
        imageContent.setBorderColor(borderColor);
        imageContent.setHasBorder(hasInnerBorder);
        components.add(imageContent);
        build();
    }

    public void delete(Component c){
        components.remove(c);
        build();
    }

    public ArrayList<Object> getValue(){
        ArrayList<Object> objects = new ArrayList<>();
        for(Component c : components){
            if(c instanceof TextContent)
                objects.add(((TextContent) c).getValue());
            if(c instanceof ImageContent)
                objects.add(((ImageContent) c).getValue());
        }
        return objects;
    }

    public void addImage(){
        this.addImage(new MemoryImage());
    }

    public String getHeader(){
        return header.getValue();
    }

    public void setHeader(String text){
        header.setValue(text);
    }

    public boolean isHasHeader() {
        return hasHeader;
    }

    public void setHasHeader(boolean hasHeader) {
        this.hasHeader = hasHeader;
        build();
    }

    public boolean isHasOuterBorder() {
        return hasOuterBorder;
    }

    public void setHasOuterBorder(boolean hasOuterBorder) {
        this.hasOuterBorder = hasOuterBorder;
        settings();
    }

    public boolean isHasInnerBorder() {
        return hasInnerBorder;
    }

    public void setHasInnerBorder(boolean hasInnerBorder) {
        this.hasInnerBorder = hasInnerBorder;
        settings();
    }

    public boolean isUserCanAdd() {
        return userCanAdd;
    }

    public void setUserCanAdd(boolean userCanAdd) {
        this.userCanAdd = userCanAdd;
        build();
    }

    public String getBorderColor() {
        return borderColor;
    }

    public void setBorderColor(String borderColor) {
        this.borderColor = borderColor;
        settings();
    }

    public String getWidthAsString() {
        return widthAsString;
    }

    public void setWidthAsString(String widthAsString) {
        this.widthAsString = widthAsString;
        settings();
    }

    public boolean isUserCannAddPicture() {
        return userCannAddPicture;
    }

    public void setUserCannAddPicture(boolean userCannAddPicture) {
        this.userCannAddPicture = userCannAddPicture;
        build();
    }
}

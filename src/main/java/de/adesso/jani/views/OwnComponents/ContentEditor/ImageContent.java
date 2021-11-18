package de.adesso.jani.views.OwnComponents.ContentEditor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.upload.Upload;
import com.vaadin.flow.component.upload.receivers.MemoryBuffer;

import java.io.IOException;

public class ImageContent extends HorizontalLayout {

    private String borderColor = "#9e9e9e";
    private boolean hasBorder = true;

    private boolean filled = false;

    private VerticalLayout upDownArea = new VerticalLayout();
    private VerticalLayout buttonArea = new VerticalLayout();

    private MemoryBuffer buffer = new MemoryBuffer();
    private Upload upload = new Upload(buffer);
    private MemoryImage memoryImage = new MemoryImage();

    private Button up = new Button();
    private Button down = new Button();
    private Button del = new Button();

    private ContentEditor father;

    public ImageContent(ContentEditor father){
        this(new MemoryImage(), father);
    }

    public ImageContent(MemoryImage image, ContentEditor father){
        if(image.getImageBytes() != null) {
            filled = true;
            memoryImage = image;
        }

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
        del.addClickListener(e -> {
            father.delete(this);
        });
        upload.addSucceededListener(e -> {
            try {
                memoryImage.insertImage(buffer.getInputStream(), "Bild");
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            filled = true;
            remove(del, upload);
            add(memoryImage, del);
        });
        //Add and remove

        upDownArea.add(up, down);
        add(upDownArea);
        if(filled)
            add(memoryImage, del);
        else
            add(upload, del);
    }

    public void settings(){
        //this
        this.setWidthFull();
        if(hasBorder)
            this.getStyle().set("border", "1px solid " + borderColor);
        this.setAlignItems(Alignment.CENTER);
        this.setMaxHeight("1000px");

        //Buttons
        up.setIcon(new Icon(VaadinIcon.ANGLE_UP));
        down.setIcon(new Icon(VaadinIcon.ANGLE_DOWN));

        del.setIcon(new Icon(VaadinIcon.BAN));

        //Button Areas
        upDownArea.setWidth(up.getWidth());
        buttonArea.setWidth(del.getWidth());

        //upload
        upload.setWidthFull();
        upload.setAcceptedFileTypes("image/jpeg", "image/png", "image/gif", "image/jpg", "image/bmp");

        //MemoryImage
        memoryImage.setMaxHeight("550px");
        memoryImage.setMaxWidth("800px");
    }

    public String getBorderColor() {
        return borderColor;
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

    public MemoryImage getMemoryImage() {
        return memoryImage;
    }

    public void setMemoryImage(MemoryImage memoryImage){
        this.memoryImage = memoryImage;
    }

    public MemoryImage getValue(){
        return memoryImage;
    }

    public void setValue(MemoryImage memoryImage){
        this.memoryImage = memoryImage;
    }

    public boolean isFilled() {
        return filled;
    }

    public void setFilled(boolean filled) {
        this.filled = filled;
    }
}

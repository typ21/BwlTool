package de.adesso.jani.views.OwnComponents.ContentEditor;

import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.server.StreamResource;
import org.apache.commons.io.IOUtils;
import org.apache.commons.io.output.ByteArrayOutputStream;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MemoryImage extends Image {

    private BufferedImage imageData;
    private byte[] imageBytes;

    public MemoryImage() {
        imageData = null;
        imageBytes = null;
    }

    public MemoryImage(InputStream imageStream, String alt) throws IOException {

        imageBytes = IOUtils.toByteArray(imageStream);

        this.imageData = ImageIO.read(new ByteArrayInputStream(imageBytes));

        StreamResource resources = new StreamResource(alt, () -> new ByteArrayInputStream(imageBytes));

        this.setAlt(alt);
        this.setSrc(resources);
    }

    public BufferedImage getImageData() {
        return imageData;
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void insertImage(InputStream in, String alt) throws IOException {

        if(checkNull(in)) return;

        imageBytes = IOUtils.toByteArray(in);

        this.imageData = ImageIO.read(new ByteArrayInputStream(imageBytes));

        StreamResource resources = new StreamResource(alt, () -> new ByteArrayInputStream(imageBytes));

        this.setAlt(alt);
        this.setSrc(resources);
    }

    public static MemoryImage construct(BufferedImage imageData, String alt) throws IOException {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ImageIO.write(imageData, "jpg", bos);
        byte[] imgData = bos.toByteArray();

        return new MemoryImage(new ByteArrayInputStream(imgData), alt);
    }

    public boolean isEmpty() {
        return this.getSrc() == null;
    }

    private boolean checkNull(Object o){
        return o == null;
    }
}

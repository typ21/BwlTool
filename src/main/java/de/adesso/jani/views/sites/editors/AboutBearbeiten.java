package de.adesso.jani.views.sites.editors;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import de.adesso.jani.views.OwnComponents.ContentEditor.ContentEditor;
import de.adesso.jani.views.OwnComponents.VerticalLayoutWithFooter;
import de.adesso.jani.views.main.MainView;

@Route(value="editabout", layout= MainView.class)
@PageTitle("About bearbeiten")
public class AboutBearbeiten extends VerticalLayoutWithFooter {

    private ContentEditor contentEditor = new ContentEditor();
    private Button speichern = new Button();

    public AboutBearbeiten(){

        settings();
        build();

    }

    private void build() {
        add(contentEditor);
    }

    private void settings() {
        contentEditor.setUserCannAddPicture(false);
        contentEditor.setHeader("About Seite bearbeiten");
        speichern.
    }
}

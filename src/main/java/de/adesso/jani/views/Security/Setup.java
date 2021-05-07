package de.adesso.jani.views.Security;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;

@Route("setup")
public class Setup implements BeforeEnterObserver {

    H1 header = new H1("Einrichtung des BWL Tools");
    Span description = new Span("Bitte wählen sie Daten für das Admin Panel aus");

    TextField name = new TextField();
    PasswordField password = new PasswordField();

    Button setup = new Button();

    public Setup(){
        settings();
        listener();
    }

    private void listener() {
        setup.addClickListener(e -> {
            //TODO
            //write to database and jan stuff
        });
    }

    private void settings() {
        name.setLabel("Admin-username");
        password.setLabel("Admin-password");

        setup.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        setup.setText("Einrichtung abschließen");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        //TODO
        //If alredy setup -> reroute to home
    }
}

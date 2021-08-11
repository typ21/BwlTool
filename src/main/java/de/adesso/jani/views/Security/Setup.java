package de.adesso.jani.views.Security;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.Route;
import de.adesso.jani.Security.AdminUserService;
import de.adesso.jani.views.sites.HomeView;
import org.springframework.beans.factory.annotation.Autowired;

@Route("setup")
@CssImport("./views/sites/setup.css")
public class Setup extends VerticalLayout implements BeforeEnterObserver {

    @Autowired
    public AdminUserService aus;

    H1 header = new H1("Einrichtung des BWL Tools");

    VerticalLayout panel = new VerticalLayout();

    Span description = new Span("Bitte wählen sie Daten für das Admin Panel aus");
    TextField name = new TextField();
    PasswordField password = new PasswordField();

    Button setup = new Button();

    public Setup(){
        settings();
        listener();
        build();
    }

    private void build() {
        panel.add(description, name, password, setup);
        add(header, panel);
    }

    private void listener() {
        setup.addClickListener(e -> {
            aus.addAdminUser(name.getValue(), password.getValue());
        });
    }

    private void settings() {
        this.setAlignItems(Alignment.CENTER);
        this.addClassName("bg-lg");
        this.setHeightFull();

        panel.setWidth("50%");
        panel.addClassName("shadow");
        panel.setAlignItems(Alignment.CENTER);

        name.setLabel("Admin-username");
        password.setLabel("Admin-password");
        password.setClassName("red-tm");

        setup.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
        setup.setText("Einrichtung abschließen");
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        if(aus.noAdminuserYet()) {
            beforeEnterEvent.rerouteTo(HomeView.class);
        }
    }
}

package de.adesso.jani.Security;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import de.adesso.jani.SimpleDatabase.AdminStorage;
import de.adesso.jani.views.Security.LoginView;
import de.adesso.jani.views.Security.Setup;
import de.adesso.jani.views.main.MainView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiEvent -> {
            final UI ui = uiEvent.getUI();
            ui.addBeforeEnterListener(this::checkSetup);
            ui.addBeforeEnterListener(this::authenticateNavigation);
        });
    }

    private void checkSetup(BeforeEnterEvent event) {
        if(AdminStorage.isEmpty()){
            event.rerouteTo(Setup.class);
        }
    }

    private void authenticateNavigation(BeforeEnterEvent event) {
        if (!SecurityUtils.isAccessGranted(event.getNavigationTarget())) {
            if (SecurityUtils.isUserLoggedIn()) {
                event.rerouteToError(NotFoundException.class);
            } else {
                event.rerouteTo(LoginView.class);
            }
        }

    }
}
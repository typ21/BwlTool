package de.adesso.jani.Security;


import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import de.adesso.jani.views.Security.LoginView;
import de.adesso.jani.views.Security.Setup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

    @Autowired
    public AdminUserService aus;

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiEvent -> {
            final UI ui = uiEvent.getUI();
            ui.addBeforeEnterListener(this::checkSetup);
            ui.addBeforeEnterListener(this::authenticateNavigation);
        });
    }

    private void checkSetup(BeforeEnterEvent event) {
        if(aus.noAdminuserYet()){
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
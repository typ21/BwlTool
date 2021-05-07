package de.adesso.jani.Security;
<<<<<<< HEAD


=======
>>>>>>> 81bacad66a633df864354d810258cc248095cb61
import com.vaadin.flow.component.UI;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.NotFoundException;
import com.vaadin.flow.server.ServiceInitEvent;
import com.vaadin.flow.server.VaadinServiceInitListener;
import de.adesso.jani.views.Security.LoginView;
import de.adesso.jani.views.main.MainView;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ConfigureUIServiceInitListener implements VaadinServiceInitListener {

    private ArrayList<Class> excludedClasses = new ArrayList<>();

    private void setExcludedClasses(){
        addNoSec(MainView.class);
    }

    private void addNoSec(Class classname){
        excludedClasses.add(classname);
    }

    @Override
    public void serviceInit(ServiceInitEvent event) {
        event.getSource().addUIInitListener(uiEvent -> {
            final UI ui = uiEvent.getUI();
            ui.addBeforeEnterListener(this::authenticateNavigation);
        });
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
<<<<<<< HEAD
}
=======
}

>>>>>>> 81bacad66a633df864354d810258cc248095cb61

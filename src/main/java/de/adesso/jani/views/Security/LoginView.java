package de.adesso.jani.views.Security;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.login.LoginForm;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.BeforeEnterEvent;
import com.vaadin.flow.router.BeforeEnterObserver;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.VaadinServlet;
import de.adesso.jani.Security.CustomRequestCache;
import de.adesso.jani.views.OwnComponents.TestButton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.jaas.SecurityContextLoginModule;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.session.SessionRegistry;
import org.springframework.security.core.userdetails.User;

import java.nio.file.attribute.UserPrincipal;
import java.util.Collection;
import java.util.Collections;

@Route("login")
@PageTitle("Login | Admin Panel")
public class LoginView extends VerticalLayout implements BeforeEnterObserver {

    private final LoginForm login;

    @Autowired
    public LoginView(AuthenticationManager authenticationManager, CustomRequestCache requestCache){

        login = new LoginForm();
        login.setForgotPasswordButtonVisible(false);
        add(TestButton.threadTest());

        addClassName("login-view");
        setSizeFull();
        setAlignItems(Alignment.CENTER);
        setJustifyContentMode(JustifyContentMode.CENTER);

        login.addLoginListener(e -> {

            try {

                final Authentication authentication = authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(e.getUsername(), e.getPassword())
                );

                SecurityContextHolder.getContext().setAuthentication(authentication);

                UI.getCurrent().navigate(requestCache.resolveRedirectUrl());

            }catch(AuthenticationException ex){
                ex.printStackTrace();
                login.setError(true);
            }
        });

        add(new H1("BWL-Tool Admin Panel"), login);
    }

    @Override
    public void beforeEnter(BeforeEnterEvent beforeEnterEvent) {
        // inform the user about an authentication error
        if(beforeEnterEvent.getLocation()
                .getQueryParameters()
                .getParameters()
                .containsKey("error")) {
            login.setError(true);
        }
    }
}
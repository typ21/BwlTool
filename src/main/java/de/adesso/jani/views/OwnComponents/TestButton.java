package de.adesso.jani.views.OwnComponents;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

public class TestButton extends Button {

    public TestButton(String s){
        super(s);
    }

    public static TestButton create(){

        TestButton b = new TestButton("TestAuthorities");

        b.addClickListener( e -> {

           Authentication o =  SecurityContextHolder.getContext().getAuthentication();

           StringBuilder message = new StringBuilder();

           if(o == null || o instanceof AnonymousAuthenticationToken){
               message.append("No authorization");
           }else {

               message.append(o.getName()).append("; ");
               message.append(o.getAuthorities().stream().reduce("", (s, grantedAuthority) -> s + "," + grantedAuthority, (s, s2) -> s + "," + s2));
           }
           Notification.show(message.toString());

        });

        return b;
    }

    public static TestButton threadTest(){
        TestButton b = new TestButton("Test Thread");

        b.addClickListener(e->
            Notification.show(Thread.currentThread().getName())
        );

        return b;
    }
}

package de.adesso.jani;

import com.vaadin.flow.server.VaadinServletConfiguration;
import de.adesso.jani.SimpleDatabase.AdminStorage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.vaadin.artur.helpers.LaunchUtil;

/**
 * The entry point of the Spring Boot application.
 */
@SpringBootApplication
@VaadinServletConfiguration(productionMode = true)
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        System.out.println(AdminStorage.addUser("admin", "deinemudda"));
        LaunchUtil.launchBrowserInDevelopmentMode(SpringApplication.run(Application.class, args));
        //SpringApplication.run(Application.class, args);

    }

}

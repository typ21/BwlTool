package de.adesso.jani.Security;

import de.adesso.jani.SimpleDatabase.AdminStorage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class AdminUserService implements UserDetailsService {


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if(AdminStorage.contains(s)) {
            return new AdminUserPrinciple(s, AdminStorage.getPasswordForName(s));
        }
        return null;
    }
}

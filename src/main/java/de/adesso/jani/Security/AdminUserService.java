package de.adesso.jani.Security;

import de.adesso.jani.backend.User;
import de.adesso.jani.backend.UserDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Optional;

@Service
public class AdminUserService implements UserDetailsService {

    @Autowired
    private UserDB uDB;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        User u = uDB.getUserByUserName(s).orElseThrow(() -> {return new UsernameNotFoundException("Username not found!");});

        return new AdminUserPrinciple(u);


    }

    public boolean noAdminuserYet(){
        return uDB.count() == 0;
    }

    public void addAdminUser(String userName, String password) {
        uDB.saveAndFlush(new User(userName, password));
    }
}

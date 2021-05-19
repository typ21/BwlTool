package de.adesso.jani.Security;

import de.adesso.jani.SimpleDatabase.AdminStorage;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AdminUserService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

        if(AdminStorage.contains(s)) {
            System.out.println("Login success!");
            AdminUserPrinciple a = new AdminUserPrinciple(s, AdminStorage.getPasswordForName(s));
            System.out.println(a.getAuthorities().stream().map(GrantedAuthority::getAuthority).reduce("",(s1, r) -> s1+""+r, (s1, s2) -> s1+","+s2));
            return a;
        }

        throw new UsernameNotFoundException("Username not found!");
    }
}

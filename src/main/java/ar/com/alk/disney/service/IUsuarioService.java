package ar.com.alk.disney.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUsuarioService  {


    default UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        return null;
    }
}

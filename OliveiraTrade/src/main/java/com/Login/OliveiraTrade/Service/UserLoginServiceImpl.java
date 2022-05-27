package com.Login.OliveiraTrade.Service;

import com.Login.OliveiraTrade.Model.User;
import com.Login.OliveiraTrade.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service("LoginService")
public class UserLoginServiceImpl implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepository.findByEmail(email);
        Set<GrantedAuthority> listRoles = new HashSet<GrantedAuthority>();

        listRoles.add(new SimpleGrantedAuthority("USER"));

        UserDetails usuario = new org.springframework.security.core.userdetails.
                                        //nao esta autenticado
                User(user.getName(), ("{noop}" + user.getPassword()), listRoles);

        return usuario;
    }
}

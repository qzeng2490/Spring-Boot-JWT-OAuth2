package com.qzeng2018.springreact.security;

import com.qzeng2018.springreact.Entity.Role;
import com.qzeng2018.springreact.Entity.User;
import com.qzeng2018.springreact.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.findByUsername(username);
        if (user == null) {
            throw new UsernameNotFoundException("user not exist");
        }

        System.out.println("User got from DB----------------------" + user.getUsername());


        List<GrantedAuthority> authorities = new ArrayList<>();
        Set<Role> roles = user.getRoles();
        //加入用户角色
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
            System.out.println("ROLE got from DB----------------------" + role.getName());
        }
        org.springframework.security.core.userdetails.User u =
                new org.springframework.security.core.userdetails.User(user.getUsername(),
                        user.getPassword(), authorities);


        return u;
    }
}
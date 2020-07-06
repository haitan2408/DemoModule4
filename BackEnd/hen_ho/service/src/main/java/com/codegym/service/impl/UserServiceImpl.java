package com.codegym.service.impl;

import com.codegym.dao.entity.Role;
import com.codegym.dao.entity.User;
import com.codegym.dao.repository.RoleRepository;
import com.codegym.dao.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder bcryptEncoder;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByDeletedIsFalseAndUserName(username);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        Set<Role> roles = user.getRoles();
        for(Role role: roles){
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        return new org.springframework.security.core.userdetails.User(user.getUserName(), user.getPassword(),
                grantedAuthorities);
    }

    public User saveMember(String username, String password) {
        User newUser = new User();
        User user=userRepository.findByDeletedIsFalseAndUserName(username);
        if(user == null) {
            newUser.setUserName(username);
            newUser.setPassword(bcryptEncoder.encode(password));
            Set<Role> roles=new HashSet<>();
            roles.add(roleRepository.findByRoleName("ROLE_MEMBER"));
            newUser.setRoles(roles);
            newUser.setDeleted(false);
            userRepository.save(newUser);
            return newUser;
        } else {
            return null;
        }
    }
}

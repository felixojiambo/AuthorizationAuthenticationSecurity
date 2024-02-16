//package com.zep.ldls.user.service;
//
//import com.zep.ldls.user.model.User;
//import com.zep.ldls.user.repository.UserRepository;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//import static java.util.Collections.emptyList;
//
//@Service
//public class AppUserDetailsService implements UserDetailsService {
//    private UserRepository userRepository;
//
//    public AppUserDetailsService(UserRepository userRepository) {
//        this.userRepository = userRepository;
//    }
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username);
//
//        if (user == null)
//            throw new UsernameNotFoundException(username);
//
//        return new User(user.getUsername(),
//                user.getPassword(),
//                emptyList());
//    }
//}
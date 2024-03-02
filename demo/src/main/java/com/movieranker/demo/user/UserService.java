package com.movieranker.demo.user;

import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
@AllArgsConstructor
public class UserService implements UserDetailsService {

    private final static String USER_NOT_FOUND_MESSAGE = "User with email %s not found";
    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException {
        return userRepository.findByNickname(nickname).
                orElseThrow(() -> new UsernameNotFoundException(String.format(USER_NOT_FOUND_MESSAGE, nickname)));
    }
}

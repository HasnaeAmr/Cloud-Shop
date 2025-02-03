package com.shs.SHS.Ecommerce.security;

import com.amazonaws.services.kms.model.NotFoundException;
import com.shs.SHS.Ecommerce.entity.User;
import com.shs.SHS.Ecommerce.repository.UserRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private final UserRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = UserRepo.findByEmail(username).orElseThrow(() -> new NotFoundException("User Email not found"));
        return AuthUser.builder().user(user).build();
    }
}

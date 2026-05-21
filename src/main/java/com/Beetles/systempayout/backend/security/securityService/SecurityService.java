package com.Beetles.systempayout.backend.security.securityService;

import com.Beetles.systempayout.backend.admin.repository.AdminRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service

public class SecurityService implements UserDetailsService {

    private final AdminRepository adminRepository;

    public SecurityService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        var admin = adminRepository.findByEmail(email);

        if (admin.isPresent()) {
            return admin.get();
        }
        throw new UsernameNotFoundException("Email ou senha incorreta");
    }
}
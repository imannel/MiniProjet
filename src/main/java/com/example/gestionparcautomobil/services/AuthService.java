package com.example.gestionparcautomobil.services;

import com.example.gestionparcautomobil.Auth.*;
import com.example.gestionparcautomobil.reposirories.AppUserRepository;

import lombok.RequiredArgsConstructor;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthService {
    private final AuthenticationManager authenticationManager;
    private final AppUserRepository userRepository;

    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider  jwtService;

    public AuthResponse login(AuthRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user =userRepository.findByUsername(request.getUsername())
                .orElseThrow();
        var token=jwtService.generateToken(user);
        return AuthResponse.builder()
                .token(token).build();

    }


    public AuthResponse register(RegisterRequest request) {

        var appUser = AppUser.builder()
                .username((request.getUsername()))
                .password(passwordEncoder.encode(request.getPassword()))
                .appRole(AppRole.USER)

                .build();
        userRepository.save(appUser);
        var token=jwtService.generateToken(appUser);
        return AuthResponse.builder()
                .token(token).build();}

}

package Assignment.service.impl;

import Assignment.dto.LoginRequest;
import Assignment.dto.LoginResponse;
import Assignment.dto.RefreshTokenRequest;
import Assignment.filter.JwtFilter;
import Assignment.helper.JwtHelper;
import Assignment.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthenticationManager authenticationManager;
    private final UserDetailsService userDetailsService;
    private final JwtHelper jwtHelper;
    @Override
    public LoginResponse login(LoginRequest loginRequest) {
        Authentication result = null;
        try {
            result = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getPassword())
            );
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(e.getMessage());
        }

        final UserDetails userDetails = userDetailsService.loadUserByUsername(result.getName());

        final String accessToken = jwtHelper.generateToken(userDetails);
        final String refreshToken = jwtHelper.generateRefreshToken(loginRequest.getEmail());
        var loginResponse = new LoginResponse(accessToken, refreshToken);
        return loginResponse;    }

    @Override
    public LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest) {
        return null;
    }
}

package Assignment.service;

import Assignment.dto.LoginRequest;
import Assignment.dto.LoginResponse;
import Assignment.dto.RefreshTokenRequest;

public interface AuthService {

    LoginResponse login(LoginRequest loginRequest);

    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}

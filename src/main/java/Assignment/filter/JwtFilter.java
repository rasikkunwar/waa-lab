package Assignment.filter;

import Assignment.dto.LoginResponse;
import Assignment.helper.JwtHelper;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.jsonwebtoken.ExpiredJwtException;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {
    private final JwtHelper jwtHelper;
    private final UserDetailsService userDetailsService;

    private final ObjectMapper objectMapper;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        final String authorizationHeader = request.getHeader("Authorization");

        String email = null;
        String token = null;
        String refresh_token;
        LoginResponse loginResponse = new LoginResponse();

        if (authorizationHeader != null && authorizationHeader.startsWith("Bearer ")) {
            token = authorizationHeader.substring(7);
            try {
                email = jwtHelper.getUsernameFromToken(token);
            } catch (ExpiredJwtException e) {
                //This is my implementation for the refresh token. I have sent the access token and refresh token from the postman.
                // And, also I have set a script to automatically set access token and refresh token to the request header from the response value.
                //Here, new access token is generated for the user using the refresh token from the header
                // For now, same refresh token is used as it has more expired time and  is not renewed if it is expired.
                String refreshTokenHeader = request.getHeader("isRefreshToken");
                if (refreshTokenHeader != null && refreshTokenHeader.startsWith("Bearer")) {
                    refresh_token = refreshTokenHeader.substring(7);
                    boolean isRefreshTokenValid = jwtHelper.validateToken(refresh_token);
                    if (isRefreshTokenValid) {
                        final String accessToken = jwtHelper.doGenerateToken(jwtHelper.getSubject(refresh_token));
                        loginResponse = new LoginResponse(accessToken, refresh_token);
                        response.setContentType("application/json");
                        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                        response.getWriter().write(objectMapper.writeValueAsString(loginResponse));
                        return;
                    }
                }
            }

        }

        if (email != null && SecurityContextHolder.getContext().getAuthentication() == null) {
            var userDetails = userDetailsService.loadUserByUsername(email);
            boolean isTokenValid = jwtHelper.validateToken(token);
            if (isTokenValid) {
                UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                authentication.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        filterChain.doFilter(request, response);
    }
}

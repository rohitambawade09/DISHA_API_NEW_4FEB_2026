package com.disha.hms.config;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class JwtAuthFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {
    	
    	try {
    		
    		String authHeader = request.getHeader("Authorization");

            if (authHeader != null && authHeader.startsWith("Bearer ")) {
                String token = authHeader.substring(7);

                if (jwtUtil.isTokenValid(token)) {
                    String username = jwtUtil.extractUsername(token);

                    UsernamePasswordAuthenticationToken authentication =
                            new UsernamePasswordAuthenticationToken(username, null, List.of());

                    SecurityContextHolder.getContext().setAuthentication(authentication);
                }
            }

            filterChain.doFilter(request, response);
    		
    	} catch (io.jsonwebtoken.security.SignatureException e) {
            sendJwtError(response, "Invalid JWT signature");
        } catch (io.jsonwebtoken.ExpiredJwtException e) {
            sendJwtError(response, "JWT token expired");
        } catch (io.jsonwebtoken.JwtException e) {
            sendJwtError(response, "Invalid JWT token");
        }
    	
    }
    
    private void sendJwtError(HttpServletResponse response, String message) throws IOException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        response.setContentType("application/json");

        response.getWriter().write("""
        {
            "status": 401,
            "error": "Unauthorized",
            "message": "%s"
        }
        """.formatted(message));
    }
}

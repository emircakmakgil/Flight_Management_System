package com.turkcell.flightmanagementsystem.core.exception.security;


import com.turkcell.flightmanagementsystem.core.exception.jwt.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;
//gelen istekte token varsa springsecuritye token ı bildirecek
//kendi filter chanimi yazıyorum aslında
//her istekte çalışsın istiyorum ondan onceper request kullanıyorum


@Component
public class JwtFilter extends OncePerRequestFilter {
    private final JwtService jwtService;

    public JwtFilter(JwtService jwtService) {this.jwtService = jwtService;}

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain //filter chaini işlemler devam etsin diye ekliyorum
    ) throws ServletException, IOException {

        String jwtHeader=request.getHeader("Authorization");
        if(jwtHeader!=null && jwtHeader.startsWith("Bearer ")) {
            String jwt=jwtHeader.substring(7);

            String username = jwtService.extractUsername(jwt);
            List<String> roles = jwtService.extractRoles(jwt);
            List<GrantedAuthority> authorities =roles.stream().map(role -> (GrantedAuthority) () -> role).toList();

            UsernamePasswordAuthenticationToken authenticationToken =new UsernamePasswordAuthenticationToken(username,
                    null,
                    authorities);
            authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        }

        filterChain.doFilter(request, response); //req ve res üzeirnde şöyle işlemler yaptım sonraki zincire geçebilriz req res in son hal ibu

    }
}

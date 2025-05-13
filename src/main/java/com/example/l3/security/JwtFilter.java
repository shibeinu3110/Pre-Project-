package com.example.l3.security;

import com.example.l3.commons.exception.ErrorMessages;
import com.example.l3.commons.exception.OctException;
import com.example.l3.consts.ConstParameter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static com.example.l3.consts.SecurityConst.*;

@Component
@RequiredArgsConstructor
@Slf4j(topic = "JWT-FILTER")
public class JwtFilter extends OncePerRequestFilter {
    private final JwtProvider jwtProvider;
    private final ApplicationContext context;
    private final RedisTemplate<String, Object> redisTemplate;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String requestUri = request.getRequestURI();
        if ("/public/login".equals(requestUri) || "/public/register".equals(requestUri)) {
            filterChain.doFilter(request, response); // Allow the request to proceed
            return; // Exit the filter
        }
        String headerAuth = request.getHeader(HEADER_AUTH);
        String token = null;
        String username = null;

        if (headerAuth != null && headerAuth.startsWith(BEARER_TOKEN)) {
            token = headerAuth.substring((int) BEARER_LENGTH);
            username = jwtProvider.extractUsername(token);
        }

        if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
//            UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
//            if (jwtProvider.validateToken(token, userDetails)) {
//                UsernamePasswordAuthenticationToken authToken =
//                        new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
//                authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
//                SecurityContextHolder.getContext().setAuthentication(authToken);
//            }
            String storedToken = (String) redisTemplate.opsForValue().get(ConstParameter.ACCESS_TOKEN + username);
            if (StringUtils.hasLength(redisTemplate.opsForValue().get(ConstParameter.BLACK_LIST + username).toString())) {
                long minutes = redisTemplate.getExpire(ConstParameter.BLACK_LIST + username, TimeUnit.MINUTES);
                log.info("Token is blacklisted for {} minutes", minutes);
                throw new OctException(ErrorMessages.NOT_ALLOW, "Token is blacklisted");
            }
            if (storedToken != null && storedToken.equals(token)) {
                UserDetails userDetails = context.getBean(MyUserDetailsService.class).loadUserByUsername(username);
                if (jwtProvider.validateToken(token, userDetails)) {
                    UsernamePasswordAuthenticationToken authToken =
                            new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
                    authToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}

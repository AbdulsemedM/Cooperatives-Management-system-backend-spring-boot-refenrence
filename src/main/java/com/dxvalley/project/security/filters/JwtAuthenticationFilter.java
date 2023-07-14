package com.dxvalley.project.security.filters;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.dxvalley.project.repositories.UserRepository;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.FilterChain;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.json.JsonParserFactory;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;




import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter  {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;

  @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        String username;
        String password;
        try {
            String body = request.getReader().lines().collect(Collectors.joining(System.lineSeparator()));
            var parser = JsonParserFactory.getJsonParser();
            var loginInfo = parser.parseMap(body);
            username = (String)loginInfo.get("username");
            password = (String)loginInfo.get("password");
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(username,password);
            return authenticationManager.authenticate(authenticationToken);
        } catch (JsonParseException jpe) {
            
            throw new RuntimeException("Username and password are required");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Username and password are required");
        }
    }

    @Override
    protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
      User user = (User)authResult.getPrincipal();
      String privateKey = "jbschjbdhjcbdbvdjfvbvbfj";
      Algorithm algorithm = Algorithm.HMAC256(privateKey.getBytes());
      Long unionId;
      Long prCooperativeId;
      try {
        unionId = userRepository.findByUsername(user.getUsername()).getUnion().getUnionId();
      }catch (Exception e){
        unionId = null;
      }
      try {
        prCooperativeId = userRepository.findByUsername(user.getUsername()).getPrCooperative().getPrCooperativeId();
      }catch (Exception e){
        prCooperativeId = null;
      }
        String access_token = JWT.create()
                    .withSubject(user.getUsername())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 30 * 1000))
                    .withIssuer(request.getRequestURL().toString())
                    .withClaim("roles", user.getAuthorities().stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
                    .withClaim("unionId", unionId)
                    .withClaim("prCooperativeId", prCooperativeId)
                    .sign(algorithm);
        String refresh_token = JWT.create()
                .withSubject(user.getUsername())
                .withExpiresAt(new Date(System.currentTimeMillis() + 60 * 24 * 60 * 1000))
                .withIssuer(request.getRequestURL().toString())
                .sign(algorithm);
        Map<String, String> tokens = new HashMap<>();
        tokens.put("access_token", access_token);
        tokens.put("refresh_token", refresh_token);
        response.setContentType(APPLICATION_JSON_VALUE);
        new ObjectMapper().writeValue(response.getOutputStream(), tokens);
    }
}

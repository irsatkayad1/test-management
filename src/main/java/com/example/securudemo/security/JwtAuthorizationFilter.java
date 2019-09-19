package com.example.securudemo.security;

import static com.auth0.jwt.algorithms.Algorithm.HMAC512;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import com.auth0.jwt.JWT;
import com.example.securudemo.model.role.Permission;
import com.example.securudemo.model.role.User;
import com.example.securudemo.repository.role.PermissionRepository;
import com.example.securudemo.repository.role.RoleGroupRepository;
import com.example.securudemo.repository.role.UserRepository;



public class JwtAuthorizationFilter extends BasicAuthenticationFilter {
    
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleGroupRepository roleGroupRepository;
	
	@Autowired
	PermissionRepository permissionRepository;
	
	

	@Autowired
    public JwtAuthorizationFilter(AuthenticationManager authenticationManager,UserRepository userRepository,RoleGroupRepository roleGroupRepository,PermissionRepository permissionRepository) {
        super(authenticationManager);
        this.userRepository=userRepository;
        this.roleGroupRepository=roleGroupRepository;
        this.permissionRepository=permissionRepository;
    }

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        
        String header = request.getHeader(JwtProperties.HEADER_STRING);

        
        if (header == null || !header.startsWith(JwtProperties.TOKEN_PREFIX)) {
            chain.doFilter(request, response);
            return;
        }

        
        Authentication authentication = getUsernamePasswordAuthentication(request);
        SecurityContextHolder.getContext().setAuthentication(authentication);

        
        chain.doFilter(request, response);
    }

    
	private Authentication getUsernamePasswordAuthentication(HttpServletRequest request) {
        String token = request.getHeader(JwtProperties.HEADER_STRING)
                .replace(JwtProperties.TOKEN_PREFIX,"");

        if (token != null) {
            // tokeni parse ediyoruz
            String userName = JWT.require(HMAC512(JwtProperties.SECRET.getBytes()))
                    .build()
                    .verify(token)
                    .getSubject();

            // token içinde subjectteki username i DB de arıyoruz
            // usernamei kullanarak yetkilerini çekiyoruz
            
			if (userName != null){
				try {
					
	                User user = userRepository.findByUserName(userName);
	                //UserPrincipal'permissionların olduğu listeyi gönderiyor
	                List<Permission> permList = new ArrayList<Permission>();
	                roleGroupRepository.findByUserId(user).forEach(z->{
	                	permissionRepository.findByRoleGroup(z).forEach(p->{
	                		permList.add(p);
	                	});
	                });
	                
	                UserPrincipal principal = new UserPrincipal(user,permList);
	                UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(userName, null, principal.getAuthorities());
	                return auth;
				} catch (Exception e) {
					System.out.println("exception jwtauthorizationfilter : "+e);
				} 
				
            }
            return null;
        }
        return null;
    }
}

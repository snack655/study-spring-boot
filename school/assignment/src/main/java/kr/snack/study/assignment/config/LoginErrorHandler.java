package kr.snack.study.assignment.config;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@ControllerAdvice
public class LoginErrorHandler extends SimpleUrlAuthenticationFailureHandler {

    @Override
    public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException, UnsupportedEncodingException {

        String errorMessage;

        if (e instanceof UsernameNotFoundException){
            errorMessage = "IdNotFound";
        } else if (e instanceof BadCredentialsException || e instanceof InternalAuthenticationServiceException){
            errorMessage = "IdOrPasswordWrong";
        } else {
            errorMessage = "InternalServerException";
        }

        errorMessage = URLEncoder.encode(errorMessage,"UTF-8");
        setDefaultFailureUrl("/user/login?error=true&exception=" + errorMessage);
        super.onAuthenticationFailure(httpServletRequest,httpServletResponse,e);
    }
}

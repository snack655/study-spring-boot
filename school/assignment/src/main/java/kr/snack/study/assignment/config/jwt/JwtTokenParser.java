package kr.snack.study.assignment.config.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureException;
import kr.snack.study.assignment.exception.token.TokenExpiredException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

@RequiredArgsConstructor
@Component
public class JwtTokenParser {

    private static final String HEADER = "Authorization";
    private static final String PREFIX = "Bearer ";
    private final UserDetailsService userDetailsService;

    public String resolvedToken(HttpServletRequest request) {
        String bearerToken = request.getHeader(HEADER);

        if (bearerToken != null && bearerToken.startsWith(PREFIX)) {
            return bearerToken.replace(PREFIX, "");
        }

        return null;
    }

    public Authentication authentication(String token) {
        UserDetails userDetails = userDetailsService
                .loadUserByUsername(getTokenBody(token).getSubject());

        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    private Claims getTokenBody(String token) {
        try {
            return Jwts.parser().setSigningKey("board")
                    .parseClaimsJws(token).getBody();
        } catch (SignatureException e) {
            throw TokenExpiredException.EXCEPTION;
        }
    }
}

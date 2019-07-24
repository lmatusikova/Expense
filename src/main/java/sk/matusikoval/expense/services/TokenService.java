package sk.matusikoval.expense.services;

import java.util.Arrays;
import java.util.Date;
import java.util.function.Function;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import sk.matusikoval.expense.entities.User;

@Service
public class TokenService {

	private static final long ACCESS_TOKEN_VALIDITY_SECONDS = 2629800;
	private static final String SIGNING_KEY = "7B$9i-V&MhDTcR8AR99XahI!W*N*$W!fEp^$fc)_EIUHT2@L&J#ubY*!YF6$0YdI";		
		
	public String generateToken(User user) {
		
        Claims claims = Jwts.claims();
        claims.put("scopes", Arrays.asList(new SimpleGrantedAuthority(user.getRole().getAuthority())));
        System.out.println("user rola " + user.getRole().getAuthority());

        return Jwts.builder()
                .setClaims(claims)
                .setIssuer("MojaAppka")
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + ACCESS_TOKEN_VALIDITY_SECONDS*1000))
                .signWith(SignatureAlgorithm.HS256, SIGNING_KEY)
                .compact();
    }
	
	public Boolean validateToken(String token, User user) {
		final String username = getClaimFromToken(token, Claims::getSubject);
        return (username.equals(user.getUsername()) && !isTokenExpired(token));
    }
	
	public Boolean validateToken(String token) {
		return !isTokenExpired(token);
	}
	
	public <T> T getClaimFromToken(String token, Function<Claims, T> claimsResolver) {
	    final Claims claims = Jwts.parser().setSigningKey(SIGNING_KEY).parseClaimsJws(token).getBody();
	    return claimsResolver.apply(claims);
	}
	
	private Boolean isTokenExpired(String token) {
		final Date expiration =  getClaimFromToken(token, Claims::getExpiration);   
		return expiration.before(new Date());
	}

}

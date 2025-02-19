package com.turkcell.flightmanagementsystem.core.exception.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;
import java.util.List;
import java.util.Map;

import static javax.crypto.Cipher.SECRET_KEY;

@Service
public class JwtService {
    //core paketi olduğu iin olabilidiğince spesifik alanları almaya çalışıyoruz ki başka bir yerde de
    //kullanalım mesela User user da diyebilirdik ama bu sefer userın tamaını alıyoruz bizer sadece name bağlı bağımlılık azaltıyoruz

    @Value("720000")
    private Long EXPIRATION_TİME ;
    @Value("${jwt.secret}")
    private String SECRET_KEY;


    public String generateToken(String username){
        return Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis())) //tarih seçiyor
                .subject(username) //username ıd atadığımız alan kimin için oluşturlduğu için
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION_TİME)) //bu jwtnin süresi ne kadar ,zamanı ne zaman geçecek
                .signWith(getSignKey())
                .compact();
    }
    public String generateToken(String username, Map<String, Object> extraClaims){
        return Jwts
                .builder()
                .issuedAt(new Date(System.currentTimeMillis())) //tarih alıyor
                .subject(username) //username ıd atadığımız alan kimin için oluşturlduğu için
                .expiration(new Date(System.currentTimeMillis() +EXPIRATION_TİME))
                .claims(extraClaims)
                .signWith(getSignKey()) //bir security key ile imzalıyoruz
                .compact();//ben işlemleri bitirdim bunları kullanarak jwtyi oluştur bana ver demek

    }
    public Boolean verifyToken(String token){
        Claims claims=Jwts
                .parser() //parçalara bölüyorum
                .verifyWith((SecretKey) getSignKey()) //bu kimliği verify et diyorum
                .build() //artık verify ettik parsı build ediyoruz
                .parseClaimsJws(token) //Payloadın her bir özelliğine claims deniyor
                .getPayload(); //Payloadı atıyoruz

        //eğer ilgili secret key ile doğrulanırsa ilgili jwt iindeki bilgileri verir
        return claims.getExpiration().after(new Date()); //var olduğu andan itibaren exp atıyoz ,programatik kontol zaöanı grçmiş olup olmamasına bakım
    }
    public String extractUsername(String token){
        Claims claims=Jwts
                .parser() //parçalara bölüyorum
                .verifyWith((SecretKey) getSignKey()) //şifreyi kontrol ediyorum
                .build() //artık kontrol ettik parse etmiştim build ediyorum
                .parseClaimsJws(token)
                .getPayload(); //payloadını alıyoruz
      return claims.getSubject();
  }
    public List<String> extractRoles(String token){
        Claims claims=Jwts
                .parser() //parçalara bölüyorum
                .verifyWith((SecretKey) getSignKey()) //bu kimliği verify ediyoruz
                .build() //parse ettik doğruladık birleştiriyoruz
                .parseClaimsJws(token)
                .getPayload(); //payloadı alıyorum
        return claims.get("roles", List.class); //rolleri dönüyorum

  }




    //secret keyi yukarıda tanımladık ama direk onu kullanamıyoruz onu bu şekilde çevirmemizlazım
    //Boilerplate code basma kalıp kod
    private Key getSignKey(){
        byte[] keyBytes = Decoders.BASE64URL.decode(SECRET_KEY);

        return Keys.hmacShaKeyFor(keyBytes);
    }
}

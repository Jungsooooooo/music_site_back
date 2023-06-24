//package com.music.restful.common;
//
//import java.time.Instant;
//import java.time.temporal.ChronoUnit;
//import java.util.Date;
//
//import com.music.restful.user.entity.UserInfo;
//
//import io.jsonwebtoken.Claims;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//
//public class TokenProv {
//	
//	private static final String SECRET_KEY = "NMA8JPctFuna59f5";
//	
//	public String create(UserInfo userEntity) {
//		// 기한은 지금부터 1일로 설정
//		Date expiryDate = Date.from(
//				Instant.now()
//				.plus(1, ChronoUnit.DAYS));
//		/*
//        	 *    ---- 토큰 구조 ---- 
//		 *  { // header
//		 *  	"alg" : "HS512"
//		 *  },
//		 *  { // payload
//		 *  	"sub" : "40288093784915d201784916a40c0001",
//		 *  	"iss" : "demo app",
//		 *  	"iat" : 1595733657,
//		 *  	"exp" : 1596597657
//		 *  }.
//		 *  // SECRET_KEY를 이용해 서명한 부분
//		 *  Nn4d1MOVLZg79sfFACTIpCPKqWmpZMZQ.....
//		 */
//		
//		// JWT Token 생성
//		return Jwts.builder()
//				// header에 들어갈 내용 및 서명을 하기 위한 SECRET_KEY
//				.signWith(SignatureAlgorithm.HS512, SECRET_KEY)
//				// payload에 들어갈 내용
//				.setSubject(userEntity.getId()) // sub
//				.setIssuer("demo app") 			// iss
//				.setIssuedAt(new Date())		// iat
//				.setExpiration(expiryDate)		// exp
//				.compact();
//	}
//	
//	public String validateAndGetUserId(String token) {
//		// parseClaimsJws 메서드가 Base64로 디코딩 및 파싱
//		// 헤더와 페이로드를 setSigningKey로 넘어온 시크릿을 이용해 서명한 후 token의 서명과 비교
//		// 위조되지 않았다면 페이로드(Claims) 리턴, 위조라면 예외를 날림
//		// 그중 우리는 userId가 필요하므로 getBody를 부른다
//		Claims claims = Jwts.parser()
//				.setSigningKey(SECRET_KEY)
//				.parseClaimsJws(token)
//				.getBody();
//		
//		return claims.getSubject(); // subject 즉 사용자 아이디를 리턴한다.
//	}
//
//}

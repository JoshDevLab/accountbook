package com.josh.accountbook.security.core

import io.jsonwebtoken.*
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import java.time.ZonedDateTime
import java.util.*
import javax.crypto.SecretKey
import javax.crypto.spec.SecretKeySpec

@Component
class JwtUtil(
    @Value("\${jwt.secret}") secretKey: String,
    @Value("\${jwt.expiration_time}") private val accessTokenExpTime: Long
) {

    private val key: SecretKey
    private val logger = LoggerFactory.getLogger(javaClass)

    init {
        val keyBytes = Base64.getDecoder().decode(secretKey)
        this.key = SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.jcaName)
    }

    /**
     * Access Token 생성
     * @param member
     * @return Access Token String
     */
    fun createAccessToken(member: CustomUserInfoDto): String {
        return createToken(member, accessTokenExpTime)
    }

    /**
     * JWT 생성
     * @param member
     * @param expireTime
     * @return JWT String
     */
    private fun createToken(member: CustomUserInfoDto, expireTime: Long): String {
        val claims = Jwts.claims()
            .setSubject(member.id.toString())
            .also {
                it["email"] = member.email
                it["role"] = member.role
            }

        val now = ZonedDateTime.now()
        val tokenValidity = now.plusSeconds(expireTime)

        return Jwts.builder()
            .setClaims(claims)
            .setIssuedAt(Date.from(now.toInstant()))
            .setExpiration(Date.from(tokenValidity.toInstant()))
            .signWith(key)
            .compact()
    }

    /**
     * Token에서 User ID 추출
     * @param token
     * @return User ID
     */
    fun getUserId(token: String): Long? {
        return parseClaims(token)?.getSubject()?.toLongOrNull()
    }

    /**
     * JWT 검증
     * @param token
     * @return IsValidate
     */
    fun validateToken(token: String): Boolean {
        return try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(token)
            true
        } catch (e: SecurityException) {
            logger.info("Invalid JWT Token", e)
            false
        } catch (e: MalformedJwtException) {
            logger.info("Invalid JWT Token", e)
            false
        } catch (e: ExpiredJwtException) {
            logger.info("Expired JWT Token", e)
            false
        } catch (e: Exception) {
            logger.info("JWT validation failed", e)
            false
        }
    }

    /**
     * JWT Claims 추출
     * @param accessToken
     * @return JWT Claims
     */
    fun parseClaims(accessToken: String): Claims? {
        return try {
            Jwts.parserBuilder().setSigningKey(key).build().parseClaimsJws(accessToken).body
        } catch (e: ExpiredJwtException) {
            e.claims
        } catch (e: Exception) {
            logger.error("Failed to parse JWT Claims", e)
            null
        }
    }
}
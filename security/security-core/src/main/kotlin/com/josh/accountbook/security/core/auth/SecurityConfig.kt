package com.josh.accountbook.security.core.auth

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.security.config.Customizer
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity
import org.springframework.security.config.annotation.web.configurers.*
import org.springframework.security.config.http.SessionCreationPolicy
import org.springframework.security.web.SecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter


@Configuration
@EnableWebSecurity
@EnableMethodSecurity
class SecurityConfig(
    private val customUserDetailService: CustomUserDetailService,
    private val jwtUtil: JwtUtil,
    private val customAccessDeniedHandler: CustomAccessDeniedHandler,
    private val customAuthenticationEntryPoint: CustomAuthenticationEntryPoint
) {

    companion object {
        private val AUTH_WHITELIST: Array<String> = arrayOf(
            "/api/v1/member/**", "/api/v1/auth/**"
        )
    }


    @Bean
    @Throws(Exception::class)
    fun filterChain(http: HttpSecurity): SecurityFilterChain {
        //CSRF, CORS
        http.csrf { csrf: CsrfConfigurer<HttpSecurity> -> csrf.disable() }
        http.cors(Customizer.withDefaults())

        //세션 관리 상태 없음으로 구성, Spring Security가 세션 생성 or 사용 X
        http.sessionManagement { sessionManagement: SessionManagementConfigurer<HttpSecurity?> ->
            sessionManagement.sessionCreationPolicy(
                SessionCreationPolicy.STATELESS
            )
        }

        //FormLogin, BasicHttp 비활성화
        http.formLogin { form: FormLoginConfigurer<HttpSecurity> -> form.disable() }
        http.httpBasic { obj: HttpBasicConfigurer<HttpSecurity> -> obj.disable() }


        //JwtAuthFilter를 UsernamePasswordAuthenticationFilter 앞에 추가
        http.addFilterBefore(
            JwtAuthFilter(customUserDetailService, jwtUtil),
            UsernamePasswordAuthenticationFilter::class.java
        )

        http.exceptionHandling { exceptionHandling: ExceptionHandlingConfigurer<HttpSecurity?> ->
            exceptionHandling
                .authenticationEntryPoint(customAuthenticationEntryPoint)
                .accessDeniedHandler(customAccessDeniedHandler)
        }

        http.authorizeHttpRequests(
            Customizer { authorize: AuthorizeHttpRequestsConfigurer<*>.AuthorizationManagerRequestMatcherRegistry ->
                authorize
                    .requestMatchers(*AUTH_WHITELIST).permitAll() // @PreAuthorization을 사용할 것이기 때문에 모든 경로에 대한 인증처리는 Pass
                    .anyRequest().permitAll()
            }
        )

        return http.build()
    }
}
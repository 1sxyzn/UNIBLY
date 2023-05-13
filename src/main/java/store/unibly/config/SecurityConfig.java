package store.unibly.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity // 모든 요청이 스프링 시큐리티 제어를 받도록
public class SecurityConfig {
    @Bean
    SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http.authorizeHttpRequests().requestMatchers(
                new AntPathRequestMatcher("/**")).permitAll() // back-office 권한 부여 추후 추가하기
            .and()
                .csrf().ignoringRequestMatchers(
                        new AntPathRequestMatcher("/h2/**")). // h2 콘솔만 CSRF 검증을 안하고 예외 처리 (h2 콘솔은 CSRF 토큰을 발행하는 기능이 없으므로)
            and()
                .headers()
                .addHeaderWriter(new XFrameOptionsHeaderWriter(
                        XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)); // h2 콘솔 frame 띄우기 위함
        return http.build();
    }
}

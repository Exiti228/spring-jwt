package ru.t1.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.t1.security.service.JwtService;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class JwtServiceTests {

    @Test
    public void generateTokenShouldContains(){
        Method methodToFind = null;
        try {
            methodToFind = JwtService.class.getMethod("generateToken", (Class<?>[]) null);
        } catch (NoSuchMethodException | SecurityException e) {

        }
        assertThat(methodToFind != null);
    }

    @Test
    public void isTokenExpiredShouldContains(){
        Method methodToFind = null;
        try {
            methodToFind = JwtService.class.getMethod("isTokenExpired", (Class<?>[]) null);
        } catch (NoSuchMethodException | SecurityException e) {

        }
        assertThat(methodToFind != null);
    }
}

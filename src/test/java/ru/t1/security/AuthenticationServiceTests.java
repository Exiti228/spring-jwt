package ru.t1.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import ru.t1.security.service.AuthenticationService;
import java.lang.reflect.Method;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class AuthenticationServiceTests {

    @Test
    public void signUpShouldContains(){
        Method methodToFind = null;
        try {
            methodToFind = AuthenticationService.class.getMethod("signUp", (Class<?>[]) null);
        } catch (NoSuchMethodException | SecurityException e) {

        }
        assertThat(methodToFind != null);
    }

    @Test
    public void signInShouldContains(){
        Method methodToFind = null;
        try {
            methodToFind = AuthenticationService.class.getMethod("signIn", (Class<?>[]) null);
        } catch (NoSuchMethodException | SecurityException e) {

        }
        assertThat(methodToFind != null);
    }
}
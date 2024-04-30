package ru.t1.security;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import ru.t1.security.service.UserService;

import java.lang.reflect.Method;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(MockitoExtension.class)
public class UserServiceTests {

    @Test
    public void createShouldContains(){
        Method methodToFind = null;
        try {
            methodToFind = UserService.class.getMethod("create", (Class<?>[]) null);
        } catch (NoSuchMethodException | SecurityException e) {

        }
        assertThat(methodToFind != null);
    }

    @Test
    public void saveShouldContains(){
        Method methodToFind = null;
        try {
            methodToFind = UserService.class.getMethod("save", (Class<?>[]) null);
        } catch (NoSuchMethodException | SecurityException e) {

        }
        assertThat(methodToFind != null);
    }
}

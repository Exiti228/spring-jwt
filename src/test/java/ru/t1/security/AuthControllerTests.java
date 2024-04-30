package ru.t1.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import ru.t1.security.controller.AuthController;
import ru.t1.security.domain.dto.JwtAuthenticationResponse;
import ru.t1.security.domain.dto.SignInRequest;
import ru.t1.security.domain.dto.SignUpRequest;
import ru.t1.security.service.AuthenticationService;
import ru.t1.security.service.JwtService;
import ru.t1.security.service.UserService;

import java.util.List;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(AuthController.class)
public class AuthControllerTests {

    @Autowired
    private MockMvc mvc;

    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private AuthenticationService authenticationService;

    @MockBean
    private JwtService jwtService;

    @MockBean
    private UserService userService;

    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    void getSignInRequestShouldReturnNotAuthorized() throws Exception {

        SignInRequest signInRequest = new SignInRequest("user", "password");

        Mockito.when(authenticationService.signIn(Mockito.any())).thenReturn(new JwtAuthenticationResponse("123"));
        var resultActions = mvc.perform(post("/auth/sign-in").
                        content(objectMapper.writeValueAsString(signInRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError()); // нет авторизации
       // resultActions.andDo(MockMvcResultHandlers.print());
    }

    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "USER")
    void getSignUpRequestShouldReturnNotAuthorized() throws Exception {
        SignUpRequest signupRequest = new SignUpRequest("user", "email", "password");

        Mockito.when(authenticationService.signUp(Mockito.any())).thenReturn(new JwtAuthenticationResponse("123"));
        var resultActions = mvc.perform(post("/auth/sign-up").
                        content(objectMapper.writeValueAsString(signupRequest))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().is4xxClientError()); // нет авторизации
        resultActions.andDo(MockMvcResultHandlers.print());
    }



}
package ru.t1.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import ru.t1.security.controller.ExampleController;
import ru.t1.security.service.AuthenticationService;
import ru.t1.security.service.JwtService;
import ru.t1.security.service.UserService;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ExampleController.class)
public class ExampleControllerTests {
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
    void getExampleShouldWork() throws Exception {
        mvc.perform(get("/example"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "ADMIN")
    void getExampleAdminShouldWork() throws Exception {
        mvc.perform(get("/example/admin"))
                .andExpect(status().isOk());
    }

    @Test
    @WithMockUser(username = "user1", password = "pwd", roles = "ADMIN")
    void getExampleAdminRoleShouldWork() throws Exception {
        mvc.perform(get("/example/get-admin"))
                .andExpect(status().isOk());
    }

}

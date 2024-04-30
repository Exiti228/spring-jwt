package ru.t1.security.domain.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Schema(description = "Запрос на аутентификацию")
@AllArgsConstructor
@NoArgsConstructor
public class SignInRequest {

    @Schema(description = "Имя пользователя", example = "aaa")
    @Size(min = 1, max = 50, message = "Имя пользователя должно содержать от 1 до 50 символов")
    @NotBlank(message = "Имя пользователя не может быть пустыми")
    private String username;

    @Schema(description = "Пароль", example = "password1234")
    @Size(min = 1, max = 255, message = "Длина пароля должна быть от 1 до 255 символов")
    @NotBlank(message = "Пароль не может быть пустыми")
    private String password;
}
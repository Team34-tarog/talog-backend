package team34.tarot.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class SignupDto {

    String username;
    String password;
    String nickname;
    int age;
    String gender;
}

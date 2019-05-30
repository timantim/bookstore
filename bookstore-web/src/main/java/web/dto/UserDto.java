package web.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserDto extends BaseDto {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private Boolean isAdmin;
}

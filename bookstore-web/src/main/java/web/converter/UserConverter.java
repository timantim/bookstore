package web.converter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import core.model.User;
import web.dto.UserDto;

@Component
public class UserConverter extends BaseConverter<User, UserDto> {

    private static final Logger log = LoggerFactory.getLogger(
            UserConverter.class);

    @Override
    public User convertDtoToModel(UserDto dto) {
        User user = new User(dto.getUsername(), dto.getPassword(), dto.getFirstName(), dto.getLastName(), dto.getIsAdmin());
        user.setId(dto.getId());
        return user;
    }

    @Override
    public UserDto convertModelToDto(User user) {
        UserDto userDto = new UserDto(user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(), user.getIsAdmin());
        userDto.setId(user.getId());
        return userDto;
    }
}

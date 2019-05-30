package web.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import core.model.User;
import core.service.UserService;
import web.converter.UserConverter;
import web.dto.UserDto;

import java.util.ArrayList;
import java.util.List;


@RestController
public class UserController {

    private static final Logger log = LoggerFactory.getLogger(
            UserController.class);

    @Autowired
    private UserService userService;

    @Autowired
    private UserConverter userConverter;


    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<UserDto> getUsers() {
        log.trace("getUsers");

        List<User> users = userService.findAll();

        log.trace("getUsers: users={}", users);

        return new ArrayList<>(userConverter.convertModelsToDtos(users));
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.PUT)
    public UserDto updateUser(
            @PathVariable final Long userId,
            @RequestBody final UserDto userDto) {
        log.trace("updateUser: userId={}, userDtoMap={}", userId,
                userDto);

        User user = userService.updateUser(userId,
                userDto.getUsername(),
                userDto.getPassword(),
                userDto.getFirstName(),
                userDto.getLastName(),
                userDto.getIsAdmin());

        UserDto result = userConverter.convertModelToDto(user);

        log.trace("updateUser: result={}", result);

        return result;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    UserDto saveUser(@RequestBody UserDto dto) {
        return userConverter.convertModelToDto(
                userService.saveUser(
                        userConverter.convertDtoToModel(dto)
                ));
    }

    @RequestMapping(value = "/users/{userId}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable final Long userId) {
        log.trace("deleteUser: userId={}", userId);

        userService.deleteUser(userId);
    }


}

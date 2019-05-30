package core.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import core.model.User;
import core.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private static final Logger log = LoggerFactory.getLogger(
            UserServiceImpl.class);

    @Autowired
    private UserRepository userRepository;


    @Override
    public List<User> findAll() {
        log.trace("findAll --- method entered");

        List<User> Users = userRepository.findAll();

        log.trace("findAll: Users={}", Users);

        return Users;
    }

    @Override
    @Transactional
    public User updateUser(Long userId, String username, String password, String firstName, String lastName, Boolean isAdmin) {
        log.trace("updateUser: username={}, password={}, firstName={}, lastName={}",
                username, password, firstName, lastName);

        Optional<User> User = userRepository.findById(userId);

        User.ifPresent(s -> {
            s.setUsername(username);
            s.setPassword(password);
            s.setFirstName(firstName);
            s.setLastName(lastName);
            s.setIsAdmin(isAdmin);
        });

        log.trace("updateUser: User={}", User.get());

        return User.orElse(null);
    }

    @Override
    public User saveUser(User User) {
        return userRepository.save(User);
    }

    @Override
    public void deleteUser(Long UserId){
        userRepository.deleteById(UserId);
    }

}

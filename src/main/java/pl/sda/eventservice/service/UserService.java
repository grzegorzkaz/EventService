package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.eventservice.controller.dto.UserDto;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.repository.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void saveUser(UserDto userDto) {

        User user = new User(userDto.getNickname(),
                userDto.getEmail(),
                userDto.getPassword());

        // zapis do bazy danych
        System.out.println(user);
        userRepository.save(user);
    }


    public User loginUser(String login, String password) {
        return userRepository.findFirstByEmailAndPassword(login, password);
    }

}

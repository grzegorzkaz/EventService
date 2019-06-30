package pl.sda.eventservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import pl.sda.eventservice.controller.dto.UserDto;
import pl.sda.eventservice.model.User;
import pl.sda.eventservice.repository.RoleRepository;
import pl.sda.eventservice.repository.UserRepository;

@Service
public class UserService {
    UserRepository userRepository;
    RoleRepository roleRepository;


    @Autowired
    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public void saveUser(UserDto userDto) {
        String encodedPassword = new BCryptPasswordEncoder().encode(userDto.getPassword());
        User user = new User(userDto.getNickname(),
                userDto.getEmail(),
                encodedPassword);
        user.addRole(roleRepository.getOne(1L));

        // zapis do bazy danych
        System.out.println(user);
        userRepository.save(user);
    }


    public User loginUser(String login, String password) {
        return userRepository.findFirstByEmailAndPassword(login, password);
    }

    public void addAdmin(Long id) {
        User user = userRepository.getOne(id);
        user.addRole(roleRepository.getOne(2L));
        userRepository.save(user);
    }

    public void addUser(Long id) {
        User user = userRepository.getOne(id);
        user.addRole(roleRepository.getOne(1L));
        userRepository.save(user);
    }

}

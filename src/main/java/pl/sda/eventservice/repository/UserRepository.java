package pl.sda.eventservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.eventservice.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findFirstByEmailAndPassword(String email, String password);
    User findFirstByEmail(String login);

}

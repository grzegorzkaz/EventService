package pl.sda.eventservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.sda.eventservice.model.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Long> {
}

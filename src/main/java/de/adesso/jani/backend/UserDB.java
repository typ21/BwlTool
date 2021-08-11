package de.adesso.jani.backend;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDB extends JpaRepository<User, Long> {

    Optional<User> getUserByUserName(String userName);

}

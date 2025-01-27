package com.springbootproject.Repository;

import com.springbootproject.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByEmail(String email);  // Check if email exists
    Optional<User> findByEmail(String email); // Find user by email
}

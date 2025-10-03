package com.wheeler.app.repo;

import com.wheeler.app.model.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Integer> {
    Optional<AppUser> findByName(String username);
    @Query("select u from AppUser u where u.Email= :email")
    Optional<AppUser> findByEmail(@Param("email") String email);
}

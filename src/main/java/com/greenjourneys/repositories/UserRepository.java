package com.greenjourneys.repositories;

import com.greenjourneys.entities.User;
import org.hibernate.boot.archive.internal.JarProtocolArchiveDescriptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface UserRepository extends JpaRepository<User,Integer> {
    @Query("SELECT u FROM User u WHERE u.username = :username")
    public User getUserByUsername(@Param("username") String username);

    @Query("SELECT u.username FROM User u WHERE u.username = :username")
    public String uniqueTestUsername(@Param("username") String username);

    @Query("SELECT u.username FROM User u WHERE u.username = :username AND u.id <> :id")
    public String uniqueTestUsernameWithId(@Param("id") int id, @Param("username") String username);

    @Query("SELECT u.email FROM User u WHERE u.email = :email")
    public String uniqueTestEmail(@Param("email") String email);

    @Query("SELECT u.email FROM User u WHERE u.email = :email AND u.id <> :id")
    public String uniqueTestEmailWithId(@Param("id") int id, @Param("email") String email);

    @Query("SELECT u FROM User u WHERE u.token = :token")
    public User getUserByToken(@Param("token") String token);
    User findByEmail(String email);
    User findFirstByResetPasswordToken(String resetPasswordToken);
}

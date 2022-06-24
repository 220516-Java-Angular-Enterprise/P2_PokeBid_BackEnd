package com.revature.pokebid.user;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, String> {

    //Inserts & Updates
    @Modifying
    @Query(value = "INSERT INTO users (id, username, password, address, email, role) VALUES (?1, ?2, crypt(?3, gen_salt('bf')), ?4, ?5, ?6)", nativeQuery = true)
    void saveUser(String id, String username, String password, String address, String email, String role);

    @Modifying
    @Query(value = "UPDATE users SET password = crypt(?1, gen_salt('bf')) WHERE id = ?2", nativeQuery = true)
    void updatePasswordById(String password, String id);

    //Select Queries
    @Modifying
    @Query(value = "UPDATE users SET username = ?1 , password = ?2, address = ?3, role = ?4, email = ?5 WHERE id = ?6", nativeQuery = true)
    void updateUser(String username, String password, String address, String email, String role, String id);

    @Query(value = "SELECT * FROM users WHERE username = ?1 AND password = crypt(?2, password)", nativeQuery = true)
    User getUserByUsernameAndPassword(String username, String password);

    @Query(value = "SELECT * from users where id = ?1", nativeQuery = true)
    User getUserById(String id);

    @Query(value = "SELECT username from users", nativeQuery = true)
    List<String> getAllUsername();

    @Query(value = "SELECT email from users", nativeQuery = true)
    List<String> getAllEmails();

}

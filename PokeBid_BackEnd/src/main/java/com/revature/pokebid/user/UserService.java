package com.revature.pokebid.user;

import com.revature.pokebid.user.dtos.requests.ChangeEmailRequest;
import com.revature.pokebid.user.dtos.requests.ChangePasswordRequest;
import com.revature.pokebid.user.dtos.requests.LoginRequest;
import com.revature.pokebid.user.dtos.requests.NewUserRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserService {
    @Inject
    private final UserRepository userRepo;

    @Inject
    @Autowired
    public UserService(UserRepository userRepo){
        this.userRepo = userRepo;
    };

    public User login(LoginRequest request) {
        //checks submitted credentials against required username and password regex
        if(!isValidUsername(request.getUsername()) || !isValidPassword(request.getPassword())){
            throw new InvalidRequestException("Invalid username or password.");
        }
        //access database to retrieve user information by username and password
        User user = userRepo.getUserByUsernameAndPassword(request.getUsername(), request.getPassword());
        //if there is no credential match, will return null for user's username
        if(user == null){
            System.out.println("I'm here in login request!");
            throw new AuthenticationException("Invalid credentials.");
        }
        return user;
    }

    public List<User> getAllUsers() {
        return (List<User>) userRepo.findAll();

    }


    public void updateById(String id){
        User user = getUserById(id);
        userRepo.updateUser(user.getUsername(), user.getPassword(), user.getAddress(), user.getEmail(), user.getRole(), user.getId());
    }

    public void delete(User user){
        userRepo.delete(user);
    }

    public User register(NewUserRequest request) {
        User user = request.extractUser(); //extracts Username, email, address;

        if (isNotDuplicateUsername(user.getUsername())) {
            if (isValidUsername(user.getUsername())) {
                if (isValidPassword(request.getPassword())) {
                    user.setPassword(request.getPassword()); //Sets password
                    if(isNotDuplicateEmail(user.getEmail())) {
                        if (isValidEmail(user.getEmail())) {
                            user.setId(UUID.randomUUID().toString()); //Sets Id
                            user.setRole("DEFAULT"); //Sets Role Id
                            userRepo.saveUser(user.getId(), user.getUsername(), user.getPassword(), user.getAddress(), user.getRole(), user.getEmail()); // Registers user.

                        } else throw new InvalidRequestException("Invalid email entered.");
                    } else throw new ResourceConflictException("Email is already taken by another user.");
                } else throw new InvalidRequestException("Invalid password. Minimum eight characters, at least one letter, one number and one special character.");
            } else throw new InvalidRequestException("Invalid username. Username needs to be 8-20 characters long.");
        } else throw new ResourceConflictException("Username is already taken.");

        return user;
    }

    public User getUserById(String id) {
        return userRepo.getUserById(id);
    }

    private boolean isValidUsername(String username) {
        if(username == null){
            throw new InvalidRequestException("Empty username entered.");
        }
        return username.matches("^(?=[a-zA-Z0-9._]{8,20}$)(?!.*[_.]{2})[^_.].*[^_.]$");
    }

    private boolean isNotDuplicateUsername(String username) {
        return !userRepo.getAllUsername().contains(username);
    }

    private boolean isNotDuplicateEmail(String email){
        return !userRepo.getAllEmails().contains(email);
    }

    private boolean isValidPassword(String password) {
        return password.matches("^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$");
    }

    private boolean isValidEmail(String email){
        return email.matches("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");

    }

    public void updatePassword(ChangePasswordRequest request) {
        if(isValidPassword(request.getPassword())){
            userRepo.updatePasswordById(request.getPassword(), request.getId());
        } else throw new InvalidRequestException("Invalid password. Minimum eight characters, at least one letter, one number and one special character.");
    }


}

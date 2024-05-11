package kg.alatoo.ticketsellingapp.controllers;

import kg.alatoo.ticketsellingapp.dto.authorization.UserDto;
import kg.alatoo.ticketsellingapp.entities.User;
import kg.alatoo.ticketsellingapp.entities.UserRole;
import kg.alatoo.ticketsellingapp.services.user.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1")
@Log4j2
public class UserApiController {

    private final String LIKED_PATH = "/liked";
    private final String ADMIN_PATH = "/admin";
    private final String COMMENTED_PATH = "/commented";
    private final String USER_PATH = "/user";
    private final String ID_PATH = USER_PATH + "/{id}";

    private final UserService userService;

    @GetMapping(USER_PATH)
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping(ID_PATH)
    public UserDto getById(@PathVariable Long id) {
        log.info("Getting user with id: {}", id);
        return userService.findUserByID(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
    }

    @PostMapping(USER_PATH)
    public UserDto createUser(@Validated @RequestBody UserDto userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping(ID_PATH)
    public UserDto updateUser(@PathVariable Long id, @Validated @RequestBody UserDto userDTO) {
        userService.findUserByID(id).orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        userDTO.setId(id);
        return userService.saveUser(userDTO);
    }

    @Transactional
    @PatchMapping(ID_PATH)
    public UserDto updateUser(@PathVariable Long id, @RequestBody Map<String, String> updates) {
        UserDto user = userService.findUserByID(id)
                .orElseThrow(() -> new NotFoundException("User not found with id: " + id));

        updates.forEach((key, value) -> {
            switch (key) {
                case "name":
                    user.setName(value);
                    break;
                case "username":
                    user.setUsername(value);
                    break;
                case "email":
                    user.setEmail(value);
                    break;
                default:
                    break;
            }
        });

        userService.saveUser(user);

        return user;
    }
}


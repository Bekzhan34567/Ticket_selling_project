package kg.alatoo.ticketsellingapp.services.user;

import kg.alatoo.ticketsellingapp.dto.authorization.UserDto;
import kg.alatoo.ticketsellingapp.dto.authorization.AuthRegistrationDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<UserDto> findAllUsers();

    Optional<UserDto> findUserByID(Long id);

    UserDto saveUser(UserDto dto);
    UserDto register(AuthRegistrationDTO dto);

}

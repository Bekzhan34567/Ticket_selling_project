package kg.alatoo.ticketsellingapp.mapper;

import kg.alatoo.ticketsellingapp.dto.authorization.UserDto;
import kg.alatoo.ticketsellingapp.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface UserMapper {

    @Mapping(target = "password", ignore = true) // Ignore password field in mapping
    User userDtoToUser(UserDto dto);

    UserDto userToUserDto(User user);
}

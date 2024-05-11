package kg.alatoo.ticketsellingapp.mapper;

import javax.annotation.processing.Generated;
import kg.alatoo.ticketsellingapp.dto.authorization.UserDto;
import kg.alatoo.ticketsellingapp.entities.User;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-05-11T14:14:50+0600",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.2 (Amazon.com Inc.)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User userDtoToUser(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.username( dto.getUsername() );
        user.email( dto.getEmail() );
        user.name( dto.getName() );

        return user.build();
    }

    @Override
    public UserDto userToUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setUsername( user.getUsername() );
        userDto.setEmail( user.getEmail() );
        userDto.setName( user.getName() );

        return userDto;
    }
}

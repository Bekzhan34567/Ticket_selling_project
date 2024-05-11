package kg.alatoo.ticketsellingapp.services.user;


import kg.alatoo.ticketsellingapp.controllers.NotFoundException;
import kg.alatoo.ticketsellingapp.dto.authorization.UserDto;
import kg.alatoo.ticketsellingapp.dto.authorization.AuthRegistrationDTO;
import kg.alatoo.ticketsellingapp.dto.authorization.CustomUserDetails;
import kg.alatoo.ticketsellingapp.entities.User;
import kg.alatoo.ticketsellingapp.entities.UserRole;
import kg.alatoo.ticketsellingapp.mapper.UserMapper;
import kg.alatoo.ticketsellingapp.repositories.UserRepository;
import kg.alatoo.ticketsellingapp.repositories.UserRoleRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class UserServiceJPA implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final UserMapper userMapper;
    private final UserRoleRepository userRoleRepository;

    public UserServiceJPA(UserRepository userRepository, PasswordEncoder passwordEncoder, UserMapper userMapper, UserRoleRepository userRoleRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.userMapper = userMapper;
        this.userRoleRepository = userRoleRepository;
    }

    @Override
    public Optional<UserDto> findUserByID(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        User user = optionalUser.orElseThrow(() -> new NotFoundException("User not found with id: " + id));
        return Optional.of(userMapper.userToUserDto(user));
    }

    @Override
    public List<UserDto> findAllUsers() {
        List<User> users = (List<User>) userRepository.findAll();
        return users.stream()
                .map(userMapper::userToUserDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto saveUser(UserDto dto) {
        UserRole userRole = userRoleRepository.findByRoleName(UserRole.Name.USER)
                .orElseThrow(() -> new RuntimeException("USER role not found")); // Handle if the role doesn't exist

        User user = userMapper.userDtoToUser(dto);
        user.setRoles(Set.of(userRole));
        user.setPassword(passwordEncoder.encode(user.getUsername() + LocalDate.now().getYear()));
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }
    @Override
    public UserDto register(AuthRegistrationDTO authRegistrationDTO) {
        UserRole userRole = userRoleRepository.findByRoleName(UserRole.Name.USER)
                .orElseThrow(() -> new RuntimeException("USER role not found")); // Handle if the role doesn't exist
        User user = User.builder()
                .name(authRegistrationDTO.getName())
                .email(authRegistrationDTO.getEmail())
                .username(authRegistrationDTO.getUsername())
                .password(passwordEncoder.encode(authRegistrationDTO.getPassword()))
                .roles(Set.of(userRole))
                .build();
        User savedUser = userRepository.save(user);
        return userMapper.userToUserDto(savedUser);
    }

}

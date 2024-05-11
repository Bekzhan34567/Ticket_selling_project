package kg.alatoo.ticketsellingapp.bootstrap;

import kg.alatoo.ticketsellingapp.entities.User;
import kg.alatoo.ticketsellingapp.entities.UserRole;
import kg.alatoo.ticketsellingapp.repositories.DistributorRepository;
import kg.alatoo.ticketsellingapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.dao.DataAccessException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

//    private final TicketRepository ticketRepository;
    private final DistributorRepository distributorRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String... arg ){
        initDefaultUsers();
//        Ticket ticket1=Ticket.builder()
//                .title("Misha Marvin & Hanna")
//                .numberOfTicket(2000)
//                .IDnumber("3432432")
//                .seatPlace(19)
//                .build();
    }
    private void initDefaultUsers() {
        User admin = User.builder()
                .name("Admin")
                .username("admin")
                .email("admin@gmail.com")
                .roles(Set.of(UserRole.ADMIN, UserRole.STAFF))
                .password(passwordEncoder.encode("password"))
                .build();

        User staff = User.builder()
                .name("Staff")
                .username("staff")
                .email("staff@gmail.com")
                .password(passwordEncoder.encode("password"))
                .roles(Set.of(UserRole.STAFF))
                .build();
        userRepository.saveAll(List.of(admin, staff));
        try {
            Set<User> savedUsers = new HashSet<>();

            // Create 50 users
            for (int i = 0; i < 50; i++) {
                User user = User.builder()
                        .name("User " + i)
                        .username("bekuser" + i)
                        .email("userbek" + i + "@gmail.com")
                        .password(passwordEncoder.encode("password"+i))
                        .roles(Set.of(UserRole.USER))
                        .build();
                savedUsers.add(user);
            }
            userRepository.saveAll(savedUsers);
        } catch ( DataAccessException e) {
            // Handle database access exception
            e.printStackTrace();
        }
    }


}

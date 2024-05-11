package kg.alatoo.ticketsellingapp.bootstrap;

//import kg.alatoo.ticketsellingapp.entities.Ticket;
import kg.alatoo.ticketsellingapp.entities.User;
import kg.alatoo.ticketsellingapp.entities.UserRole;
import kg.alatoo.ticketsellingapp.repositories.DistributorRepository;
//import kg.alatoo.ticketsellingapp.repositories.TicketRepository;
import kg.alatoo.ticketsellingapp.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

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
        User user = User.builder()
                .username("user")
                .password(passwordEncoder.encode("password"))
                .email("user@example.com")
                .roles(Set.of(UserRole.USER))
                .build();

        User staff = User.builder()
                .username("staff")
                .password(passwordEncoder.encode("password"))
                .email("staff@example.com")
                .roles(Set.of(UserRole.STAFF))
                .build();

        User admin = User.builder()
                .username("admin")
                .password(passwordEncoder.encode("password"))
                .email("admin@example.com")
                .roles(Set.of(UserRole.ADMIN, UserRole.STAFF))
                .build();

        userRepository.saveAll(List.of(user, staff, admin));
    }


}

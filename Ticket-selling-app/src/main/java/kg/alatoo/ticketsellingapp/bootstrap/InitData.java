package kg.alatoo.ticketsellingapp.bootstrap;

import kg.alatoo.ticketsellingapp.entities.Ticket;
import kg.alatoo.ticketsellingapp.repositories.DistributorRepository;
import kg.alatoo.ticketsellingapp.repositories.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class InitData implements CommandLineRunner {

    private final TicketRepository ticketRepository;
    private final DistributorRepository distributorRepository;

    @Override
    public void run(String... arg ){

        Ticket ticket1=Ticket.builder()
                .title("Misha Marvin & Hanna")
                .numberOfTicket(2000)
                .IDnumber("3432432")
                .seatPlace(19)
                .build();

    }


}

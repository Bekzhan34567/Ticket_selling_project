package kg.alatoo.ticketsellingapp.mappers;

import kg.alatoo.ticketsellingapp.dto.TicketDTO;
import kg.alatoo.ticketsellingapp.entities.Distributor;
import kg.alatoo.ticketsellingapp.entities.Ticket;
import kg.alatoo.ticketsellingapp.mapper.TicketMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Set;
import java.util.concurrent.Flow;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class TicketMapperTest {

    @Autowired
    TicketMapper ticketMapper;

    @Test
    void bookToBookDto() {
        Ticket ticket = Ticket.builder()
                .id(12l)
                .title("Misha Marvin")
                .numberOfTicket(300)
                .IDnumber("220104106")
                .seatPlace(23)
                .build();

        Distributor distributor = Distributor.builder()
                .id(1L)
                .nameOforganization("Black Star")
                .phone("+9961394832904")
                .officialsite("http:localhost:2022")
                .build();

        ticket.setDistributor(distributor);

        TicketDTO dto = ticketMapper.ticketToTicketDto(ticket);

        assertNotNull(dto);
        assertEquals("Misha Marvin",dto.getName());
        assertEquals(300, dto.getnumberOfticket());
        assertEquals(23, dto.getseat());
        assertEquals("Test publisher",dto.getDistributor());
    }
}

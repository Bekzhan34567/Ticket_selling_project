package kg.alatoo.ticketsellingapp.services;

import kg.alatoo.ticketsellingapp.dto.TicketDTO;
import kg.alatoo.ticketsellingapp.entities.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface TicketService {
    Page<TicketDTO> findTickets(Integer pageNumber, Integer pageSize);

    Optional<TicketDTO> findTicketByID(Long id);

    TicketDTO saveTicket(TicketDTO dto);


}

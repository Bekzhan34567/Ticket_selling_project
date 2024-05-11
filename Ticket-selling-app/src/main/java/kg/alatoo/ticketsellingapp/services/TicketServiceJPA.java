//package kg.alatoo.ticketsellingapp.services;
//
//import kg.alatoo.ticketsellingapp.dto.TicketDTO;
//import kg.alatoo.ticketsellingapp.entities.Ticket;
//import kg.alatoo.ticketsellingapp.mapper.TicketMapper;
//import kg.alatoo.ticketsellingapp.repositories.TicketRepository;
//import org.springframework.data.domain.Page;
//import org.springframework.stereotype.Service;
//
//import java.util.Optional;
//
//@Service
//public abstract class TicketServiceJPA implements TicketService {
//    private final TicketRepository ticketRepository;
//    private final TicketMapper ticketMapper;
//
//    public TicketServiceJPA(TicketRepository ticketRepository,TicketMapper ticketMapper){
//        this.ticketMapper=ticketMapper;
//        this.ticketRepository=ticketRepository;
//    }
//
//
//    public Optional<TicketDTO> findBookByID(Long id) {
//        Optional<Ticket> optionalTicket = ticketRepository.findById(id);
//        return Optional.ofNullable(
//                ticketMapper.ticketToTicketDto(optionalTicket.orElse(null))
//        );
//    }
//
//
//
//}

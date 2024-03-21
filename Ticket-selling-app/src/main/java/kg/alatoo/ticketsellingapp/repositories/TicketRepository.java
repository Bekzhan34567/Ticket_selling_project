package kg.alatoo.ticketsellingapp.repositories;

import kg.alatoo.ticketsellingapp.entities.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TicketRepository extends CrudRepository<Ticket,Long>,PagingAndSortingRepository<Ticket, Long>,
    ListPagingAndSortingRepository<Ticket, Long>,
    JpaRepository<Ticket, Long>{

}

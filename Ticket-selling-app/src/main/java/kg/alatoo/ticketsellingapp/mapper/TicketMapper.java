//package kg.alatoo.ticketsellingapp.mapper;
//
//import kg.alatoo.ticketsellingapp.dto.TicketDTO;
//import kg.alatoo.ticketsellingapp.entities.Ticket;
//import org.mapstruct.InheritInverseConfiguration;
//import org.mapstruct.Mapper;
//import org.mapstruct.Mapping;
//@Mapper
//public interface  TicketMapper {
//    @Mapping(target = "authors", ignore = true)
//    @Mapping(source = "name", target = "title")
//    @Mapping(target = "distributor.tickets", ignore = true)
//    Ticket ticketDtoToTicket(TicketDTO dto);
//
//
//    @InheritInverseConfiguration
//    @Mapping(target = "distributor.tickets", ignore = true)
//    TicketDTO ticketToTicketDto(Ticket ticket);
//}

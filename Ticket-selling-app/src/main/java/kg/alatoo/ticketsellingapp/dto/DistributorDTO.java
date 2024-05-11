package kg.alatoo.ticketsellingapp.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DistributorDTO {
    private long id;
    private String nameOforganization;
    private String phone;
    private String officialsite;

//    Set<TicketDTO> tickets;
}

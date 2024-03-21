package kg.alatoo.ticketsellingapp.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Builder;

@Builder
public class TicketDTO {
    private Long id;
    @NotNull
    @NotBlank
    private String name;

    private int numberOfTicket;
    private String idnumber;
    @Positive
    @Builder.Default
    private int seatPlace=1;

    private DistributorDTO distributor;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getnumberOfticket() {
        return numberOfTicket;
    }

    public int getseat() {
        return seatPlace;
    }

    public DistributorDTO getDistributor() {
        return distributor;
    }
}

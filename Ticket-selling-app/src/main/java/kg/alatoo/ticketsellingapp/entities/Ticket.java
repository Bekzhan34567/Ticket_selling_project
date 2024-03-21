package kg.alatoo.ticketsellingapp.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Builder
@Entity
@Table(uniqueConstraints = @UniqueConstraint(name = "ticket_code", columnNames = {"ticketCode"}))
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @EqualsAndHashCode.Include
    private Long id;

    @NotNull
    @NotBlank
    @Size(max = 30,min = 6)

    private String title;
    private int numberOfTicket;
    private String IDnumber;
    private int seatPlace;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Distributor distributor;

    @ManyToMany
    private List<Author> authors;
}

package kg.alatoo.ticketsellingapp.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
@ToString
@Table(name = "Sellers")
public class Distributor {
    @Id
    @GeneratedValue
    @EqualsAndHashCode.Include
    private Long id;
    private String nameOforganization;
    private String phone;
    private String officialsite;

//    @OneToMany(mappedBy = "distributor")
//    Set<Ticket> tickets;
}

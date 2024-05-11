package kg.alatoo.ticketsellingapp.entities;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
@Table(name = "Eventquest")

public class Author {
    @Id
    @GeneratedValue
    @Column
    private Long id;
    @Column
    private String producer;
    @Column
    @NotNull
    private String email;

//    @ManyToMany(mappedBy = "authors")
//    private List<Ticket> tickets;
}

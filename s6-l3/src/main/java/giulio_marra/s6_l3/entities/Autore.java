package giulio_marra.s6_l3.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Autore {
    @Id
    private UUID uuid;

    private String nome;
    private String cognome;
    private String email;
    private LocalDate data_di_nascita;
    private String avatar;

}

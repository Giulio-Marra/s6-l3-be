package giulio_marra.s6_l3.entities;

import giulio_marra.s6_l3.enums.Categorie;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Post {
    @Id
    private UUID uuid;

    private List<Categorie> categorie;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempo_di_lettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private Autore autore;
}

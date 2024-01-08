package Com.Elif.entity;

import Com.Elif.utility.Unvan;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbldoktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String ad;
    String adres;
    String telefon;
    @Column(name = "brans_id")
    Long bransid;
    @Enumerated(EnumType.STRING)
    Unvan unvan;
}

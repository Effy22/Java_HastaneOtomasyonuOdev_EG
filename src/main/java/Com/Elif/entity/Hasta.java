package Com.Elif.entity;

import Com.Elif.utility.Cinsiyet;
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
@Table(name = "tblhasta")
public class Hasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "hasta_adi",nullable = false)
    String ad;
    String telefon;
    @Lob
    String adres;
    int yas;
    @Enumerated(EnumType.STRING)
    Cinsiyet cinsiyet;
}

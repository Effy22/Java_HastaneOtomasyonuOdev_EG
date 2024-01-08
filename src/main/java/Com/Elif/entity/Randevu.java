package Com.Elif.entity;

import Com.Elif.utility.Durum;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tblrandevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(name = "doktor_id")
    Long doktorid;
    @Column(name = "hasta_id")
    Long hastaid;
    @Temporal(TemporalType.DATE)
    LocalDate tarih;
    @Temporal(TemporalType.TIME)
    LocalTime zaman;
    @Enumerated(EnumType.STRING)
    Durum durum;

}

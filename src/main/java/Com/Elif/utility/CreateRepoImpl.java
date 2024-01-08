package Com.Elif.utility;

import Com.Elif.entity.Brans;
import Com.Elif.entity.Doktor;
import Com.Elif.entity.Hasta;
import Com.Elif.entity.Randevu;

import Com.Elif.repository.BransRepository;
import Com.Elif.repository.DoktorRepository;
import Com.Elif.repository.HastaRepository;
import Com.Elif.repository.RandevuRepository;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class CreateRepoImpl {
    private final BransRepository bransRepository;
    private final DoktorRepository doktorRepository;
    private final HastaRepository hastaRepository;
    private final RandevuRepository randevuRepository;
    public CreateRepoImpl(){
        this.bransRepository=new BransRepository();
        this.doktorRepository = new DoktorRepository();
        this.hastaRepository = new HastaRepository();
        this.randevuRepository=new RandevuRepository();
    }

    public void  createDemoData(){
        createBrans();
        createDoktor();
        createHasta();
        createRandevu();
    }
    private void createBrans(){
        bransRepository.save(Brans.builder()
                .ad("Göz")
                .build());
        bransRepository.save(Brans.builder()
                .ad("KBB")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Ortopedi")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Kardiyoloji")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Dermatoloji")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Morfoloji")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Dahiliye")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Çocuk Cerrahi")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Genel Cerrahi")
                .build());
        bransRepository.save(Brans.builder()
                .ad("Nöroloji")
                .build());
    }
    private void createDoktor(){
        doktorRepository.save(Doktor.builder()
                        .ad("Mehmet Malak")
                        .adres("Çayyolu, Ankara")
                        .telefon("0545 354 65 34")
                        .bransid(1L)
                        .unvan(Unvan.UZMAN)
                        .build());
        doktorRepository.save(Doktor.builder()
                .ad("Ayşe Kılcıoğlu")
                .adres("Yenimahalle, Ankara")
                .telefon("0503 325 65 34")
                .bransid(2L)
                .unvan(Unvan.DOCENT)
                .build());
        doktorRepository.save(Doktor.builder()
                .ad("Demet Evgar")
                .adres("Demetevler, Ankara")
                .telefon("0503 469 43 24")
                .bransid(3L)
                .unvan(Unvan.UZMAN)
                .build());
        doktorRepository.save(Doktor.builder()
                .ad("Ali Şehirlioğlu")
                .adres("Tunalı Hilmi, Ankara")
                .telefon("0532 563 43 24")
                .bransid(3L)
                .unvan(Unvan.PROFESOR)
                .build());
        doktorRepository.save(Doktor.builder()
                .ad("Elif Kekeli")
                .adres("Yenimahalle, Ankara")
                .telefon("0533 045 03 32")
                .bransid(8L)
                .unvan(Unvan.DOCENT)
                .build());
    }
    private void createHasta(){
        hastaRepository.save(Hasta.builder()
                .ad("Elif Çolak").telefon("0312 453 54 45")
                .adres("Çayyolu, Ankara")
                .yas(30)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Elif Çolak").telefon("0312 453 54 45")
                .adres("Çayyolu, Ankara")
                .yas(30)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Ali Yılmaz").telefon("0312 111 11 11")
                .adres("Kızılay, Ankara")
                .yas(22)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Ayşe Kaya").telefon("0312 222 22 22")
                .adres("Çankaya, Ankara")
                .yas(35)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Mehmet Demir").telefon("0312 333 33 33")
                .adres("Bahçelievler, Ankara")
                .yas(45)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Fatma Yıldız").telefon("0312 444 44 44")
                .adres("Cebeci, Ankara")
                .yas(28)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Ahmet Yılmaz").telefon("0312 123 45 67")
                .adres("Kızılay, Ankara")
                .yas(25)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Bihter Ziyagil").telefon("0312 987 65 43")
                .adres("Bahçelievler, Ankara")
                .yas(40)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Mehmet Kaya").telefon("0312 555 44 33")
                .adres("Cebeci, Ankara")
                .yas(50)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Kadir Yıldırım").telefon("0312 234 65 43")
                .adres("Beysukent, Ankara")
                .yas(31)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Mehmet Kaya").telefon("0312 236 44 33")
                .adres("Yenimahalle, Ankara")
                .yas(33)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Memoli Kayakent").telefon("0312 555 44 33")
                .adres("Cebeci, Ankara")
                .yas(50)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Pirzan Yıldırım").telefon("0312 234 60 23")
                .adres("Beysukent, Ankara")
                .yas(55)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Şebnem Kurt").telefon("0312 236 44 14")
                .adres("Tunalı Hilmi, Ankara")
                .yas(45)
                .cinsiyet(Cinsiyet.KADIN)
                .build());

        hastaRepository.save(Hasta.builder()
                .ad("Eyşan Kaya").telefon("0322 555 44 33")
                .adres("Cebeci, Ankara")
                .yas(42)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Ahmet Ayyıldız").telefon("0312 367 65 43")
                .adres("Tunalı Hilmi, Ankara")
                .yas(45)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("İrem İnceçay").telefon("0312 236 41 33")
                .adres("Yenimahalle, Ankara")
                .yas(30)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Memoli Teknokent").telefon("0312 719 44 33")
                .adres("Yenimahalle, Ankara")
                .yas(34)
                .cinsiyet(Cinsiyet.ERKEK)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Aybüke Yıldırıcı").telefon("0312 920 60 23")
                .adres("Beysukent, Ankara")
                .yas(28)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
        hastaRepository.save(Hasta.builder()
                .ad("Şebnem Maydonoz").telefon("0312 832 44 14")
                .adres("Çayyolu, Ankara")
                .yas(42)
                .cinsiyet(Cinsiyet.KADIN)
                .build());
    }
    private void createRandevu(){
        Random rnd = new Random();
        List<LocalTime> availableTimes = Arrays.asList(
                LocalTime.of(8, 30),
                LocalTime.of(9, 30),
                LocalTime.of(10, 30),
                LocalTime.of(11, 30),
                LocalTime.of(13, 30),
                LocalTime.of(14, 30),
                LocalTime.of(15, 30),
                LocalTime.of(16, 30),
                LocalTime.of(17, 30)
        );

        List<LocalDate> availableDates = Arrays.asList(
                LocalDate.of(2024, 1, 8),
                LocalDate.of(2024, 1, 9),
                LocalDate.of(2024, 1, 10),
                LocalDate.of(2024, 1, 11),
                LocalDate.of(2024, 1, 12),

                LocalDate.of(2024, 1, 15),
                LocalDate.of(2024, 1, 16),
                LocalDate.of(2024, 1, 17),
                LocalDate.of(2024, 1, 18),
                LocalDate.of(2024, 1, 19),

                LocalDate.of(2024, 1, 22),
                LocalDate.of(2024, 1, 23),
                LocalDate.of(2024, 1, 24),
                LocalDate.of(2024, 1, 25),
                LocalDate.of(2024, 1, 26)
        );

        List<Long> doctorIds = Arrays.asList(1L, 2L, 3L, 4L, 5L);
        List<Long> hastaIds = Arrays.asList(1L, 2L, 3L, 4L, 5L,6L,7L, 8L, 9L, 10L,11L,12L,13L,14L,15L,16L,17L,18L,19L,10L);

        for (int i = 0; i < 100; i++) {
            Long doctorId = doctorIds.get(rnd.nextInt(doctorIds.size()));
            Long hastaId = hastaIds.get(rnd.nextInt(hastaIds.size()));
            LocalDate date = availableDates.get(rnd.nextInt(availableDates.size()));
            LocalTime time = availableTimes.get(rnd.nextInt(availableTimes.size()));

            Durum randDurum = Durum.values()[rnd.nextInt(Durum.values().length)];

            randevuRepository.save(Randevu.builder()
                    .doktorid(doctorId)
                    .hastaid(hastaId)
                    .tarih(date)
                    .zaman(time)
                    .durum(randDurum)
                    .build());
        }
    }


}

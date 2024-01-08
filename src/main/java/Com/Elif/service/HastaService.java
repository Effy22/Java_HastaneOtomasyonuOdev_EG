package Com.Elif.service;

import Com.Elif.entity.Hasta;
import Com.Elif.entity.Randevu;
import Com.Elif.repository.BransRepository;
import Com.Elif.repository.DoktorRepository;
import Com.Elif.repository.HastaRepository;
import Com.Elif.repository.RandevuRepository;

import java.time.LocalDate;
import java.util.*;

public class HastaService {
    private final HastaRepository hastaRepository;
    private final RandevuRepository randevuRepository;
    private final DoktorRepository doktorRepository;
    private final BransRepository bransRepository;

    public HastaService() {
        hastaRepository = new HastaRepository();
        randevuRepository = new RandevuRepository();
        doktorRepository = new DoktorRepository();
        bransRepository = new BransRepository();
    }

    public void adiVerilenHastaninRandevulari(String hastaAdi){
         Hasta hasta = hastaRepository.findByColumnAndValue("ad",hastaAdi).getFirst();
         List<Randevu> randevuList =randevuRepository.findByColumnAndValue("hastaid",hasta.getId());
         randevuList.forEach(rnd->{
             System.out.println("********** RANDEVU BİLGİSİ **********");
             System.out.println("Hasta Adı... : " + hasta.getAd());
             System.out.println("Doktor Adı...: " + doktorRepository.findById(rnd.getDoktorid()).get().getAd() );
             System.out.println("Tarih........: " + rnd.getTarih());
             System.out.println("Saat.........: " + rnd.getZaman());
             System.out.println();
         });
    }
    public void hastaAdiBransAdediGetir(String hastaAdi) {
        List<Object[]> list = hastaRepository.branslaraGoreHastaListesi(hastaAdi);
        Map<String, Integer> bransAdedi = new HashMap<>();
        for (Object[] row : list) {
            String bransAdi = (String) row[2]; // 3. sütunun brans adı olduğunu varsayalım

            bransAdedi.put(bransAdi, bransAdedi.getOrDefault(bransAdi, 0) + 1);
        }
        for (Map.Entry<String, Integer> entry : bransAdedi.entrySet()) {
            System.out.println("Hasta Adı: " + hastaAdi + ", Branş Adı: " + entry.getKey() + ", Adet: " + entry.getValue());
        }
    }

    public void tarihlerArasindakiRandevulariGetir(String hastaAdi){
        Hasta hasta = hastaRepository.findByColumnAndValue("ad",hastaAdi).getFirst();
        LocalDate start = new HastaService().tarihAl(" başlangıç ");
        LocalDate finish = new HastaService().tarihAl(" bitiş ");

        List<Randevu> randevuList = randevuRepository.findByHastaIdAndDateRange(hasta.getId(),start,finish);
        randevuList.forEach(rnd->{
            System.out.println("********** RANDEVU BİLGİSİ **********");
            System.out.println("Hasta Adı... : " + hasta.getAd());
            System.out.println("Doktor Adı...: " + doktorRepository.findById(rnd.getDoktorid()).get().getAd() );
            System.out.println("Tarih........: " + rnd.getTarih());
            System.out.println("Saat.........: " + rnd.getZaman());
            System.out.println();
        });
    }

    public LocalDate tarihAl(String implication){
        //Bu metot daha verimli olması açısından Utility'e de yazılabilirdi.
        Scanner scanner = new Scanner(System.in);

        System.out.println("Lütfen bir"+ implication+" tarihi seçiniz: ");
        System.out.print("Yıl: ");
        int year = scanner.nextInt();

        System.out.print("Ay: ");
        int month = scanner.nextInt();

        System.out.print("Gün: ");
        int day = scanner.nextInt();

        LocalDate selectedDate = LocalDate.of(year, month, day);
        System.out.println("Seçilen Tarih: " + selectedDate);

        return selectedDate;
    }

}

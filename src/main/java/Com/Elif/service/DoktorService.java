package Com.Elif.service;

import Com.Elif.entity.Brans;
import Com.Elif.entity.Doktor;
import Com.Elif.entity.Randevu;
import Com.Elif.repository.BransRepository;
import Com.Elif.repository.DoktorRepository;
import Com.Elif.repository.HastaRepository;
import Com.Elif.repository.RandevuRepository;

import java.util.List;
import java.util.Scanner;

public class DoktorService {
    private final HastaRepository hastaRepository;
    private final RandevuRepository randevuRepository;
    private final DoktorRepository doktorRepository;
    private final BransRepository bransRepository;
    public DoktorService() {
        hastaRepository = new HastaRepository();
        randevuRepository = new RandevuRepository();
        doktorRepository = new DoktorRepository();
        bransRepository = new BransRepository();
    }

    public void doktorHastaSayisiBul(){
        System.out.println("Lütfen hasta sayısını bulmak istediğiniz doktorun adını yazınız...: ");
        String doktorAd=new Scanner(System.in).nextLine();
        Doktor doktor = doktorRepository.findByColumnAndValue("ad",doktorAd).getFirst();
        List<Randevu> randevuList=randevuRepository.findByColumnAndValue("doktorid",doktor.getId());
        System.out.println(doktor.getAd()+ " adlı doktorun toplam randevu sayısı...: " +randevuList.size());
    }
    public void bransSecimineGoreDoktorlariGoruntule(){
        bransRepository.findAll().forEach(System.out::println);
        System.out.println("Lütfen yukarıdaki branşlardan birini seçiniz...: ");
        String bransAdi = new Scanner(System.in).nextLine();

        Brans brans = bransRepository.findByColumnAndValue("ad",bransAdi).getFirst();
        List<Doktor> doktorList = doktorRepository.findByColumnAndValue("bransid", brans.getId());
        System.out.println(bransAdi+ " adlı branşın tüm doktorları....: ");
        doktorList.forEach(d->{
            System.out.println("Doktor Adı...: "+ d.getAd());
            System.out.println("Doktor Branş Id...: "+ d.getBransid());
            System.out.println("************************************");
        });
    }


}

package Com.Elif;

/**
 * Hastane randevu Sistemi
 * -> 10+ branş
 * -> 20+ Hasta
 * -> 5+ doktor
 * -> 100+ randevu
 */

import Com.Elif.entity.Brans;
import Com.Elif.service.DoktorService;
import Com.Elif.service.HastaService;
import Com.Elif.utility.Cinsiyet;
import Com.Elif.utility.CreateRepoImpl;

import java.util.Scanner;

/**
 * Tablolar;
 * tbldoktor;
 * id, ad, adres, telefon bransid,unvan
 *
 *
 * tblrandevu;
 * id, doktorid, hastaid, tarih, zaman, durum
 *
 * tblbrans;
 * id,ad
 *
 * tblhasta;
 * id,ad telefon,adres, yaş, cinsiyet
 *
 */
public class Runner {
    public static void main(String[] args) {
    // new CreateRepoImpl().createDemoData(); //ilk taslak verileri ekledim.
    // new HastaService().hastaAdiBransAdediGetir("Elif Çolak"); //çalıştı.Not:native sorgusunda db'deki kolon adlarını yaz.

    //    new HastaService().tarihlerArasindakiRandevulariGetir("Elif Çolak");


        new Runner().hastaneApp();
    }

    public void hastaneApp(){
        int secim;
        do{
            System.out.println("******** HASTANE OTOMASYONU ********");
            System.out.println("İŞLEMLER;");
            System.out.println("1- Hasta ile ilgili İşlemler");
            System.out.println("2- Doktor ile ilgili İşlemler");
            System.out.println("0-Çıkış");
            System.out.println("************************************");
            System.out.println("Lütfen seçiniz...: ");
            secim=new Scanner(System.in).nextInt();
            switch (secim){
                case 1:
                    hastaIslemleri();break;
                case 2:
                    doktorIslemleri();break;
                case 0:
                    System.out.println("Sistemden çıkış yapıldı.");break;
                default:
                    System.out.println("Hatalı bir seçim yaptınız...");

            }
        }while(secim!=0);


    }

    public void hastaIslemleri(){
        System.out.println("Lütfen işlem yapmak istediğiniz hasta adını ve soyadını giriniz..: ");
        String hastaIsmi = new Scanner(System.in).nextLine();
        int secim;
        do{
            System.out.println("******** HASTA İŞLEMLERİ ********");
            System.out.println("İŞLEMLER;");
            System.out.println("1- Hasta ismi ile randevularının dökümünü al");
            System.out.println("2- Hastanın seçilen branşlardaki randevu sayısını bul");
            System.out.println("3- Hastanın belirli bir tarih aralığındaki randevuları getir");
            System.out.println("0-Çıkış");
            System.out.println("************************************");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz...: ");
            secim=new Scanner(System.in).nextInt();
            new Scanner(System.in).nextLine();

            switch (secim){
                case 1:
                    new HastaService().adiVerilenHastaninRandevulari(hastaIsmi);break;
                case 2:
                    new HastaService().hastaAdiBransAdediGetir(hastaIsmi);break;
                case 3:
                    new HastaService().tarihlerArasindakiRandevulariGetir(hastaIsmi);break;
                case 0:
                    System.out.println("Hasta işlemlerinden çıkış yapıldı.");break;
                default:
                    System.out.println("Hatalı bir seçim yaptınız...");
            }
        }while(secim!=0);
    }

    public void doktorIslemleri(){
        int secim;
        do{
            System.out.println("******** DOKTOR İŞLEMLERİ ********");
            System.out.println("İŞLEMLER;");
            System.out.println("1- Doktorun baktığı tüm hasta sayısı");
            System.out.println("2- Branş seçimine göre Doktorları görüntüle");
            System.out.println("0-Çıkış");
            System.out.println("************************************");
            System.out.println("Lütfen yapmak istediğiniz işlemi seçiniz...: ");
            secim=new Scanner(System.in).nextInt();
            new Scanner(System.in).nextLine();
            switch (secim){
                case 1: new DoktorService().doktorHastaSayisiBul();
                    break;
                case 2: new DoktorService().bransSecimineGoreDoktorlariGoruntule();
                    break;
                case 0:
                    System.out.println("Doktor işlemlerinden çıkış yapıldı.");break;
                default:
                    System.out.println("Hatalı bir seçim yaptınız...");
            }
        }while(secim!=0);
    }
}

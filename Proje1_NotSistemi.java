 /**
 * Ad Soyad: [Elif İkra Çakmak]
 * Numara: [250541010]
 * Proje: [Not Sistemi]
 * Tarih: [25.11.2025]
 */

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.util.Scanner;
public class NotSistemi {
    public static double calculateAverage(int vize_notu, int final_notu, int odev_notu) {
        double ortalama = vize_notu * 0.3 + final_notu * 0.4 + odev_notu * 0.3;
        return ortalama;

    }

    public static boolean isPassingGrade(double ortalama) {
        if (ortalama >= 50) {
            return true;
        } else {
            return false;
        }
    }

    public static String getLetterGrade(double ortalama) {
        String harf_notu = "Geçersiz";
        if (ortalama >= 90 && ortalama <= 100) {
            harf_notu = "A";
        } else if (ortalama >= 80 && ortalama < 90) {
            harf_notu = "B";
        } else if (ortalama >= 70 && ortalama < 80) {
            harf_notu = "C";
        } else if (ortalama >= 60 && ortalama < 70) {
            harf_notu = "D";
        } else {// 60'dan küçük ise
            harf_notu = "F";
        }
        return harf_notu;

    }
     public static boolean isHonorList(double ortalama , int vize_notu , int final_notu ,int odev_notu){

            if (ortalama >= 85 && vize_notu >= 70 && final_notu >= 70 && odev_notu >= 70) {
                return true;
            } else {
                return false;
             }

    }
    public static boolean hasRetakeRight(double ortalama){
        if (ortalama >= 40 && ortalama < 50) {
            return true;
        }
        return false;
    }



    public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       int vize_notu,final_notu,odev_notu;
        System.out.print("Vize notunu giriniz:");
        vize_notu = scanner.nextInt();
       System.out.print("Final notunu giriniz:");
       final_notu = scanner.nextInt();
       System.out.print("Ödev notunu giriniz");
       odev_notu = scanner.nextInt();
       System.out.println("====OGRENCI NOT RAPORU====" );
        System.out.println("Vize notu:"+ vize_notu);
        System.out.println("Final notu:"+final_notu);
        System.out.println("Ödev notu:"+odev_notu);
        System.out.println("--------------------------");
        double ortalama = calculateAverage(vize_notu,final_notu,odev_notu);
        System.out.println("Ortalama:"+ortalama);
        System.out.println("Harf notu:"+getLetterGrade(ortalama));
        System.out.println("Durum:"+isPassingGrade(ortalama));
        if (isPassingGrade(ortalama)) {
            System.out.println("Durum:GEÇTİ");
        }else {
            System.out.println("Durum:KALDI");
        }
            System.out.println("Onur Listesi:"+( isHonorList(ortalama,vize_notu,final_notu,odev_notu) == true? "Evet" : "Hayır"));


    }

}

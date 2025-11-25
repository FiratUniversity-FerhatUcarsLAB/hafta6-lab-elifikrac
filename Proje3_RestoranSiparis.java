 /**
 * Ad Soyad: [Elif İkra Çakmak]
 * Numara: [250541010]
 * Proje: [Not Sistemi]
 * Tarih: [25.11.2025]
 */

import java.util.Scanner;

public class SiparisSistemi {

    // Gün: 1=Pzt, 2=Sal, 3=Çar, 4=Per, 5=Cum, 6=Cmt, 7=Paz
    public static boolean isWeekday(int gun) {
        return gun >= 1 && gun <= 5;
    }

    // Happy Hour: 14:00 - 17:00 arası
    public static boolean isHappyHour(int saat) {
        return saat >= 14 && saat < 17;
    }

    // Ana yemek fiyatları (switch-case)
    public static double getAnaYemekFiyat(int secim) {
        switch (secim) {
            case 1: // Izgara Tavuk
                return 85.0;
            case 2: // Adana Kebap
                return 120.0;
            case 3: // Levrek
                return 110.0;
            case 4: // Mantı
                return 65.0;
            default:
                return 0.0;
        }
    }

    // Başlangıç fiyatları
    public static double getBaslangicFiyat(int secim) {
        switch (secim) {
            case 1: // Çorba
                return 25.0;
            case 2: // Humus
                return 45.0;
            case 3: // Sigara Böreği
                return 55.0;
            default:
                return 0.0;
        }
    }

    // İçecek fiyatları (Happy Hour indirimi bu metotta uygulanabilir)
    public static double getIcecekFiyat(int secim, boolean happyHour) {
        double fiyat;
        switch (secim) {
            case 1: // Kola
                fiyat = 15.0;
                break;
            case 2: // Ayran
                fiyat = 12.0;
                break;
            case 3: // Taze Meyve Suyu
                fiyat = 35.0;
                break;
            case 4: // Limonata
                fiyat = 25.0;
                break;
            default:
                fiyat = 0.0;
        }

        // Happy Hour: içeceklerde %20 indirim
        if (happyHour && fiyat > 0) {
            fiyat = fiyat * 0.80; // %20 indirim
        }

        return fiyat;
    }

    // Tatlı fiyatları
    public static double getTatliFiyat(int secim) {
        switch (secim) {
            case 1: // Künefe
                return 65.0;
            case 2: // Baklava
                return 55.0;
            case 3: // Sütlaç
                return 35.0;
            default:
                return 0.0;
        }
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // --- Müşteri ve zaman bilgileri ---
        System.out.println("Gün seçiniz (1=Pzt, 2=Sal, 3=Çar, 4=Per, 5=Cum, 6=Cmt, 7=Paz): ");
        int gun = input.nextInt();

        System.out.print("Saat (0-23): ");
        int saat = input.nextInt();

        System.out.print("Öğrenci misiniz? (E/H): ");
        char ogrenciChar = input.next().toUpperCase().charAt(0);
        boolean isOgrenci = (ogrenciChar == 'E');

        boolean happyHour = isHappyHour(saat);
        boolean weekday = isWeekday(gun);

        System.out.println();
        System.out.println("=== MENÜ ===");
        System.out.println("1) Ana Yemekler");
        System.out.println("   1- Izgara Tavuk (85 TL)");
        System.out.println("   2- Adana Kebap (120 TL)");
        System.out.println("   3- Levrek (110 TL)");
        System.out.println("   4- Mantı (65 TL)");
        System.out.println("2) Başlangıçlar");
        System.out.println("   1- Çorba (25 TL)");
        System.out.println("   2- Humus (45 TL)");
        System.out.println("   3- Sigara Böreği (55 TL)");
        System.out.println("3) İçecekler");
        System.out.println("   1- Kola (15 TL)");
        System.out.println("   2- Ayran (12 TL)");
        System.out.println("   3- Taze Meyve Suyu (35 TL)");
        System.out.println("   4- Limonata (25 TL)");
        System.out.println("4) Tatlılar");
        System.out.println("   1- Künefe (65 TL)");
        System.out.println("   2- Baklava (55 TL)");
        System.out.println("   3- Sütlaç (35 TL)");
        System.out.println();

        double anaYemekToplam = 0;
        double baslangicToplam = 0;
        double icecekToplam = 0;
        double tatliToplam = 0;

        int anaYemekAdet = 0;
        int icecekAdet = 0;
        int tatliAdet = 0;

        // --- Ana yemek seçimi ---
        System.out.print("Ana yemek almak istiyor musunuz? (E/H): ");
        char c = input.next().toUpperCase().charAt(0);
        if (c == 'E') {
            System.out.print("Ana yemek seçiniz (1-4): ");
            int secim = input.nextInt();
            System.out.print("Kaç adet? ");
            int adet = input.nextInt();
            double fiyat = getAnaYemekFiyat(secim);
            anaYemekToplam = fiyat * adet;
            anaYemekAdet = adet;
        }

        // --- Başlangıç seçimi ---
        System.out.print("Başlangıç almak istiyor musunuz? (E/H): ");
        c = input.next().toUpperCase().charAt(0);
        if (c == 'E') {
            System.out.print("Başlangıç seçiniz (1-3): ");
            int secim = input.nextInt();
            System.out.print("Kaç adet? ");
            int adet = input.nextInt();
            double fiyat = getBaslangicFiyat(secim);
            baslangicToplam = fiyat * adet;
        }

        // --- İçecek seçimi ---
        System.out.print("İçecek almak istiyor musunuz? (E/H): ");
        c = input.next().toUpperCase().charAt(0);
        if (c == 'E') {
            System.out.print("İçecek seçiniz (1-4): ");
            int secim = input.nextInt();
            System.out.print("Kaç adet? ");
            int adet = input.nextInt();
            double fiyat = getIcecekFiyat(secim, happyHour);
            icecekToplam = fiyat * adet;
            icecekAdet = adet;
        }

        // --- Tatlı seçimi ---
        System.out.print("Tatlı almak istiyor musunuz? (E/H): ");
        c = input.next().toUpperCase().charAt(0);
        if (c == 'E') {
            System.out.print("Tatlı seçiniz (1-3): ");
            int secim = input.nextInt();
            System.out.print("Kaç adet? ");
            int adet = input.nextInt();
            double fiyat = getTatliFiyat(secim);
            tatliToplam = fiyat * adet;
            tatliAdet = adet;
        }

        // --- Ara toplam (Happy Hour içecek indirimi zaten uygulanmış durumda) ---
        double araToplam = anaYemekToplam + baslangicToplam + icecekToplam + tatliToplam;
        double toplam = araToplam;

        System.out.println();
        System.out.println("=== HESAP DETAYI ===");
        System.out.printf("Ana Yemekler Toplam : %.2f TL%n", anaYemekToplam);
        System.out.printf("Başlangıçlar Toplam : %.2f TL%n", baslangicToplam);
        System.out.printf("İçecekler Toplam    : %.2f TL%n", icecekToplam);
        System.out.printf("Tatlılar Toplam     : %.2f TL%n", tatliToplam);
        System.out.printf("Ara Toplam          : %.2f TL%n", araToplam);

        // --- Combo Menü İndirimi (Ana yemek + İçecek + Tatlı) ---
        int comboAdet = Math.min(anaYemekAdet, Math.min(icecekAdet, tatliAdet));
        if (comboAdet > 0) {
            // Basitlik için: En az 1 combo varsa tüm siparişe %15 indirim
            double comboIndirim = toplam * 0.15;
            toplam -= comboIndirim;
            System.out.printf("Combo Menü İndirimi (%%15) : -%.2f TL%n", comboIndirim);
        }

        // --- 200 TL üzeri %10 indirim ---
        if (toplam > 200) {
            double indirim200 = toplam * 0.10;
            toplam -= indirim200;
            System.out.printf("200 TL üzeri İndirim (%%10) : -%.2f TL%n", indirim200);
        }

        // --- Öğrenci: Hafta içi %10 ekstra indirim ---
        if (isOgrenci && weekday) {
            double ogrenciIndirim = toplam * 0.10;
            toplam -= ogrenciIndirim;
            System.out.printf("Öğrenci Hafta İçi İndirimi (%%10) : -%.2f TL%n", ogrenciIndirim);
        }

        System.out.println("--------------------------------------");
        System.out.printf("İndirimler Sonrası Toplam : %.2f TL%n", toplam);

        // --- Garson servisi için %10 bahşiş önerisi ---
        double bahsis = toplam * 0.10;
        double bahsisliToplam = toplam + bahsis;

        System.out.printf("Önerilen Bahşiş (%%10)     : %.2f TL%n", bahsis);
        System.out.printf("Bahşiş Dahil Toplam        : %.2f TL%n", bahsisliToplam);

        input.close();
    }
}

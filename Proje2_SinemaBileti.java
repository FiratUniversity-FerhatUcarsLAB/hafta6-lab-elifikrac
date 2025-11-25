 /**
 * Ad Soyad: [Elif İkra Çakmak]
 * Numara: [250541010]
 * Proje: [Not Sistemi]
 * Tarih: [25.11.2025]
 */


    

     import java.util.Scanner;

        public class SinemaBiletiSistemi {

            // 1) Hafta sonu mu?
            public static boolean isWeekend(int gun) {
                // 6 = Cumartesi, 7 = Pazar
                return gun == 6 || gun == 7;
            }

            // 2) Matine mi? (12:00 öncesi)
            public static boolean isMatinee(int saat) {
                return saat < 12;
            }

            // 3) Temel fiyatı hesapla
            public static double calculateBasePrice(int gun, int saat) {
                boolean weekend = isWeekend(gun);
                boolean matinee = isMatinee(saat);

                if (!weekend && matinee) {          // Hafta içi matine
                    return 45.0;
                } else if (!weekend && !matinee) {  // Hafta içi normal
                    return 65.0;
                } else if (weekend && matinee) {    // Hafta sonu matine
                    return 55.0;
                } else {                            // Hafta sonu normal
                    return 85.0;
                }
            }

            // 4) İndirim oranını hesapla (0.20 = %20 gibi düşün)
            public static double calculateDiscount(int yas, int meslek, int gun) {
                double maxIndirimOrani = 0.0;

                // Yaşa göre indirimler
                if (yas >= 65) {
                    maxIndirimOrani = Math.max(maxIndirimOrani, 0.30);  // %30
                }
                if (yas < 12) {
                    maxIndirimOrani = Math.max(maxIndirimOrani, 0.25);  // %25
                }

                // Meslek: 1=Öğrenci, 2=Öğretmen, 3=Diğer
                switch (meslek) {
                    case 1: // Öğrenci
                        // Pazartesi(1) - Perşembe(4): %20
                        if (gun >= 1 && gun <= 4) {
                            maxIndirimOrani = Math.max(maxIndirimOrani, 0.20);
                        }
                        // Cuma(5) - Pazar(7): %15
                        else if (gun >= 5 && gun <= 7) {
                            maxIndirimOrani = Math.max(maxIndirimOrani, 0.15);
                        }
                        break;
                    case 2: // Öğretmen
                        // Sadece Çarşamba (3): %35
                        if (gun == 3) {
                            maxIndirimOrani = Math.max(maxIndirimOrani, 0.35);
                        }
                        break;
                    case 3: // Diğer
                    default:
                        // İndirim yok
                        break;
                }

                return maxIndirimOrani;
            }

            // 5) Film türüne göre ekstra ücret
            public static double getFormatExtra(int filmTuru) {
                // 1=2D, 2=3D, 3=IMAX, 4=4DX
                switch (filmTuru) {
                    case 2: // 3D
                        return 25.0;
                    case 3: // IMAX
                        return 35.0;
                    case 4: // 4DX
                        return 50.0;
                    case 1: // 2D
                    default:
                        return 0.0;
                }
            }

            // 6) Toplam fiyatı hesapla
            public static double calculateFinalPrice(int gun, int saat, int yas, int meslek, int filmTuru) {
                double basePrice = calculateBasePrice(gun, saat);
                double discountRate = calculateDiscount(yas, meslek, gun);
                double extra = getFormatExtra(filmTuru);

                double indirimliFiyat = basePrice * (1 - discountRate);
                return indirimliFiyat + extra;
            }

            // 7) Bilet bilgisi oluşturan metot
            public static String generateTicketInfo(int gun, int saat, int yas, int meslek, int filmTuru, double finalPrice) {
                StringBuilder sb = new StringBuilder();
                double basePrice = calculateBasePrice(gun, saat);
                double discountRate = calculateDiscount(yas, meslek, gun);
                double extra = getFormatExtra(filmTuru);

                sb.append("=========== SİNEMA BİLETİ ===========\n");
                sb.append("Gün          : ").append(getGunAdi(gun)).append("\n");
                sb.append("Saat         : ").append(saat).append(":00\n");
                sb.append("Yaş          : ").append(yas).append("\n");
                sb.append("Meslek       : ").append(getMeslekAdi(meslek)).append("\n");
                sb.append("Film Türü    : ").append(getFilmTuruAdi(filmTuru)).append("\n");
                sb.append("-------------------------------------\n");
                sb.append(String.format("Temel Fiyat : %.2f TL\n", basePrice));
                sb.append(String.format("İndirim Oranı : %d%%\n", (int) (discountRate * 100)));
                sb.append(String.format("Format Ekstra : %.2f TL\n", extra));
                sb.append("-------------------------------------\n");
                sb.append(String.format("TOPLAM FİYAT : %.2f TL\n", finalPrice));
                sb.append("=====================================\n");

                return sb.toString();
            }

            // Yardımcı: Gün adı (switch-case kullanımı)
            public static String getGunAdi(int gun) {
                switch (gun) {
                    case 1: return "Pazartesi";
                    case 2: return "Salı";
                    case 3: return "Çarşamba";
                    case 4: return "Perşembe";
                    case 5: return "Cuma";
                    case 6: return "Cumartesi";
                    case 7: return "Pazar";
                    default: return "Geçersiz Gün";
                }
            }

            // Yardımcı: Meslek adı (switch-case)
            public static String getMeslekAdi(int meslek) {
                switch (meslek) {
                    case 1: return "Öğrenci";
                    case 2: return "Öğretmen";
                    case 3: return "Diğer";
                    default: return "Bilinmiyor";
                }
            }

            // Yardımcı: Film türü adı (switch-case)
            public static String getFilmTuruAdi(int filmTuru) {
                switch (filmTuru) {
                    case 1: return "2D";
                    case 2: return "3D";
                    case 3: return "IMAX";
                    case 4: return "4DX";
                    default: return "Bilinmiyor";
                }
            }

            // Örnek kullanım için main
            public static void main(String[] args) {
                Scanner input = new Scanner(System.in);

                System.out.println("Gün seçiniz (1=Pzt, 2=Sal, 3=Çar, 4=Per, 5=Cum, 6=Cmt, 7=Paz): ");
                int gun = input.nextInt();

                System.out.print("Saat (0-23): ");
                int saat = input.nextInt();

                System.out.print("Yaş: ");
                int yas = input.nextInt();

                System.out.println("Meslek seçiniz: ");
                System.out.println("1 - Öğrenci");
                System.out.println("2 - Öğretmen");
                System.out.println("3 - Diğer");
                int meslek = input.nextInt();

                System.out.println("Film türü seçiniz: ");
                System.out.println("1 - 2D");
                System.out.println("2 - 3D (+25 TL)");
                System.out.println("3 - IMAX (+35 TL)");
                System.out.println("4 - 4DX (+50 TL)");
                int filmTuru = input.nextInt();

                double finalPrice = calculateFinalPrice(gun, saat, yas, meslek, filmTuru);
                String ticketInfo = generateTicketInfo(gun, saat, yas, meslek, filmTuru, finalPrice);

                System.out.println();
                System.out.println(ticketInfo);

                input.close();
            }
        }

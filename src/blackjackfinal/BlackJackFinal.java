/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackfinal;

import java.util.Scanner;

/**
 *
 * @author s1800575
 */
public class BlackJackFinal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         Scanner lukija = new Scanner(System.in);
         
        System.out.println("Pelataan erä BlackJackia!");
        System.out.println("[Hyväksy painamalla enter]");
        lukija.nextLine();
        System.out.println("Kerron ensin säännöt. Pääset aina eteenpäin painamalla enter.");
        lukija.nextLine();
        System.out.println("Jaan ensin kortit vain sinulle.");
        lukija.nextLine();
        System.out.println("Voit päättää toisen kortin jälkeen haluatko nostaa lisää vai lopettaa.");
        lukija.nextLine();
        System.out.println("Jos haluat lisää kortteja, kirjoita 'k'.");
        lukija.nextLine();
        System.out.println("Jos et halua enempää kortteja, kirjoita 'e' jolloin vuoro siirtyy minulle.");
        lukija.nextLine();
        System.out.println("Isoilla tai pienillä kirjaimilla ei ole väliä.");
        lukija.nextLine();
        System.out.println("Kortin arvo 2-10: käden summaan lisätään kortin numeroa vastaava arvo(2 lisätään 2, 3 lisätään 3.)");
        lukija.nextLine();
        System.out.println("Kortin arvo 11-13: käden summaan lisätään 10.");
        lukija.nextLine();
        System.out.println("Kortin arvo 1 (ässä): käden summaan lisätään 11. Mikäli korttien yhteissummaksi tuli yli 21,\nniin vähennetään summasta 10. Tässä tilanteessa on saatu kaksi ässää, jolloin toisen ässän tulkitaan olevan arvoltaan 1. ");
        lukija.nextLine();
        System.out.println("Mikäli saat yli 21, häviät ja peli loppuu.");
        lukija.nextLine();
        System.out.println("Mikäli saat 21, voitat ja peli loppuu.");
        lukija.nextLine();
        System.out.println("Tilanteessa, jossa molemmilla alle 21, voittaa se kenellä on isompi käden summa.");
        lukija.nextLine();
        System.out.println("Peli alkaa...");
        lukija.nextLine();
              
              
        Pelaajankasi PelaajanKasi = new Pelaajankasi(); // luodaan PelaajanKasi niminen ilmentymä oliosta Pelaajankasi, jolla on pelaajankasi-luokan ominaisuudet käytössä
        Pelaajankasi EmannanKasi = new Pelaajankasi(); // jne.
        Korttipakka meidanPakka = new Korttipakka(); // jne.

        String jaettuKortti = ""; // lisäkortin kysymyksen vastaus k/e
        int i = 1; // pelaajan korttilaskuri
        int j = 1; // emannan korttilaskuri
        int pelaajanKadenSumma = 0;
        int emannanKadenSumma = 0;

        meidanPakka.sekoitaPakka(); // sekoitetaan korttipakka

        Kortti uusiPelaajanKortti = meidanPakka.jaaKortti(); // Kortti-tyyppinen muuttuja uusiPelaajanKortti
        PelaajanKasi.otaKortti(uusiPelaajanKortti); //kutsutaan PelaajanKasi olion otaKortti metodia uusiPelaajanKortti parametrillä
        System.out.println("Pelaajan " + i + ". kortti: " + uusiPelaajanKortti + ".");
        i++;
        
        uusiPelaajanKortti = meidanPakka.jaaKortti();
        PelaajanKasi.otaKortti(uusiPelaajanKortti);
        System.out.println("Pelaajan " + i + ". kortti: " + uusiPelaajanKortti + ".");
        i++;
                
        System.out.println("Pelaajan" + PelaajanKasi + ". Käden summa: "+PelaajanKasi.selvitaSumma());
                
        if (PelaajanKasi.onkoBlackJackMetodi() == true) {
           
            
        } else {
        System.out.println("Haluatko nostaa lisää kortteja? (k/e)");
        jaettuKortti = lukija.nextLine();
        }
        
        while (jaettuKortti.equalsIgnoreCase("k")) {
                uusiPelaajanKortti = meidanPakka.jaaKortti();
                PelaajanKasi.otaKortti(uusiPelaajanKortti);
                System.out.println("Pelaajan " + i + ". kortti: " + uusiPelaajanKortti);
                i++;
                System.out.println("Pelaajan" + PelaajanKasi + ". Käden summa: "+PelaajanKasi.selvitaSumma());
               
        // Leelan kommentti 18.3., että jos pelaajalla 21 tai yli, ohjelmaa ei tarvitse jatkaa
        
                if (PelaajanKasi.selvitaSumma() > 21) {
                    System.out.println("Pelaajalla yli 21, pelaaja hävisi ja peli päättyy");
                            System.exit(0);
                } 

                if (PelaajanKasi.selvitaSumma() == 21) {
                    System.out.println("Pelaajalla tasan 21, pelaaja voitti ja peli päättyy");
                            System.exit(0);
                }else {

                System.out.println("Haluatko nostaa lisää kortteja? (k/e)");
                jaettuKortti = lukija.nextLine(); }

        if (jaettuKortti.equalsIgnoreCase("e")) {
            PelaajanKasi.selvitaSumma();
            System.out.println("Lopullinen pelaajan käsi: " + PelaajanKasi + ". Summa: "+PelaajanKasi.selvitaSumma());
        }
        }
       
        System.out.println("**********************************************************************************************************");
        System.out.println("Huutojen ja epätoivon välttämiseksi, muistathan, että kortti nro. 1 on arvoltaan 11 ja kortit 11-13 on 10.");

        Kortti uusiEmannanKortti = meidanPakka.jaaKortti();
        EmannanKasi.otaKortti(uusiEmannanKortti);
        System.out.println("Emännän " + j + ". kortti: " + uusiEmannanKortti + ".");
        j++;
        
        uusiEmannanKortti = meidanPakka.jaaKortti();
        EmannanKasi.otaKortti(uusiEmannanKortti);
        System.out.println("Emännän " + j + ". kortti: " + uusiEmannanKortti + ".");
        j++;
        
       // System.out.println("Emännän" + EmannanKasi);
        while (EmannanKasi.selvitaSumma() < 15) {

            uusiEmannanKortti = meidanPakka.jaaKortti();
            System.out.println("Emännän " + j + ". kortti: " + uusiEmannanKortti);
            j++;
            EmannanKasi.otaKortti(uusiEmannanKortti);

           if (EmannanKasi.selvitaSumma() >= 15) 
              break;
           }
        
       
//        if (EmannanKasi.selvitaSumma() >= 15) {
//            System.out.println("Kontrollirivi: Emnnän käsi >= 15.");
            System.out.println("Emännän" + EmannanKasi + ". Käden summa: " + EmannanKasi.selvitaSumma());

//        }
        if ((PelaajanKasi.selvitaSumma() > EmannanKasi.selvitaSumma())) {
            System.out.println("Pelaaja voitti");

        } 
        
        if ((EmannanKasi.selvitaSumma() > PelaajanKasi.selvitaSumma() && EmannanKasi.selvitaSumma() < 21 )) {
            System.out.println("Emäntä voitti");
        
        if ((EmannanKasi.selvitaSumma() == 21)) {
            System.out.println("Emännällä BlackJack ja emäntä voitti.");
        }
            
        if ((EmannanKasi.selvitaSumma() < PelaajanKasi.selvitaSumma()) && (EmannanKasi.selvitaSumma() > 21)) {
            System.out.println("Pelaaja voitti");
        }
         
        // tasapelin ehdot
        if (PelaajanKasi.selvitaSumma() == EmannanKasi.selvitaSumma()) {
            System.out.println("Tasapeli, ei lue teht.annossa mitä tapahtuu");

        } 

        System.out.println("Loppu");
    }
    }
    }

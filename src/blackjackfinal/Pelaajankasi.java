/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackfinal;

import java.util.ArrayList;

/**
 *
 * @author s1800575
 */
public class Pelaajankasi {
      
    
    private final ArrayList<Kortti> PelaajanKasi = new ArrayList<>();
    
    
    // int PelaajanKasiArvo oli globaali muuttuja, joka lisääntyi / kumuloitui joka kerran
   

    public void otaKortti(Kortti jaettu) {
        PelaajanKasi.add(jaettu);
    }

    public int selvitaSumma() {
        
        int PelaajanKasiArvo = 0;
               
        //PelaajanKasi.forEach((kortinArvo) -> {
            
            // uuden syntaksin mukainen for loop
            for (int i = 0; i < PelaajanKasi.size(); i++) {
            // heikki miikulainen neuvoi jossain kohdassa

            if (PelaajanKasi.get(i).getArvo() >= 2 && PelaajanKasi.get(i).getArvo() <= 10) {
                PelaajanKasiArvo = PelaajanKasiArvo + PelaajanKasi.get(i).getArvo();
                
            } else if (PelaajanKasi.get(i).getArvo() >= 11 && PelaajanKasi.get(i).getArvo() <= 13) {
                PelaajanKasiArvo = PelaajanKasiArvo + 10;
            
            } else if (PelaajanKasi.get(i).getArvo() == 1) {
                PelaajanKasiArvo = PelaajanKasiArvo + 11;

            }
        }

        if (PelaajanKasi.get(1).getArvo() == 1 && 
            PelaajanKasi.get(0).getArvo() == 1) {
            PelaajanKasiArvo -= 10;
          
        }

        return PelaajanKasiArvo;//palauttaa käden summan
    }
    
    public boolean onkoBlackJackMetodi(){
      
        if (selvitaSumma() == 21)
        return true;     
        else return false;
        
    }
    
    
//public boolean onkoBlackJackMetodi(){
//         
//((PelaajanKasi.get(0).getArvo() == 1) && (PelaajanKasi.get(1).getArvo() >= 10 && PelaajanKasi.get(1).getArvo() <= 13))
//|| ((PelaajanKasi.get(1).getArvo() == 1) && PelaajanKasi.get(0).getArvo() >= 10 && PelaajanKasi.get(0).getArvo() <= 13);
//        return false;
//
//}

    @Override
    public String toString() {
        return " käden kortit: "+PelaajanKasi+". Onko BlackJack: "+onkoBlackJackMetodi();
    }

      


}

    


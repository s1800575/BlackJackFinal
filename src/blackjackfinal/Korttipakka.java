/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackfinal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 *
 * @author s1800575
 */
public class Korttipakka {

    
    
    private ArrayList<Kortti> pakka = new ArrayList<>();

   
    public Korttipakka() {

        ArrayList<String> maat = new ArrayList<>(Arrays.asList("♥", "♠", "♦", "♣"));

        // uuden syntaksin mukainen for loop
        //  for (int i = 0; i < 10; i++) {} sijaan
        // heikki miikulainen neuvoi jossain kohdassa
        maat.forEach((maa) -> { 
            int arvo = 1;

            // tässä kohdassa arvo on siis 1-13 eli ja koska index = n-1 = 13
            // ja 13 * 4 = 52
            while (arvo <= 13) {
                pakka.add(new Kortti(arvo, maa));

                arvo++;
            }
        });
    }
    
    // tarkastaa että syntyvä kortti on oikean lainen ts. ei päästä 
    // olioa väärään tilaan missään vaiheessa
    
     public static boolean parametritOK(String maa, int arvo) {
        return (maa.equals("♣") || maa.equals("♦")
                || maa.equals("♠") || maa.equals("♥"))
                && arvo >= 1 && arvo <= 13;
    }

    // sekoita
      public void sekoitaPakka() {
        Collections.shuffle(pakka);
    }

      // määritetään päällimmäisen kortin index pakka.size() funktiolla
     
     int paallimmainen = pakka.size();
    
     public Kortti jaaKortti(){
        if(pakka.isEmpty())
            return null;
        else 
            return pakka.remove(paallimmainen);
                           
    }



   
}
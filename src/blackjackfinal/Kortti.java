/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjackfinal;

/**
 *
 * @author s1800575
 */
public class Kortti {
    
// tämä H&R alkuperäisestä projektista 11/2018
    
    // olion ominaisuudet
    
    private int arvo;
    private String maa;
    
    // tehdään konstruktori
    // määrittää miten olio luodaan
    // public + LuokanNimi
    // konstruktorissa voi käyttää if - else- while - jne..
    
    public Kortti(int arvo, String maa) {
        this.arvo = arvo;
        this.maa = maa;
      }

   
    public int getArvo() {
        return arvo;
    }

    public String getMaa() {
        return maa;
    }

    public void setArvo(int arvo) {
        this.arvo = arvo;
    }

    public void setMaa(String maa) {
        this.maa = maa;
    }

    @Override
    public String toString() {
        return maa+arvo;
    }
    
}

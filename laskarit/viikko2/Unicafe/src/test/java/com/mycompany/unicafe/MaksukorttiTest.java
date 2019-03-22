package com.mycompany.unicafe;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class MaksukorttiTest {

    Maksukortti kortti;

    @Before
    public void setUp() {
        kortti = new Maksukortti(10);
    }

    @Test
    public void luotuKorttiOlemassa() {
        assertTrue(kortti!=null);      
    }
    
    @Test
    public void konstruktoriAsettaaSaldonOikein() {
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void rahanOttoVahentaaSaldoaOikein() {
        kortti.otaRahaa(2);
        assertEquals(8, kortti.saldo());
    }
    
    @Test
    public void saldoEiMuutuJosEiTarpeeksiRahaa() {
        kortti.otaRahaa(100);
        assertEquals(10, kortti.saldo());
    }
    
    @Test
    public void palauttaaTrueJosOttoOnnistui() {
        assertTrue(kortti.otaRahaa(2));
    }
    
    @Test
    public void palauttaaFalseJosOttoEpaonnistui() {
        assertFalse(kortti.otaRahaa(100));
    }
    
    @Test
    public void toStringPalauttaaOikeatArvot() {
        assertEquals("saldo: 0.10", kortti.toString());
    }
    
    @Test
    public void kortilleVoiLadataRahaa() {
        kortti.lataaRahaa(100);
        assertEquals(110, kortti.saldo());
    }
}

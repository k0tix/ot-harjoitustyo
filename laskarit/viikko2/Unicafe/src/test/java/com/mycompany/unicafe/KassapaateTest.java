package com.mycompany.unicafe;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author k0tix
 */
public class KassapaateTest {
    
    Kassapaate kassa;
    
    @Before
    public void setUp() {
        kassa = new Kassapaate();
    }
    
    @Test
    public void kassassaAlkuunOikeaMaaraRahaaJaOstoja() {
        assertEquals(100000, kassa.kassassaRahaa());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void syoEdullisestiPalauttaaOikeanMaaranVaihtorahaa() {
        assertEquals(60, kassa.syoEdullisesti(300));
    }
    
    @Test
    public void syoMaukkaastiPalauttaaOikeanMaaranVaihtorahaa() {
        assertEquals(100, kassa.syoMaukkaasti(500));
    }
    
    @Test
    public void syominenKasvattaaMyytyjenAnnostenMaaraa() {
        kassa.syoEdullisesti(300);
        kassa.syoMaukkaasti(500);
        kassa.syoMaukkaasti(500);
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(2, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void josMaksuEiRiittavaKassassaEiMuutostaJaVaihtorahaOikea() {
        assertEquals(10, kassa.syoEdullisesti(10));
        assertEquals(20, kassa.syoMaukkaasti(20));
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiOstoToimii() {
        Maksukortti kortti = new Maksukortti(1000);
        assertTrue(kassa.syoMaukkaasti(kortti));
        assertTrue(kassa.syoEdullisesti(kortti));
        assertEquals(1, kassa.edullisiaLounaitaMyyty());
        assertEquals(1, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassaEiMuutuJaVeloitaTyhjaaKorttia() {
        Maksukortti kortti = new Maksukortti(10);
        assertFalse(kassa.syoEdullisesti(kortti));
        assertFalse(kassa.syoMaukkaasti(kortti));
        assertEquals(10, kortti.saldo());
        assertEquals(0, kassa.edullisiaLounaitaMyyty());
        assertEquals(0, kassa.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kassanRahamaaraEiMuutuKorttiOstolla() {
        Maksukortti kortti = new Maksukortti(1000);
        kassa.syoMaukkaasti(kortti);
        assertEquals(100000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kortinLatausToimii() {
        Maksukortti kortti = new Maksukortti(0);
        kassa.lataaRahaaKortille(kortti, 1000);
        assertEquals(1000, kortti.saldo());
        assertEquals(101000, kassa.kassassaRahaa());
        
        kassa.lataaRahaaKortille(kortti, -1);
        assertEquals(1000, kortti.saldo());
        assertEquals(101000, kassa.kassassaRahaa());
    }
    
    @Test
    public void kassaEiHyvaksyNegatiivistaLatausta() {
        Maksukortti kortti = new Maksukortti(0);
        
        kassa.lataaRahaaKortille(kortti, -1);
        assertEquals(0, kortti.saldo());
        assertEquals(100000, kassa.kassassaRahaa());
    }

}

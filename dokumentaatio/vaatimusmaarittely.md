# Vaatimusmäärittely Uno-korttipelille

## Sovelluksen tarkoitus
Sovellus toteuttaa uno-korttipelin toisia pelaajia vastaan.

## Perusversion tarjoama toiminnallisuus
Normaali uno-korttipeli logiikka:

Ennen peliä
* määritetään kuinka monta pelaajaa on mukana (2-10 pelaajaa)
* pelaajille voi antaa yksilöidyt nimet
* määritetään pelataanko
  *  yksi peli 

Pelin aikana
* pelaaja näkee omat korttinsa sekä pakan päällimäisen kortin
* pelivuoro siirty pelaajalta pelaajalle

Pelin jälkeen
* pelaajat näkevät 
  *  tulostaulun pelaajien pisteistä

### Kuvaus

Uno on korttipeli, jossa pelaajilla on kädessään kortteja. Kortteja pelataan vuorotellen, yksi kortti kerrallaan. Kortin pelaamisen jälkeen vuoro siirtyy seuraavalle pelaajalle. Pelin voittaja on se, jonka kädestä loppuu ensimmäisenä kortit. Unossa voidaan pelata yksittäisiä pelejä tai useampi peli siihen asti, että jokin pelaajista saa 500 pistettä. Pisteet lasketaan jokaisen yksittäisen pelin lopputtua niin, että pelin voittaja saa pisteitä muiden pelaajien korteista.

### Säännöt

#### Aloitus

* Korttipakka sekoitetaan ja jokaiselle pelaajalle jaetaan 7 korttia
* Pakan ylin kortti asetetaan pöydälle alkukortiksi ja loput pakasta toimii nostopakkana
* Pelin aloittaja valitaan satunnaisesti

#### Peli

* Pelaaja yrittää laittaa pöydällä olevan kortin päälle oman kortin
  * jossa on sama väri, numero tai kuvio
  * joka on villikortti
* Jos pelaaja ei pysty laittamaan mitään korttia, täytyy hänen nostaa itselleen uusi kortti
* Jos juuri nostetun kortin pystyy pelaamaan voi pelaaja pelata kortin heti pöytään tai pitää kortin vielä itsellään
* Vuoro siirtyy seuraavalle pelaajalle kun edellinen pelaaja on pelannut korttinsa

#### Lopetus
* Peli päättyy joko 
  * yksittäiseen peliin ja voittaja on se, jonka kädestä kortit loppuivat ensimmäisenä
  * silloin kun yksi pelaajista saa kerättyä 500 pistettä useammasta pelistä

#### Pakka
```
yhteensä 108 korttia

    Numerokortit:
        19 sinistä korttia 0–9
        19 vihreää korttia 0–9
        19 punaista korttia 0–9
        19 keltaista korttia 0–9

    Erikoiskortit:
        8 nosta kaksi -korttia (kaksi kutakin väriä)
        8 suunnanvaihto -korttia (kaksi kutakin väriä)
        8 ohituskorttia (kaksi kutakin väriä)
        4 villikorttia
        4 villi + nosta neljä -korttia
```

## Jatkokehitysideoita
Perusversion jälkeen järjestelmää täydennetään ajan salliessa esim. seuraavilla toiminnallisuuksilla:
* Telegrambot käyttöliittymä javafx lisäksi
* Erilaisia pelimuotoja normaalin unon lisäksi esim. tiimipohjainen versio, pikapeli tai viimeinen hengissä
* Tulosten tallentaminen
* Pelien tallentaminen, jotta pitkälle edennyt peli ei katoa
